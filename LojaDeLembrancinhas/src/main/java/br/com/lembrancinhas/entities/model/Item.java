package br.com.lembrancinhas.entities.model;

import br.com.lembrancinhas.entities.error.FlowException;
import java.math.BigDecimal;
import java.math.BigInteger;
import lombok.Getter;

@Getter
public class Item {

  private static final BigDecimal MAX_VALUE = new BigDecimal("100");

  private String name;

  private BigDecimal value;

  public Item(String name, BigDecimal value) {
    if (value.compareTo(MAX_VALUE) > 0) {
      throw new FlowException(String.format("The max value for an item is %s!", MAX_VALUE));
    }
    if (name.length() > 50) {
      throw new FlowException("An item can not have a name greater than 50 characters!");
    }
    this.name = name;
    this.value = value;
  }

  private void setValue(BigDecimal bigInteger){
    if (bigInteger.compareTo(MAX_VALUE) > 0) {
      throw new FlowException(String.format("The max value for an item is %s!", MAX_VALUE));
    }
    this.value = bigInteger;
  }

  private void setName(String name) {
    if (name.length() > 50) {
      throw new FlowException("An item can not have a name greater than 50 characters!");
    }
    this.name = name;
  }
}
