package br.com.lembrancinhas.infrastructure.io;

public interface InputReader {

  <T> T input(Object object, Class<T> type);

  <T> T output(Object object, Class<T> type);

}
