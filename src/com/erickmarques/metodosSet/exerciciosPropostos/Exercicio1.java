package com.erickmarques.metodosSet.exerciciosPropostos;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Exercicio1 {
    /*
    crie uma classe LinguagemFavorita que possua os atributos nome, anoDeCriacao e IDE.
    Em seguida, crie um conjunto com 3 linguagens e faça um programa que ordene esse conjunto por:

    A. Ordem de Inserção
    B. Ordem Natural (nome)
    C. IDE
    D. Ano de Criação e Nome
    E. Nome, ano de criação e IDE

    Ao final, exiba as linguagens no console, um abaixo da outra

     */
    public static void main(String[]args)
    {
        Set<LinguagemFavorita> linguagens = new LinkedHashSet<>(){{
            add(new LinguagemFavorita("Java",1991, "IntelliJ"));
            add(new LinguagemFavorita("Kotlin",2010, "IntelliJ"));
            add(new LinguagemFavorita("C#",2000, "Visual Studio"));
        }};

        Set<LinguagemFavorita> linguagensOrdemNatural = new TreeSet<>(linguagens);

        Set<LinguagemFavorita> linguagensIde = new TreeSet<>(new ComparatorIDE());
        linguagensIde.addAll(linguagens);

        Set<LinguagemFavorita> linguagensAnoCriacaoNome = new TreeSet<>(new ComparatorAnoCriacaoNome());
        linguagensAnoCriacaoNome.addAll(linguagens);

        Set<LinguagemFavorita> linguagensNomeAnoCriacaoIde = new TreeSet<>(new ComparatorNomeAnoCriacaoIde());
        linguagensNomeAnoCriacaoIde.addAll(linguagens);

        for(int i=0; i<5; i++){
            switch(i){
                case 0: imprimirLista("Imprimir por ordem de inserção", linguagens);
                break;
                case 1: imprimirLista("Imprimir por ordem natural (nome)", linguagensOrdemNatural);
                break;
                case 2: imprimirLista("Imprimir por Ide", linguagensIde);
                break;
                case 3: imprimirLista("Imprimir por Ano de Criação e Nome",linguagensAnoCriacaoNome);
                break;
                case 4: imprimirLista("Imprimir por Nome, Ano de Criação e Ide", linguagensNomeAnoCriacaoIde);
            }
        }

    }

    public static void imprimirLista(String mensagem, Set<LinguagemFavorita> set){
        System.out.println("\n---\t"+mensagem+"\t---");
        for (LinguagemFavorita l: set) System.out.println(l);
    }
}
