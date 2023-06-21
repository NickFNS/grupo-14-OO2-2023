package com.grupo14.oob2.controllers;

import com.grupo14.oob2.dtos.DispositivoCreate;
import com.grupo14.oob2.entities.DAula;
import com.grupo14.oob2.entities.Dispositivo;
import com.grupo14.oob2.entities.Sector;
import com.grupo14.oob2.repositories.SectorRepository;
import com.grupo14.oob2.services.DAulaService;
import com.grupo14.oob2.utils.ViewRouteHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/aula")
public class AulaController {

    //Repositories
    @Autowired
    SectorRepository sectorRepository;
    @Autowired
    DAulaService dAulaService;


    @GetMapping("/dashboard")
    public ModelAndView dashboard() {
        ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.AULA_DASHBOARD);
        return modelAndView;
    }

    //TableABM
    @GetMapping("/dashboard/tableAbm")
    public ModelAndView tableAbm(Model model) {
        model.addAttribute("dAulas", dAulaService.findAll());
        ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.AULA_DASHBOARD_ABMTABLE);
        return modelAndView;
    }

    //Delete Aula

    //Get By Sector
    @GetMapping("/dashboard/sectores")
    public String sectoresGet(Model model) {
        model.addAttribute("sectores", sectorRepository.findAll());
        return ViewRouteHelper.AULA_DASHBOARD_SECTORES;
    }

    @GetMapping("/dashboard/sectores/{id}")
    public String verSector(@PathVariable("id") int id, Model model) {
        // Aquí obtienes los detalles del sector desde tu backend utilizando el ID
        Sector sector = sectorRepository.getById(id);
        model.addAttribute("sector", sector);
        model.addAttribute("Daulas", sector.getDispositivos());
        return ViewRouteHelper.AULA_DASHBOARD_SECTORES_DAULA;
    }

    //Delete DE AULAS
    @GetMapping("/dashboard/abm/aulaDelete/{id}")
    public String aulaDelete(@PathVariable("id") int id,Model model) throws Exception {
        model.addAttribute("daula", new DispositivoCreate());
        DAula edit = dAulaService.findByID(id);
        edit.setEnabled(false);
        dAulaService.update(edit);
        return ViewRouteHelper.AULA_ABM_SUCCESS;
    }

    //Update DE AULAS
    @GetMapping("/dashboard/abm/aulaUpdate/{id}")
    public String aulaUpdate(@PathVariable("id") int id,Model model) {
        model.addAttribute("daula", new DispositivoCreate());
        model.addAttribute("sectores", sectorRepository.findAll());
        return ViewRouteHelper.AULA_ABM_EDIT;
    }

    @PostMapping("/dashboard/abm/aulaUpdate/{id}")
    public RedirectView aulaUpdatePost(@PathVariable("id") int id,@Valid @ModelAttribute("daula")DispositivoCreate dAula, BindingResult result, ModelMap model) throws Exception {

        if(result.hasErrors()) {
            model.addAttribute("daula", dAula);
            model.addAttribute("sectores", sectorRepository.findAll());
            return new RedirectView(ViewRouteHelper.AULA_ABM_EDIT);
        }else {
            DAula edit = dAulaService.findByID(id);
            edit.setEnabled(dAula.isEnabled());
            edit.setName(dAula.getName());
            edit.setType(dAula.getType());
            dAulaService.update(edit);
            return new RedirectView("/"+ViewRouteHelper.AULA_DASHBOARD);
        }
    }


    //Create DE AULAS
    @GetMapping("/dashboard/abm/aulaCreate")
    public String aulaCreateGet(Model model) {
        model.addAttribute("daula", new DispositivoCreate());
        model.addAttribute("sectores", sectorRepository.findAll());
        return ViewRouteHelper.AULA_ABM_CREATE;
    }
    @PostMapping("/dashboard/abm/aulaCreate")
    public RedirectView aulaCreatePost(@Valid @ModelAttribute("daula")DispositivoCreate dAula, BindingResult result, ModelMap model) throws Exception {

        if(result.hasErrors()) {
            model.addAttribute("cursada", dAula);
            model.addAttribute("sectores", sectorRepository.findAll());
            return new RedirectView(ViewRouteHelper.AULA_ABM_CREATE);
        }else {
            DAula newDaula = new DAula(false,false,false,false,false);
            newDaula.setEnabled(dAula.isEnabled());
            newDaula.setName(dAula.getName());
            newDaula.setType(dAula.getType());
            DAula response = dAulaService.save(newDaula);
            Sector sector = sectorRepository.getById(dAula.getIdSector());
            Set<Dispositivo> dispositoSector = sector.getDispositivos();
            dispositoSector.add(response);
            sector.setDispositivos(dispositoSector);
            sectorRepository.save(sector);
            return new RedirectView("/aula/dashboard/tableAbm");
        }
    }


    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.AULA_DASHBOARD);
        return modelAndView;
    }

}
