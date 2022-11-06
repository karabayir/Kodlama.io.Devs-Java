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

import odev.Kodlama.io.Devs.dto.FrameworkDto;
import odev.Kodlama.io.Devs.dto.SaveFrameworkRequest;
import odev.Kodlama.io.Devs.dto.UpdateLanguageRequest;
import odev.Kodlama.io.Devs.service.FrameworkService;

@RestController
@RequestMapping("/api/frameworks/")
public class FrameworkController {

	private final FrameworkService frameworkService;

	public FrameworkController(FrameworkService frameworkService) {
		this.frameworkService = frameworkService;
	}
	
	@GetMapping
	public List<FrameworkDto> getAllFrameworks(){
		return frameworkService.getAllFrameworks();
	}
	
	@GetMapping("{id}")
	public FrameworkDto findFrameworkById(@PathVariable int id) {
		return frameworkService.findFrameworkById(id);
	}
	
	@PostMapping
	public FrameworkDto add(@RequestBody SaveFrameworkRequest request) throws Exception {
		return frameworkService.add(request);
	}
	
	@PutMapping("{id}")
	public FrameworkDto updateFrameworkById(@PathVariable int id, @RequestBody UpdateLanguageRequest request) {
		return frameworkService.updateFrameworkById(id, request);
	}
	
	@DeleteMapping("{id}")
	public void deleteFrameworkById(@PathVariable int id) {
		 frameworkService.deleteFrameworkById(id);
	}
}
