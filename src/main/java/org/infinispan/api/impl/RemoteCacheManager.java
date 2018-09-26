package org.infinispan.api.impl;

import org.infinispan.api.Cache;
import org.infinispan.api.CacheManager;
import org.infinispan.configuration.cache.Configuration;

public class RemoteCacheManager implements CacheManager {

   @Override
   public Cache getCache() {
      return new RemoteCache();
   }

   @Override
   public Cache getCache(Configuration configuration) {
      return new RemoteCache(configuration);
   }
}
