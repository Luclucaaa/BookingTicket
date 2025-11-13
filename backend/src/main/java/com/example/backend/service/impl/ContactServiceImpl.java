package com.example.backend.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import com.example.backend.dto.ContactDTO;
import com.example.backend.exception.ResourceNotFoundException;
import com.example.backend.model.Contact;
import com.example.backend.model.Trip;
import com.example.backend.repository.ContactRepository;
import com.example.backend.repository.specification.ContactSpecification;
import com.example.backend.repository.specification.TripSpecifications;
import com.example.backend.service.ContactService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {
    private ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public Contact createContact(ContactDTO ContactDTO) {
        Contact contact = new Contact();
        contact.setContent(ContactDTO.getContent());
        contact.setEmail(ContactDTO.getEmail());
        contact.setName(ContactDTO.getName());
        contact.setTitle(ContactDTO.getTitle());
        contact.setCreatedAt(LocalDateTime.now());
        return contactRepository.save(contact);
    }

    @Override
    public List<Contact> getAllContact() { return contactRepository.findAll();}

    @Override
    public Contact getContactByID(int id) {
        return contactRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Contact", "Id", id));
    }

    @Override
    public Contact updateContactByID(ContactDTO contactDTO, int id) {
        Contact existingContact  = contactRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Contact", "Id", id));
        existingContact.setContent(contactDTO.getContent());
        existingContact.setEmail(contactDTO.getEmail());
        existingContact.setName(contactDTO.getName());
        existingContact.setTitle(contactDTO.getTitle());
        existingContact.setCreatedAt(LocalDateTime.now());
        return contactRepository.save(existingContact);
    }

    @Override
    public void deleteContactByID(int id) {
        contactRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Contact", "Id", id));
        contactRepository.deleteById(id);
    }

    @Override
    public Page<Contact> getAllContactPage(String email, String name, String title, String content, Pageable pageable) {
        Specification<Contact> spec = Specification
                .where(ContactSpecification.hasEmail(email))
                .and(ContactSpecification.hasName(name))
                .and(ContactSpecification.hasTitle(title))
                .and(ContactSpecification.hasContent(content));

        return contactRepository.findAll(spec, pageable);
    }

}
