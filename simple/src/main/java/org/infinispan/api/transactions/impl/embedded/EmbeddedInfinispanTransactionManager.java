package org.infinispan.api.transactions.impl.embedded;

import javax.transaction.TransactionManager;

import org.infinispan.api.transactions.InfinispanTransactionManager;
import org.infinispan.api.transactions.TransactionalMap;

public class EmbeddedInfinispanTransactionManager implements InfinispanTransactionManager {

   @Override
   public <K, V> TransactionalMap getOrCreate(String name) {
      return new EmbeddedTransactionalMap();
   }

   @Override
   public void begin() {
      System.out.println("begin");
   }

   @Override
   public void commit() {
      System.out.println("commit");
   }

   @Override
   public void rollback() {
      System.out.println("rollback");
   }

   @Override
   public TransactionManager unwrapTransactionManager() {
      return null;
   }
}
