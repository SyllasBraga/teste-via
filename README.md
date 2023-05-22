# Teste técnico para desenvolvedor Java Júnior na VIA

1.	Crie um repositório público no Github, para o projeto
2.	Crie uma solution, e dentro da mesma crie 2 projetos um de web api e o outro de cmd para a chamada da api
3.	No projeto de webapi, projete um microservico de carrinho de compras, onde recebemos os produtos e o armazenamos em um banco com o status de vendido ou não
4.	No projeto de cmd básico faça a chamada da api de carrinho de preços.
5.	No projeto de cmd, também faça um método que solucione o problema abaixo:

    Crie um método PostoDeGasolina que receba um parâmetro de array de carros, cada carro teria a propriedade de tempo de abastecimento e o nome do carro.
    
    Este método irá receber outro parâmetro o de quantidade de bombas de gasolina, cada bomba de gasolina, está apta para o primeiro carro que chegou, e ele deverá abastecer pelo tempo de abastecimento, a bomba ficará bloqueada até esse carro sair da bomba, e a deverá vir o próximo carro da fila.
    
    Ex:
    Array de Entrada de Carros
    Carro1, Tempo abastecimento: 10 segs
    Carro2, Tempo abastecimento: 5 segs
    Carro3, Tempo abastecimento: 1 segs
    Carro4, Tempo abastecimento: 1 segs
    Carro5, Tempo abastecimento: 1 segs
    
    Bombas de Gasolina (3)
    
    O método deverá retornar a ordem de saída dos carros. Nesse caso seria:
    
    Carro3, Tempo abastecimento: 1 segs
    Carro4, Tempo abastecimento: 1 segs
    Carro5, Tempo abastecimento: 1 segs
    Carro2, Tempo abastecimento: 5 segs
    Carro1, Tempo abastecimento: 10 segs
