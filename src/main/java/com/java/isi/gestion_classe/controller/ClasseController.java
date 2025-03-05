package com.java.isi.gestion_classe.controller;

import com.java.isi.gestion_classe.model.Classe;
import com.java.isi.gestion_classe.service.ClasseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/classes")
public class ClasseController {

    @Autowired
    private ClasseService classeService;

    @GetMapping()
    public String listClasse(Model model){
        List<Classe> classes = classeService.listClasse();
        model.addAttribute("classes", classes);
        return "classes/list";
    }

    @GetMapping("/{id}")
    public Classe getClasseById(@PathVariable Long id){
        return  classeService.getClasseById(id);
    }

    @GetMapping("/add")
    public  String showAddClasse(Model model){
        model.addAttribute("classe", new Classe());
        return "classes/add";
    }

    @PostMapping("/add")
    public  String addClasse(@ModelAttribute Classe classe){
        classeService.addClasse(classe);
        return "redirect:/classes";
    }

    @GetMapping("/edit/{id}")
    public String showEditClasse(@PathVariable Long id, Model model){
        Classe  classe = classeService.getClasseById(id);
        model.addAttribute("classe", classe);
        return "classes/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateClasse(@PathVariable Long id, @ModelAttribute Classe classe){
         classeService.updateClasse(id, classe);
        return "redirect:/classes";
    }

    @PostMapping("/delete/{id}")
    public String  deleteClasse(@PathVariable Long id){
        classeService.deleteClasse(id);
        return "redirect:/classes";
    }

}
