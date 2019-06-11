
package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import br.com.senac.dominio.OrdemDeServico;
import br.com.senac.dominio.Recurso;
import br.com.senac.servico.OrdemDeServicoService;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("/servico")
public class ControllerOrdemDeServico {
	
	@Autowired
	private OrdemDeServicoService ordemDeServicoService;
	
	@GetMapping("/listarServico")
	public ModelAndView listaServicos() {
		ModelAndView mv = new ModelAndView("servico/paginaOrdemDeServicos");
		//tem que add o objeto aqui mais esta dando erro e não sei revolver 
		mv.addObject("servicos", ordemDeServicoService.listaServicos());
		return mv;
	}
	
	@GetMapping("/adicionarServico")
	public ModelAndView add(OrdemDeServico servico) {
		ModelAndView mv = new ModelAndView("servico/paginaAdicionarOrdemDeServico");
		mv.addObject("servico", servico);
		return mv;
	}

		
	@PostMapping("/salvar")
	public ModelAndView inserir(OrdemDeServico servico) {
			ordemDeServicoService.inserir(servico);
			return listaServicos();
	}
	
	@GetMapping("/excluirOrdemDeServico/{id}")
	public ModelAndView delete(@PathVariable("id")Integer id) {
		ordemDeServicoService.excluir(id);
		return listaServicos();
	}
	
	@GetMapping("/alterarOrdemDeServico/{id}")
	public ModelAndView alterar(@PathVariable("id")Integer id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("servico/paginaAlterarOrdemDeServico");
		mv.addObject("servico", ordemDeServicoService.buscar(id));
		return mv;
	}
	 
	@PostMapping("/alterarOrdemDeServico")
	public ModelAndView alterar(OrdemDeServico servico) throws ObjectNotFoundException {
		ordemDeServicoService.alterar(servico);
		return listaServicos();
	}

 }

