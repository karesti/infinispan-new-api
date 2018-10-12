package org.infinispan.api.transactions.impl.embedded;

import org.infinispan.api.transactions.InfinispanTransactionManager;
import org.infinispan.api.transactions.TransactionalMap;

public class EmbeddedInfinispanTransactionManager implements InfinispanTransactionManager {

   public <K, V> TransactionalMap<K, V> getOrCreate(String name) {
      return new EmbeddedTransactionalMap();
   }

   public void begin() {
      System.out.println("begin");
   }

   public void commit() {
      System.out.println("commit");
   }

   public void rollback() {
      System.out.println("rollback");
   }
}
