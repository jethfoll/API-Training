#language: pt
@Consulta
Funcionalidade: Consulta

  Cenario: realizar consulta informando um cep valido
    Dado que realizo uma requisicao com o cep "01000-000"
    Quando recebo o status code 200
    Entao no corpo da resposta o estado sera "Sao Paulo"
