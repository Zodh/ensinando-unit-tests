package br.com.lembrancinhas.adapters.presentation;

public class PurchaseMenuImpl implements MenuPresenter{

  @Override
  public String showMenu() {
    var initialMenuOptions = new StringBuilder();
    initialMenuOptions.append(String.format("1 - Listar itens %s", lineSeparator()));
    initialMenuOptions.append(String.format("2 - Adicionar item %s", lineSeparator()));
    initialMenuOptions.append(String.format("3 - Remover item %s", lineSeparator()));
    initialMenuOptions.append(String.format("4 - Finalizar compra %s", lineSeparator()));
    initialMenuOptions.append(String.format("5 - Cancelar compra %s", lineSeparator()));
    return initialMenuOptions.toString();
  }
}
