package org.infinispan.api.v1.transactions;

//import javax.transaction.TransactionManager;

public interface InfinispanTransactionManager {
   <K, V> TransactionalMap<K, V> getOrCreate(String name);

   void begin();

   void commit();

   void rollback();

   //TransactionManager unwrapTransactionManager();
}
