import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhoneBookTest {
  Contact contact;
  PhoneBook phoneBook;

  @BeforeEach
  public void initEachTest() {
    contact = new Contact("Petya", 79106549876l);
    phoneBook = new PhoneBook();
  }

  @Test
  public void testAddGroup() {
    //assert
    Map<String, List<Contact>> expected = new HashMap<>();
    expected.put("Work", new ArrayList<>());

    //act
    phoneBook.addGroup("Work");
    Map<String, List<Contact>> result = phoneBook.groups;

    //assert
    assertEquals(expected, result);
  }

  @Test
  public void testAddContact() {
    //assert
    Map<String, List<Contact>> expected = new HashMap<>();
    expected.put("Work", new ArrayList<>());
    expected.get("Work").add(contact);

    phoneBook.addGroup("Work");

    //act
    phoneBook.addContact("Work", contact);
    Map<String, List<Contact>> result = phoneBook.groups;

    //assert
    assertEquals(expected, result);
  }

  @Test
  public void testFindContactByGroup() {
    //assert
    List<Contact> expected = new ArrayList<>();
    expected.add(contact);
    phoneBook.addGroup("Work");
    phoneBook.addContact("Work", contact);

    //act
    List<Contact> result = phoneBook.findContactByGroup("Work");

    //assert
    assertEquals(expected, result);
  }

  @Test
  public void testFindContactByNumber() {
    //assert
    String expected = "Petya";
    phoneBook.addGroup("Work");
    phoneBook.addContact("Work", contact);

    //act
    String result = phoneBook.findContactByNumber(79106549876l);

    //assert
    assertEquals(expected, result);
  }

  @Test
  public void testGetGroups() {
    //assert
    Map<String, List<Contact>> expected = new HashMap<>();
    expected.put("Work", new ArrayList<>());
    expected.get("Work").add(contact);

    phoneBook.addGroup("Work");
    phoneBook.addContact("Work", contact);

    //act
    Map<String, List<Contact>> result = phoneBook.getGroups();

    //assert
    assertEquals(expected, result);
  }
}