package org.infinispan.example;

import org.infinispan.api.Infinispan;
import org.infinispan.api.map.v1.ApiCache;
import org.infinispan.api.map.v1.Cache;
import org.infinispan.api.map.v1.CacheConfig;

/**
 * With this :
 *
 *  - Versioning is on packaging (v1, v2 etc)
 *  - We have different API for Remote, Embedded, Async, Rx etc
 *
 * Pros :
 *  - Very modular, we pick up APIs
 *  - Easy to change and evolve without breaking any compatibility
 *
 * Cons :
 *  - Discovery of API
 *  - Too much API instead of methods (vs having a single entry point)
 */
public class ExampleModularity {

   public static void main(String[] args){

      Cache<String, String> foobarCache = Infinispan.get(ApiCache.instance(), new CacheConfig("foobar-cache"));

      foobarCache.put("foo", "bar");
      System.out.println(foobarCache.getName());
      System.out.println(foobarCache.get("foo"));
      System.out.println(foobarCache.getClass());

   }

}
