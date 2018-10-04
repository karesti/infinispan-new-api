package org.infinispan.api.concurrent.counter;

import java.util.concurrent.CompletionStage;

public interface StrongCounterAsync {

   CompletionStage<Integer> addAndGet(int increment);
}
