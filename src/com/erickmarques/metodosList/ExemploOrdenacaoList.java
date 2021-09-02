package com.erickmarques.metodosList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExemploOrdenacaoList {
    /*dadas as seguintes informacoes sobre meus gatos, crie uma lista
    exibindo nome, idade e cor
    gato 1 = nome: nyongo idade: 24 cor: preto e branco
    gato 2 = nome: jupiter idade: 12 cor: preto
    gato 3 = nome: remi idade: 12 cor: marrom
     */
    public static void main(String[]args){
        List<Gato> meusGatos = new ArrayList<>(){{
            add(new Gato("Nyongo", 24, "preto e branco"));
            add(new Gato("Jupiter", 10, "preto"));
            add(new Gato("Remi", 12, "marrom"));
        }};

        //imprimir por ordem de inserção
        System.out.println("imprimir por ordem de inserção\n"+meusGatos);

        //imprimir em ordem aleatoria
        Collections.shuffle(meusGatos);
        System.out.println("imprimir por ordem aleatoria\n"+meusGatos);

        //organizar pela ordem natural
        Collections.sort(meusGatos); // utiliza comparable implementando na classe para ordenar
        System.out.println("imprimir por ordem natural (nome)\n"+meusGatos);

        //ordenar por idade
        meusGatos.sort(new ComparatorIdade());
        System.out.println("imprimir por idade\n"+meusGatos);

        //ordenar por cor
        meusGatos.sort(new ComparatorCor());
        System.out.println("imprimir por cor\n"+meusGatos);

        //ordernar por Nome-Cor-Idade
        meusGatos.sort(new ComparatorNomeCorIdade());
        System.out.println("imprimir por cor\n"+meusGatos);
    }
}
class Gato implements Comparable<Gato>{
    private String nome;
    private Integer idade;
    private String cor;

    public Gato(String nome, Integer idade, String cor) {
        this.nome = nome;
        this.idade = idade;
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public String toString() {
        return "Gato{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cor='" + cor + '\'' +
                '}';
    }

    @Override
    public int compareTo(Gato gato) {
        return this.getNome().compareToIgnoreCase(gato.getNome());
    }
}
class ComparatorIdade implements Comparator<Gato> {

    @Override
    public int compare(Gato g1, Gato g2) {
        return Integer.compare(g1.getIdade(), g2.getIdade());
    }
}

class ComparatorCor implements Comparator<Gato> {

    @Override
    public int compare(Gato g1, Gato g2) {
        return g1.getCor().compareToIgnoreCase(g2.getCor());
    }
}

class ComparatorNomeCorIdade implements Comparator<Gato> {

    @Override
    public int compare(Gato g1, Gato g2) {
        int nome = g1.getNome().compareToIgnoreCase(g2.getNome());
        if(nome!=0) return nome;

        int cor = g1.getCor().compareToIgnoreCase(g2.getCor());
        if (cor != 0) return cor;

        return Integer.compare(g1.getIdade(),g2.getIdade());
    }
}
