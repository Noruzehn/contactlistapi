package com.noruzehn.contactlistapi.Service;

import com.noruzehn.contactlistapi.dto.ContactDto;
import com.noruzehn.contactlistapi.entity.Contact;
import com.noruzehn.contactlistapi.exception.ResourceNotFoundException;
import com.noruzehn.contactlistapi.repository.ContactRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class ContactService {

    private final ContactRepository contactRepository;
    private final ModelMapper mapper;

    public Iterable<Contact> findAll() {
        return contactRepository.findAll();
    }

    public Contact findById(Integer id) {
        return contactRepository
                .findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    public Contact create(ContactDto contactDto) {
        Contact contact = mapper.map(contactDto, Contact.class);
        contact.setCreateAt(LocalDateTime.now());
        return contactRepository.save(contact);
    }

    public Contact update(Integer id, ContactDto contactDto) {
        Contact contactFromDb = findById(id);
        mapper.map(contactDto, contactFromDb);
        return contactRepository.save(contactFromDb);
    }

    public void delete(Integer id) {
        Contact contactFromDb = findById(id);
        contactRepository.delete(contactFromDb);
    }
}