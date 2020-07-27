package Examples;


import static org.assertj.core.api.Assertions.assertThat;

import beans.Car;
import beans.Person;
import beans.PersonDTO;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class MultiplesFiltrosAverage {
//Buscar que son los predicados(predicate) evalua q una condicion sea true or false
//Como poner multiples filtros 
  @Test
  public void understandingFilter() throws Exception {
    ImmutableList<Car> cars = MockData.getCars();
    Predicate<Car> carPredicate = car -> car.getPrice() < 10000;
    List<Car> c= cars.stream()
                  .filter( carPredicate)
                  .collect(Collectors.toList());
     c.forEach(System.out::println);
  }

  @Test
  public void ourFirstMapping() throws Exception {
    // transform from one data type to another
    List<Person> people = MockData.getPeople();
       List<PersonDTO> dto =  people.stream()
               .filter(person -> person.getAge() < 7)
              .map(person -> {
                        PersonDTO p = new PersonDTO(person.getId(),person.getFirstName(),person.getAge());
                        return p;
              })
            .collect(Collectors.toList())
          ;
       dto.forEach(System.out::println);
//Best Way y metodo map static en el dto
    List<PersonDTO> dto2 =  people.stream()
            .filter(person -> person.getAge() < 7)
            .map(PersonDTO::map)
            .collect(Collectors.toList())
            ;
    dto2.forEach(System.out::println);

    //OtherWay
    Function<Person,PersonDTO> funct = person -> new PersonDTO(person.getId(),person.getFirstName(),person.getAge());
    List<PersonDTO> dto3 =  people.stream()
            .filter(person -> person.getAge() < 7)
            .map(funct)
            .collect(Collectors.toList())
            ;
    dto3.forEach(System.out::println);

  }

  @Test
  public void averageCarPrice() throws Exception {
    // calculate average of car prices
      ImmutableList<Car> cars = MockData.getCars();

      double avg=cars.stream()
              .mapToDouble(car -> car.getPrice())
              .average()
              .orElse(0);

    System.out.println(avg);
  }

  @Test
  public void test() throws Exception {

  }
}



