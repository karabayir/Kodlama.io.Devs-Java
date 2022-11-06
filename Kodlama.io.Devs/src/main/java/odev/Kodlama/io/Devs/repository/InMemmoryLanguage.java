package odev.Kodlama.io.Devs.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import odev.Kodlama.io.Devs.model.Language;

//@Repository
public class InMemmoryLanguage {

	List<Language> languageList = new ArrayList<Language>();
	
	public List<Language> getAllLanguageList(){                            //lIST
		return languageList;
	}
	
	public Language addLanguage(Language language) throws Exception {    //ADD
		
		languageList.add(language);
		
		System.out.println(language+" dili eklendi");
		
		return language;
	}
	
	public void deleteLanguage(int id) {                              // DELETE
		
		Language result = getProgrammingLanguageById(id);
		
		languageList.remove(result);
		//languageList.remove(languageList.indexOf(result));
		
		System.out.println(id + " programala dili listeden kaldırıldı");
	}
	
	public Language updateLanguage(int id , Language newLanguage) throws Exception { //UPDATE
		
		Language result = getProgrammingLanguageById(id);
		
		languageList.set(languageList.indexOf(result), newLanguage);
		
		return newLanguage;
	}
	
	public Language getProgrammingLanguageById(int id) {
		return languageList.stream()
				.filter(l -> l.getId() == id)
				.findAny()
				.get();
				
	}
	
 
	
}
