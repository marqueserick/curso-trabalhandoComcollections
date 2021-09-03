package com.erickmarques.metodosMap;

import java.util.*;

public class ExemploMap {
    /*dados os modelos e consumos dos carros abaixo, faça
    modelo gol - consumo 14.4 hm/l
    modelo uno - consumo 15.6 km/l
    modelo mobi - consumo 16.1 km/l
    modelo hb20 - consumo 14.5 km/l
    modelo kwid - consumo 15.6 km/l
     */
    public static void main(String[]args){
        //crie um dicionario que relacione os modelos e seus respectivos consumos
        Map<String, Double> carrosPopulares = new HashMap<>(){{
            put("gol",14.4);
            put("uno",15.6);
            put("mobi",16.1);
            put("hb20",14.5);
            put("kwid",15.6);
        }};
        System.out.println(carrosPopulares);

        //substitua o consumo do gol por 15.2 km/l
        carrosPopulares.put("gol", 15.2);
        System.out.println(carrosPopulares);

        //verifique se contem tucson no dicionario
        System.out.println("Contém Tucson no dicionario? - "+(carrosPopulares.containsKey("tucson")?"Sim":"Não"));

        //exiba consumo do uno
        System.out.println("Consumo do Uno (km/l): "+carrosPopulares.get("uno"));

        //exiba o terceiro modelo adicionado -> não possui index

        //exiba os modelos
        System.out.println("modelos ="+carrosPopulares.keySet());

        //exiba os consumos
        System.out.println("consumos = "+carrosPopulares.values());

        //exiba o modelo mais economico e seu consumo
        Double maiorConsumo = Collections.max(carrosPopulares.values());
        Set<Map.Entry<String, Double>> entries = carrosPopulares.entrySet();
        System.out.println("Carro com melhor consumo");
        for(Map.Entry<String,Double> entry : entries){
            if(entry.getValue().equals(maiorConsumo)){
                System.out.println(entry.getKey()+" - "+entry.getValue());
            }
        }

        //exiba modelo menos economico e seu consumo
        Double menorConsumo = Collections.min(carrosPopulares.values());
        System.out.println("Carro com pior consumo");
        for(Map.Entry<String,Double> entry : entries){
            if(entry.getValue().equals(menorConsumo)){
                System.out.println(entry.getKey()+" - "+entry.getValue());
            }
        }

        //exiba soma dos consumos
        Double soma = 0d;
        for(Double valorConsumo: carrosPopulares.values()) soma+=valorConsumo;
        System.out.println("Soma dos consumos: "+ soma);

        //exiba a média dos consumos
        Double media = soma / carrosPopulares.size();
        System.out.println("Valor médio de consumo: "+ media);

        System.out.println("remover carros com consumo igual a 15,6 km/l");
        Iterator<Double> iterator = carrosPopulares.values().iterator();
        while (iterator.hasNext()){
            if(iterator.next().equals(15.6)) iterator.remove();
        }
        System.out.println(carrosPopulares);

        //exiba carros na ordem que foram informados
        Map<String, Double> carrosPopulares1 = new LinkedHashMap<>(){{
            put("gol",14.4);
            put("uno",15.6);
            put("mobi",16.1);
            put("hb20",14.5);
            put("kwid",15.6);
        }};
        System.out.println("Ordem de inserção: "+carrosPopulares1);

        //exiba carros ordenados por modelo
        Map<String, Double> carrosPopulares2 = new TreeMap<>(carrosPopulares1);
        System.out.println("Ordenados por modelo: "+carrosPopulares2);

        //apague o dicionario de carros
        carrosPopulares.clear();

        //confira se o dicionario esta vazio
        System.out.println(carrosPopulares.isEmpty()?"Dicionário está vazio":"Dicionário contém carros");

    }
}
