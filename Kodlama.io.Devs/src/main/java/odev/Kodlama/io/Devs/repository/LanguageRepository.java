package odev.Kodlama.io.Devs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import odev.Kodlama.io.Devs.model.Language;

public interface LanguageRepository extends JpaRepository<Language,Integer> {

	Language findByName(String name);
}
