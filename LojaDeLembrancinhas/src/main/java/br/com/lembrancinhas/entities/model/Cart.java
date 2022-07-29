package br.com.lembrancinhas.entities.model;

import br.com.lembrancinhas.entities.error.FlowException;
import java.util.ArrayList;
import java.util.Collection;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Cart extends ArrayList<Item> {

  @Override
  public boolean add(Item item) {
    verifyIfHasItemType(item);
    checkIfReceivedListHasMoreThanThreeItems();
    return super.add(item);
  }

  @Override
  public void add(int index, Item element) {
    verifyIfHasItemType(element);
    checkIfReceivedListHasMoreThanThreeItems();
    super.add(index, element);
  }

  public Cart() {
  }

  public Cart(Collection<? extends Item> items) {
    super(items);
    try {
      checkIfReceivedListHasMoreThanThreeItems(items);
    } catch (FlowException flowException) {
      log.error("Can not create a full cart. The cart is empty.");
      this.removeAll(items);
    }
    if (items.size() > 0) {
      items.forEach(item -> {
        var itemQuantity = 0;
        for (Item value : this) {
          if (value == item) {
            itemQuantity++;
          }
        }
        if (itemQuantity > 1) {
          log.error("Invalid collection received, it can not contains two or more items of the same"
              + " type. Now the cart is empty.");
          this.removeAll(items);
        }
      });
    } else {
      this.removeAll(items);
    }
  }

  @Override
  public boolean remove(Object o) {
    if (this.isEmpty()) {
      log.error("You can not remove items when the cart is empty.");
      return false;
    } else {
      return super.remove(o);
    }
  }

  private void verifyIfHasItemType(Item item){
    if (this.contains(item)) {
      throw new FlowException("Cart already contains this item!");
    }
  }

  private void checkIfReceivedListHasMoreThanThreeItems(){
    if (this.size() >= 3) {
      throw new FlowException("The cart is full!");
    }
  }

  private void checkIfReceivedListHasMoreThanThreeItems(Collection<? extends Item> items){
    if (items.size() > 3) {
      throw new FlowException("The cart is full!");
    }
  }
}
