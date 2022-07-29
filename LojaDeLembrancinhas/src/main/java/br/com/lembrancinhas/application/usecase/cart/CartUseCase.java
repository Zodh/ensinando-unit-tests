package br.com.lembrancinhas.application.usecase.cart;

import br.com.lembrancinhas.entities.model.Cart;
import br.com.lembrancinhas.entities.model.Item;

public interface CartUseCase {

  String addItem(Cart cart, Item item);

  String removeItem(Cart cart, Item item);

}
