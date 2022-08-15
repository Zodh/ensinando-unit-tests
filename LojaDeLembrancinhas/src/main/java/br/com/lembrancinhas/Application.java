package br.com.lembrancinhas;

import br.com.lembrancinhas.entities.model.Cart;
import br.com.lembrancinhas.entities.model.Item;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Application {

  public static void main(String[] args) {
    var itemUm = new Item("Carrinho de controle remoto", new BigDecimal("105.99"));
    var itemDois = new Item("Gorro do papai noel", new BigDecimal("29.99"));
    var itemTres = new Item("Jack Daniels Honey", new BigDecimal("45.99"));

    // --------------------------------------------------------------------------------

    var listaComum = List.of(itemUm, itemDois, itemTres);
    mostraItensDaListaDeCompra(listaComum);

    var arrayListDeItem = new ArrayList<Item>();
    arrayListDeItem.add(itemUm);
    arrayListDeItem.add(itemDois);
    arrayListDeItem.add(itemTres);
    mostraItensDaListaDeCompra(arrayListDeItem);

    var carrinho = new Cart();
    carrinho.add(itemUm);
    carrinho.add(itemDois);
    carrinho.add(itemTres);
    mostraItensDaListaDeCompra(carrinho);
  }

  private static void mostraItensDaListaDeCompra(List<Item> items) {
    items.forEach(System.out::println);
  }

}
