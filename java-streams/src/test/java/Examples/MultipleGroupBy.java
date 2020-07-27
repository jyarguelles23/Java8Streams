package Examples;


import beans.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.assertj.core.util.Lists;
import org.junit.Test;

public class MultipleGroupBy {
 // Hacer multiples group by?
  @Test
  public void simpleGrouping() throws Exception {
  List<Car> cars = MockData.getCars();
   Map<Integer,List<Car>> group =   cars.stream()
           .collect(Collectors.groupingBy(Car::getYear));
    group.forEach(
        (make, car) -> {
          System.out.println(make);
          car.forEach(System.out::println);
        });
  }

  @Test
  public void groupingAndCounting() throws Exception {
    ArrayList<String> names = Lists
        .newArrayList(
            "John",
            "John",
            "Mariam",
            "Alex",
            "Mohammado",
            "Mohammado",
            "Vincent",
            "Alex",
            "Alex"
        );

   Map<String,Long> count= names.stream()
            .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
    count.forEach((name,contar)-> System.out.println(name + " > "+ contar));
  }

}