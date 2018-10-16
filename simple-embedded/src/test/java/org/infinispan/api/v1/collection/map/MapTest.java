package org.infinispan.api.v1.collection.map;

import java.util.concurrent.CompletionStage;

import org.infinispan.api.Infinispan;
import org.junit.jupiter.api.Test;

public class MapTest {

   @Test
   public void embedded_simple() {
      ReactiveMap<Integer, String> numbers = Infinispan.get(ReactiveMapApi.instance(), "numbers");
   }

   @Test
   public void embedded_reactive() {
      ReactiveMap<Integer, String> numbers = Infinispan.get(ReactiveMapApi.instance(), "numbers");

      CompletionStage<Long> count = numbers.publisher()
            .filter(e -> e.getKey() > 10)
            .map(e -> e.getKey() + "-" + e.getValue())
            .count();

      count.whenComplete((c, ex) -> System.out.println(c));
   }
}