package it.engineering.spring.mvc.task.contacts.exception;

public class ExistEntityException extends MyApplicationException {
	private static final long serialVersionUID = 1L;
	private final Object entity; 
	
	public ExistEntityException(Object entity, String message) {
		super(message);
		this.entity = entity;
	}

	public Object getEntity() {
		return entity;
	}
	
}
