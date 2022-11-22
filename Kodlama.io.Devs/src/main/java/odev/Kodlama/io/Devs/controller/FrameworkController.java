package odev.Kodlama.io.Devs.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import odev.Kodlama.io.Devs.business.abstracts.FrameworkService;
import odev.Kodlama.io.Devs.business.requests.CreateFrameworkRequest;
import odev.Kodlama.io.Devs.business.requests.UpdateFrameworkRequest;
import odev.Kodlama.io.Devs.business.responses.CreateFrameworkResponse;
import odev.Kodlama.io.Devs.business.responses.GetAllFrameworkResponse;
import odev.Kodlama.io.Devs.business.responses.GetFrameworkResponse;
import odev.Kodlama.io.Devs.business.responses.UpdateFrameworkResponse;

@RestController
@RequestMapping("/api/v1/frameworks")
@AllArgsConstructor
public class FrameworkController {

	private final FrameworkService frameworkService;
	
	@GetMapping("getAll")
	List<GetAllFrameworkResponse> getAll(){
		return frameworkService.getAll();
	}
	
	@GetMapping("getByName")
	GetFrameworkResponse getByName(String name) {
		return frameworkService.getBtName(name);
	}
	
	@GetMapping("getById/{id}")
	GetFrameworkResponse getById(int id) {
		return frameworkService.getById(id);
	}
	
	@PostMapping("add")
	CreateFrameworkResponse add(CreateFrameworkRequest request) {
		return frameworkService.add(request);
	}
	@PutMapping("update")
	UpdateFrameworkResponse update(UpdateFrameworkRequest request) {
		return frameworkService.update(request);
	}
	@DeleteMapping("deleteById/{id}")
	void delete(int id) {
		frameworkService.delete(id);
	}
}
