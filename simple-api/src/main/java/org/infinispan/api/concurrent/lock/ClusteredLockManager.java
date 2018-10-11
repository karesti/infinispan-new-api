package org.infinispan.api.concurrent.lock;

import java.util.concurrent.CompletionStage;

public interface ClusteredLockManager {

    CompletionStage<Void> defineLock(String name);

    CompletionStage<Boolean> isDefined(String name);

    ClusteredLock get(String name);

    CompletionStage<Boolean> remove(String name);

    CompletionStage<Boolean> forceRelease(String name);
}

