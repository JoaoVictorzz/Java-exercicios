package optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TesteOptional {
    public static void main(String[] args) {
        List<Pessoa> pessoas = new ArrayList<>(List.of(
                new Pessoa("joao", 19),
                new Pessoa("arthur", 9),
                new Pessoa("lucas", 20)
        ));

        Pessoa pessoa1 = buscarPessoa(pessoas, "arthur").
                orElseGet(() -> new Pessoa("Desconhecido", 0));

        Pessoa pessoa2 = buscarPessoa(pessoas, "lucas").
                orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));

        Pessoa pessoa3 = buscarPessoa(pessoas, "joao").
                filter(p -> p.getAge() > 18).
                orElse(new Pessoa("Desconhecido", 0));

        System.out.println(pessoa3);

    }

    public static Optional<Pessoa> buscarPessoa(List<Pessoa> pessoas, String name) {
        Pessoa pessoa = null;
        for(Pessoa pessoa1: pessoas) {
            if(pessoa1.getName().equals(name)){
                pessoa = pessoa1;
            }
        }

        return Optional.ofNullable(pessoa);
    }

    public static String buscarNome(List<Pessoa> p, String name) {
        return buscarPessoa(p, name).
                map(Pessoa::getName).
                orElse("Nâo encontrado.");
    }
}
