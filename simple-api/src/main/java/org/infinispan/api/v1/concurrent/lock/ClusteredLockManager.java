package org.infinispan.api.v1.concurrent.lock;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.function.Function;

public interface ClusteredLockManager {

    CompletionStage<Boolean> defineLock(String name);

    CompletionStage<Boolean> defineLock(String name, ClusteredLockConfiguration configuration);

    CompletionStage<ClusteredLock> get(String name);

    CompletionStage<ClusteredLockConfiguration> getConfiguration(String name);

    CompletionStage<Boolean> isDefined(String name);

    CompletableFuture<Boolean> remove(String name);

    CompletableFuture<Boolean> forceRelease(String name);

    interface Factory extends Function<String, ClusteredLockManager> {}

}

