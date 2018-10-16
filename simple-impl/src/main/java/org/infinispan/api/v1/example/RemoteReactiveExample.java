//package org.infinispan.api.v1.example;
//
//import java.util.Random;
//
//import org.infinispan.api.Infinispan;
//import org.infinispan.api.cache.v1.MapConfig;
//import org.infinispan.api.cache.v1.RemoteMap;
//import org.infinispan.api.cache.v1.RemoteMapApi;
//import org.reactivestreams.Subscriber;
//import org.reactivestreams.Subscription;
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
//public class RemoteReactiveExample {
//
//   public static void main(String[] args){
//
//      System.out.println("---------------------------");
//      System.out.println("  Remote reactive example  ");
//      System.out.println("---------------------------");
//
//
//      RemoteMap<Integer, String> remoteCache = Infinispan.get(RemoteMapApi.instance(), new MapConfig("foobar-cache"));
//
//      new Random().ints(1000, 1, 1000)
//            .forEach(num -> remoteCache.put(num, String.valueOf(num)));
//
//      remoteCache.size().whenComplete((size,ex) -> System.out.println(size));
//
//      class PrintSubscriber<T> implements Subscriber<T> {
//
//         @Override
//         public void onSubscribe(Subscription subscription) {
//            System.out.println("On subscribe");
//         }
//
//         @Override
//         public void onNext(T t) {
//            System.out.println("On next " + t);
//         }
//
//         @Override
//         public void onError(Throwable t) {
//            System.out.println("oops");
//         }
//
//         @Override
//         public void onComplete() {
//            System.out.println("end");
//         }
//      }
//
//      System.out.println("---------------------------");
//      System.out.println("          getKeys          ");
//      System.out.println("---------------------------");
//      remoteCache.getKeys().subscribe(new PrintSubscriber<>());
//
//      System.out.println("---------------------------");
//      System.out.println("         getValues         ");
//      System.out.println("---------------------------");
//      remoteCache.getValues().subscribe(new PrintSubscriber<>());
//
//   }
//
//}
