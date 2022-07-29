package br.com.lembrancinhas.entities.model;

import static org.assertj.core.api.Assertions.assertThat;

import br.com.lembrancinhas.entities.error.FlowException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ItemTest {

  @Nested
  class SetNameToItem {

    @DisplayName("Empty or null name should throw an exception")
    @ParameterizedTest
    @ValueSource(strings = {"", "                                                           "})
    void emptyNameShouldThrowsAnException(String value) {

      //arrange
      var item = new Item();

      //act and assert
      var flowException = Assertions.assertThrows(FlowException.class, () -> item.setName(value));
      assertThat(flowException.getMessage()).isEqualTo("Invalid name");
    }

    @DisplayName("null name should throw an exception")
    @ParameterizedTest
    @NullSource
    void nullNameShoudThrowsAnException(String value) {

      //arrange
      var item = new Item();

      //act and assert
      var flowException = Assertions.assertThrows(FlowException.class, () -> item.setName(value));
      assertThat(flowException.getMessage()).isEqualTo("Invalid name");
    }


    @Test
    @DisplayName("Name with more than 50 characters should throws an exception")
    void nameWithLenGreaterThanFiftyShouldThrowsAnException() {

      //arrange
      var item = new Item();

      //act and assert
      var flowException = Assertions.assertThrows(FlowException.class,
          () -> item.setName("s".repeat(51)));
      assertThat(flowException.getMessage()).isEqualTo(
          "A name can not have more than 50 characters");

    }

    @Test
    @DisplayName("Name with valid length is setted with success")
    void setNameWithValidLen() {

      //arrange
      var item = new Item();

      //act
      var name = "Gabriel";
      item.setName(name);

      //assert
      assertThat(item.getName()).isEqualTo(name);

    }


  }

}