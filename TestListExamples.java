import static org.junit.Assert.*;
import org.junit.*;
import java.util.Arrays;
import java.util.List;

class IsMoon implements StringChecker {
  public boolean checkString(String s) {
    return s.equalsIgnoreCase("moon");
  }
}

public class TestListExamples {


  @Test 
	public void testFilter() {
    List<String> input1 = Arrays.asList("a", "ab", "moon", "bcd");
    List<String> expected1 = Arrays.asList("moon");

    IsMoon contains = new IsMoon();

    List<String> output1 = ListExamples.filter(input1, contains);


    List<String> input2 = Arrays.asList("a", "b", "c");
    List<String> expected2 = Arrays.asList();

    List<String> output2 = ListExamples.filter(input2, contains);

    assertEquals(expected1, output1);
    assertEquals(expected2, output2);
  }

  public void testFilterEmpty() {
    List<String> input1 = Arrays.asList();

    List<String> expected1 = Arrays.asList();

    IsMoon contains = new IsMoon();


    List<String> output1 = ListExamples.filter(input1, contains);


    assertEquals(expected1, output1);
  }

  @Test(timeout = 500)
  public void testMergeRightEnd() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList("a", "d");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testMergeLeftEnd() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList("a", "d");
    List<String> merged = ListExamples.merge(right, left);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testMergeEmpty() {
    List<String> left = Arrays.asList();
    List<String> right = Arrays.asList();
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList();
    assertEquals(expected, merged);
  }
}
