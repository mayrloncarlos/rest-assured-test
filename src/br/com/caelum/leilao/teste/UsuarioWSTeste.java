package br.com.caelum.leilao.teste;

import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.path.xml.XmlPath;

import br.com.caelum.leilao.modelo.Usuario;



public class UsuarioWSTeste {
	
	
	private Usuario mauricio;
	private Usuario guilherme;

	@Before
	public void inicializa() {
		mauricio = new Usuario(1L, "Mauricio Aniche", "mauricio.aniche@caelum.com.br");
		guilherme = new Usuario(2L, "Guilherme Silveira", "guilherme.silveira@caelum.com.br");
	}

	@Test
	public void deveRetornarListaDeUsuariosXML() {
		XmlPath path = given()
				.header("Accept", "application/xml")
				.get("/usuarios")
				.andReturn().xmlPath();
		
		Usuario usuario1 = path.getObject("list.usuario[0]", Usuario.class);
		Usuario usuario2 = path.getObject("list.usuario[1]", Usuario.class);
		
		assertEquals(mauricio, usuario1);
		assertEquals(guilherme, usuario2);
	}
	
	@Test
	public void deveRetornareUsuarioPeloId() {
		JsonPath path = given()
				.parameter("usuario.id", 1)
				.header("Accept", "application/json")
				.get("/usuarios/show")
				.andReturn().jsonPath();
		
		Usuario usuario = path.getObject("usuario", Usuario.class);
		
		assertEquals(mauricio, usuario);
	}
	
	@Test
	public void deveRetornareUsuarioPeloNome() {
		JsonPath path = given()
				.parameter("usuario.id", 1)
				.header("Accept", "application/json")
				.get("/usuarios/show")
				.andReturn().jsonPath();
		
		String usuario = path.getString("usuario.nome");
		
		assertEquals(mauricio.getNome(), usuario);
	}
}
