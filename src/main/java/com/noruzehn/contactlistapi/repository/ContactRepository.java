package com.noruzehn.contactlistapi.repository;

import com.noruzehn.contactlistapi.entity.Contact;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact, Integer> {
}
