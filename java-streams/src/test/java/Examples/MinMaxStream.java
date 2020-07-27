package Examples;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.common.collect.ImmutableList;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

public class MinMaxStream{

  @Test
  public void min() throws Exception {
    final List<Integer> numbers = ImmutableList.of(1, 2, 3, 100, 23, 93, 99);
      Integer min = numbers.stream()
              .min((num1, num2) -> num1 > num2  ? 1 : -1)
              .get();
      assertThat(min).isEqualTo(1);
    System.out.println(min);

    Integer min2 = numbers.stream()
            .min(Comparator.naturalOrder())
            .get();
    assertThat(min2).isEqualTo(1);
    System.out.println(min2);
  }

  @Test
  public void max() throws Exception {
    final List<Integer> numbers = ImmutableList.of(1, 2, 3, 100, 23, 93, 99);
    Integer min2 = numbers.stream()
            .max(Comparator.naturalOrder())
            .get();
   // assertThat(min2).isEqualTo(1);
    System.out.println(min2);
  }
}
//Ver como usar el min y el max en Objetos