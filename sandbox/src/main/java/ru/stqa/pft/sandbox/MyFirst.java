package ru.stqa.pft.sandbox;

import java.awt.*;

/**
 * Created by Андрей on 20.11.2019.
 */
public class MyFirst {
  public static void main(String[] args) {
    hello("hello motherfuckers");
    hello("1");
    hello("2");

    Square s = new Square(5);
    System.out.println("площадь квадрата со стороной " + s.l + " = " + s.area());

    Rectangle r = new Rectangle(4, 6);
    System.out.println("площадь примоуг со стороной " + r.a + " и " + r.b + "= " + r.area());
  }

  public static void hello(String somebody) {
    System.out.println("  " + somebody);

  }

}
