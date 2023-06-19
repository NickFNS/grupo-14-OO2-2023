package com.grupo14.oob2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grupo14.oob2.entities.Evento;
import com.grupo14.oob2.services.EventoService;
import com.grupo14.oob2.utils.ViewRouteHelper;

@Controller
@RequestMapping("/evento")
public class EventoController {

	@Autowired
	private EventoService eventoService;
	
	@GetMapping("/eventosEstacionamientos")
	public String mostrarEventosEstacionamientos(Model model) {
	    // Obtener todos los eventos cuyo dispositivo es un estacionamiento
	    List<Evento> eventosEstacionamientos = eventoService.findByDispositivoType("Estacionamiento");
	    
	    // Agregar los eventos al modelo para mostrarlos en la vista
	    model.addAttribute("eventos", eventosEstacionamientos);
	    
	    // Devolver la vista que muestra los eventos de estacionamientos
	    return ViewRouteHelper.SHOW_EVENTOS_ESTACIONAMIENTO;
	}
	
}
