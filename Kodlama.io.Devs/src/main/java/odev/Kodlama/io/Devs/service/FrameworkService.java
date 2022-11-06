package odev.Kodlama.io.Devs.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import odev.Kodlama.io.Devs.dto.FrameworkDto;
import odev.Kodlama.io.Devs.dto.FrameworkDtoConverter;
import odev.Kodlama.io.Devs.dto.SaveFrameworkRequest;
import odev.Kodlama.io.Devs.dto.UpdateLanguageRequest;
import odev.Kodlama.io.Devs.model.Framework;
import odev.Kodlama.io.Devs.model.Language;
import odev.Kodlama.io.Devs.repository.FrameworkRepository;

@Service
public class FrameworkService {
	
	private final FrameworkRepository frameworkRepository;
	private final FrameworkDtoConverter frameworkDtoConverter;
	private final LanguageService languageService;

	public FrameworkService(FrameworkRepository frameworkRepository, 
			                FrameworkDtoConverter frameworkDtoConverter,
			                LanguageService languageService) 
	{
		this.frameworkRepository = frameworkRepository;
		this.frameworkDtoConverter = frameworkDtoConverter;
		this.languageService = languageService;
	}

	public List<FrameworkDto> getAllFrameworks() {	
		return frameworkRepository.findAll()
				.stream()
				.map(f -> frameworkDtoConverter.convert(f))
				.collect(Collectors.toList());
	}
	
	public FrameworkDto findFrameworkById(int id) {
		return frameworkDtoConverter.convert(frameworkRepository.findById(id).orElseThrow());
	}
	
	protected Framework findById(int id) {
		return frameworkRepository.findById(id).orElseThrow();
	}
	
	public FrameworkDto add(SaveFrameworkRequest request) throws Exception {	
		Language language = languageService.findById(request.getLanguageId());
		
		Framework framework = new Framework();
		framework.setName(request.getName());
		framework.setLanguage(language);
		
		if(framework.getName().isBlank() || framework.getLanguage().getName().isBlank())
			throw new Exception("Framewok or Language names are not be null");
		
		frameworkRepository.save(framework);
		
		return frameworkDtoConverter.convert(framework);
	}
	
	public FrameworkDto updateFrameworkById(int id, UpdateLanguageRequest request) {
		
		Framework framework = findById(id);
		framework.setName(request.getName());
		
		frameworkRepository.save(framework);
		
		return frameworkDtoConverter.convert(framework);
	}
	
	public void deleteFrameworkById(int id) {
		frameworkRepository.deleteById(id);
	}
}
