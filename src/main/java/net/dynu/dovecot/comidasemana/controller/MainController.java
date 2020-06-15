package net.dynu.dovecot.comidasemana.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.dynu.dovecot.comidasemana.model.Comida;
import net.dynu.dovecot.comidasemana.repository.ComidaRepository;

@Controller
@RequestMapping(path="/comida")
public class MainController {
	@Autowired
	private ComidaRepository comidaRepository;
	
	@PostMapping(path="/add")
	  public @ResponseBody String addNewComida (@RequestParam String name, 
			  @RequestParam String image, 
			  @RequestParam String url) {
	    // @ResponseBody means the returned String is the response, not a view name
	    // @RequestParam means it is a parameter from the GET or POST request

	    Comida comida = new Comida();
	    comida.setName(name);
	    comida.setImage(image);
	    comida.setUrl(url);
	    comidaRepository.save(comida);
	    return "Saved";
	  }
}
