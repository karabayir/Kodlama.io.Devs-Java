package odev.Kodlama.io.Devs.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import odev.Kodlama.io.Devs.model.ProgrammingLanguage;

@Repository
public class InMemmoryLanguage {

	List<ProgrammingLanguage> languageList = new ArrayList<ProgrammingLanguage>();
	
	public List<ProgrammingLanguage> getAllLanguageList(){                            //lIST
		return languageList;
	}
	
	public ProgrammingLanguage addLanguage(ProgrammingLanguage language) throws Exception {    //ADD
		
		LanguageNameControl(language.getName());
		
		languageList.add(language);
		
		System.out.println(language+" dili eklendi");
		
		return language;
	}
	
	public void deleteLanguage(int id) {                              // DELETE
		
		ProgrammingLanguage result = getProgrammingLanguageById(id);
		
		languageList.remove(result);
		//languageList.remove(languageList.indexOf(result));
		
		System.out.println(id + " programala dili listeden kaldırıldı");
	}
	
	public ProgrammingLanguage updateLanguage(int id , ProgrammingLanguage newLanguage) throws Exception { //UPDATE
		
		ProgrammingLanguage result = getProgrammingLanguageById(id);
		
		LanguageNameControl(newLanguage.getName());
		
		languageList.set(languageList.indexOf(result), newLanguage);
		
		return newLanguage;
	}
	
	public ProgrammingLanguage getProgrammingLanguageById(int id) {
		return languageList.stream()
				.filter(l -> l.getId() == id)
				.findAny()
				.orElseThrow(()-> new NoSuchElementException(
						id+" numarasına ait progralama dili listede mevcut değil:)"));
	}
	
 
	
	public void LanguageNameControl(String languageName) throws Exception {
		
		List<String> names=languageList
				.stream()
				.map(l->l.getName())
				.collect(Collectors.toList());
		
		if(names.contains(languageName))
			throw new Exception(languageName+" dili zaten listede mevcuttur :)");
		
		if(languageName.isBlank()) 
			throw new Exception("programlama dili boş ya da null olmamalıdır");
	}
	
	
}
