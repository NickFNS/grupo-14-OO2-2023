package com.grupo14.oob2.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.grupo14.oob2.entities.Banio;
import com.grupo14.oob2.services.DispositivoService;

@Controller
@RequestMapping("/banio")
public class BanioController {

	@Autowired
	private DispositivoService dispositivoService;

	@GetMapping("/show")
	public String mostrarBanios(Model model) {
		Iterable<Banio> banios = dispositivoService.findAllBanios();
		List<Banio> baniosActivos = new ArrayList<Banio>();
		for (Banio banio : banios) {
			if(banio.isEnabled()) {
				baniosActivos.add(banio);
			}
		}
		model.addAttribute("banios", baniosActivos);
		return "/banio/show";
	}

	@GetMapping("/crear")
	public String mostrarFormularioCreacion(Model model) {
		model.addAttribute("banio", new Banio());
		return "banio/newBanioForm";
	}

	@PostMapping("/crear")
	public String crearBanio(@ModelAttribute("banio") Banio banio) {
		banio.setType("Banio");
		banio.setEnabled(true);
		dispositivoService.insertOrUpdateBanio(banio);
		return "redirect:/banio/show";
	}

	@GetMapping
	public String buscarBanio(@RequestParam("nombre") String nombre, Model model) {
		if (nombre == null || nombre.isEmpty()) {
			return mostrarBanios(model);
		}

		Iterable<Banio> banios = dispositivoService.findBaniosByName(nombre);
		model.addAttribute("banios", banios);
		return "banio/show";
	}

	@PostMapping("/delete/{idBanio}")
	public String deleteBanio(@PathVariable("idBanio") int banioId) {
	    dispositivoService.removeByIdDispositivo(banioId);
	    return "redirect:/banio/show";
	}
}