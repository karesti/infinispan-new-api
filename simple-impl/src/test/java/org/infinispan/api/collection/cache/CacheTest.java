package org.infinispan.api.collection.cache;

import org.infinispan.api.collection.InfinispanCollectionManagement;
import org.infinispan.api.collection.InfinispanCollectionsAccess;
import org.junit.jupiter.api.Test;

public class CacheTest {

   @Test
   public void testEmbeddedAsyncTest(){
      InfinispanCollectionManagement infinispan = InfinispanCollectionsAccess.getInfinispanLocal();

      CacheManager cacheManager = infinispan.getCacheManager();
      Cache<String, String> cache = cacheManager.getOrCreate("numbers");
      cache.put("1", "one").whenComplete((r, ex) -> System.out.println("put done"));
      cache.get("k").whenComplete((v, ex) -> System.out.println("value " + v));
   }

   @Test
   public void testRemoteAsyncTest(){
      InfinispanCollectionManagement infinispan = InfinispanCollectionsAccess.getInfinispanRemote();

      CacheManager cacheManager = infinispan.getCacheManager();
      Cache<String, String> cache = cacheManager.getOrCreate("numbers");
      cache.put("1", "one").whenComplete((r, ex) -> System.out.println("put done"));
   }
}
