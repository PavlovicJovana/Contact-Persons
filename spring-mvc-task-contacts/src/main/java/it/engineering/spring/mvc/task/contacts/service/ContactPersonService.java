package it.engineering.spring.mvc.task.contacts.service;

import java.util.List;

import it.engineering.spring.mvc.task.contacts.dto.ContactPersonDto;

public interface ContactPersonService {
	void save(ContactPersonDto contactPersonDto) throws Exception;
	ContactPersonDto findById(Long id) throws Exception;
	List<ContactPersonDto> getAll() throws Exception;
	ContactPersonDto update(ContactPersonDto contactPersonDto) throws Exception;
}
