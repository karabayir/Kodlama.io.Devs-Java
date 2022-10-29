package odev.Kodlama.io.Devs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import odev.Kodlama.io.Devs.model.ProgrammingLanguage;
import odev.Kodlama.io.Devs.repository.InMemmoryLanguage;

@Service
public class LanguageService {
	
	private InMemmoryLanguage inMemmoryLanguage;

	public LanguageService(InMemmoryLanguage inMemmoryLanguage) {
		this.inMemmoryLanguage = inMemmoryLanguage;
	}
	
	
	public List<ProgrammingLanguage> getAllLanguages(){              
		return inMemmoryLanguage.getAllLanguageList();
	}
	
	public ProgrammingLanguage getProgrammingLanguageById(int id) {
		return inMemmoryLanguage.getProgrammingLanguageById(id);
	}
	
	
	public ProgrammingLanguage addLanguage(ProgrammingLanguage language) throws Exception {
		return inMemmoryLanguage.addLanguage(language);
	}
	
	public void deleteLanguage(int id) {
		inMemmoryLanguage.deleteLanguage(id);
	}
	
	public ProgrammingLanguage updateLanguage(int id , ProgrammingLanguage newLanguage) throws Exception {
		return inMemmoryLanguage.updateLanguage(id, newLanguage);
	}

	
}
