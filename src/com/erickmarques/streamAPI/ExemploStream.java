package com.erickmarques.streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ExemploStream {
    public static void main(String[]args){
        List<String> numerosAleatorios = Arrays.asList(
          "1","2","1","3","6","7","9","0","4","6"
        );

        //imprima todos os numeros dessa lista
        numerosAleatorios.forEach(System.out::println);

        //coloque os 5 primeiros numeros dentro de um Set
        System.out.println("5 primeiros numeros dentro de um Set");
        numerosAleatorios.stream()
                .limit(5)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        System.out.println("Transforme a lista de String em lista de inteiros");
        List<Integer> numeros = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        System.out.println(numeros);

        System.out.println("pegue os numeros pares e maiores que 2 e coloque numa lista");
        List<Integer> numerosPares = numeros.stream()
                .filter(i -> i>2 && i%2==0?true:false)
                .collect(Collectors.toList());
        System.out.println(numerosPares);
        System.out.println("imprimir a media dos numeros");
        numerosAleatorios.stream().mapToInt(Integer::parseInt).average().ifPresent(System.out::println);
        System.out.println("remover numeros impares");
        numeros.removeIf(integer -> integer%2!=0);
        System.out.println(numeros);
    }
}
