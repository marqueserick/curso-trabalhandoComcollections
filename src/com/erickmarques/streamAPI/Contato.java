package com.erickmarques.streamAPI;

import java.util.Objects;

public class Contato {
    private String nome;
    private String numero;

    public Contato(String nome, String numero) {
        this.nome = nome;
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contato)) return false;
        Contato contato = (Contato) o;
        return getNome().equals(contato.getNome()) && getNumero().equals(contato.getNumero());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getNumero());
    }

    @Override
    public String toString() {
        return "Contato:\n{ Nome: '"+nome+"'\nNúmero: "+numero+"}";
    }
}
