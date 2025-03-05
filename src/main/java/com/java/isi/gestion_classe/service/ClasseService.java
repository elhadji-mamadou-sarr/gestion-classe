package com.java.isi.gestion_classe.service;

import com.java.isi.gestion_classe.model.Classe;
import com.java.isi.gestion_classe.repository.ClasseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClasseService {

    private ClasseRepository classeRepository;

    public ClasseService(ClasseRepository classeRepository) {
        this.classeRepository = classeRepository;
    }

    public List<Classe> listClasse(){
        return classeRepository.findAll();
    }

    public Classe addClasse(Classe classe){
        Classe classeTm;
        try{
            classeTm = classeRepository.save(classe);
        }catch (Exception message) {
            throw new RuntimeException("Echec de l'ajout : "+ message);
        }
        return classeTm;
    }


    public Classe getClasseById(Long id){
        Classe classe = classeRepository.findById(id).orElse(null);
        if (classe == null) {
            throw new RuntimeException("Classe non trouvé");
        }
        return classe;
    }

    public Classe updateClasse(Long id, Classe classeDetails){
        Classe classe = classeRepository.findById(id).orElseThrow(() -> new RuntimeException("Classe non trouve"));
        classe.setNom(classeDetails.getNom());
        classe.setNiveau(classeDetails.getNiveau());
        return classeRepository.save(classe);
    }

    public void deleteClasse(Long id){
        classeRepository.deleteById(id);
    }


}
