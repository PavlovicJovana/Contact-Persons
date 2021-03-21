package it.engineering.spring.mvc.task.contacts.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.engineering.spring.mvc.task.contacts.dao.ManufacturerDao;
import it.engineering.spring.mvc.task.contacts.entity.ManufacturerEntity;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class JpaManufacturerDaoImpl implements ManufacturerDao {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public ManufacturerEntity findById(Long number) throws Exception {
		return entityManager.find(ManufacturerEntity.class, number);
	}
	
	@Override
	public List<ManufacturerEntity> getAll() throws Exception {
		return entityManager
				.createQuery("SELECT manufacturer from ManufacturerEntity manufacturer ORDER BY name", ManufacturerEntity.class)
				.getResultList();
	}

}
