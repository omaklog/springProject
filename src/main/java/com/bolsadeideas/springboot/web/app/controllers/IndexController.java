package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bolsadeideas.springboot.web.app.models.Usuario;

@Controller
public class IndexController {
	
	
	@GetMapping({"index","/"})
	public String index(Model model) {
		model.addAttribute("titulo", "hola Spring compilando");
		return "index";
	}
	
	@GetMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario=new Usuario();
		usuario.setNombre("Andrés");
		usuario.setApellido("Apellido");
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "perfil del usuario".concat(usuario.getNombre()));
		return "perfil";
	}
	

}

