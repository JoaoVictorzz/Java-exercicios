package collections.collectionsexercicio1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProdutoMain {
    public static void main(String[] args) {
        List<Produto> lista = new ArrayList<>();
        lista.add(new Produto("A", 5.66));
        lista.add(new Produto("B", 17.88));
        lista.add(new Produto("C", 2.69));
        lista.add(new Produto("D", 54));

        Collections.sort(lista, new ComparatorPrecoDecrescente());
        System.out.println(lista);

        Collections.sort(lista, new ComparatorNome());
        System.out.println(lista);
    }
}