package org.infinispan.api.collection;

import org.infinispan.api.collection.impl.embedded.EmbeddedInfinispan;
import org.infinispan.api.collection.impl.remote.RemoteInfinispan;

public final class InfinispanCollectionsAccess {

   public static InfinispanCollectionManagement getInfinispanLocal() {
      return new EmbeddedInfinispan();
   }

   public static InfinispanCollectionManagement getInfinispanRemote() {
      return new RemoteInfinispan();
   }
}
