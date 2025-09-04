package br.com.edukacode.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.edukacode.api.Entities.Genero;

public interface GeneroRepository extends JpaRepository<Genero, Long> {

}
