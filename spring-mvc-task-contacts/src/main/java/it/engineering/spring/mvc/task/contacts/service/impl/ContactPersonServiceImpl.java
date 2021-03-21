package it.engineering.spring.mvc.task.contacts.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.engineering.spring.mvc.task.contacts.converter.impl.ContactPersonConverterDtoEntity;
import it.engineering.spring.mvc.task.contacts.dao.CityDao;
import it.engineering.spring.mvc.task.contacts.dao.ContactPersonDao;
import it.engineering.spring.mvc.task.contacts.dao.ManufacturerDao;
import it.engineering.spring.mvc.task.contacts.dto.ContactPersonDto;
import it.engineering.spring.mvc.task.contacts.entity.CityEntity;
import it.engineering.spring.mvc.task.contacts.entity.ContactPersonEntity;
import it.engineering.spring.mvc.task.contacts.entity.ManufacturerEntity;
import it.engineering.spring.mvc.task.contacts.exception.ExistEntityException;
import it.engineering.spring.mvc.task.contacts.service.ContactPersonService;

@Service
@Transactional
public class ContactPersonServiceImpl implements ContactPersonService {
	private final ContactPersonDao contactPersonDao;
	private final ManufacturerDao manufacturerDao;
	private final CityDao cityDao;
	private final ContactPersonConverterDtoEntity contactPersonConverterDtoEntity;
	
	@Autowired
	public ContactPersonServiceImpl(ContactPersonDao contactPersonDao, ManufacturerDao manufacturerDao, CityDao cityDao, ContactPersonConverterDtoEntity contactPersonConverterDtoEntity) {
		this.contactPersonDao = contactPersonDao;
		this.manufacturerDao = manufacturerDao;
		this.cityDao = cityDao;
		this.contactPersonConverterDtoEntity = contactPersonConverterDtoEntity;
	}
	
	@Override
	public void save(ContactPersonDto contactPersonDto) throws Exception {
		ManufacturerEntity manufacturerEntity = manufacturerDao.findById(contactPersonDto.getManufacturerDto().getId());
		if(manufacturerEntity == null) {
			throw new ExistEntityException(contactPersonDto.getManufacturerDto(), "Manufacturer with id " + contactPersonDto.getManufacturerDto().getId() + " don't exist!");
		}

		CityEntity cityEntity = cityDao.findById(contactPersonDto.getManufacturerDto().getCityDto().getNumber());
		if(cityEntity == null) {
			throw new ExistEntityException(contactPersonDto.getManufacturerDto().getCityDto(), "City with number " + contactPersonDto.getManufacturerDto().getCityDto().getNumber() + " don't exist!");
		}
		
		contactPersonDao.save(contactPersonConverterDtoEntity.toEntity(contactPersonDto));
	}

	@Override
	public ContactPersonDto findById(Long id) throws Exception {
		ContactPersonEntity contactPersonEntity = contactPersonDao.findById(id);
		
		if(contactPersonEntity == null) {
			throw new ExistEntityException(contactPersonEntity, "Contact person with id " + id + " don't exist!");
		}
		
		return contactPersonConverterDtoEntity.toDto(contactPersonEntity);
	}

	@Override
	public List<ContactPersonDto> getAll() throws Exception {
		List<ContactPersonEntity> entities = contactPersonDao.getAll();
		return entities.stream().map(entity -> {return contactPersonConverterDtoEntity.toDto(entity);}).collect(Collectors.toList());
	}

	@Override
	public ContactPersonDto update(ContactPersonDto contactPersonDto) throws Exception {
		ContactPersonEntity contactPersonEntity = contactPersonDao.findById(contactPersonDto.getId());
		if (contactPersonEntity == null) {
			throw new ExistEntityException(contactPersonDto, "Contact person with id " + contactPersonDto.getId() + " don't exist!");
		}
		
		ManufacturerEntity manufacturerEntity = manufacturerDao.findById(contactPersonDto.getManufacturerDto().getId());
		if(manufacturerEntity == null) {
			throw new ExistEntityException(contactPersonDto.getManufacturerDto(), "Manufacturer with id " + contactPersonDto.getManufacturerDto().getId() + " don't exist!");
		}
		
		CityEntity cityEntity = cityDao.findById(contactPersonDto.getManufacturerDto().getCityDto().getNumber());
		if(cityEntity == null) {
			throw new ExistEntityException(contactPersonDto.getManufacturerDto().getCityDto(), "City with number " + contactPersonDto.getManufacturerDto().getCityDto().getNumber() + " don't exist!");
		}
		
		ContactPersonEntity entity = new ContactPersonEntity();
		entity.setId(contactPersonDto.getId());
		entity.setFirstname(contactPersonDto.getFirstname());
		entity.setLastname(contactPersonDto.getLastname());
		entity.setManufacturer(manufacturerEntity);
		
		entity = contactPersonDao.update(entity);
		
		return contactPersonConverterDtoEntity.toDto(entity);
	}

}
