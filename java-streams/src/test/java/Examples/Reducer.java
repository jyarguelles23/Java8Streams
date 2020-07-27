package Examples;


import java.util.Arrays;
import org.junit.Test;

public class Reducer {
//reduce combine all elements of the stream and then produces a single result
  @Test
  public void reduce() throws Exception {
    Integer[] integers = {1, 2, 3, 4, 99, 100, 121, 1302, 199};

    Integer reduce = Arrays.stream(integers)
                       .reduce(0, (a, b) -> a + b);
    System.out.println(reduce);

    Integer reduce2 = Arrays.stream(integers)
            .reduce(0, Integer::sum);
    System.out.println(reduce2);
  }


}

