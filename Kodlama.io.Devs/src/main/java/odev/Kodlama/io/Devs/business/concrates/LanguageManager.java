package odev.Kodlama.io.Devs.business.concrates;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import odev.Kodlama.io.Devs.business.abstracts.LanguageService;
import odev.Kodlama.io.Devs.business.requests.CreateLanguageRequest;
import odev.Kodlama.io.Devs.business.requests.UpdateLanguageRequest;
import odev.Kodlama.io.Devs.business.responses.CreateLanguageResponse;
import odev.Kodlama.io.Devs.business.responses.GetAllLanguageResponse;
import odev.Kodlama.io.Devs.business.responses.GetLanguageResponse;
import odev.Kodlama.io.Devs.business.responses.UpdateLanguageResponse;
import odev.Kodlama.io.Devs.core.utilities.mapping.ModelMapperService;
import odev.Kodlama.io.Devs.model.Language;
import odev.Kodlama.io.Devs.repository.LanguageRepository;

@Service
@AllArgsConstructor
public class LanguageManager implements LanguageService{
	
	private final LanguageRepository languageRepository;
	private final ModelMapperService mapperService;
	

	
	@Override
	public List<GetAllLanguageResponse> getAll() {
		return languageRepository.findAll()
				.stream()
				.map(l-> mapperService.forResponse().map(l, GetAllLanguageResponse.class))
				.collect(Collectors.toList());
	}

	@Override
	public GetLanguageResponse getByName(String name) {
		Language language= languageRepository.findByName(name);
		return mapperService.forResponse().map(language, GetLanguageResponse.class);
	}

	@Override
	public GetLanguageResponse getById(int id) {
		Language language = languageRepository.findById(id).orElseThrow();
		return mapperService.forResponse().map(language, GetLanguageResponse.class);
	}

	@Override
	public CreateLanguageResponse add(CreateLanguageRequest request) {
		Language language = mapperService.forRequest().map(request, Language.class);
		//language.setId(0);
		
		languageRepository.save(language);
		return mapperService.forResponse().map(language, CreateLanguageResponse.class);
	}

	@Override
	public UpdateLanguageResponse update(UpdateLanguageRequest request) {
		Language language = mapperService.forRequest().map(request, Language.class);
		languageRepository.save(language);
		return mapperService.forResponse().map(language, UpdateLanguageResponse.class);
	}

	@Override
	public void deleteById(int id) {
		languageRepository.deleteById(id);
	}
	
}
