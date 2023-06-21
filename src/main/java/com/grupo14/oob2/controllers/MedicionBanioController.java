package com.grupo14.oob2.controllers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.grupo14.oob2.entities.Banio;
import com.grupo14.oob2.entities.Evento;
import com.grupo14.oob2.entities.MedicionBanio;
import com.grupo14.oob2.services.DispositivoService;
import com.grupo14.oob2.services.EventoService;
import com.grupo14.oob2.services.MedicionService;
import com.grupo14.oob2.utils.ViewRouteHelper;

@Controller
@RequestMapping("/medicionBanio")
public class MedicionBanioController {

	@Autowired
	private MedicionService medicionService;

	@Autowired
	private DispositivoService dispositivoService;

	@Autowired
	private EventoService eventoService;

	@PostMapping("/create")
	public RedirectView crearMedicionBanio(@RequestParam("idBanio") int banioId) {
		Banio banio = dispositivoService.findBanioByIdDispositivo(banioId);

		if (banio != null) {
			MedicionBanio nuevaMedicion = new MedicionBanio();
			nuevaMedicion.setDispositivo(banio);

			boolean nuevoEstado = true;
			MedicionBanio ultimaMedicion = medicionService.getUltimaMedicionBanio(banio)
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
				nuevoEvento.setDescription("Banio Ocupado");
			} else {
				nuevoEvento.setDescription("Banio Desocupado");
			}

			nuevoEvento.setEnabled(true);
			nuevoEvento.setDateTime(LocalDateTime.now());
			nuevoEvento.setDispositivo(banio);

			eventoService.insertOrUpdateEvento(nuevoEvento);

			return new RedirectView(ViewRouteHelper.SHOW_BANIOS);
		}

		// En caso de que no se encuentre el banio
		return new RedirectView(ViewRouteHelper.INDEX);
	}

}