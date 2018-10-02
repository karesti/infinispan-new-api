package org.infinispan.api.data.counter;

import java.util.concurrent.CompletableFuture;

public interface StrongCounter {

   CompletableFuture<Integer> addAndGet(int increment);
}
