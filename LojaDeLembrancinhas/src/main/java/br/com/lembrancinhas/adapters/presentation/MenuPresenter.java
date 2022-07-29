package br.com.lembrancinhas.adapters.presentation;

public interface MenuPresenter {

  String showMenu();

  default String lineSeparator(){
    return "\n";
  }

}
