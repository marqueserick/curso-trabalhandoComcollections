package com.erickmarques.metodosSet;

import java.util.*;

public class ExemploSet {
    public static void main (String[] args){
        // dado uma lista com 7 notas de um aluno, faça
        Set<Double> notas = new HashSet<>(Arrays.asList(7d,8.5,0d,1.5,3.6,9d,10d));
        System.out.println(notas);
        //exiba a nota 5.0 -> Set nao possui indexOf()
        //insira a nota 7.0 na posicao 4 -> Set não possui index
        //substitua a nota 5.o por 6.0 -> não dá pra encontrar a posicao da nota 5.0
        //verifique se a nota 5.0 está na lista
        System.out.println("A nota 5.0 está na lista?\n"
                + (notas.contains(5d)? "Sim" : "Não"));
        //exiba a terceira nota inserida -> Set não é ordenado
        //exiba a menor nota
        System.out.println("Menor nota: "+ Collections.min(notas));
        
        //exiba maior nota
        System.out.println("Maior nota: "+ Collections.max(notas));
        
        //exiba soma dos valores
        Iterator<Double> iterator = notas.iterator();
        Double soma = 0d;
        while(iterator.hasNext()){
            Double next = iterator.next();
            soma += next;
        }
        System.out.println("Soma das notas: "+ soma);

        //exiba media das notas
        Double media = soma / notas.size();
        System.out.println("Média: "+media);

        //remova a nota 0.0
        notas.remove(0d);
        System.out.println(notas);

        //remova a nota da posicao 0 -> não tem index

        //remova notas menores que 7 e exiba as notas
        Iterator<Double> iterator1 = notas.iterator();
        while (iterator1.hasNext()){
            Double next = iterator1.next();
            if(next<7) iterator1.remove();
        }
        System.out.println(notas);

        //exiba as notas na ordem que foram informadas -> HashSet não tem ordenaocao
        //criar LinkedHashSet
        Set<Double> notas2 = new LinkedHashSet<>();
        notas2.add(7d);
        notas2.add(8d);
        notas2.add(9d);
        notas2.add(7.5);
        notas2.add(0d);
        notas2.add(3.6);
        notas2.add(4.7);
        System.out.println(notas2);

        //exibir em ordem crescente
        //usar TreeSet para ordenacao natural dos elementos

        Set<Double> notas3 = new TreeSet<>(notas2);
        System.out.println(notas3);

        //remova todas as notas
        notas.clear();
        System.out.println(notas);

        //verifique se notas esta vazia
        System.out.println(notas.isEmpty()?"Lista está vazia":"Lista contém notas");

    }
}
