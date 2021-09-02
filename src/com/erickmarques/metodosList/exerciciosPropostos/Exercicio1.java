package com.erickmarques.exerciciosPropostos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Exercicio1 {
    /*
    faça um programa que receba a temperatura média dos 6 primeiros
    meses do ano e armazene em uma lista.
    Após isto, calcule a média semestral das temperaturas e mostre
    todas as temperaturas acima desta média e em que mês elas ocorreram
    (mostrar mês por extenso. Ex: 1 - Janeiro, 2 - Fevereiro e etc.)
     */
    public static void main(String[] args) {
        List<Double> temperaturas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        for (int i=0; i<6;i++){
            System.out.println("Informe a temperatura média do mês de "+mes(i));
            temperaturas.add(scanner.nextDouble());
        }
        //realizar media das temperaturas
        Iterator<Double> iterator= temperaturas.iterator();
        Double totalTemperatura = 0d;

        while(iterator.hasNext()){
            Double next = iterator.next();
            totalTemperatura += next;
        }
        Double mediaTemperatura = totalTemperatura / temperaturas.size();
        System.out.println("Média semestral: "+ mediaTemperatura+"ºC\nMeses com temperatura " +
                "acima da média: ");
        int mes=0;
        for(Double temperatura: temperaturas){
            if(temperatura>mediaTemperatura){
                System.out.println((mes+1)+" - "+mes(mes) +": " +temperatura+"ºC");
            }
            mes++;
        }
    }

    public static String mes(int mes){
        switch(mes){
            case 0: return "Janeiro";
            case 1: return "Fevereiro";
            case 2: return "Março";
            case 3: return "Abril";
            case 4: return "Maio";
            case 5: return "Junho";
            default: return null;
        }

    }
}
