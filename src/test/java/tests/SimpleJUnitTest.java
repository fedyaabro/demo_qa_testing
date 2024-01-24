package tests;

import org.junit.jupiter.api.*;

public class SimpleJUnitTest {
  
  @BeforeEach
  void beforeEach() {
    System.out.println("### @BeforeEach");
  }
  
  @BeforeAll
  static void beforeAll() {
    System.out.println("### @BeforeAll");
  }
  
  @AfterAll
  static void asterAll() {
    System.out.println("### @BeforeAll");
  }
  
  @AfterEach
  void afterEach() {
    System.out.println("### @AfterEach");
  }
  
  @Test
  void firstTest() {
    System.out.println("### firstTest");
    Assertions.assertTrue(3 * 2 == 6);
  }
  @Test
  void secondTest() {
    System.out.println("### secondTest");
    Assertions.assertTrue(3 + 3 == 6);
  }
}
