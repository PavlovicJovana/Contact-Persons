package it.engineering.spring.mvc.task.contacts.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.engineering.spring.mvc.task.contacts.dto.ContactPersonDto;
import it.engineering.spring.mvc.task.contacts.dto.ManufacturerDto;
import it.engineering.spring.mvc.task.contacts.service.ContactPersonService;
import it.engineering.spring.mvc.task.contacts.service.ManufacturerService;
import it.engineering.spring.mvc.task.contacts.validator.ContactPersonValidator;

@Controller
@RequestMapping(path = {"/contactPerson", "/cp"})
public class ContactPersonController {
	private final ContactPersonService contactPersonService;
	private final ManufacturerService manufacturerService;
	
	@Autowired
	public ContactPersonController(ContactPersonService contactPersonService, ManufacturerService manufacturerService) {
		this.contactPersonService = contactPersonService;
		this.manufacturerService = manufacturerService;
	}
	
	@GetMapping(path = "/add")
	public ModelAndView add() {
		ModelAndView modelAndView = new ModelAndView("contactPerson/contactPerson-add");
		return modelAndView;
	}
	
	@PostMapping(path = "/confirm")
	public ModelAndView confirm(@Valid @ModelAttribute(name = "contactPersonDto") ContactPersonDto contactPersonDto, Errors errors) {
		ModelAndView modelAndView = new ModelAndView();
		String view = "contactPerson/contactPerson-add";
		
		if(errors.hasErrors()) {
			System.out.println("Imamo greske kod validacije");
			if (contactPersonDto.getId()!=null) view = "contactPerson/contactPerson-edit";
		} else view = "contactPerson/contactPerson-confirm";
		
		modelAndView.setViewName(view);
		return modelAndView;
	}
	
	@PostMapping(path = "/saveOrUpdate")
	public ModelAndView saveOrUpdate(@Valid @ModelAttribute(name = "contactPersonDto") ContactPersonDto contactPersonDto, Errors errors,
			RedirectAttributes redirectAttributes) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		String view = "contactPerson/contactPerson-add";
		
		if(errors.hasErrors()) {
			System.out.println("Ima gresaka kod validacije");
			if(contactPersonDto.getId() != null) view = "contactPerson/contactPerson-edit";
		} else {
			System.out.println("Nema gresaka kod validacije");
			if(contactPersonDto.getId() == null) {
				contactPersonService.save(contactPersonDto);
				redirectAttributes.addFlashAttribute("info", "Successfully saved contact person");
				view = "redirect:/contactPerson/add";
			} else {	
				contactPersonDto = contactPersonService.update(contactPersonDto);
				redirectAttributes.addFlashAttribute("info", "Successfully updated contact person");
				view = "redirect:/contactPerson/details/id/" + contactPersonDto.getId();
			}
		}
		
		modelAndView.setViewName(view);
		return modelAndView;
	}
	
	@GetMapping(path = "/list")
	public ModelAndView list() throws Exception {
		ModelAndView modelAndView = new ModelAndView("contactPerson/contactPerson-list");
		modelAndView.addObject("contactPersons", contactPersonService.getAll());
		return modelAndView;
	}
	
	@GetMapping(path = "/details/id/{id}")
	public ModelAndView details(@PathVariable (name = "id") Long id) throws Exception {
		ContactPersonDto contactPersonDto = contactPersonService.findById(id);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("contactPerson/contactPerson-details");
		modelAndView.addObject("contactPersonDto", contactPersonDto);

		return modelAndView;
	}
	
	@GetMapping(path = "/edit/id/{id}")
	public ModelAndView edit(@PathVariable(name = "id") Long id) throws Exception {
		ContactPersonDto contactPersonDto = contactPersonService.findById(id);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("contactPerson/contactPerson-edit");
		modelAndView.addObject("contactPersonDto", contactPersonDto);
		return modelAndView;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new ContactPersonValidator());
	}
	
	@ModelAttribute(name = "manufacturers")
	private List<ManufacturerDto> getManufacturers() throws Exception {
		return manufacturerService.getAll();
	}
	
	@ModelAttribute(name = "contactPersonDto")
	private ContactPersonDto getManufacturerDto() {
		ContactPersonDto contactPersonDto = new ContactPersonDto();
		return contactPersonDto;
	} 
	
}
