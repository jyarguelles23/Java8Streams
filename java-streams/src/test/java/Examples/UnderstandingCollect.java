package Examples;

import beans.Person;
import java.util.ArrayList;
import java.util.List;

import mockdata.MockData;
import org.junit.Test;

public class UnderstandingCollect {
  @Test
  public void understandingCollect() throws Exception {
    List<String> emails = MockData.getPeople()
        .stream()
        .map(Person::getEmail)
        .collect(
                ArrayList::new,
                ArrayList::add,
                ArrayList::addAll
        );

    emails.forEach(System.out::println);
  }
}
