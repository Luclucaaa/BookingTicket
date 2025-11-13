package com.example.backend.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.backend.dto.LogDTO;
import com.example.backend.dto.ReviewDTO;
import com.example.backend.exception.ResourceNotFoundException;
import com.example.backend.model.Review;
import com.example.backend.model.Seat;
import com.example.backend.model.Vehicle;
import com.example.backend.service.LogService;
import com.example.backend.service.ReviewService;
import com.example.backend.utils.JwtTokenUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/review")
@CrossOrigin("http://localhost:3000")
public class ReviewController {
    private ReviewService reviewService;
    @Autowired
    private JwtTokenUtils jwtTokenUtils;
    @Autowired
    private LogService logService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    // Get all Review
    @GetMapping
    public List<Review> getAllReviews(){
        return reviewService.getAllReview();
    }

    // Create a new Review
    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody ReviewDTO ReviewDTO, HttpServletRequest request){
        String token = jwtTokenUtils.extractJwtFromRequest(request);
        if (token == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        if (jwtTokenUtils.isTokenExpired(token)) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        int userId = jwtTokenUtils.extractUserId(token);
        Integer userRole = jwtTokenUtils.extractRole(token);

        if (userRole == null ||  (userRole != 2 && userRole != 3)) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        try {
            Review createReview = reviewService.createReview(ReviewDTO);

            LogDTO logData =  logService.convertToLogDTO(userId, "Tạo đánh giá ", 1);
            logService.createLog(logData);
            return new ResponseEntity<>(createReview, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get Review by id
    @GetMapping("{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable ("id") int id){
        return new ResponseEntity<>(reviewService.getReviewByID(id), HttpStatus.OK);
    }

    //get review by userId
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Review>> getReviewByUserId(@PathVariable int userId) {
        List<Review> reviews = reviewService.getReviewByUserId(userId);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }
    // lấy review theo userid phân trang
    @GetMapping("/user/{userId}/page")
    public ResponseEntity<Map<String, Object>> getReviewByUserId(
            @PathVariable int userId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<Review> reviewPage = reviewService.getReviewByUserIdPageable(userId, pageable);
        Map<String, Object> response = new HashMap<>();
        response.put("reviews", reviewPage.getContent());
        response.put("currentPage", reviewPage.getNumber());
        response.put("totalItems", reviewPage.getTotalElements());
        response.put("totalPages", reviewPage.getTotalPages());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // phân trang
    @GetMapping("page")
    public ResponseEntity<Map<String, Object>> getAllReviewByPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) Integer userId,
            @RequestParam(required = false) String userName,
            @RequestParam(required = false) Integer rating) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<Review> reviewPage = reviewService.getAllReviewPage(userId, userName, rating, pageable);
        Map<String, Object> response = new HashMap<>();
        response.put("reviews", reviewPage.getContent());
        response.put("currentPage", reviewPage.getNumber());
        response.put("totalItems", reviewPage.getTotalElements());
        response.put("totalPages", reviewPage.getTotalPages());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Update Review by id
    @PutMapping("{id}")
    public ResponseEntity<Review> updateReviewById(@PathVariable ("id") int id, @RequestBody ReviewDTO reviewDTO, HttpServletRequest request){
        String token = jwtTokenUtils.extractJwtFromRequest(request);
        if (token == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        if (jwtTokenUtils.isTokenExpired(token)) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        int userId = jwtTokenUtils.extractUserId(token);
        Integer userRole = jwtTokenUtils.extractRole(token);

        if (userRole == null ||  (userRole != 2 && userRole != 3)) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        try{
            Review updateReview = reviewService.updateReviewByID(reviewDTO, id);

            LogDTO logData =  logService.convertToLogDTO(userId, "Cập nhật đánh giá Id: "+ id, 2);
            logService.createLog(logData);
            return new ResponseEntity<>(updateReview, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete Review by id
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteReviewById(@PathVariable ("id") int id, HttpServletRequest request){
        String token = jwtTokenUtils.extractJwtFromRequest(request);
        if (token == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        if (jwtTokenUtils.isTokenExpired(token)) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        int userId = jwtTokenUtils.extractUserId(token);
        Integer userRole = jwtTokenUtils.extractRole(token);

        if (userRole == null ||  (userRole != 2 && userRole != 3)) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        try {
            reviewService.deleteReviewByID(id);

            // Ghi log sau khi hành động thành công
            LogDTO logData =  logService.convertToLogDTO(userId, "Xóa đánh giá Id: "+ id, 2);
            logService.createLog(logData);

            return new ResponseEntity<>("Review " + id + " is deleted successfully", HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>("Review " + id + " not found", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
