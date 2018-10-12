package org.infinispan.api.concurrent;

import org.infinispan.api.collection.impl.embedded.EmbeddedInfinispan;
import org.infinispan.api.collection.impl.remote.RemoteInfinispan;

public final class InfinispanConcurrencyAccess {

   public static InfinispanConcurrencyManagement getLocalAccess() {
      return new EmbeddedInfinispan();
   }

   public static InfinispanConcurrencyManagement getRemoteAcess() {
      return new RemoteInfinispan();
   }
}
