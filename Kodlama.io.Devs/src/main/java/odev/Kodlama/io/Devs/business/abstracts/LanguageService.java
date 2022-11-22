package odev.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import odev.Kodlama.io.Devs.business.requests.CreateLanguageRequest;
import odev.Kodlama.io.Devs.business.requests.UpdateLanguageRequest;
import odev.Kodlama.io.Devs.business.responses.CreateLanguageResponse;
import odev.Kodlama.io.Devs.business.responses.GetAllLanguageResponse;
import odev.Kodlama.io.Devs.business.responses.GetLanguageResponse;
import odev.Kodlama.io.Devs.business.responses.UpdateLanguageResponse;

public interface LanguageService {

	List<GetAllLanguageResponse> getAll();
	
	GetLanguageResponse getByName(String name);
	
	GetLanguageResponse getById(int id);
	
	CreateLanguageResponse add(CreateLanguageRequest request);
	
	UpdateLanguageResponse update(UpdateLanguageRequest request); 
	
	void deleteById(int id);
}
