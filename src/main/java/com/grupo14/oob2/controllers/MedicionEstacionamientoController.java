package com.grupo14.oob2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.grupo14.oob2.entities.Estacionamiento;
import com.grupo14.oob2.entities.MedicionEstacionamiento;
import com.grupo14.oob2.services.DispositivoService;
import com.grupo14.oob2.services.MedicionService;

@Controller
@RequestMapping("/medicionEstacionamiento")
public class MedicionEstacionamientoController {

	@Autowired
	private MedicionService medicionService;

	@Autowired
	private DispositivoService dispositivoService;

	// TODO: Crea la medicion, pero sin el id de dispositivo.
	@PostMapping("/create")
	public String crearMedicionEstacionamiento(@RequestParam("idEstacionamiento") int estacionamientoId) {
		// Buscar el estacionamiento por su ID
		Estacionamiento estacionamiento = dispositivoService.findEstacionamientoByIdDispositivo(estacionamientoId);

		if (estacionamiento != null) {
			// Crear una nueva instancia de MedicionEstacionamiento
			MedicionEstacionamiento nuevaMedicion = new MedicionEstacionamiento();
			nuevaMedicion.setDispositivo(estacionamiento);

			// Cambiar el valor de occupied en base al estado anterior
			boolean nuevoEstado = true; // Valor predeterminado cuando no hay mediciones anteriores
			MedicionEstacionamiento ultimaMedicion = medicionService.getUltimaMedicionEstacionamiento(estacionamiento)
					.stream().findFirst().orElse(null);

			if (ultimaMedicion != null) {
				nuevoEstado = !ultimaMedicion.isOccupied();
			} else {
				nuevoEstado = true;
			}
			nuevaMedicion.setOccupied(nuevoEstado);

			// Guardar la nueva medicionEstacionamiento en la base de datos
			medicionService.insertOrUpdate(nuevaMedicion);

			return "redirect:/estacionamiento/show";
		}

		// En caso de que no se encuentre el estacionamiento
		return "redirect:/error";
	}

}

