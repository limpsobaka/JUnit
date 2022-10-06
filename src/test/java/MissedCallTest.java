import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MissedCallTest {
  Contact contact;
  PhoneBook phoneBook;

  @BeforeEach
  public void initEachTest() {
    contact = new Contact("Petya", 79106549876l);
    phoneBook = new PhoneBook();
    phoneBook.addGroup("Work");
    phoneBook.addContact("Work", contact);
  }

  @AfterEach
  public void afterEachTest() {
    MissedCalls.missedCalls = new HashMap<>();
  }

  @Test
  public void testAddCall() {
    //assert
    Map<LocalDateTime, Long> expected = new TreeMap<>();
    expected.put(LocalDateTime.of(2022, 05, 15, 12, 15, 33), 79159645231l);

    //act
    MissedCalls.addCall(LocalDateTime.of(2022, 05, 15, 12, 15, 33), 79159645231l);
    Map<LocalDateTime, Long> result = MissedCalls.missedCalls;

    //assert
    assertEquals(expected, result);
  }

  @Test
  public void testGetMissedCalls() {
    //assert
    PrintStream save_out = System.out;
    final ByteArrayOutputStream out = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out));

    String expected = "12.06.2022 12:15:24 - Petya\r\n";
    MissedCalls.addCall(LocalDateTime.of(2022, 06, 12, 12, 15, 24), 79106549876l);

    //act
    MissedCalls.getMissedCalls(phoneBook);

    //assert
    assertEquals(expected, out.toString());
    System.setOut(save_out);
  }
}