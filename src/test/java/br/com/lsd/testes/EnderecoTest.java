package br.com.lsd.testes;

import org.junit.Test;

import br.com.lsd.model.Cidade;
import br.com.lsd.model.Endereco;
import br.com.lsd.model.Estado;

public class EnderecoTest {

	Endereco endereco = new Endereco();
	Cidade cidade = new Cidade();
	Estado estado = new Estado();
	
	@Test
	public void testEnderecoCompleto() {
		estado.setId(1L);
		estado.setNome("Mato Grosso");
		estado.setSigla("MT");
		
		cidade.setId(1L);
		cidade.setNome("Cuiabá");
		cidade.setEstado(estado);
		
		endereco.setId(1L);
		endereco.setRua("Dr.Fernando Gonçalves");
		endereco.setNumero(318);
		endereco.setBairro("Dom Melan");
		endereco.setCidade(cidade);
		endereco.setCep("78016-5555");
		System.out.println(endereco.enderecoCompleto());
	}
}