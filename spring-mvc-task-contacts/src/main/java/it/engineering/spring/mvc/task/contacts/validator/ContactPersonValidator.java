package it.engineering.spring.mvc.task.contacts.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import it.engineering.spring.mvc.task.contacts.dto.ContactPersonDto;

public class ContactPersonValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return ContactPersonDto.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ContactPersonDto contactPersonDto = (ContactPersonDto) target;
		if(contactPersonDto != null) {
			if(contactPersonDto.getFirstname().isEmpty()) {
				errors.rejectValue("firstname", "contactPerson.firstname", "Ime je obavezno polje");
			}
			if(contactPersonDto.getLastname().isEmpty()) {
				errors.rejectValue("lastname", "contactPerson.lastname", "Prezime je obavezno polje");
			}
			if(contactPersonDto.getManufacturerDto() == null) {
				errors.rejectValue("manufacturerDto", "contactPerson.manufacturerDto", "Proizvodjac je obavezno polje");
			}
		}
	}

	

}
