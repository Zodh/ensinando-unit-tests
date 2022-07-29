package br.com.lembrancinhas.adapters.presentation;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class InitialMenuImpl implements MenuPresenter {

  @Override
  public String showMenu() {
    var initialMenuOptions = new StringBuilder();
    initialMenuOptions.append(String.format("0 - Criar item %s", lineSeparator()));
    initialMenuOptions.append(String.format("1 - Iniciar compra %s", lineSeparator()));
    initialMenuOptions.append(String.format("2 - Sair %s", lineSeparator()));
    return initialMenuOptions.toString();
  }
}
