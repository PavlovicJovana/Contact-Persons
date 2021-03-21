package it.engineering.spring.mvc.task.contacts.service;

import java.util.List;

import it.engineering.spring.mvc.task.contacts.dto.ManufacturerDto;

public interface ManufacturerService {
	ManufacturerDto findById(Long id) throws Exception;	
	List<ManufacturerDto> getAll() throws Exception;
}
