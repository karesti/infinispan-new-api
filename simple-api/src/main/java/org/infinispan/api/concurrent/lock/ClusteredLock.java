package org.infinispan.api.concurrent.lock;

import java.util.concurrent.CompletionStage;
import java.util.concurrent.TimeUnit;

public interface ClusteredLock {

   CompletionStage<Void> lock();

   CompletionStage<Boolean> tryLock();

   CompletionStage<Boolean> tryLock(long time, TimeUnit unit);

   CompletionStage<Void> unlock();

   CompletionStage<Boolean> isLocked();

   CompletionStage<Boolean> isLockedByMe();
}
