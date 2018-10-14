package org.infinispan.api.transactions;

import java.util.concurrent.CompletionStage;

public interface TransactionalMap<K, V> {
   CompletionStage<Void> put(K key, V value);
}