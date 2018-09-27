package org.infinispan.api.counter;

import java.util.concurrent.CompletableFuture;

public interface StrongCounter {

   CompletableFuture<Integer> addAndGet(int increment);
}
