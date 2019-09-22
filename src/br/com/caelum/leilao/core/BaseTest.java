package br.com.caelum.leilao.core;

import org.junit.Before;

import br.com.caelum.leilao.modelo.Usuario;

public class BaseTest {
	
	protected Usuario mauricio;
	protected Usuario guilherme;

	@Before
	public void inicializa() {
		mauricio = new Usuario(1L, "Mauricio Aniche", "mauricio.aniche@caelum.com.br");
		guilherme = new Usuario(2L, "Guilherme Silveira", "guilherme.silveira@caelum.com.br");
	}
}
