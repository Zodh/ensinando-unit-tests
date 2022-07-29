package br.com.lembrancinhas.entities.model;

import br.com.lembrancinhas.entities.error.FlowException;
import java.util.ArrayList;
import java.util.Collection;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Cart extends ArrayList<Item> {

  public Cart() {
  }

  public Cart(Collection<? extends Item> c) {
    super(c);
    if (c.size() > 3) {
      log.error("Can not create a full cart. The cart is empty.");
      this.removeAll(c);
    }
    c.forEach(item -> {
      var itemQuantity = 0;
      for (Item value : this) {
        if (value == item) {
          itemQuantity++;
        }
      }
      if (itemQuantity > 1) {
        log.error("Invalid collection received, it can not contains two or more items of the same"
            + " type. Now the cart is empty.");
        this.removeAll(c);
      }
    });
  }

  @Override
  public boolean add(Item item) {
    verifyIfHasItemType(item);
    checkIfCanAddMoreItens();
    return super.add(item);
  }

  @Override
  public void add(int index, Item element) {
    verifyIfHasItemType(element);
    checkIfCanAddMoreItens();
    super.add(index, element);
  }

  public String listItems(){
    var stringBuilder = new StringBuilder();
    if (this.isEmpty()) {
      stringBuilder.append("The cart is empty.");
    } else {
      for (var item : this) {
        stringBuilder.append(String.format("Name: %s | Value: %s", item.getName(),
            item.getValue()));
      }
    }
    return stringBuilder.toString();
  }

  private void verifyIfHasItemType(Item item) {
    if(this.contains(item)) {
      throw new FlowException("Cart already contains this item!");
    }
  }

  private void checkIfCanAddMoreItens() {
    if (this.size() >= 3) {
      throw new FlowException("The cart is full!");
    }
  }
}
