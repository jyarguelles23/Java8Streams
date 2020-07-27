package Examples;


import java.util.Arrays;
import java.util.function.Predicate;
import org.junit.Test;

public class FindAnyFindFirst {

  final Predicate<Integer> numbersLessThan10 = n -> n > 5 && n < 10;
  //ctrl+alt+v paar sacar un predicado de una lambda
  final Predicate<Integer> integerPredicate = n -> n > 12;
  @Test
  public void findAny() throws Exception {
    Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    Integer a = Arrays.stream(numbers)
             .filter(integerPredicate)
             .findAny()
             .orElse(-1);
    //si no uso el or else tengo q poner .get
    System.out.println(a);
  }

  @Test
  public void findFirst() throws Exception {
    Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    Integer a = Arrays.stream(numbers)
            .filter(numbersLessThan10)
            .findFirst()
            .orElse(-1);
    //si no uso el or else tengo q poner .get
    System.out.println(a);
  }
}

