package com.example.backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.backend.dto.BookingDetailDTO;
import com.example.backend.model.BookingDetail;

import java.util.List;

public interface BookingDetailService {
    BookingDetail createBookingDetail(BookingDetailDTO orderDetailDTO);
    List<BookingDetail> getAllBookingDetail();
    BookingDetail getBookingDetailByID(String id);
    BookingDetail updateBookingDetailByID(BookingDetail orderDetail, String id);
    void deleteBookingDetailByID(String id);
    List<BookingDetail> getBookingDetailsByBookingId(int bookingId);
    List<BookingDetail> getAllBookingDetailByUserId(int userId);
    Page<BookingDetail> getBookingDetailsByUserId(int userId, Pageable pageable);
    Page<BookingDetail> getBookingDetailsByUserId(int userId, Pageable pageable, String id);

}
