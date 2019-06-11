package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import br.com.senac.dominio.Recurso;
import br.com.senac.servico.OrdemDeServicoService;
import br.com.senac.servico.RecursoService;
import javassist.tools.rmi.ObjectNotFoundException;
@Controller
@RequestMapping("/recurso")
public class ControllerRecurso {

	@Autowired
	private RecursoService recursoService;
	
	@Autowired
	private OrdemDeServicoService ordemDeServicoService;
	
	@GetMapping("/listarRecurso")
	public ModelAndView listaRecurso() {
	ModelAndView	mv = new ModelAndView("recurso/paginaRecursos");
	mv.addObject("recursos", recursoService.listaRecurso());
	return mv;
	}
	
	@GetMapping("/adicionarRecurso")
	public ModelAndView add() {
	ModelAndView	mv = new ModelAndView("recurso/paginaAdicionarRecurso");
	mv.addObject("recurso", new Recurso());
	//mv.addObject("servicos", ordemDeServicoService.listaRecurso());
	return mv;
	
	} 
	
	@PostMapping("/salvarRecurso")
	public ModelAndView inserir(Recurso recurso) {
		recursoService.inserir(recurso);
		return listaRecurso();
	}
	@GetMapping("/excluirRecurso/{id}")
	public ModelAndView delete(@PathVariable("id") Integer id) {
		recursoService.excluir(id);
		return listaRecurso();
	
	}
	@GetMapping("/alterarRecurso/{id}")
	public ModelAndView alterar(@PathVariable("id") Integer id) throws ObjectNotFoundException{
	ModelAndView	mv = new ModelAndView("recurso/paginaAlterarRecurso");
	mv.addObject("recurso", recursoService.buscar(id));
	//mv.addObject("usuarios", ordemDeServicoService.listaOrdemDeServico());
	return mv;
	}
	
	@PostMapping("/alterarRecurso")
	public ModelAndView alterar(Recurso recurso) throws ObjectNotFoundException{
		recursoService.alterar(recurso);
		return listaRecurso();
	}

}


