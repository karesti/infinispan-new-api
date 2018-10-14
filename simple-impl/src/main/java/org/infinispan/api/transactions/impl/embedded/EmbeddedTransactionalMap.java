package org.infinispan.api.transactions.impl.embedded;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import org.infinispan.api.transactions.TransactionalMap;

public class EmbeddedTransactionalMap<K,V> implements TransactionalMap<K, V> {

   public CompletionStage<Void> put(K key, V value) {
      return CompletableFuture.completedFuture(null);
   }
}
