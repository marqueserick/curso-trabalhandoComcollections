package com.erickmarques.metodosList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ExemploList {

    public static void main(String[] args){
        //dado um aluno que possui 7 notas faça o seguinte:

        //crie uma lista e adicione as 7 notas
        List<Double> notas = new ArrayList<>();
        notas.add(7.0);
        notas.add(0.0);
        notas.add(9.5);
        notas.add(3.6);
        notas.add(5.0);
        notas.add(8.5);
        notas.add(9.7);

        System.out.println(notas);

        //exiba a posicao da nota 5.0
        System.out.println("Posição da nota 5.0 = "+notas.indexOf(5.0));

        //adicione a nota 8.2 na posicao 4
        notas.add(4, 8.2);
        System.out.println(notas);

        //substitua a nota 5.0 pela nota 7.7
        notas.set(notas.indexOf(5.0),7.7);
        System.out.println(notas);

        //confira se a nota 5.0 está na lista
        System.out.println("nota 5.0 está na lista?\n"+(notas.contains(5.0)?"sim":"não"));

        //exiba todas as notas na ordem que foram informadas
        for (Double nota:notas) System.out.println(nota);

        //exiba a terceira nota adicionada
        System.out.println("terceira nota: "+notas.get(2).toString());

        //exiba a menor nota
        System.out.println("menor nota: "+ Collections.min(notas));

        //exiba maior nota
        System.out.println("maior nota: "+Collections.max(notas));

        //exiba a soma dos valores
        Iterator<Double> iterator = notas.iterator();
        Double soma = 0d;
        while (iterator.hasNext()){
            Double proximo = iterator.next();
            soma += proximo;
        }
        System.out.println("Soma das notas: "+soma);
        
        //exiba media das notas
        System.out.println("Média das notas: "+ soma/notas.size());
        // remova a nota 0.0
        notas.remove(0d);
        System.out.println(notas);

        //remova a nota na posicao 0
        notas.remove(0);
        System.out.println(notas);

        //remova as notas iterator1 que 7.0 e exiba a lista
        Iterator<Double> iterator1 = notas.iterator();
        while(iterator1.hasNext()){
            Double next = iterator1.next();
            if(next < 7) iterator1.remove();
        }
        System.out.println(notas);

        //remova todas as notas
        notas.clear();
        System.out.println(notas);

        //confira se lista esta vazia
        System.out.println(notas.isEmpty()?"Lista está vazia":"Lista contém notas");
    }
}
