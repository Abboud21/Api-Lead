package br.com.edukacode.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.edukacode.api.Entities.Lead;

public interface LeadRepository extends JpaRepository<Lead, Long> {
    // JpaRepository estão presentes na interface

}
