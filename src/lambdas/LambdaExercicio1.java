package lambdas;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaExercicio1 {
    public static void main(String[] args) {
        //filtrar Predicate Generic
        List<Integer> numeros = new ArrayList<>(List.of(10, 5, 6, 16, 19, 22, 3));
        System.out.println(filtrarPG(numeros, numero -> numero > 10));

        //filtrar consumer generic
        resultado(numeros, numero -> System.out.println(numero > 5));

        //trasnformar
        List<String> nomes = List.of("João", "Ana", "Carlos", "Pedro");
        System.out.println(transformar(nomes, nome -> nome.length()));

        //trasnformar Generic
        System.out.println(transformarG(nomes, nome -> nome.length()));


        //filtrar consumer
        filtrarC(nomes, nome -> System.out.println(nome.startsWith("C")));



    }

    private static <T> List<T> filtrarPG(List<T> lista, Predicate<T> p) {
        List<T> retorno = new ArrayList<>();
        for(T e: lista) {
            if(p.test(e)) {
                retorno.add(e);
            }
        }

        return retorno;
    }

    private static <T> void resultado(List<T> lista, Consumer<T> c) {
        for(T e: lista){
            c.accept(e);
        }
    }

    private static List<Integer> transformar(List<String> lista, Function<String, Integer> f) {
        List<Integer> retorno = new ArrayList<>();
        for(String nome: lista) {
            Integer i = f.apply(nome);
            retorno.add(i);
        }

        return retorno;
    }

    private static <T, R> List<R> transformarG(List<T> lista, Function<T, R> f) {
        List<R> retorno = new ArrayList<>();
        for(T e: lista) {
            R r = f.apply(e);
            retorno.add(r);
        }

        return retorno;
    }

    private static void filtrarC(List<String> lista, Consumer<String> consumer) {

        for(String nome: lista) {
            consumer.accept(nome);
        }

    }

}
