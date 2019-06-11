package br.com.senac.servico;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.senac.dominio.OrdemDeServico;
import br.com.senac.repositorio.OrdemDeServicoRepositorio;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class OrdemDeServicoService {
	
	@Autowired
	private OrdemDeServicoRepositorio repoOrdem;
	
	
	public OrdemDeServico buscar(Integer id) throws ObjectNotFoundException {
		Optional<OrdemDeServico> objOrdemDeServico = repoOrdem.findById(id);
		return objOrdemDeServico.orElseThrow(() -> new  ObjectNotFoundException(
				" não encotrado! id: " + id + ", Tipo!" + OrdemDeServico.class.getName()));
	}	
	
	public OrdemDeServico inserir (OrdemDeServico objOrdemDeServico) {
		//estou colacondo um objeto novo entao o id precisa ser null
		objOrdemDeServico.setId(null);
		return repoOrdem.save(objOrdemDeServico);
	}
	
   public OrdemDeServico alterar(OrdemDeServico objOrdemDeServico) throws ObjectNotFoundException{
		
	   OrdemDeServico objOrdemServicoEncotrado = buscar(objOrdemDeServico.getId());
	   objOrdemServicoEncotrado = buscar(objOrdemDeServico.getId());
	   objOrdemServicoEncotrado.setNome(objOrdemDeServico.getNome());
	   objOrdemServicoEncotrado.setDataInicio(objOrdemDeServico.getDataInicio());
	   objOrdemServicoEncotrado.setDataTermino(objOrdemDeServico.getDataTermino());
	   objOrdemServicoEncotrado.setDescricao(objOrdemDeServico.getDescricao());
	  
	  
		return repoOrdem.save(objOrdemServicoEncotrado);
	}
   		
   public void excluir(Integer id) {
   		repoOrdem.deleteById(id);
   }
   
   public List<OrdemDeServico> listaServicos(){
   		return repoOrdem.findAll();
   }



}
