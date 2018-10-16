//package org.infinispan.api.v1.example;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Set;
//
//import org.infinispan.api.Infinispan;
//import org.infinispan.api.cache.v1.MapConfig;
//import org.infinispan.api.cache.v1.RemoteMap;
//import org.infinispan.api.cache.v1.RemoteMapApi;
//import org.infinispan.api.cache.v1.events.ClientEvent;
//import org.infinispan.api.cache.v1.events.SafeClosable;
//
///**
// * With this :
// * <p>
// * - Versioning is on packaging (v1, v2 etc) - We have different API for Remote, Embedded, Async, Rx etc
// * <p>
// * Pros : - Very modular, we pick up APIs - Easy to change and evolve without breaking any compatibility
// * <p>
// * Cons : - Discovery of API - Too much API instead of methods (vs having a single entry point)
// */
//public class RemoteListenerExample {
//
//   public static void main(String[] args) {
//
//      System.out.println("---------------------------");
//      System.out.println("  Remote listener example  ");
//      System.out.println("---------------------------");
//
//
//      RemoteMap<Integer, String> remoteCache = Infinispan.get(RemoteMapApi.instance(), new MapConfig("foobar-cache"));
//
//      // Give me all
//      SafeClosable subscribe = remoteCache.getEventPublisher().subscribe(e -> {
//         System.out.println(e);
//      });
//
//      subscribe.close();
//
//      // by event
//      SafeClosable eventSusbcription = remoteCache.getEventPublisher()
//            .filterByEventType(Set.of(ClientEvent.Type.CREATED))
//            .subscribe(e -> System.out.println("toto"));
//      eventSusbcription.close();
//
//      List<Integer> nearCache = new ArrayList<>();
//
//      remoteCache.getEventPublisher().onFailover(() -> nearCache.clear())
//            .filterByEventType(Set.of(ClientEvent.Type.CREATED))
//            .includeCurrentState()
//            .subscribe(e -> {
//               nearCache.add(e.getKey());
//            });
//
//      remoteCache.getEventPublisher().onFailover(() -> nearCache.clear())
//            .filterByEventType(Set.of(ClientEvent.Type.MODIFIED, ClientEvent.Type.REMOVED))
//            .subscribe(e -> {
//         nearCache.remove(e.getKey());
//      });
//
//
//   }
//
//}
