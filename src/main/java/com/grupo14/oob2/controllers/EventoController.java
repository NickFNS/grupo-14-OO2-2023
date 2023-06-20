package com.grupo14.oob2.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.grupo14.oob2.entities.Evento;
import com.grupo14.oob2.services.EventoService;
import com.grupo14.oob2.utils.ViewRouteHelper;

@Controller
@RequestMapping("/evento")
public class EventoController {

	@Autowired
	private EventoService eventoService;

	@GetMapping("/eventosEstacionamientos")
	public String mostrarEventosEstacionamientos(@RequestParam(value = "date", required = false) String date,
			@RequestParam(value = "idDispositivo", required = false) Integer idDispositivo,
			@RequestParam(value = "description", required = false) String description, Model model) {

		String type = "Estacionamiento";
		List<Evento> eventosEstacionamientos;

		if (date != null && !date.isEmpty()) {
			try {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date fecha = dateFormat.parse(date);

				if (idDispositivo != null) {
					eventosEstacionamientos = eventoService
							.findByTypeAndDateAndDispositivoIdAndDescriptionContainingOrderByIdEventoDesc(type, fecha,
									idDispositivo, description);
				} else {
					eventosEstacionamientos = eventoService.findByTypeAndDateOrderByIdEventoDesc(type, fecha);
				}
			} catch (ParseException e) {

				return "error";
			}
		} else if (idDispositivo != null && description != null) {
			eventosEstacionamientos = eventoService
					.findByTypeAndDispositivoIdAndDescriptionContainingOrderByIdEventoDesc(type, idDispositivo,
							description);
		} else if (idDispositivo != null) {
			eventosEstacionamientos = eventoService.findByTypeAndDispositivoIdOrderByIdEventoDesc(type, idDispositivo);
		} else if (description != null) {
			eventosEstacionamientos = eventoService.findByTypeAndDescriptionContainingOrderByIdEventoDesc(type,
					description);
		} else {
			eventosEstacionamientos = eventoService.findByDispositivoTypeOrderByIdEventoDesc(type);
		}

		model.addAttribute("eventos", eventosEstacionamientos);
		return ViewRouteHelper.SHOW_EVENTOS_ESTACIONAMIENTO;
	}


	@GetMapping("/eventosAula")
	public String mostrarEventosAula(@RequestParam(value = "date", required = false) String date,
												 @RequestParam(value = "idDispositivo", required = false) Integer idDispositivo,
												 @RequestParam(value = "description", required = false) String description, Model model) {

		String type = "Aula";
		List<Evento> eventosAula;

		if (date != null && !date.isEmpty()) {
			try {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date fecha = dateFormat.parse(date);

				if (idDispositivo != null) {
					eventosAula = eventoService
							.findByTypeAndDateAndDispositivoIdAndDescriptionContainingOrderByIdEventoDesc(type, fecha,
									idDispositivo, description);
				} else {
					eventosAula = eventoService.findByTypeAndDateOrderByIdEventoDesc(type, fecha);
				}
			} catch (ParseException e) {

				return "error";
			}
		} else if (idDispositivo != null && description != null) {
			eventosAula = eventoService
					.findByTypeAndDispositivoIdAndDescriptionContainingOrderByIdEventoDesc(type, idDispositivo,
							description);
		} else if (idDispositivo != null) {
			eventosAula = eventoService.findByTypeAndDispositivoIdOrderByIdEventoDesc(type, idDispositivo);
		} else if (description != null) {
			eventosAula = eventoService.findByTypeAndDescriptionContainingOrderByIdEventoDesc(type,
					description);
		} else {
			eventosAula = eventoService.findByDispositivoTypeOrderByIdEventoDesc(type);
		}

		model.addAttribute("eventos", eventosAula);
		return ViewRouteHelper.SHOW_EVENTOS_ESTACIONAMIENTO;
	}

	@GetMapping("/todosLosEventos")
	public String mostrarTodosLosEventos(Model model) {
		List<Evento> eventos = eventoService.getAll();
		model.addAttribute("eventos", eventos);
		return ViewRouteHelper.SHOW_EVENTOS;
	}
}
