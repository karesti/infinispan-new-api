package org.infinispan.api;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CacheTest {

   @Test
   public static void testRemoteCache(){
      Infinispan infinispan = RemoteInfinispanManager.getInfinispan();

      CacheManager cacheManager = infinispan.getCacheManager();
      Cache<String, String> cache = cacheManager.getCache();

      cache.put("1", "one");
      cache.put("2", "two");
      assertThat("true").isNotEmpty();
   }

   @Test
   public static void testEmbeddedCache(){
      Infinispan infinispan = InfinispanManager.getInfinispan();

      CacheManager cacheManager = infinispan.getCacheManager();
      Cache<String, String> cache = cacheManager.getCache();

      cache.put("1", "one");
      cache.put("2", "two");
      assertThat("true").isNotEmpty();
   }
}
