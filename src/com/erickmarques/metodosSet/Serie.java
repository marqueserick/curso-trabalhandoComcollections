package com.erickmarques.metodosSet;

import java.util.Comparator;
import java.util.Objects;

public class Serie implements Comparable<Serie>{
        private String nome;
        private String genero;
        private Integer duracaoEpisodio;

        public Serie(String nome, String genero, Integer duracaoEpisodio) {
            this.nome = nome;
            this.genero = genero;
            this.duracaoEpisodio = duracaoEpisodio;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getGenero() {
            return genero;
        }

        public void setGenero(String genero) {
            this.genero = genero;
        }

        public Integer getDuracaoEpisodio() {
            return duracaoEpisodio;
        }

        public void setDuracaoEpisodio(Integer duracaoEpisodio) {
            this.duracaoEpisodio = duracaoEpisodio;
        }

        @Override
        public String toString() {
            return "Serie{" +
                    "nome='" + nome + '\'' +
                    ", genero='" + genero + '\'' +
                    ", duracaoEpisodio=" + duracaoEpisodio +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof com.erickmarques.metodosSet.Serie)) return false;
            com.erickmarques.metodosSet.Serie serie = (com.erickmarques.metodosSet.Serie) o;
            return getNome().equals(serie.getNome()) && getGenero().equals(serie.getGenero())
                    && getDuracaoEpisodio().equals(serie.getDuracaoEpisodio());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getNome(), getGenero(), getDuracaoEpisodio());
        }

    @Override
    public int compareTo(Serie serie) {
            int duracaoEpisodio = Integer.compare(this.getDuracaoEpisodio(), serie.getDuracaoEpisodio());
            if (duracaoEpisodio != 0) return duracaoEpisodio;
            return this.getGenero().compareToIgnoreCase(serie.getGenero());
    }
}

class ComparatorNomeGeneroDuracaoEpisodio implements Comparator<Serie> {

    @Override
    public int compare(Serie serie1, Serie serie2) {
        int nome = serie1.getNome().compareToIgnoreCase(serie2.getNome());
        if (nome!=0) return nome;
        int genero = serie1.getGenero().compareToIgnoreCase(serie2.getGenero());
        if (genero!=0) return genero;

        return Integer.compare(serie1.getDuracaoEpisodio(),serie2.getDuracaoEpisodio());
    }
}
