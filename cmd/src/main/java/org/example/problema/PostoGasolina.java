package org.example.problema;


import java.util.*;

/*   Cenários:
        -- Possuir apenas uma bomba, retornar a lista de chegada;
        -- Possuir o numero de bombas maior ou igual ao numero de carros, retornar uma lista ordenada apenas pelo
        tempo de abastecimento;
        -- Nenhum dos anteriores, retornar uma lista ordenada pela ordem de chegada e pelo de abastecimento.
*/
public class PostoGasolina {

    public static Carro[] abastecerCarros(Carro[] carros, int numBombas) {

        if (numBombas == 1) {
            return carros;
        } else if (numBombas >= carros.length) {
            for (int i = 0; i < carros.length; i++) {
                for (int j = 0; j < (carros.length - 1); j++) {
                    if (carros[j].getTempoAbastecimento() > carros[j + 1].getTempoAbastecimento()) {
                        Carro auxiliar = carros[j];
                        carros[j] = carros[j + 1];
                        carros[j + 1] = auxiliar;
                    }
                }
            }
            return carros;
        } else {
            int esperaIndex =0, saidaIndex = 0;
            Carro[] carrosIniciais = new Carro[numBombas];
            Carro[] carrosEspera = new Carro[carros.length - numBombas];
            Carro[] arraySaida = new Carro[carros.length];

            for (int i = 0; i < carrosIniciais.length; i++) {
                carrosIniciais[i] = carros[i];
            }

            for (int i = carrosIniciais.length; i < carros.length; i++) {
                carrosEspera[esperaIndex] = carros[i];
                esperaIndex++;
            }

            for (int i = 0; i < carrosIniciais.length; i++) {
                for (int j = 0; j < (numBombas - 1); j++) {
                    if (carrosIniciais[j].getTempoAbastecimento() > carrosIniciais[j + 1].getTempoAbastecimento()) {
                        Carro auxiliar = carrosIniciais[j];
                        carrosIniciais[j] = carrosIniciais[j + 1];
                        carrosIniciais[j + 1] = auxiliar;
                    }
                }
            }

            for (int i=0; i<carrosIniciais.length; i++){
                arraySaida[i] = carrosIniciais[i];
            }
            
            for (int i = carrosIniciais.length; i < carros.length; i++) {
                arraySaida[i] = carrosEspera[saidaIndex];
                saidaIndex++;
            }

            return arraySaida;
        }
    }
}
