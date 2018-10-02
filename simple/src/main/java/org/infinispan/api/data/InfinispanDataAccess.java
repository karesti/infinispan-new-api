package org.infinispan.api.data;

import org.infinispan.api.data.impl.embedded.EmbeddedInfinispan;
import org.infinispan.api.data.impl.remote.RemoteInfinispan;

public final class InfinispanDataAccess {

   public static InfinispanData getInfinispanLocal() {
      return new EmbeddedInfinispan();
   }

   public static InfinispanData getInfinispanRemote() {
      return new RemoteInfinispan();
   }
}
