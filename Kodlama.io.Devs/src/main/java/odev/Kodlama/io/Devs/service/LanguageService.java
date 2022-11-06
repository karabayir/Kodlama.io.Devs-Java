package odev.Kodlama.io.Devs.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import odev.Kodlama.io.Devs.dto.LanguageDto;
import odev.Kodlama.io.Devs.dto.LanguageDtoConverter;
import odev.Kodlama.io.Devs.dto.SaveLanguageRequest;
import odev.Kodlama.io.Devs.dto.UpdateLanguageRequest;
import odev.Kodlama.io.Devs.model.Language;
import odev.Kodlama.io.Devs.repository.LanguageRepository;

@Service
public class LanguageService {
	
	private final LanguageRepository languageRepository;
	private final LanguageDtoConverter  languageDtoConverter;

	public LanguageService(LanguageRepository languageRepository, LanguageDtoConverter languageDtoConverter) {
		this.languageRepository = languageRepository;
		this.languageDtoConverter = languageDtoConverter;
	}
	
	public List<LanguageDto> getAllLanguages(){

		return languageRepository.findAll()
				.stream()
				.map(l-> languageDtoConverter.convert(l))
				.collect(Collectors.toList());
			
	}
	
	public LanguageDto findLanguageById(int id) {
		return languageDtoConverter.convert(languageRepository.findById(id).orElseThrow());
	}
	
    protected Language findById(int id) {
    	return languageRepository.findById(id).orElseThrow();
    }
	
	public LanguageDto add(SaveLanguageRequest request) {
		
		Language language = new Language();
		language.setName(request.getName());
		
		LanguageDto languageDto = new LanguageDto();
		languageDto.setId(language.getId());
		languageDto.setName(language.getName());
		
		languageRepository.save(language);
		
		return languageDto;
	}
	
	public void deleteLanguageById(int id) {
		languageRepository.deleteById(id);
	}
	
	public LanguageDto updateLanguageById(int id, UpdateLanguageRequest request) {
		Language language = languageRepository.findById(id).orElseThrow();
		language.setName(request.getName());
		languageRepository.save(language);
		
		return languageDtoConverter.convert(language);
	}
}
