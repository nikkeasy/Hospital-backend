package hh.swd20.Hospital_project.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd20.Hospital_project.domain.Patient;
import hh.swd20.Hospital_project.domain.PatientRepository;
import hh.swd20.Hospital_project.domain.WardRepository;
import hh.swd20.Hospital_project.domain.Ward;


@Controller
public class PatientController {
	@Autowired
	private PatientRepository prepository; 
	
	@Autowired 
	private WardRepository wrepository; 
	
	

	//Show all
    @RequestMapping(value="/login")
    public String login() {	
        return "login";
    }	
    
 // Basic view 
    @RequestMapping(value="/")
    public String homePage(Model model) {	
        
        return "index";
    }
	
    @RequestMapping(value="/index")
    public String homePageOne(Model model) {	
        
        return "index";
    }
	
	
	// Show all students
    @RequestMapping(value="/patientslist")
    public String patientList(Model model) {	
        model.addAttribute("patients", prepository.findAll());
        return "patientslist";
    }
    
 
    
    
    // Add P A T I E N T 
    @RequestMapping(value = "/add")
    public String addPatient(Model model){
    	model.addAttribute("patient", new Patient());
    	model.addAttribute("wards", wrepository.findAll());
        return "addpatient";
    }     
    
    // Save P A T I E N T 
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Patient patient){
        prepository.save(patient);
        return "redirect:patientslist";
    }   
    
 
	//-----------  D E L E T E FUNCTIONALITIES ----- 

    // Delete P A T I E N T 

    @RequestMapping(value = "/deletepatient/{id}", method = RequestMethod.GET)
    public String deletePatient(@PathVariable("id") Long patientId, Model model) {
    	prepository.deleteById(patientId);
        return "redirect:../patientslist";
    }     
   

    
	
	@RequestMapping(value="/editpatient/{id}", method = RequestMethod.GET)
	public String editPatient(@PathVariable("id") Long patientId, Model model) {
	    model.addAttribute("patient", prepository.findById(patientId)); // Miksi eri metodi kuin departmentsissä? 
	    model.addAttribute("wardslist", wrepository.findAll()); // Miksi tässä findAll 
	 
	return "editpatient";
	
	}

	
	@RequestMapping(value = "/saveedit", method = RequestMethod.POST)
		public String savePatientEdit(@ModelAttribute @Valid Patient patient, BindingResult bindingResult, Model model) {
			if (bindingResult.hasErrors()) {
				model.addAttribute("wardslist", prepository.findAll());
				return "editpatient";
				}
			prepository.save(patient);
			return "redirect:/patientslist"; 
		}
	
	

	@RequestMapping(value = "/allwards", method = RequestMethod.GET)
	public String getAllWards(Model model) {
		List<Ward> wards = (List<Ward>) wrepository.findAll();
		model.addAttribute("wardslist", wards);
		return "wardslist";
	}

	
	
  
	
    
    
    
	// RESTful service to get all patients
    @RequestMapping(value="/patients")
    public @ResponseBody List<Patient> patientListRest() {	
        return (List<Patient>) prepository.findAll();
    }    

	// RESTful service to get a patient by id
    @RequestMapping(value="/patient/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Patient> findPatientRest(@PathVariable("id") Long patientId) {	
    	return prepository.findById(patientId);
    }   
    
    
    
    
    
    
    /*   
       	// ADD W A R D  - Lisätään uusi osasto 
       
   	@RequestMapping(value = "/newward", method = RequestMethod.GET)
   	public String getNewWardForm(Model model) {
   		model.addAttribute("ward", new Ward());
   		return "newwardform";
   	}
       
   	
   		// Save W A R D 
       
   	@RequestMapping(value = "/saveward", method = RequestMethod.POST)
   	public String saveBook(@ModelAttribute @Valid Ward ward, BindingResult bindingResult1, Model model) {
   		// talletetaan yhden kategorian tiedot tietokantaan
   		if (bindingResult1.hasErrors()) {
   			//model.addAttribute("cat", new Category());
   			return "newwardform";
   		}
   		wrepository.save(ward);
   		return "redirect:/allwards"; //allcats-endpointin kutsu. 
   	} 
   	
   	*/ 
   	
    
    
    
}
