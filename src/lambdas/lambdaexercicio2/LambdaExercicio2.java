package lambdas.lambdaexercicio2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaExercicio2 {
    public static void main(String[] args) {
        List<Pessoa> pessoas = new ArrayList<>(List.of(
                new Pessoa("Joao", "A", 18),
                new Pessoa("Pedro", "A", 38),
                new Pessoa("Arthur", "D", 68),
                new Pessoa("Lucas", "P", 13),
                new Pessoa("Pedro", "O", 22),
                new Pessoa("Joao", "U", 19),
                new Pessoa("Gabriel", "C", 27),
                new Pessoa("Wave", "B", 41)
        ));

        List<Integer> numeros = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        numeros.forEach(n -> System.out.println(n));
        List<String> nomes = new ArrayList<>(List.of("Joao", "Pedro", "Arthur", "Lucas", "O"));
        nomes.forEach(nome -> System.out.println(nome.toUpperCase()));
        pessoas.sort((a, b) -> a.getNome().compareTo(b.getNome()));
        System.out.println(pessoas);
        pessoas.sort((a, b) -> Integer.compare(a.getIdade(), b.getIdade()));
        pessoas.sort(Comparator.comparing(Pessoa::getNome));
        pessoas.sort(Comparator.comparing(Pessoa::getIdade).reversed());
        pessoas.sort(Comparator.comparing(Pessoa::getCidade).thenComparing(Pessoa::getNome));
        List<Integer> num = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(filtrar(num, n -> n % 2 == 0));
        System.out.println(filtrar(num, n -> n > 5));
        System.out.println(filtrar(num, n -> n % 3 == 0));
        System.out.println(map(num, n -> n * n));


    }

    private static List<Integer> filtrar(List<Integer> lista, Predicate<Integer> p) {
        List<Integer> listaFinal = new ArrayList<>();
        for(Integer n: lista) {
            if(p.test(n)) {
                listaFinal.add(n);
            }
        }
        return listaFinal;
    }

    private static List<Pessoa> filtrarPessoa(List<Pessoa> l, Predicate<Pessoa> p) {
        List<Pessoa> listaFinal = new ArrayList<>();
        for(Pessoa pe: l) {
            if(p.test(pe)) {
                listaFinal.add(pe);
            }
        }
        return listaFinal;
    }

    private static List<Integer> map(List<Integer> lista, Function<Integer, Integer> f) {
        List<Integer> result = new ArrayList<>();
        for(Integer inteiroInicial: lista) {
            Integer novoNumero = f.apply(inteiroInicial);
            result.add(novoNumero);
        }

        return result;
    }
}
