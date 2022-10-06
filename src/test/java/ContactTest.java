import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactTest {
  Contact contact;

  @BeforeEach
  public void initEachTest() {
    contact = new Contact("Petya", 79106549876l);
  }

  @Test
  public void testHashCode() {
    //assert
    int expected = 77005895;

    //act
    int result = contact.hashCode();

    //assert
    assertEquals(expected, result);
  }

  @Test
  public void testToString() {
    //assert
    String expected = "Petya - 79106549876";

    //act
    String result = contact.toString();

    //assert
    assertEquals(expected, result);

  }

  @Test
  public void testGetNumber() {
    //assert
    Long expected = 79106549876l;

    //act
    Long result = contact.getNumber();

    //assert
    assertEquals(expected, result);

  }

  @Test
  public void testGetName() {
    //assert
    String expected = "Petya";

    //act
    String result = contact.getName();

    //assert
    assertEquals(expected, result);
  }
}
