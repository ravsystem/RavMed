package br.com.consultemed.utils;
import java.util.List;

import br.com.consultemed.model.Contato;
import br.com.consultemed.service.ContatoService;

public class Main {

	public static void main(String[] args) {
		
		ContatoService service = new ContatoService();
		
		
		Contato contato = new Contato();
		contato.setId(null);
		contato.setNome("YgoHamon");
		contato.setEmail("chablau@gmail.com");
		contato.setTelefone("83 9 8888-9999");
		
//		service.salvar(contato);
		
//		Contato contatoBanco = service.buscaContatoId(2L);
		
//		Contato contatoEditado = new Contato();
//		contatoEditado.setId(contatoBanco.getId());
//		contatoEditado.setEmail("joão@gmail.com");
//		contatoEditado.setNome(contatoBanco.getNome());
//		contatoEditado.setTelefone("81 9 8888-9999");
		
//		contatoBanco.setTelefone("81 9 8888-9999");
		
//		service.salvar(contato);
//		
		service.listarContatos();
//		for (Contato c : contatos) {
//			System.out.println(c.getNome());
//		}
		
//		System.out.println("Contato " + contato.getEmail() + " retornado com sucesso.");
	}

}
