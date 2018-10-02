package org.infinispan.api.transactions;


import org.infinispan.api.transactions.impl.embedded.EmbeddedInfinispanTransactionManager;

public final class InfinispanTransactionAccess {

   public static InfinispanTransactionManager getLocalTransactionManager() {
      return new EmbeddedInfinispanTransactionManager();
   }

   public static InfinispanTransactionManager getRemoteTransactionManager() {
      throw new UnsupportedOperationException("Remote search not implemented yet");
   }
}
