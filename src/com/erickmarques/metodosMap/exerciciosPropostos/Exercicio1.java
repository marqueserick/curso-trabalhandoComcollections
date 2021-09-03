package com.erickmarques.metodosMap.exerciciosPropostos;

import java.text.NumberFormat;
import java.util.*;

public class Exercicio1 {
    //enunciado no arquivo enunciado_exercicio1.txt
    public static void main(String[] args) {
        Map<String, Integer> estados = new LinkedHashMap<>() {{
            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);
        }};
        //alterar populacao RN
        estados.put("RN", 3534165);

        //adicionar PB
        if (!estados.containsKey("PB")) estados.put("PB", 4039277);

        //exibir populacao PE
        System.out.println(estados.containsKey("PE")?
                "População do PE: "+NumberFormat.getInstance().format(estados.get("PE")):
                "PE nã está no dicionario");

        //exibir todos os estados na ordem de insercao
        for (Map.Entry<String, Integer> estado : estados.entrySet()) {
            NumberFormat form = NumberFormat.getInstance();
            System.out.println("Estado: " + estado.getKey()
                    + " População: " + form.format(estado.getValue()));
        }

        System.out.println("\t---Estados em ordem alfabética---");
        //exiba estados em ordem alfabetica
        Map<String,Integer> estadosOrdemAlfabetica = new TreeMap<>(estados);
        for (Map.Entry<String, Integer> estado : estadosOrdemAlfabetica.entrySet()) {
            NumberFormat form = NumberFormat.getInstance();
            System.out.println("Estado: " + estado.getKey()
                    + " População: " + form.format(estado.getValue()));
        }

        //estado com menor população
        System.out.println("\t---Estado com menor populaçao---");
        Integer menorPopulacao = Collections.min(estados.values());
        for(Map.Entry<String,Integer> estado: estados.entrySet()){
            if(estado.getValue().equals(menorPopulacao)) System.out.println(
                    estado.getKey()+" População: "
                            +NumberFormat.getInstance().format(estado.getValue()));
        }

        System.out.println("\t---Estado com maior populaçao---");
        Integer maiorPopulacao = Collections.max(estados.values());
        for(Map.Entry<String,Integer> estado: estados.entrySet()){
            if(estado.getValue().equals(maiorPopulacao)) System.out.println(
                    estado.getKey()+" População: "
                            +NumberFormat.getInstance().format(estado.getValue()));
        }

        //exiba a soma das populações
        Integer populacaoTotal=0;
        for(Map.Entry<String,Integer> estado: estados.entrySet()) populacaoTotal+=estado.getValue();
        System.out.println("População total dos estados: "+NumberFormat.getInstance().format(populacaoTotal));

        //exiba media das populações
        Double media = Double.valueOf(populacaoTotal)/Double.valueOf(estados.size());
        System.out.println("Média da população: "+NumberFormat.getInstance().format(media));

        //remova os estados com a populacao menor que 4.000.000
        System.out.println("Populações maiores que 4.000.000");
        Iterator<Integer> iterator = estados.values().iterator();
        while (iterator.hasNext()){
            if(iterator.next().doubleValue()<4000000) iterator.remove();
        }
        for (Map.Entry<String, Integer> estado : estados.entrySet())
            System.out.println("Estado: " + estado.getKey()
                    + " População: " + NumberFormat.getInstance().format(estado.getValue()));
        estados.clear();
        System.out.println(estados.isEmpty()?"Dicionario de estados está vazio":"Dicionário contém estados");



    }
}
