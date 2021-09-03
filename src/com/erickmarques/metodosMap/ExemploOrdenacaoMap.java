package com.erickmarques.metodosMap;

import java.util.*;

public class ExemploOrdenacaoMap {
    /*
    dadas as seguintes informações sobre meus livros favoritos e seus autores
    crie e ordene um dicionario de livros
    Autor = Hawking, Stephen  - Livro = nome: Uma Breve História do Tempo, páginas: 256
    Autor = King, Stephen - Livro = nome: Mr. Mercedes, páginas: 400
    Autor = Dick, Philip K. - Livro = nome: Espere Agora Pelo Ano Passado, páginas: 296
    */
    public static void main(String[] args){
        //exiba livros em ordem aleatoria
        Map<String, Livro> meusLivros = new HashMap<>(){{
           put("Hawking, Stephen", new Livro("Uma Breve História do Tempo", 256));
           put("King, Stephen", new Livro("Mr. Mercedes", 400));
           put("Dick, Philip K.", new Livro("Espere Agora Pelo Ano Passado", 296));
        }};
        for(Map.Entry<String, Livro> livro : meusLivros.entrySet()) System.out.println(livro.getKey()
                +" - "+livro.getValue().getNome());

        //imprimir por ordem de insercao
        Map<String, Livro> meusLivros1 = new LinkedHashMap<>(){{
            put("Hawking, Stephen", new Livro("Uma Breve História do Tempo", 256));
            put("King, Stephen", new Livro("Mr. Mercedes", 400));
            put("Dick, Philip K.", new Livro("Espere Agora Pelo Ano Passado", 296));
        }};
        System.out.println("\n\t---imprimir por ordem de inserção---");
        for(Map.Entry<String, Livro> livro : meusLivros1.entrySet()) System.out.println(livro.getKey()
                +" - "+livro.getValue().getNome());

        System.out.println("\n\t---imprimir por ordem dos autores---");
        Map<String, Livro> meusLivros2 = new TreeMap<>(meusLivros1);
        for(Map.Entry<String, Livro> livro : meusLivros2.entrySet()) System.out.println(livro.getKey()
                +" - "+livro.getValue().getNome());

        System.out.println("\n\t---imprimir por ordem dos nomes dos livros---");
        Set<Map.Entry<String, Livro>> meusLivros3 = new TreeSet<>(new ComparatorNome());
        meusLivros3.addAll(meusLivros.entrySet());
        for(Map.Entry<String, Livro> livro : meusLivros3) System.out.println(livro.getKey()
                +" - "+livro.getValue().getNome());

        System.out.println("\n\t---imprimir por ordem do numero de paginas---");
        Set<Map.Entry<String, Livro>> meusLivros4 = new TreeSet<>(new ComparatorQtdPaginas());
        meusLivros4.addAll(meusLivros.entrySet());
        for(Map.Entry<String, Livro> livro : meusLivros4) System.out.println(livro.getKey()
                +" - "+livro.getValue().getNome()+", "+ livro.getValue().getQtdPaginas()+" páginas");
    }
}
class Livro{
    private String nome;
    private Integer qtdPaginas;

    public Livro(String nome, Integer qtdPaginas) {
        this.nome = nome;
        this.qtdPaginas = qtdPaginas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQtdPaginas() {
        return qtdPaginas;
    }

    public void setQtdPaginas(Integer qtdPaginas) {
        this.qtdPaginas = qtdPaginas;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "nome='" + nome + '\'' +
                ", qtdPaginas=" + qtdPaginas +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Livro)) return false;
        Livro livro = (Livro) o;
        return getNome().equals(livro.getNome()) && getQtdPaginas().equals(livro.getQtdPaginas());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getQtdPaginas());
    }
}
class ComparatorNome implements Comparator<Map.Entry<String, Livro>>{
    @Override
    public int compare(Map.Entry<String, Livro> livro1, Map.Entry<String, Livro> livro2) {
        return livro1.getValue().getNome().compareToIgnoreCase(livro2.getValue().getNome());
    }
}
class ComparatorQtdPaginas implements Comparator<Map.Entry<String, Livro>>{

    @Override
    public int compare(Map.Entry<String, Livro> livro1, Map.Entry<String, Livro> livro2) {
        int paginas = Integer.compare(livro1.getValue().getQtdPaginas(),livro2.getValue().getQtdPaginas());
        if(paginas!=0) return paginas;
        return livro1.getValue().getNome().compareToIgnoreCase(livro2.getValue().getNome());
    }
}
