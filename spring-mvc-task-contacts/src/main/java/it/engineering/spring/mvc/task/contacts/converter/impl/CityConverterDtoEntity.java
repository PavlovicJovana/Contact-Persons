package it.engineering.spring.mvc.task.contacts.converter.impl;

import org.springframework.stereotype.Component;

import it.engineering.spring.mvc.task.contacts.converter.ConverterDtoEntity;
import it.engineering.spring.mvc.task.contacts.dto.CityDto;
import it.engineering.spring.mvc.task.contacts.entity.CityEntity;

@Component
public class CityConverterDtoEntity implements ConverterDtoEntity<CityDto, CityEntity> {

	@Override
	public CityDto toDto(CityEntity e) {
		return new CityDto(e.getNumber(), e.getName());
	}

	@Override
	public CityEntity toEntity(CityDto dto) {
		return new CityEntity(dto.getNumber(),dto.getName());
	}

}
