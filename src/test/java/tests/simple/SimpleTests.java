package tests.simple;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("simple")
public class SimpleTests {
  
  @Test
  void someTest(){
    assertTrue(true);
  }
}
