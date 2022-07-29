package br.com.lembrancinhas.entities.model;

import br.com.lembrancinhas.entities.error.FlowException;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;


@Getter
@NoArgsConstructor
public class Item {

  private static final BigDecimal MAX_VALUE = new BigDecimal("350.00");

  private String name;

  private BigDecimal value;

  public Item(String name, BigDecimal value) {
    this.name = name;
    this.value = value;
  }

  private void setValue(BigDecimal bigDecimal) {
    if (bigDecimal.compareTo(MAX_VALUE) > 0) {
      throw new FlowException(String.format("The max value for an item is %s", MAX_VALUE));
    }
    this.value = bigDecimal;
  }

  public void setName(String name) {
    if (StringUtils.isBlank(name)) {
      throw new FlowException("Invalid name");
    }
    if (name.length() > 50) {
      throw new FlowException("A name can not have more than 50 characters");
    }
    this.name = name;
  }
}
