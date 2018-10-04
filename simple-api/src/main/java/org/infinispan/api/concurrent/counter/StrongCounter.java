package org.infinispan.api.concurrent.counter;

public interface StrongCounter {

   int addAndGet(int increment);
}
