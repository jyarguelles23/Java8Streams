package Examples;

import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class JoiningStrings {

  @Test
  public void joiningStrings() throws Exception {
    List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");
    String concat="";
    for (String n : names){
      concat+=n+", " ;
    }
    System.out.println(concat.substring(0,concat.length()-2));
  }

  @Test
  public void joiningStringsWithStream() throws Exception {
    List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");
    String collect = names.stream()
            .map(String::toUpperCase)
            .collect(Collectors.joining(","));
    System.out.println(collect);
  }
}
