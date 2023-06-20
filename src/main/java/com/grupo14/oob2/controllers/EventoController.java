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
				// Manejo de la excepción en caso de que la cadena no pueda ser parseada como
				// fecha
				// Aquí puedes agregar un mensaje de error o realizar alguna acción adecuada
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

	@GetMapping("/todosLosEventos")
	public String mostrarTodosLosEventos(Model model) {
		List<Evento> eventos = eventoService.getAll();
		model.addAttribute("eventos", eventos);
		return ViewRouteHelper.SHOW_EVENTOS;
}
	}

/*
 * @GetMapping("/eventosEstacionamientos") public String
 * mostrarEventosEstacionamientos(@RequestParam(value = "dateTime", required =
 * false) String dateTime, Model model) { List<Evento> eventosEstacionamientos;
 * 
 * if (dateTime != null && !dateTime.isEmpty()) { try { SimpleDateFormat
 * dateFormat = new SimpleDateFormat("yyyy-MM-dd"); Date fecha =
 * dateFormat.parse(dateTime);
 * 
 * eventosEstacionamientos =
 * eventoService.findByDispositivoTypeAndDateTimeOrderByIdEventoDesc(
 * "Estacionamiento", fecha); } catch (ParseException e) { // Manejo de la
 * excepción en caso de que la cadena no pueda ser parseada como fecha // Aquí
 * puedes agregar un mensaje de error o realizar alguna acción adecuada return
 * "error"; } } else { eventosEstacionamientos =
 * eventoService.findByDispositivoTypeOrderByIdEventoDesc("Estacionamiento"); }
 * 
 * model.addAttribute("eventos", eventosEstacionamientos); return
 * ViewRouteHelper.SHOW_EVENTOS_ESTACIONAMIENTO; }
 * 
 * 
 * 
 * El normal:
 * 
 * @GetMapping("/eventosEstacionamientos") public String
 * mostrarEventosEstacionamientos(Model model) { // Obtener todos los eventos
 * cuyo dispositivo es un estacionamiento List<Evento> eventosEstacionamientos =
 * eventoService.findByDispositivoTypeOrderByIdEventoDesc("Estacionamiento");
 * 
 * // Agregar los eventos al modelo para mostrarlos en la vista
 * model.addAttribute("eventos", eventosEstacionamientos);
 * 
 * // Devolver la vista que muestra los eventos de estacionamientos return
 * ViewRouteHelper.SHOW_EVENTOS_ESTACIONAMIENTO; }
 */