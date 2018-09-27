package org.infinispan.api;

import org.infinispan.api.impl.remote.RemoteInfinispan;

public final class InfinispanRemote {

   public static Infinispan getInfinispan() {
      return new RemoteInfinispan();
   }

}
