package com.uca.capas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.dao.ContribuyenteDAO;
import com.uca.capas.dao.ImportanciaDAO;
import com.uca.capas.domain.Contribuyente;
import com.uca.capas.domain.Importancia;

@Controller
public class MainController {

	@Autowired
	private ContribuyenteDAO contribuyenteDao;
	
	@Autowired
	private ImportanciaDAO importanciaDao;
	
	@RequestMapping("/inicio")
	public ModelAndView inicio() {
		ModelAndView mav = new ModelAndView();
		Contribuyente contribuyente = new Contribuyente();
		mav.addObject("contribuyente", contribuyente);
		List<Importancia> importancias = null;
		importancias = importanciaDao.findAll();
		mav.addObject("importancia", contribuyente.getImportancia());
		mav.addObject("importancias", importancias);
		mav.setViewName("index");
		return mav;		
	}
	
	@RequestMapping("/listado")
	public ModelAndView main() {
		ModelAndView mav = new ModelAndView();
		List<Importancia> importancias =importanciaDao.findAll(); 
		//Importancia importancias = importanciaDao.findOne(2);
		try {
			mav.addObject("importancias", importancias);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		mav.setViewName("listado");
		return mav;
	}
	
	@RequestMapping("/guardarContribuyente")
	public ModelAndView guardar(@Valid @ModelAttribute Contribuyente contribuyente, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.setViewName("index");
			System.out.println("Entre aqui pq tengo errores");
		}
		else {
			System.out.println("Estoy aqui");
			contribuyenteDao.save(contribuyente);
			mav.setViewName("exito");
		}	
		return mav;
	}
	
}
