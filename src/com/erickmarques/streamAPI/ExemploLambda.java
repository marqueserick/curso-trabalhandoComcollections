package com.erickmarques.streamAPI;

import java.util.*;
import java.util.function.Function;

public class ExemploLambda {
    /*
    dadas as infromações de id e contato, crie e ordene um dicionario exibindo
    (id - Nome contato)
    Id = 1 Contato = Nome:Erick Numero:5555
    Id = 3 Contato = Nome:Mariana Numero:1234
    Id = 4 Contato = Nome:Marcelo Numero:4321
     */
    public static void main(String[] args){
        Map<Integer, Contato> contatos = new HashMap<>(){{
            put(4,new Contato("Marcelo","4321"));
            put(1,new Contato("Erick","5555"));
            put(3,new Contato("Mariana","1234"));

        }};
        //exiba em ordem aleatoria
        System.out.println("em ordem aleatória");
        for(Map.Entry<Integer,Contato>contato: contatos.entrySet())
            System.out.println("ID: "+contato.getKey()+" - "+contato.getValue().getNome());

        //exiba em ordem de inserçao
        System.out.println("em ordem de insercao");
        Map<Integer, Contato> contatos1 = new LinkedHashMap<>(){{
            put(1,new Contato("Erick","5555"));
            put(4,new Contato("Marcelo","4321"));
            put(3,new Contato("Mariana","1234"));

        }};
        for(Map.Entry<Integer,Contato> contato : contatos1.entrySet())
            System.out.println("ID: "+contato.getKey()+" - "+contato.getValue().getNome());

        //exiba por ordem de numero
        System.out.println("em ordem de numero");
        Set<Map.Entry<Integer, Contato>> contatos2 = new TreeSet<>(new Comparator<Map.Entry<Integer, Contato>>() {
            @Override
            public int compare(Map.Entry<Integer, Contato> o1, Map.Entry<Integer, Contato> o2) {
                return o1.getValue().getNumero().compareToIgnoreCase(o2.getValue().getNumero());
            }
        });
        contatos2.addAll(contatos1.entrySet());
        for(Map.Entry<Integer,Contato> contato : contatos2)
            System.out.println("ID: "+contato.getKey()+" - "+contato.getValue());

        System.out.println("em ordem de nome");
        Set<Map.Entry<Integer,Contato>> contatos3 = new TreeSet<>(Comparator.comparing(
                new Function<Map.Entry<Integer, Contato>, String>(){
                    @Override
                    public String apply(Map.Entry<Integer, Contato> contato) {
                        return contato.getValue().getNome();
                    }
                }
        ));
        contatos3.addAll(contatos1.entrySet());
        contatos3.addAll(contatos1.entrySet());
        for(Map.Entry<Integer,Contato> contato : contatos3)
            System.out.println("ID: "+contato.getKey()+" - "+contato.getValue());

        System.out.println("em ordem de nome usando funcao lambda");
        Set<Map.Entry<Integer,Contato>> contatos4 = new TreeSet<>(
                Comparator.comparing(contato -> contato.getValue().getNome()));
        contatos4.addAll(contatos1.entrySet());
        for(Map.Entry<Integer,Contato> contato : contatos4)
            System.out.println("ID: "+contato.getKey()+" - "+contato.getValue());
    }
}
