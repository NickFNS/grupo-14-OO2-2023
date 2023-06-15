package com.grupo14.oob2.controllers;

import java.time.LocalDate;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.grupo14.oob2.entities.Estacionamiento;
import com.grupo14.oob2.services.DispositivoService;
import com.grupo14.oob2.utils.ViewRouteHelper;

@Controller
@RequestMapping("/estacionamiento")
public class EstacionamientoController {

	@Autowired
	private DispositivoService dispositivoService;

	private ModelMapper modelMapper = new ModelMapper();

	@GetMapping("/show")
	public ModelAndView getEstacionamientos() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(ViewRouteHelper.SHOW_ESTACIONAMIENTOS);
		modelAndView.addObject("estacionamientos", dispositivoService.FindAllEstacionamiento());
		return modelAndView;
	}

	@GetMapping("/new")
	public ModelAndView newEstacionamiento() {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.FORM_NEW_ESTACIONAMIENTO);
		mV.addObject("estacionamiento", new Estacionamiento());
		return mV;
	}

	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("estacionamiento") Estacionamiento estacionamiento) {
		dispositivoService.insertOrUpdateDispositivo(modelMapper.map(estacionamiento, Estacionamiento.class));
		return new RedirectView(ViewRouteHelper.SHOW_ESTACIONAMIENTOS);
	}
	
	//TODO: Hacer funcionar los filtros.
	@GetMapping
    public List<Estacionamiento> getEstacionamientosByFecha(@RequestParam("fecha") LocalDate fecha) {
        return dispositivoService.findEstacionamientosByDate(fecha);
    }

}
