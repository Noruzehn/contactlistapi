package com.noruzehn.contactlistapi.controller;

import com.noruzehn.contactlistapi.Service.ContactService;
import com.noruzehn.contactlistapi.dto.ContactDto;
import com.noruzehn.contactlistapi.entity.Contact;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@AllArgsConstructor
@RequestMapping("/api/contacts")
@RestController
public class ContactController {

    private final ContactService contactService;

    @GetMapping
    public Iterable<Contact> list() {
        return contactService.findAll();
    }

    @GetMapping("{id}")
    public Contact get(@PathVariable Integer id) {
        return contactService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Contact create(@Validated @RequestBody ContactDto contactDto) {
        return contactService.create(contactDto);
    }

    @PutMapping("{id}")
    public Contact update(@PathVariable Integer id,
                          @Validated @RequestBody ContactDto contactDto) {
        return contactService.update(id, contactDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        contactService.delete(id);
    }
}