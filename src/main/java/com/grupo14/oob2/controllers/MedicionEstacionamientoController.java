package com.grupo14.oob2.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.grupo14.oob2.entities.Estacionamiento;
import com.grupo14.oob2.entities.MedicionEstacionamiento;
import com.grupo14.oob2.services.DispositivoService;
import com.grupo14.oob2.services.MedicionService;
import com.grupo14.oob2.utils.ViewRouteHelper;

@Controller
@RequestMapping("/medicionEstacionamiento")
public class MedicionEstacionamientoController {

	@Autowired
	private MedicionService medicionService;

	@Autowired
	private DispositivoService dispositivoService;

	private ModelMapper modelMapper = new ModelMapper();

	@GetMapping("/show")
	public ModelAndView getMedicionEstacionamientos() {
		ModelAndView mV = new ModelAndView();
		mV.setViewName(ViewRouteHelper.SHOW_MEDICION_ESTACIONAMIENTO);
		mV.addObject("medicionEstacionamiento", medicionService.getAllMedicionEstacionamiento());
		return mV;
	}

	@GetMapping("/new")
	public ModelAndView newMedicionEstacionamiento() {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.FORM_NEW_MEDICION_ESTACIONAMIENTO);
		MedicionEstacionamiento mE = new MedicionEstacionamiento();

		mV.addObject("medicionEstacionamiento", mE);
		return mV;
	}

	// TODO: Crea la medicion, pero sin el id de dispositivo.
	@PostMapping("/create")
	public RedirectView create(
			@ModelAttribute("medicionEstacionamiento") MedicionEstacionamiento medicionEstacionamiento) {
		medicionService.insertOrUpdate(modelMapper.map(medicionEstacionamiento, MedicionEstacionamiento.class));
		return new RedirectView(ViewRouteHelper.SHOW_MEDICION_ESTACIONAMIENTO);
	}

	@GetMapping("/medicionEstacionamiento/newMedicionEstacionamiento")
	public String mostrarFormularioCrearMedicionEstacionamiento(
			@RequestParam("idEstacionamiento") int idEstacionamiento, Model model) {
		model.addAttribute("idEstacionamiento", idEstacionamiento);
		return ViewRouteHelper.FORM_NEW_MEDICION_ESTACIONAMIENTO;
	}

}

//    @PostMapping("/crear-medicion")
//    public String crearMedicionEstacionamiento(@RequestParam("estacionamientoId") int estacionamientoId) {
//        // Buscar el estacionamiento por su ID
//        Estacionamiento estacionamiento = (Estacionamiento) dispositivoService.findByIdDispositivo(estacionamientoId);
//        
//        if (estacionamiento != null) {
//            // Crear una nueva instancia de MedicionEstacionamiento
//            MedicionEstacionamiento medicionEstacionamiento = new MedicionEstacionamiento();
//            
//            // Establecer el estacionamiento y otros atributos de la medicionEstacionamiento
//            medicionEstacionamiento.setDispositivo(estacionamiento);
//            medicionEstacionamiento.setPlace_number(estacionamiento.getPlaceNumber());
//            medicionEstacionamiento.setOccupied(true);
//            
//            // Guardar la medicionEstacionamiento en la base de datos
//            medicionService.guardarMedicionEstacionamiento(medicionEstacionamiento);
//            
//            return "redirect:/estacionamiento/show";
//        }
//        
//        // En caso de que no se encuentre el estacionamiento
//        return "redirect:/error";
//    }
