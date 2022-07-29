package br.com.lembrancinhas.entities.error;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;

@Getter
@Log4j2
public class FlowException extends RuntimeException {

  public FlowException(String message) {
    super(message);
    log.error(message);
  }
}
