package RequestTest;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import RequestObject.Consulta_RO;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.path.json.JsonPath;

public class Consulta_RT {

	private String url;
	private Consulta_RO consultaRO = new Consulta_RO();
	private JsonPath jPath;

	@Before
	public void setUp() {
		url = "http://api.zippopotam.us/BR/";

	}

	@Dado("que realizo uma requisicao com o cep {string}")
	public void queRealizoUmaRequisicaoComOCep(String cep) {
		// Write code here that turns the phrase above into concrete actions throw new
		// io.cucumber.java.PendingException();
		jPath = consultaRO.enviarRequisicao(url, cep);
	}

	@Quando("recebo o status code {int}")
	public void receboOStatusCode(Integer int1) {
		// Write code here that turns the phrase above into concrete actions throw new
		// io.cucumber.java.PendingException();
		int statusCode = consultaRO.statusCodeRecebido(url, "01000-000");
		assertEquals(200, statusCode);
	}

	@Entao("no corpo da resposta o estado sera {string}")
	public void noCorpoDaRespostaOEstadoSera(String estadoEsperado) {
		// Write code here that turns the phrase above into concrete actions throw new
		// io.cucumber.java.PendingException();

		String estadoRecebido = jPath.getString("places.state");
		assertTrue(estadoRecebido.contains(estadoEsperado));
	}
}
