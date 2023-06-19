package com.grupo14.oob2.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grupo14.oob2.entities.Banio;
import com.grupo14.oob2.services.DispositivoService;

@Controller
@RequestMapping("/banio")
public class BanioController {

	@Autowired
	private DispositivoService dispositivoService;

	private ModelMapper modelMapper = new ModelMapper();

	@GetMapping("/show")
	public String mostrarBanios(Model model) {
		Iterable<Banio> banios = dispositivoService.findAllBanios();
		model.addAttribute("banios", banios);
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
		dispositivoService.insertOrUpdateBanio(banio);
		return "redirect:/banio/show";
	}
}