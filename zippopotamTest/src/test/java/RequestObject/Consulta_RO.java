package RequestObject;

import static io.restassured.RestAssured.given;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class Consulta_RO {

	private JsonPath jPath;
	private Response response;

	public JsonPath enviarRequisicao(String endereco, String cep) {
		String enderecoCompleto = endereco + cep;

		jPath = given().header("Accept", "application/json").get(enderecoCompleto).andReturn().jsonPath();
		return jPath;
	}

	public Integer statusCodeRecebido(String endereco, String cep) {
		String enderecoCompleto = endereco + cep;
		return given().header("Accept", "application/json").get(enderecoCompleto).getStatusCode();
	}
}
