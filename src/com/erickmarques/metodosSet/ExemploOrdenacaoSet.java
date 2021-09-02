package com.erickmarques.metodosSet;

import java.util.*;

public class ExemploOrdenacaoSet {
    /*dadas as seguintes informacoes sobre minhas series favoritas
    crie e ordene um conjunto exibindo:
    (nome da serie - genero - tempo de duracao do episodio)

    Serie 1 (Nome: The Handmaid's Tale - Gênero: Drama - Tempo de Duração do Episodio: 60)
    Serie 2 (Nome: Loki - Gênero: Fantasia - Tempo de Duração do Episodio: 60)
    Serie 3 (Nome: Brooklyn Nine-Nine - Gênero: Comédia - Tempo de Duração do Episodio: 25)
     */
    public static void main(String[]args){

        //ordem aleatoria
        System.out.println("\t---imprimr em ordem aleatoria---");
        Set<Serie> minhasSeries = new HashSet<>(){{
            add(new Serie("The Handmaid's Tale", "Drama", 60));
            add(new Serie("Loki", "Fantasia", 60));
            add(new Serie("Brooklyn Nine-Nine", "Comédia", 25));
        }};

        for (Serie serie:minhasSeries) System.out.println(serie.getNome()
                +" - "+serie.getGenero()+" - "+serie.getDuracaoEpisodio());

        //imprimir por ordem de insercao
        System.out.println("\t---imprimir em ordem de insercao---");
        Set<Serie> minhasSeries1 = new LinkedHashSet<>(){{
            add(new Serie("The Handmaid's Tale", "Drama", 60));
            add(new Serie("Loki", "Fantasia", 60));
            add(new Serie("Brooklyn Nine-Nine", "Comédia", 25));
        }};
        for (Serie serie:minhasSeries1) System.out.println(serie.getNome()
                +" - "+serie.getGenero()+" - "+serie.getDuracaoEpisodio());

        //imprimir por ordem natural (tempo de duracao do episodio)
        System.out.println("\t---imprimir por tempo de duracao do episodio---");
        Set<Serie> minhasSeries2 = new TreeSet<>(minhasSeries1);
        for (Serie serie:minhasSeries2) System.out.println(serie.getNome()
                +" - "+serie.getGenero()+" - "+serie.getDuracaoEpisodio());

        //imprimir por nome/genero/tempodeDuracaoEpisodio
        System.out.println("\t---imprimir por nome-genero-tempoDeEpisodio---");
        Set<Serie> minhasSeries3 = new TreeSet<>(new ComparatorNomeGeneroDuracaoEpisodio());
        minhasSeries3.addAll(minhasSeries);
        for (Serie serie:minhasSeries3) System.out.println(serie.getNome()
                +" - "+serie.getGenero()+" - "+serie.getDuracaoEpisodio());

    }
}