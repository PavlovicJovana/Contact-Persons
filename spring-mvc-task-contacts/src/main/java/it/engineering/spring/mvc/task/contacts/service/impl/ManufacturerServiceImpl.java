package it.engineering.spring.mvc.task.contacts.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.engineering.spring.mvc.task.contacts.converter.impl.ManufacturerConverterDtoEntity;
import it.engineering.spring.mvc.task.contacts.dao.ManufacturerDao;
import it.engineering.spring.mvc.task.contacts.dto.ManufacturerDto;
import it.engineering.spring.mvc.task.contacts.entity.ManufacturerEntity;
import it.engineering.spring.mvc.task.contacts.exception.ExistEntityException;
import it.engineering.spring.mvc.task.contacts.service.ManufacturerService;

@Service
@Transactional
public class ManufacturerServiceImpl implements ManufacturerService {
	private final ManufacturerDao manufacturerDao;
	private final ManufacturerConverterDtoEntity manufacturerConverterDtoEntity;
	
	@Autowired
	public ManufacturerServiceImpl(ManufacturerDao manufacturerDao, ManufacturerConverterDtoEntity manufacturerConverterDtoEntity) {
		this.manufacturerDao = manufacturerDao;
		this.manufacturerConverterDtoEntity = manufacturerConverterDtoEntity;
	}
	
	@Override
	public ManufacturerDto findById(Long id) throws Exception {
		ManufacturerEntity manufacturerEntity = manufacturerDao.findById(id);
		
		if (manufacturerEntity==null) throw new ExistEntityException(manufacturerEntity, "Manufactuerr with id " + id + " don't exist!");
		
		return manufacturerConverterDtoEntity.toDto(manufacturerEntity);
	}
	
	@Override
	public List<ManufacturerDto> getAll() throws Exception {
		List<ManufacturerEntity> entities = manufacturerDao.getAll();
		return entities.stream().map(entity->{return manufacturerConverterDtoEntity.toDto(entity);}).collect(Collectors.toList());
	}

}
