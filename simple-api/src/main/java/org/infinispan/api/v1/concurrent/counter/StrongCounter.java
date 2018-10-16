package org.infinispan.api.v1.concurrent.counter;

import java.util.concurrent.CompletionStage;
import java.util.function.Function;

public interface StrongCounter {

   CompletionStage<Integer> addAndGet(int increment);

   SyncStrongCounter getSync();

   interface Factory extends Function<CounterConfiguration, StrongCounter> {}
   interface ClientFactory extends Function<CounterConfiguration, StrongCounter> {}

}
