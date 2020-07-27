package Examples;


import static org.assertj.core.api.Assertions.assertThat;

import beans.Car;

import java.math.BigDecimal;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;

import mockdata.MockData;
import org.junit.Test;

public class StatisticsAll {

  final Predicate<Car> yellow = car -> car.getColor().equalsIgnoreCase("yellow");

  @Test
  public void count() throws Exception {
    long count=MockData.getPeople()
            .stream()
            .filter(person -> person.getGender().equalsIgnoreCase("Female"))
            .count()
            ;

  }

  @Test
  public void min() throws Exception {
     List<Car> cars=MockData.getCars();

     double price=cars.stream()
             .filter(car -> car.getColor().equalsIgnoreCase("yellow"))
             .mapToDouble(Car::getPrice)
             .min()
             .getAsDouble();
     System.out.println(price);
  }

  @Test
  public void max() throws Exception {
    List<Car> cars=MockData.getCars();


    double price=cars.stream()
            .filter(yellow)
            .mapToDouble(Car::getPrice)
            .max()
            .getAsDouble();
    System.out.println(price);
  }


  @Test
  public void average() throws Exception {
    List<Car> cars = MockData.getCars();
     double avg= cars.stream()
              .filter(yellow)
              .mapToDouble(Car::getPrice)
              .average()
              .getAsDouble();
    System.out.println(avg);
  }

  @Test
  public void sum() throws Exception {
    List<Car> cars = MockData.getCars();
    double sum = cars.stream()
        .mapToDouble(Car::getPrice)
        .sum();
    BigDecimal bigDecimalSum = BigDecimal.valueOf(sum);
    System.out.println(sum);
    System.out.println(bigDecimalSum);

  }

  @Test
  public void statistics() throws Exception {
    List<Car> cars = MockData.getCars();
    DoubleSummaryStatistics statistics = cars.stream()
        .mapToDouble(Car::getPrice)
        .summaryStatistics();
    System.out.println(statistics);
    System.out.println(statistics.getAverage());
    System.out.println(statistics.getCount());
    System.out.println(statistics.getMax());
    System.out.println(statistics.getMin());
    System.out.println(statistics.getSum());
  }

}