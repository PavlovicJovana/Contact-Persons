package it.engineering.spring.mvc.task.contacts.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.engineering.spring.mvc.task.contacts.dao.ContactPersonDao;
import it.engineering.spring.mvc.task.contacts.entity.ContactPersonEntity;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class JpaContactPersonDaoImpl implements ContactPersonDao {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(ContactPersonEntity contactPersonEntity) throws Exception {
		entityManager.persist(contactPersonEntity);
	}

	@Override
	public ContactPersonEntity findById(Long id) throws Exception {
		return entityManager.find(ContactPersonEntity.class, id);
	}

	@Override
	public List<ContactPersonEntity> getAll() throws Exception {
		return entityManager
				.createQuery("SELECT contactPerson FROM ContactPersonEntity contactPerson ORDER BY firstname", ContactPersonEntity.class)
				.getResultList();
	}

	@Override
	public ContactPersonEntity update(ContactPersonEntity contactPersonEntity) throws Exception {
		return entityManager.merge(contactPersonEntity);
	}

}
