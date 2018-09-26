package org.infinispan.api;

import org.infinispan.api.impl.RemoteInfinispan;

public final class RemoteInfinispanManager {

   public static Infinispan getInfinispan() {
      return new RemoteInfinispan();
   }
}

