package ferreira.filipe.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ferreira.filipe.entity.Usuario;


@RestController
public class IndexController {
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String getString() {
		
		return "Olá pessoal";
	}

}
