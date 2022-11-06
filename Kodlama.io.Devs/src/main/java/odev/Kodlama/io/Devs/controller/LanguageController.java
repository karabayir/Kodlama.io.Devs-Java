package odev.Kodlama.io.Devs.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import odev.Kodlama.io.Devs.dto.LanguageDto;
import odev.Kodlama.io.Devs.dto.SaveLanguageRequest;
import odev.Kodlama.io.Devs.dto.UpdateLanguageRequest;
import odev.Kodlama.io.Devs.service.LanguageService;

@RestController
@RequestMapping("/api/languages/")
public class LanguageController {

	private final LanguageService languageService;

	public LanguageController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@GetMapping
	public List<LanguageDto> getAllLanguages(){
		return languageService.getAllLanguages();
	}
	
	@GetMapping("{id}")
	public LanguageDto findLanguageById(@PathVariable int id) {
		return languageService.findLanguageById(id);
	}
	
	@PostMapping
	public LanguageDto add(@RequestBody SaveLanguageRequest request) throws Exception {
		return languageService.add(request);
	}
	
	@PutMapping("{id}")
	public LanguageDto updateLanguageById(@PathVariable int id,@RequestBody UpdateLanguageRequest request) {
		return languageService.updateLanguageById(id, request);
	}
	
	@DeleteMapping("{id}")
	public void deleteLanguageById(int id) {
		languageService.deleteLanguageById(id);
	}
	
}
