package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Андрей on 09.12.2019.
 */
public class PrimeTests {

  @Test
  public void testPrime(){
    Assert.assertTrue(Primes.isPrime(Integer.MAX_VALUE));
  }


    @Test
    public void testNonPrimes(){
    Assert.assertFalse(Primes.isPrime(Integer.MAX_VALUE-2));
  }
  }
