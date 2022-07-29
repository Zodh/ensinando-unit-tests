package br.com.lembrancinhas.application.usecase.cashier;

import br.com.lembrancinhas.entities.model.Cart;

public interface CashierUseCase {

  String startPurchase();

  String finalizePurchase(Cart cart);

  void cancelPurchase();

}
