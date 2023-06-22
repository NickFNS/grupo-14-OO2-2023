package com.grupo14.oob2.controllers;

import com.grupo14.oob2.entities.*;
import com.grupo14.oob2.services.DAulaService;
import com.grupo14.oob2.services.DispositivoService;
import com.grupo14.oob2.services.EventoService;
import com.grupo14.oob2.services.MedicionService;
import com.grupo14.oob2.utils.ViewRouteHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/medicionAula")
public class MedicionAulaController {

    @Autowired
    private MedicionService medicionService;

    @Autowired
    private DAulaService dAulaService;

    @Autowired
    private EventoService eventoService;

    @GetMapping("/create/{id}")
    public String crearMedicionAula(@PathVariable("id") int dAulaId) throws Exception {
        DAula daula = dAulaService.findByID(dAulaId);

        if (daula != null) {
            MedicionDAula nuevaMedicion = new MedicionDAula();
            nuevaMedicion.setDispositivo(daula);

            // Cambiar el valor de occupied segun el estado anterior
            boolean nuevoEstado = true; // Valor predeterminado cuando no hay mediciones anteriores
            MedicionDAula ultimaMedicion = medicionService.getUltimaMedicionDAulao(daula)
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
                nuevoEvento.setDescription("Aula Ocupada");
                daula.setInUse(true);
                daula.setComputersOn(true);
                daula.setLightsOn(true);
                daula.setOpenDoor(true);
                daula.setOpenWindows(true);
            } else {
                nuevoEvento.setDescription("Aula Desocupada");
                daula.setInUse(false);
                daula.setComputersOn(false);
                daula.setLightsOn(false);
                daula.setOpenDoor(false);
                daula.setOpenWindows(false);
            }

            dAulaService.update(daula);
            nuevoEvento.setEnabled(true);
            nuevoEvento.setDateTime(LocalDateTime.now());
            nuevoEvento.setDispositivo(daula);

            eventoService.insertOrUpdateEvento(nuevoEvento);

        }
        return ViewRouteHelper.AULA_ABM_SUCCESS;
    }

}
