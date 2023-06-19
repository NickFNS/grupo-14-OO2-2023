package com.grupo14.oob2.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
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

import com.grupo14.oob2.entities.Banio;
import com.grupo14.oob2.services.DispositivoService;
import com.grupo14.oob2.utils.ViewRouteHelper;

@Controller
@RequestMapping("/banio")
public class BanioController {

	@Autowired
	private DispositivoService dispositivoService;

	private ModelMapper modelMapper = new ModelMapper();

	@GetMapping("/show")
	public ModelAndView getBanios(@RequestParam(value = "fecha", required = false) String fechaString,
			@RequestParam(value = "nombre", required = false) String nombre) {
		ModelAndView mV = new ModelAndView();
		mV.setViewName(ViewRouteHelper.SHOW_BANIOS);

		List<Banio> banios = null;

		if (fechaString != null && !fechaString.isEmpty() && nombre != null && !nombre.isEmpty()) {
			try {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date fecha = dateFormat.parse(fechaString);

				banios = dispositivoService.findBaniosByDateAndName(fecha, nombre);
			} catch (ParseException e) {
			}
		} else if (fechaString != null && !fechaString.isEmpty()) {
			try {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date fecha = dateFormat.parse(fechaString);

				banios = dispositivoService.findBaniosByDateAndName(fecha, nombre);
			} catch (ParseException e) {
			}
		} else if (nombre != null && !nombre.isEmpty()) {
			banios = dispositivoService.findBaniosByName(nombre);
		} else {
			banios = dispositivoService.findAllBanios();
		}

		mV.addObject("banios", banios);
		return mV;
	}
	
	// A desarrollar
	@GetMapping("/new")
	public ModelAndView newBanio() {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.FORM_NEW_BANIO);
		return mV;
	}

	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("banio") Banio banio) {
		dispositivoService.insertOrUpdateDispositivo(modelMapper.map(banio, Banio.class));
		return new RedirectView(ViewRouteHelper.SHOW_BANIOS);
	}

}