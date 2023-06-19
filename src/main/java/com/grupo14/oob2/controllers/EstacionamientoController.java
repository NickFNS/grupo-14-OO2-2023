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

import com.grupo14.oob2.entities.Estacionamiento;
import com.grupo14.oob2.services.DispositivoService;
import com.grupo14.oob2.utils.ViewRouteHelper;

@Controller
@RequestMapping("/estacionamiento")
public class EstacionamientoController {

	@Autowired
	private DispositivoService dispositivoService;

	private ModelMapper modelMapper = new ModelMapper();

	@GetMapping("/show")
	public ModelAndView getEstacionamientos(@RequestParam(value = "fecha", required = false) String fechaString,
	                                        @RequestParam(value = "nombre", required = false) String nombre) {
	    ModelAndView mV = new ModelAndView();
	    mV.setViewName(ViewRouteHelper.SHOW_ESTACIONAMIENTOS);

	    List<Estacionamiento> estacionamientos = null;

	    if (fechaString != null && !fechaString.isEmpty() && nombre != null && !nombre.isEmpty()) {
	        try {
	            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	            Date fecha = dateFormat.parse(fechaString);

	            estacionamientos = dispositivoService.findEstacionamientosByDateAndName(fecha, nombre);
	        } catch (ParseException e) {
	            // Manejo de la excepción en caso de que la cadena no pueda ser parseada como fecha
	            // Aquí puedes agregar un mensaje de error o realizar alguna acción adecuada
	        }
	    } else if (fechaString != null && !fechaString.isEmpty()) {
	        try {
	            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	            Date fecha = dateFormat.parse(fechaString);

	            estacionamientos = dispositivoService.findEstacionamientosByDate(fecha);
	        } catch (ParseException e) {
	            // Manejo de la excepción en caso de que la cadena no pueda ser parseada como fecha
	            // Aquí puedes agregar un mensaje de error o realizar alguna acción adecuada
	        }
	    } else if (nombre != null && !nombre.isEmpty()) {
	        estacionamientos = dispositivoService.findEstacionamientosByName(nombre);
	    } else {
	        estacionamientos = dispositivoService.FindAllEstacionamiento();
	    }

	    mV.addObject("estacionamientos", estacionamientos);
	    return mV;
	}

	@GetMapping("/new")
	public ModelAndView newEstacionamiento() {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.FORM_NEW_ESTACIONAMIENTO);
		Estacionamiento estacionamiento = new Estacionamiento();
		
		estacionamiento.setPlaces(new ArrayList<Integer>()); 

		mV.addObject("estacionamiento", estacionamiento);
		return mV;
	}

	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("estacionamiento") Estacionamiento estacionamiento) {
		estacionamiento.setType("Estacionamiento");
		dispositivoService.insertOrUpdateEstacionamiento(modelMapper.map(estacionamiento, Estacionamiento.class));
		return new RedirectView(ViewRouteHelper.SHOW_ESTACIONAMIENTOS);
	}

}
