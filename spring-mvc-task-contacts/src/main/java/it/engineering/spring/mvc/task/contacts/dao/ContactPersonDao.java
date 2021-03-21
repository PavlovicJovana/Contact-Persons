package it.engineering.spring.mvc.task.contacts.dao;

import java.util.List;

import it.engineering.spring.mvc.task.contacts.entity.ContactPersonEntity;

public interface ContactPersonDao {
	void save(ContactPersonEntity contactPersonEntity) throws Exception;
	ContactPersonEntity findById(Long id) throws Exception;
	List<ContactPersonEntity> getAll() throws Exception;
	ContactPersonEntity update(ContactPersonEntity contactPersonEntity) throws Exception;

}
