package org.infinispan.api.v1.concurrent.counter;

import java.util.function.Function;

import org.infinispan.api.Api;

public class StrongCounterApi implements Api<StrongCounter, CounterConfiguration> {
   private static final StrongCounterApi INSTANCE = new StrongCounterApi();

   private StrongCounterApi() {
   }

   public static StrongCounterApi instance() {
      return INSTANCE;
   }

   @Override
   public <F extends Function<CounterConfiguration, StrongCounter>> Class<F> classApi() {
      return (Class) StrongCounter.Factory.class;
   }

   @Override
   public <F extends Function<String, StrongCounter>> Class<F> classApiWithNameConfig() {
      return (Class) StrongCounter.Factory.class;
   }

}
