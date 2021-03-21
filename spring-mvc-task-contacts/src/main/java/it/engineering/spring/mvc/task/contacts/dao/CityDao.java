package it.engineering.spring.mvc.task.contacts.dao;

import it.engineering.spring.mvc.task.contacts.entity.CityEntity;

public interface CityDao {
	CityEntity findById(Long number) throws Exception;

}
