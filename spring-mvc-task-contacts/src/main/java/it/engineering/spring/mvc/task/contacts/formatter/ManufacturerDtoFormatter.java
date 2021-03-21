package it.engineering.spring.mvc.task.contacts.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import it.engineering.spring.mvc.task.contacts.dto.ManufacturerDto;
import it.engineering.spring.mvc.task.contacts.service.ManufacturerService;

public class ManufacturerDtoFormatter implements Formatter<ManufacturerDto> {
	private final ManufacturerService manufacturerService;
	
	@Autowired
	public ManufacturerDtoFormatter(ManufacturerService manufacturerService) {
		this.manufacturerService = manufacturerService;
	}

	@Override
	public String print(ManufacturerDto manufacturerDto, Locale locale) {
		return manufacturerDto.getId() + " - " + manufacturerDto.getName();
	}

	@Override
	public ManufacturerDto parse(String manufacturer, Locale locale) throws ParseException {
		Long id = Long.parseLong(manufacturer);
		try {
			ManufacturerDto manufacturerDto = manufacturerService.findById(id);
			return manufacturerDto;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ParseException("Greska u formatter-u", 0);
		}
	}

}
