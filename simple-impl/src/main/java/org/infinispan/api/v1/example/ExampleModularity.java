//package org.infinispan.api.v1.example;
//
//import org.infinispan.api.Infinispan;
//import org.infinispan.api.cache.v1.Cache;
//import org.infinispan.api.cache.v1.CacheApi;
//import org.infinispan.api.cache.v1.MapConfig;
//import org.infinispan.api.cache.v1.RemoteMap;
//import org.infinispan.api.cache.v1.RemoteMapApi;
//
///**
// * With this :
// *
// *  - Versioning is on packaging (v1, v2 etc)
// *  - We have different API for Remote, Embedded, Async, Rx etc
// *
// * Pros :
// *  - Very modular, we pick up APIs
// *  - Easy to change and evolve without breaking any compatibility
// *
// * Cons :
// *  - Discovery of API
// *  - Too much API instead of methods (vs having a single entry point)
// */
//public class ExampleModularity {
//
//   public static void main(String[] args){
//
//      System.out.println("---------------------------");
//      System.out.println("     Embedded example      ");
//      System.out.println("---------------------------");
//      Cache<String, String> foobarCache = Infinispan.get(CacheApi.instance(), new MapConfig("foobar-cache"));
//
//      foobarCache.put("foo", "bar").whenComplete((nil, ex) -> System.out.println("put foo"));
//      foobarCache.get("foo").whenComplete((val, ex) -> System.out.println("get foo -> " + val));
//
//      System.out.println(foobarCache.getName());
//      System.out.println(foobarCache.getClass());
//
//      System.out.println("\n");
//
//      System.out.println("---------------------------");
//      System.out.println("      Remote example       ");
//      System.out.println("---------------------------");
//
//      RemoteMap<String, String> remoteCache = Infinispan.get(RemoteMapApi.instance(), new MapConfig("people"));
//      remoteCache.put("foo", "bar")
//            .whenComplete((nil, ex) -> System.out.println("put foo"));
//      remoteCache.get("foo")
//            .whenComplete((val, ex) -> System.out.println("get foo -> " + val));
//
//      System.out.println(remoteCache.getName());
//      System.out.println(remoteCache.getClass());
//
//   }
//
//}
