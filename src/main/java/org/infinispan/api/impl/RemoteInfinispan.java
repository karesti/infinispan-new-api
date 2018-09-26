package org.infinispan.api.impl;

import org.infinispan.api.CacheManager;
import org.infinispan.api.Infinispan;

public class RemoteInfinispan implements Infinispan {

   @Override
   public CacheManager getCacheManager() {
      return new RemoteCacheManager();
   }
}
