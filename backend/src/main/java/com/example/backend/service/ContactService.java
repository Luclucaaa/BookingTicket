package com.example.backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.backend.dto.ContactDTO;
import com.example.backend.model.Contact;
import com.example.backend.model.Seat;

import java.util.List;

public interface ContactService {
    Contact createContact(ContactDTO contactDTO);
    List<Contact> getAllContact();
    Contact getContactByID(int id);
    Contact updateContactByID(ContactDTO contactDTO, int id);
    void deleteContactByID(int id);
    Page<Contact> getAllContactPage(String email, String name, String title, String content, Pageable pageable);
}
