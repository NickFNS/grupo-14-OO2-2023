package com.grupo14.oob2.controllers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.grupo14.oob2.entities.Estacionamiento;
import com.grupo14.oob2.entities.Evento;
import com.grupo14.oob2.entities.MedicionEstacionamiento;
import com.grupo14.oob2.services.DispositivoService;
import com.grupo14.oob2.services.EventoService;
import com.grupo14.oob2.services.MedicionService;

@Controller
@RequestMapping("/medicionEstacionamiento")
public class MedicionEstacionamientoController {

	@Autowired
	private MedicionService medicionService;

	@Autowired
	private DispositivoService dispositivoService;

	@Autowired
	private EventoService eventoService;

	@PostMapping("/create")
	public String crearMedicionEstacionamiento(@RequestParam("idEstacionamiento") int estacionamientoId) {
		Estacionamiento estacionamiento = dispositivoService.findEstacionamientoByIdDispositivo(estacionamientoId);

		if (estacionamiento != null) {
			MedicionEstacionamiento nuevaMedicion = new MedicionEstacionamiento();
			nuevaMedicion.setDispositivo(estacionamiento);

			// Cambiar el valor de occupied segun el estado anterior
			boolean nuevoEstado = true; // Valor predeterminado cuando no hay mediciones anteriores
			MedicionEstacionamiento ultimaMedicion = medicionService.getUltimaMedicionEstacionamiento(estacionamiento)
					.stream().findFirst().orElse(null);

			if (ultimaMedicion != null) {
				nuevoEstado = !ultimaMedicion.isOccupied();
			} else {
				nuevoEstado = true;
			}
			nuevaMedicion.setOccupied(nuevoEstado);
			medicionService.insertOrUpdate(nuevaMedicion);

			// Creacion de Evento en base a la nueva medicion:
			Evento nuevoEvento = new Evento();
			if (nuevoEstado) {
				nuevoEvento.setDescription("Estacionamiento Ocupado");
			} else {
				nuevoEvento.setDescription("Estacionamiento Desocupado");
			}

			nuevoEvento.setEnabled(true);
			nuevoEvento.setDateTime(LocalDateTime.now());
			nuevoEvento.setDispositivo(estacionamiento);

			eventoService.insertOrUpdateEvento(nuevoEvento);

			return "redirect:/estacionamiento/show";
		}

		// En caso de que no se encuentre el estacionamiento
		return "redirect:/error";
	}

}