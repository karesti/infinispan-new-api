package org.infinispan.api.counter;

public class StrongCounterConfig {
   private final String name;
   private final int initialValue;

   public StrongCounterConfig(String name) {
      this.name = name;
      this.initialValue = 0;
   }
}
