package org.infinispan.example;

import java.util.Random;
import java.util.concurrent.Flow;

import org.infinispan.api.Infinispan;
import org.infinispan.api.map.v1.CacheConfig;
import org.infinispan.api.map.v1.RemoteCache;
import org.infinispan.api.map.v1.RemoteCacheApi;

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
public class RemoteReactiveExample {

   public static void main(String[] args){

      System.out.println("---------------------------");
      System.out.println("  Remote reactive example  ");
      System.out.println("---------------------------");


      RemoteCache<Integer, String> remoteCache = Infinispan.get(RemoteCacheApi.instance(), new CacheConfig("foobar-cache"));

      new Random().ints(1000, 1, 1000)
            .forEach(num -> remoteCache.put(num, String.valueOf(num)));

      remoteCache.size().whenComplete((size,ex) -> System.out.println(size));

      class PrintSubscriber implements Flow.Subscriber<String> {

         private Flow.Subscription subscription;

         @Override
         public void onSubscribe(Flow.Subscription subscription) {
            this.subscription = subscription;
            this.subscription.request(1);
         }

         @Override
         public void onNext(String key) {
            System.out.println(key);
            this.subscription.request(1);
         }

         @Override
         public void onError(Throwable t) {
            System.out.println("oops");
         }

         @Override
         public void onComplete() {
            System.out.println("end");
         }
      }

      remoteCache.getValues().subscribe(new PrintSubscriber());

   }

}
