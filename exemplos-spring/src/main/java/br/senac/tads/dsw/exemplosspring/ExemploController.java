package br.senac.tads.dsw.exemplosspring;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExemploController {

	@GetMapping("/ex1")
	public String exemplo1() {
		return "exemplo1";
	}
	
	@GetMapping("/ex2")
	public String exemplo2(Model modelo) {
		String mensagem = "Mensagem gerada no Controller";
		int numero = 23032020;
		LocalDateTime dataHoraAtual = LocalDateTime.now();
		
		modelo.addAttribute("msg", mensagem);
		modelo.addAttribute("numero", numero);
		modelo.addAttribute("dataHoraAcesso", dataHoraAtual);
		
		return "exemplo2";
	}

	@GetMapping("/ex2b")
	public ModelAndView exemplo2() {
		String mensagem = "Mensagem gerada no Controller (exemplo ModelAndView)";
		int numero = 203040;
		LocalDateTime dataHoraAtual = LocalDateTime.now();
		
		ModelAndView mv = new ModelAndView("exemplo2");
		mv.addObject("msg", mensagem);
		mv.addObject("numero", numero);
		mv.addObject("dataHoraAcesso", dataHoraAtual);
		return mv;
	}

	@GetMapping("/ex3")
	public ModelAndView exemplo3() {
		List<String> valores = new ArrayList<>();
		for (int i = 1; i <= 100; i++) {
			valores.add("Item " + i);
		}
		
		ModelAndView mv = new ModelAndView("exemplo3");
		mv.addObject("itens", valores);
		return mv;
	}

	@GetMapping("/ex3b")
	public ModelAndView exemplo3b() {
		List<Item> valores = new ArrayList<>();
		for (int i = 1; i <= 100; i++) {
			valores.add(new Item("Item " + i, i));
		}
		
		ModelAndView mv = new ModelAndView("exemplo3b");
		mv.addObject("itens", valores);
		return mv;
	}

	@GetMapping("/ex4")
	public ModelAndView exemplo4(
			@RequestParam("nome") String nome, 
			@RequestParam(value = "genero", defaultValue = "0") int genero,
			@RequestParam(value = "dtnasc", required = false) String dataNascimento) {
		
		ModelAndView mv = new ModelAndView("exemplo4");
		mv.addObject("nome", nome);
		mv.addObject("genero", genero);
		
		if (dataNascimento != null) {
			LocalDate dtNasc = LocalDate.parse(dataNascimento);
			Period periodo = Period.between(dtNasc, LocalDate.now());
			mv.addObject("dtnasc", dataNascimento);
			mv.addObject("idade", periodo.getYears());
		}
		return mv;
	}

	@GetMapping("/ex5/{apelido}")
	public ModelAndView exemplo5(
			@PathVariable("apelido") String apelido,
			@RequestParam(value = "genero", defaultValue = "0") int genero,
			@RequestParam(value = "dtnasc", required = false) String dataNascimento) {
		ModelAndView mv = new ModelAndView("exemplo5");
		mv.addObject("apelido", apelido);
		mv.addObject("genero", genero);
		
		if (dataNascimento != null) {
			LocalDate dtNasc = LocalDate.parse(dataNascimento);
			Period periodo = Period.between(dtNasc, LocalDate.now());
			mv.addObject("dtnasc", dataNascimento);
			mv.addObject("idade", periodo.getYears());
		}
		return mv;
	}

	@GetMapping("/ex6")
	public ModelAndView exemplo6(
			@RequestHeader("user-agent") String userAgent) {
		ModelAndView mv = new ModelAndView("exemplo6");
		mv.addObject("ua", userAgent);
		return mv;
	}

	@GetMapping("/ex7")
	public ModelAndView exemplo7(
			@RequestHeader Map<String, String> cabecalhos
			) {
		ModelAndView mv = new ModelAndView("exemplo7");
		mv.addObject("cabecalhos", cabecalhos);
		return mv;
	}
	

}
