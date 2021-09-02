package com.erickmarques.exerciciosPropostos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercicio2 {
    /*
    utilizando listas, faça um programa que faça 5 perguntas para uma pessoa sobre um crime
    as perguntas são:
    1 — Telefonou para a vítima?
    2 — Esteve no local do crime?
    3 — Mora perto da vítima?
    4 — Devia para a vítima?
    5 — Já trabalhou com a vítima?

    se a pessoa responder positivamente a 2 questões ela deve ser classificada como Suspeita,
    entre 3 e 4 como Cúmplice
    e 5 como Assassina, caso contrario deve ser considerada Inocente
     */
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int positivos = 0;
        List<String> perguntas = new ArrayList<>(){{
            add("1 — Telefonou para a vítima?");
            add("2 — Esteve no local do crime?");
            add("3 — Mora perto da vítima?");
            add("4 — Devia para a vítima?");
            add("5 — Já trabalhou com a vítima?");
        }};
        List<String> respostas = new ArrayList<>();

        for (String pergunta : perguntas){
            System.out.println(pergunta);
            respostas.add(scanner.nextLine().toLowerCase());
        }

        for (String resposta: respostas){
            if (resposta.contains("s")){
                positivos++;
            }
        }

        System.out.println("Você é "+classificar(positivos));
    }
    public static String classificar(int i){
        switch (i){
            case 0:
            case 1: return "inocente";
            case 2: return "suspeito";
            case 3:
            case 4: return "cúmplice";
            case 5: return "assassino";
            default: return null;
        }
    }
}
