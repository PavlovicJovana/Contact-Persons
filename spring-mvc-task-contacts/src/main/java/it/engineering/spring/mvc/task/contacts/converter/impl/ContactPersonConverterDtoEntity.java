package it.engineering.spring.mvc.task.contacts.converter.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.engineering.spring.mvc.task.contacts.converter.ConverterDtoEntity;
import it.engineering.spring.mvc.task.contacts.dto.ContactPersonDto;
import it.engineering.spring.mvc.task.contacts.entity.ContactPersonEntity;

@Component
public class ContactPersonConverterDtoEntity implements ConverterDtoEntity<ContactPersonDto, ContactPersonEntity> {
	private ManufacturerConverterDtoEntity manufacturerConverterDtoEntity;
	
	@Autowired
	public ContactPersonConverterDtoEntity(ManufacturerConverterDtoEntity manufacturerConverterDtoEntity) {
		this.manufacturerConverterDtoEntity = manufacturerConverterDtoEntity;
	}

	@Override
	public ContactPersonDto toDto(ContactPersonEntity entity) {
		return new ContactPersonDto(entity.getId(), entity.getFirstname(), entity.getLastname(), manufacturerConverterDtoEntity.toDto(entity.getManufacturer()));
	}

	@Override
	public ContactPersonEntity toEntity(ContactPersonDto dto) {
		return new ContactPersonEntity(dto.getId(), dto.getFirstname(), dto.getLastname(), manufacturerConverterDtoEntity.toEntity(dto.getManufacturerDto()));
	}

}
