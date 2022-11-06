package odev.Kodlama.io.Devs.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import odev.Kodlama.io.Devs.model.Language;
import odev.Kodlama.io.Devs.repository.InMemmoryLanguage;

//@Service
public class LanguageServiceInMemory {
	
	private InMemmoryLanguage inMemmoryLanguage;
	

	public LanguageServiceInMemory(InMemmoryLanguage inMemmoryLanguage) {
		this.inMemmoryLanguage = inMemmoryLanguage;
	}
	
	
	public List<Language> getAllLanguages(){              
		return inMemmoryLanguage.getAllLanguageList();
	}
	
	public Language getProgrammingLanguageById(int id) {
		LanguageIdControl(id);
		return inMemmoryLanguage.getProgrammingLanguageById(id);
	}
	
	
	public Language addLanguage(Language language) throws Exception {
		LanguageNameControl(language.getName());
		return inMemmoryLanguage.addLanguage(language);
	}
	
	public void deleteLanguage(int id) {
		LanguageIdControl(id);
		inMemmoryLanguage.deleteLanguage(id);
	}
	
	public Language updateLanguage(int id , Language newLanguage) throws Exception {
		LanguageIdControl(id);
		LanguageNameControl(newLanguage.getName());
		return inMemmoryLanguage.updateLanguage(id, newLanguage);
	}
	
    public void LanguageNameControl(String languageName) throws Exception {
		
		List<String> names=inMemmoryLanguage.getAllLanguageList()
				.stream()
				.map(l->l.getName())
				.collect(Collectors.toList());
		
		if(names.contains(languageName))
			throw new Exception(languageName+" dili zaten listede mevcuttur :)");
		
		if(languageName.isBlank()) 
			throw new Exception("programlama dili boş ya da null olmamalıdır");
	}

	public void LanguageIdControl(int id) {
		inMemmoryLanguage.getAllLanguageList()
		.stream()
		.filter(l -> l.getId() == id)
		.findAny()
		.orElseThrow(()-> new NoSuchElementException(
				id+" numarasına ait progralama dili listede mevcut değil:)"));
			
	}
}
