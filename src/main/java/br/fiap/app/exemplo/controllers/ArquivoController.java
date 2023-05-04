package br.fiap.app.exemplo.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.util.StringUtils;

import br.fiap.app.exemplo.models.Arquivo;
import br.fiap.app.exemplo.repositories.ArquivoRepository;

@RequestMapping("/arquivo")
@Controller
public class ArquivoController {
	
	@Autowired
	private ArquivoRepository arquivoRepository;
	
	@GetMapping("")
	private ModelAndView get() {
		ModelAndView model = new ModelAndView("arquivo/index");
		return model;
	}
	
	@PostMapping
	private ResponseEntity<Arquivo> post(@RequestParam MultipartFile image) throws IOException{
		Arquivo file = new Arquivo();
		file.setNome(StringUtils.cleanPath(image.getOriginalFilename()));
		file.setType(image.getContentType());
		file.setData(image.getBytes());
		
		arquivoRepository.save(file);
		Long id = file.getId();
			
		
		return new ResponseEntity<Arquivo>(file, HttpStatus.CREATED);
		
	}
	
	

}
