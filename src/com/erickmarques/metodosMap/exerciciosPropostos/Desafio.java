package com.erickmarques.metodosMap.exerciciosPropostos;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Desafio {
    /*
    faça um programa que simule um lançamento de dados
    lance o dado 100 vezes e armazene.
    depois, mostre quantas vezes cada valor foi inserido
    */
    public static void main(String [] args){
        int resultado;
        Map<Integer, Integer> resultados = new HashMap<>();

        for(int i=0;i<100;i++){
            resultado = lancarDado();

            if(resultados.containsKey(resultado)){
                resultados.put(resultado,resultados.get(resultado)+1);
            }else{
                resultados.put(resultado,1);
            }
        }
        for (int i=1;i<=resultados.size();i++){
            System.out.println("O número "+i+" foi sorteado "+resultados.get(i)+" vezes");
        }
    }

    public static int lancarDado(){
        return new Random().nextInt(6)+1;
    }
}
