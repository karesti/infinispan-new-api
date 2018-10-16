package org.infinispan.api.v1.concurrent.counter;

import java.util.concurrent.CompletionStage;

public interface StrongCounter {

   CompletionStage<Integer> addAndGet(int increment);

   SyncStrongCounter getSync();
}
