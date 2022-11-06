package odev.Kodlama.io.Devs.dto;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import odev.Kodlama.io.Devs.model.Language;

@Component
public class LanguageDtoConverter {
	
	private final FrameworkDtoConverter frameworkDtoConverter;
	
	public LanguageDtoConverter(FrameworkDtoConverter frameworkDtoConverter) {
		this.frameworkDtoConverter = frameworkDtoConverter;
	}

	public LanguageDto convert(Language language) {
		
		LanguageDto languageDto = new LanguageDto();
		languageDto.setId(language.getId());
		languageDto.setName(language.getName());
		languageDto.setFrameworkList(language.getFrameworkList()
				.stream()
				.map(f-> frameworkDtoConverter.convert(f)).collect(Collectors.toList()));
		
		return languageDto;
	}

}
