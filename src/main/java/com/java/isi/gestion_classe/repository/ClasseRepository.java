package com.java.isi.gestion_classe.repository;


import com.java.isi.gestion_classe.model.Classe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClasseRepository extends JpaRepository<Classe, Long> {

}
