package it.engineering.spring.mvc.task.contacts.converter;

import it.engineering.spring.mvc.task.contacts.dto.Dto;
import it.engineering.spring.mvc.task.contacts.entity.Entity;

public interface ConverterDtoEntity<DTO extends Dto, ENTITY extends Entity> {
	public DTO toDto(ENTITY entity);
	public ENTITY toEntity(DTO dto);

}
