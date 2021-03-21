package it.engineering.spring.mvc.task.contacts.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.engineering.spring.mvc.task.contacts.dao.CityDao;
import it.engineering.spring.mvc.task.contacts.entity.CityEntity;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class JpaCityDaoImpl implements CityDao {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public CityEntity findById(Long number) throws Exception {
		return entityManager.find(CityEntity.class, number);
	}

}
