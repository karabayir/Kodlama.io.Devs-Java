package odev.Kodlama.io.Devs.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import odev.Kodlama.io.Devs.model.ProgrammingLanguage;
import odev.Kodlama.io.Devs.service.LanguageService;

@RestController
@RequestMapping("/api/languages")
public class LanguageController {

	private LanguageService languageService;

	public LanguageController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@GetMapping("/getall")
	public List<ProgrammingLanguage> getAllLanguages(){
		return languageService.getAllLanguages();
	}
	
	@GetMapping("/{id}")
	public ProgrammingLanguage getProgrammingLanguageById(@PathVariable int id) {
		return languageService.getProgrammingLanguageById(id);
	}
	
	
	
	@PostMapping()
	public ProgrammingLanguage addLanguage(@RequestBody ProgrammingLanguage language) throws Exception {
		return languageService.addLanguage(language);
	}
	
	@DeleteMapping({"/{id}"})
	public void deleteLanguage(@PathVariable int id) {
		 languageService.deleteLanguage(id);
	}
	
	@PutMapping({"/{id}"})
	public ProgrammingLanguage updateLanguage(@PathVariable int id ,@RequestBody ProgrammingLanguage newLanguage) throws Exception {
		return languageService.updateLanguage(id, newLanguage);
	}

}
