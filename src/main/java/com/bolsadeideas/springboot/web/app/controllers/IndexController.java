package com.bolsadeideas.springboot.web.app.controllers;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bolsadeideas.springboot.web.app.models.Usuario;

@Controller
public class IndexController {
	
	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;
	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;

	
	
	@GetMapping({"	","/"})
	public String index(Model model) {
		model.addAttribute("titulo", textoIndex);
		return "index";
	}
	
	@GetMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario=new Usuario();
		usuario.setNombre("Andrés");
		usuario.setApellido("bbbbbb");

		usuario.setEmail("asaasasas@gmail.com");
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", textoPerfil.concat(" "+usuario.getNombre()));
		return "perfil";
	}
	
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Usuario>  usuarios= new ArrayList<>();
		
		usuarios.add(new Usuario("andres","guzman","andresg@gmail.com"));
		usuarios.add(new Usuario ("juan","sandoval","jsandoval@gmail.com"));
		usuarios.add(new Usuario("carlos","perez","charlyp@gmail.com"));
		
		model.addAttribute("usuarios", usuarios);
		model.addAttribute("titulo", textoListar);
		
		return "listar";
	}

}

