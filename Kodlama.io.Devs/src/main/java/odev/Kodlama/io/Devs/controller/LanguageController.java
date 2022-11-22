package odev.Kodlama.io.Devs.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import odev.Kodlama.io.Devs.business.abstracts.LanguageService;

import odev.Kodlama.io.Devs.business.requests.CreateLanguageRequest;
import odev.Kodlama.io.Devs.business.requests.UpdateLanguageRequest;
import odev.Kodlama.io.Devs.business.responses.CreateLanguageResponse;
import odev.Kodlama.io.Devs.business.responses.GetAllLanguageResponse;
import odev.Kodlama.io.Devs.business.responses.GetLanguageResponse;
import odev.Kodlama.io.Devs.business.responses.UpdateLanguageResponse;


@RestController
@RequestMapping("/api/v1/languages/")
@AllArgsConstructor
public class LanguageController {

	private final LanguageService languageService;
	
	@GetMapping("getAll")
	public List<GetAllLanguageResponse> getAll(){
		return languageService.getAll();
	}
	
	@GetMapping("getAllByName")
	GetLanguageResponse getByName(String name){
		return languageService.getByName(name);
	}
	
	@GetMapping("getById/{id}")
	public GetLanguageResponse getById(@PathVariable int id) {
		return languageService.getById(id);
	}
	
	@PostMapping("add")
	public CreateLanguageResponse add(CreateLanguageRequest request) {
		return languageService.add(request);
	}
	
	@PutMapping("update")
	UpdateLanguageResponse update(UpdateLanguageRequest request) {
		return languageService.update(request);
	}
	
	@DeleteMapping("deleteById/{id}")
	void deleteById(@PathVariable int id) {
		languageService.deleteById(id);
	}
}
