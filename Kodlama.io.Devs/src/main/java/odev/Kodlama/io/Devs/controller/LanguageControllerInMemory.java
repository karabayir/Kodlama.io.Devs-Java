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

import odev.Kodlama.io.Devs.model.Language;
import odev.Kodlama.io.Devs.service.LanguageServiceInMemory;

/*@RestController
@RequestMapping("/api/languages")*/
public class LanguageControllerInMemory {

	private LanguageServiceInMemory languageService;

	public LanguageControllerInMemory(LanguageServiceInMemory languageService) {
		this.languageService = languageService;
	}
	
	@GetMapping("/getall")
	public List<Language> getAllLanguages(){
		return languageService.getAllLanguages();
	}
	
	@GetMapping("/{id}")
	public Language getProgrammingLanguageById(@PathVariable int id) {
		return languageService.getProgrammingLanguageById(id);
	}
	
	
	
	@PostMapping()
	public Language addLanguage(@RequestBody Language language) throws Exception {
		return languageService.addLanguage(language);
	}
	
	@DeleteMapping({"/{id}"})
	public void deleteLanguage(@PathVariable int id) {
		 languageService.deleteLanguage(id);
	}
	
	@PutMapping({"/{id}"})
	public Language updateLanguage(@PathVariable int id ,@RequestBody Language newLanguage) throws Exception {
		return languageService.updateLanguage(id, newLanguage);
	}

}
