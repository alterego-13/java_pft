package ru.stqa.pft.sandbox;

import org.testng.annotations.Test;

/**
 * Created by Андрей on 20.11.2019.
 */
public class SquareTests {
@Test
  public void testArea(){
    Square s = new Square(5);
    assert s.area()==25;
  }
}
