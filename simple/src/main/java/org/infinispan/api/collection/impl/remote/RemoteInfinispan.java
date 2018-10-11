package org.infinispan.api.collection.impl.remote;

import org.infinispan.api.collection.InfinispanCollectionManagement;
import org.infinispan.api.collection.cache.CacheManager;
import org.infinispan.api.collection.impl.remote.map.RemoteMapManager;
import org.infinispan.api.concurrent.InfinispanConcurrencyManagement;
import org.infinispan.api.concurrent.counter.CounterManager;
import org.infinispan.api.concurrent.counter.impl.remote.RemoteCounterManager;
import org.infinispan.api.concurrent.lock.ClusteredLockManager;

public class RemoteInfinispan implements InfinispanCollectionManagement, InfinispanConcurrencyManagement {

   @Override
   public CacheManager getCacheManager() {
      return new RemoteMapManager();
   }

   @Override
   public CounterManager getCounterManager() {
      return new RemoteCounterManager();
   }

   @Override
   public ClusteredLockManager getClusteredLockManager() {
      return null;
   }
}
