package it.engineering.spring.mvc.task.contacts.dao;

import java.util.List;

import it.engineering.spring.mvc.task.contacts.entity.ManufacturerEntity;

public interface ManufacturerDao {
	ManufacturerEntity findById(Long id) throws Exception;
	List<ManufacturerEntity> getAll() throws Exception;
	
}
