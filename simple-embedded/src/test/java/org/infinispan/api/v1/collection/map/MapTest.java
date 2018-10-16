package org.infinispan.api.v1.collection.map;

import org.infinispan.api.Infinispan;
import org.junit.jupiter.api.Test;

public class MapTest {

   @Test
   public void embedded_simple() {
      ReactiveMap<Integer, String> numbers = Infinispan.get(ReactiveMapApi.instance(), "numbers");

   }
}