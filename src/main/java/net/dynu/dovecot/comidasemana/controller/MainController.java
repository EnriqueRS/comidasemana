package net.dynu.dovecot.comidasemana.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.dynu.dovecot.comidasemana.domain.Utils;
import net.dynu.dovecot.comidasemana.model.Comida;
import net.dynu.dovecot.comidasemana.model.Semana;
import net.dynu.dovecot.comidasemana.repository.ComidaRepository;
import net.dynu.dovecot.comidasemana.repository.SemanaRepository;

@Controller
@RequestMapping("/comida")
public class MainController {
	@Autowired
	private ComidaRepository comidaRepository;
	
	@Autowired
	private SemanaRepository semanaRepository;
	
	@GetMapping("/")
	public String showHome(Model model) {
		int currentWeek = Utils.getCurrentWeekOfYear();
		Optional<Semana> currentSemana = semanaRepository.findById(currentWeek);
		
		if(currentSemana.isPresent()) {
			model.addAttribute("semanaObj", currentSemana.get());
		} else {
			Optional<Semana> pastSemana = semanaRepository.findById(currentWeek - 1);
			if (pastSemana.isPresent())
				model.addAttribute("semanaObj", pastSemana.get());
		}
		List<Comida> comidas = (List<Comida>) comidaRepository.findAll();
		model.addAttribute("comidas", comidas);
		model.addAttribute("week", currentWeek);
		return "comida/home";
	}

	@PostMapping(path = "/add")
	public @ResponseBody String addNewComida(@RequestParam String name, @RequestParam String image,
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

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Comida> getAllComida() {
		return comidaRepository.findAll();
	}
}
