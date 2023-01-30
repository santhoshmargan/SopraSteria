package com.santhosh.functionalInterface;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionInterface {

  public static void main(String[] args) {

    // Function Interface has apply() method
    Function<Integer, Integer> addition = i -> i + 2;
    int additionResult = addition.apply(10);

    System.out.println(additionResult);

    FunctionInterfaceAddition(10, 20, addition);

    // Predicate Interface has test() method
    Predicate<Integer> result = i -> i > 10;
    System.out.println(result.test(9));

    // Supplier Interface has get() method
    Supplier<Double> supplierResult = () -> Math.random();
    System.out.println(supplierResult.get());

    // Consumer Interface has accept() method
    Consumer<Integer> consumerResult = (a) -> System.out.println(a);
    consumerResult.accept(10);
  }

  public static void FunctionInterfaceAddition(int a, int b, Function<Integer, Integer> function) {

    System.out.println(function.apply(10) + (a + b));

  }

}
