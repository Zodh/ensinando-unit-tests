package br.com.lembrancinhas.entities.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import br.com.lembrancinhas.entities.error.FlowException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class CartTest {

  @Nested
  class AddItemInAnExistingCart {

    @Test
    @DisplayName("Should not add an item in the cart when cart is full (max items is 3).")
    void shouldNotAddItemInTheCart() {
      // arrange
      var cart = new Cart();

      var bone = new Item("Bone", new BigDecimal("30.00"));
      var xicara = new Item("Xicara", new BigDecimal("9.90"));
      var chaveiro = new Item("Chaveiro de time", new BigDecimal("14.99"));

      var alianca = new Item("Alianca", new BigDecimal("349.99"));

      // act
      cart.add(bone);
      cart.add(xicara);
      cart.add(chaveiro);

      // assert
      var flowException = assertThrows(FlowException.class, () -> cart.add(alianca));
      assertThat(cart).hasSize(3);
      assertThat(flowException.getMessage()).isEqualTo("The cart is full!");
    }

    @Test
    @DisplayName("Should not place an item in the cart when cart is full (max items is 3).")
    void shouldNotPlaceAnItemInAFullCart() {
      // arrange
      var cart = new Cart();

      var bone = new Item("Bone", new BigDecimal("30.00"));
      var xicara = new Item("Xicara", new BigDecimal("9.90"));
      var chaveiro = new Item("Chaveiro de time", new BigDecimal("14.99"));

      var alianca = new Item("Alianca", new BigDecimal("349.99"));

      // act
      cart.add(0, bone);
      cart.add(1, xicara);
      cart.add(2, chaveiro);

      // assert
      var flowException = assertThrows(FlowException.class, () -> cart.add(3, alianca));
      assertThat(cart).hasSize(3);
      assertThat(flowException.getMessage()).isEqualTo("The cart is full!");
    }

    @Test
    @DisplayName("Should add an item in the cart when we have the same item")
    void shouldNotAddAnItemRepeatedInAFullCart() {
      // arrange
      var cart = new Cart();
      var alianca = new Item("Alianca", new BigDecimal("349.99"));

      // act
      cart.add(alianca);

      // assert
      var flowException = assertThrows(FlowException.class, () -> cart.add(alianca));
      assertThat(cart).hasSize(1);
      assertThat(flowException.getMessage()).isEqualTo("Cart already contains this item!");
    }

    @Test
    @DisplayName("Should add item in the cart")
    void shouldAddItemInTheCart(){
      // arrange
      var item = new Item("Chaveiro de time", new BigDecimal("14.99"));
      var cart = new Cart();

      // act
      cart.add(item);

      // assert
      assertThat(cart.get(0)).isEqualTo(item);
    }

  }

  @Nested
  class RemoveItemFromACart {

    @Test
    @DisplayName("Can not remove an item from an empty cart")
    void shouldNotRemoveItemWhenItDoesNotExists(){
      // arrange
      var item = new Item("Chaveiro de time", new BigDecimal("14.99"));
      var cart = new Cart();

      // act
      var result = cart.remove(item);

      // assert
      assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Should remove an item from the cart")
    void shouldRemoveItem() {
      // arrange
      var item = new Item("Chaveiro de time", new BigDecimal("14.99"));
      var cart = new Cart();
      cart.add(item);

      // act
      var result = cart.remove(item);

      // assert
      assertThat(result).isTrue();
    }

  }

  @Nested
  class BuildCartFromConstructor {

    @Test
    @DisplayName("Should create a cart by receiving an item list")
    void shouldCreateACart() {
      // arrange
      var bone = new Item("Bone", new BigDecimal("30.00"));
      var xicara = new Item("Xicara", new BigDecimal("9.90"));
      var chaveiro = new Item("Chaveiro de time", new BigDecimal("14.99"));
      var items = List.of(bone, xicara, chaveiro);

      // act
      var result = new Cart(items);

      // assert
      assertThat(result).hasSize(3);
    }

    @Test
    @DisplayName("Should create an empty cart because received list is greater than three")
    void shouldCreateAnEmptyCartWhenReceiveAListWithMoreThanThreeItems(){
      // arrange
      var bone = new Item("Bone", new BigDecimal("30.00"));
      var xicara = new Item("Xicara", new BigDecimal("9.90"));
      var chaveiro = new Item("Chaveiro de time", new BigDecimal("14.99"));
      var woodShip = new Item("Wood Ship", new BigDecimal("49.99"));
      var items = List.of(bone, xicara, chaveiro, woodShip);

      // act and assert
      assertThat(new Cart(items)).isEmpty();
    }

    @Test
    @DisplayName("Should create an empty cart when receive repeated items")
    void shouldCreateAnEmptyCartWhenReceiveRepeatedItems(){
      // arrange
      var mouse = new Item("Mouse", new BigDecimal("19.99"));
      var items = List.of(mouse, mouse);

      // act and assert
      assertThat(new Cart(items)).isEmpty();
    }

    @Test
    @DisplayName("When cart constructor receives an empty list then return an empty cart")
    void shouldReturnAnEmptyCartWhenReceivesAnEmptyList(){
      // arrange
      var items = new ArrayList<Item>();

      // act
      var result = new Cart(items);

      // assert
      assertThat(result).isEmpty();
    }

  }

  @Nested
  class DoesNotLetTheValueBeGreaterThanTheBase{

    @Test
    void mustSetValueWhenValueIsGreater(){

    }
    // arrange

    //act

    //assert
  }

}
