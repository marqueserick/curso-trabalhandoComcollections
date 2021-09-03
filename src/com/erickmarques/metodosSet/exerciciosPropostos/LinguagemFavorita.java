package com.erickmarques.metodosSet.exerciciosPropostos;

import java.util.Comparator;
import java.util.Objects;

public class LinguagemFavorita implements Comparable<LinguagemFavorita>{
    private String nome;
    private Integer anoCriacao;
    private String ide;

    public LinguagemFavorita(String nome, Integer anoCriacao, String ide) {
        this.nome = nome;
        this.anoCriacao = anoCriacao;
        this.ide = ide;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAnoCriacao() {
        return anoCriacao;
    }

    public void setAnoCriacao(Integer anoCriacao) {
        this.anoCriacao = anoCriacao;
    }

    public String getIde() {
        return ide;
    }

    public void setIde(String ide) {
        this.ide = ide;
    }

    @Override
    public String toString() {
        return "Nome: "+this.getNome()
                +"\nAno de Criação: "+this.getAnoCriacao()
                +"\nIDE: "+this.getIde();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LinguagemFavorita)) return false;
        LinguagemFavorita that = (LinguagemFavorita) o;
        return getNome().equals(that.getNome()) && getAnoCriacao().equals(that.getAnoCriacao()) && getIde().equals(that.getIde());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getAnoCriacao(), getIde());
    }

    @Override
    public int compareTo(LinguagemFavorita o) {
        return this.getNome().compareTo(o.getNome());
    }
}

class ComparatorIDE implements Comparator<LinguagemFavorita>{

    @Override
    public int compare(LinguagemFavorita o1, LinguagemFavorita o2) {
        int ide = o1.getIde().compareToIgnoreCase(o2.getIde());
        if(ide!=0) return ide;
        return o1.getNome().compareToIgnoreCase(o2.getNome());
    }
}

class ComparatorAnoCriacaoNome implements Comparator<LinguagemFavorita>{

    @Override
    public int compare(LinguagemFavorita o1, LinguagemFavorita o2) {
        int anoCriacao = Integer.compare(o1.getAnoCriacao(),o2.getAnoCriacao());
        if (anoCriacao!=0) return anoCriacao;
        return o1.getNome().compareToIgnoreCase(o2.getNome());
    }
}

class ComparatorNomeAnoCriacaoIde implements Comparator<LinguagemFavorita>{

    @Override
    public int compare(LinguagemFavorita o1, LinguagemFavorita o2) {
        int nome = o1.getNome().compareToIgnoreCase(o2.getNome());
        if(nome!=0) return nome;

        int anoCriacao = Integer.compare(o1.getAnoCriacao(),o2.getAnoCriacao());
        if(anoCriacao!=0) return anoCriacao;

        return o1.getIde().compareToIgnoreCase(o2.getIde());
    }
}
