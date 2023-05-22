package org.example.problema;

public class Carro {

    private String nome;
    private int tempoAbastecimento;

    public Carro(String nome, int tempoAbastecimento) {
        this.nome = nome;
        this.tempoAbastecimento = tempoAbastecimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTempoAbastecimento() {
        return tempoAbastecimento;
    }

    public void setTempoAbastecimento(int tempoAbastecimento) {
        this.tempoAbastecimento = tempoAbastecimento;
    }
    @Override
    public String toString() {
        return  nome + ", Tempo abastecimento: " + tempoAbastecimento + " segs";
    }

}
