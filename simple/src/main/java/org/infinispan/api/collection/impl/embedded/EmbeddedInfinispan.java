package org.infinispan.api.collection.impl.embedded;

import org.infinispan.api.collection.InfinispanCollectionManagement;
import org.infinispan.api.collection.cache.CacheManager;
import org.infinispan.api.collection.impl.embedded.cache.EmbeddedMapManager;
import org.infinispan.api.concurrent.InfinispanConcurrencyManagement;
import org.infinispan.api.concurrent.counter.CounterManager;
import org.infinispan.api.concurrent.counter.impl.embedded.EmbeddedCounterManager;
import org.infinispan.api.concurrent.lock.ClusteredLockManager;

public class EmbeddedInfinispan implements InfinispanCollectionManagement, InfinispanConcurrencyManagement {

   @Override
   public CacheManager getCacheManager() {
      return new EmbeddedMapManager();
   }

   @Override
   public CounterManager getCounterManager() {
      return new EmbeddedCounterManager();
   }

   @Override
   public ClusteredLockManager getClusteredLockManager() {
      return null;
   }
}
