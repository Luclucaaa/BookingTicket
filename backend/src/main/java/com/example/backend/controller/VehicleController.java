package com.example.backend.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.backend.dto.LogDTO;
import com.example.backend.dto.VehicleDTO;
import com.example.backend.exception.ResourceNotFoundException;
import com.example.backend.model.City;
import com.example.backend.model.Seat;
import com.example.backend.model.Vehicle;
import com.example.backend.service.LogService;
import com.example.backend.service.VehicleService;
import com.example.backend.utils.JwtTokenUtils;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/vehicle")
@CrossOrigin("http://localhost:3000")
public class VehicleController {
    private VehicleService vehicleService;
    @Autowired
    private JwtTokenUtils jwtTokenUtils;
    @Autowired
    private LogService logService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    // Get all Vehicle
    @GetMapping
    public List<Vehicle> getAllVehicles(){return vehicleService.getAllVehicle();}

    // lấy danh sách xe theo loại xe
    @GetMapping("/kind/{kindVehicleId}")
    public ResponseEntity<List<Vehicle>> getVehiclesByKindVehicleId(@PathVariable int kindVehicleId) {
        List<Vehicle> vehicles = vehicleService.getVehiclesByKindVehicleId(kindVehicleId);
        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }
    // Create a new Vehicle
    @PostMapping
    public ResponseEntity<Vehicle> createVehicle(@RequestBody VehicleDTO vehicleDTO, HttpServletRequest request){

//        String token = jwtTokenUtils.extractJwtFromRequest(request);
//        if (token == null) {
//            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//        }
//
//        int userId = jwtTokenUtils.extractUserId(token);
//        LogDTO logData =  logService.convertToLogDTO(userId, "Tạo phương tiện tên: "+ vehicleDTO.getName(), 1);
//        logService.createLog(logData);

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
            Vehicle createVehicle = vehicleService.createVehicle(vehicleDTO);

            LogDTO logData =  logService.convertToLogDTO(userId, "Tạo phương tiện tên: "+ vehicleDTO.getName(), 1);
            logService.createLog(logData);
            return new ResponseEntity<>(createVehicle, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get Vehicle By id
    @GetMapping("{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable ("id") int id){
        return new ResponseEntity<>(vehicleService.getVehicleByID(id), HttpStatus.OK);
    }

    // phân trang
    @GetMapping("page")
    public ResponseEntity<Map<String, Object>> getAllVehicleByPage(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer kindVehicleId,
            @RequestParam(required = false) String vehicleNumber,
            @RequestParam(required = false) Integer value,
            @RequestParam(required = false) Integer status
    ) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<Vehicle> vehiclePage = vehicleService.getAllVehiclePage(name, kindVehicleId, vehicleNumber, value, status, pageable);

        Map<String, Object> response = new HashMap<>();
        response.put("vehicles", vehiclePage.getContent());
        response.put("currentPage", vehiclePage.getNumber() + 1);
        response.put("totalItems", vehiclePage.getTotalElements());
        response.put("totalPages", vehiclePage.getTotalPages());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    // Update Vehicle by id
    @PutMapping("{id}")
    public ResponseEntity<Vehicle> updateVehicleById(@PathVariable ("id") int id, @RequestBody VehicleDTO vehicleDTO, HttpServletRequest request){
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
            Vehicle updateVehicle = vehicleService.updateVehicleByID(vehicleDTO, id);

            LogDTO logData =  logService.convertToLogDTO(userId, "Cập nhật phương tiện Id: "+ id, 2);
            logService.createLog(logData);
            return new ResponseEntity<>(updateVehicle, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete Vehicle by id
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteVehicleById(@PathVariable ("id") int id, HttpServletRequest request){
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
            vehicleService.deleteVehicleByID(id);

            // Ghi log sau khi hành động thành công
            LogDTO logData =  logService.convertToLogDTO(userId, "Xóa phương tiện Id: "+ id, 2);
            logService.createLog(logData);

            return new ResponseEntity<>("Vehicle " + id + " is deleted successfully", HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>("Vehicle " + id + " not found", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/available/{kindVehicleId}")
    public ResponseEntity<List<Vehicle>> getAvailableVehiclesByKindVehicleId(
            @PathVariable int kindVehicleId,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dayStart) {
        List<Vehicle> availableVehicles = vehicleService.findAvailableVehiclesByKindVehicleId(kindVehicleId, dayStart);
        return ResponseEntity.ok(availableVehicles);
    }
}
