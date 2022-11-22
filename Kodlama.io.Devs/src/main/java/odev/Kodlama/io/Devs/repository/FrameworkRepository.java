package odev.Kodlama.io.Devs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import odev.Kodlama.io.Devs.model.Framework;

public interface FrameworkRepository extends JpaRepository<Framework, Integer>{

	Framework findByName(String name);
}
