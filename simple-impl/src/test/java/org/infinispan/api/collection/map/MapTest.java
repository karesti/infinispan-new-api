package org.infinispan.api.collection.map;

import java.util.Random;

import org.infinispan.api.v1.InfinispanAccess;
import org.infinispan.api.v1.collection.map.RemoteMap;
import org.infinispan.api.v1.collection.map.RemoteMapApi;
import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class MapTest {

   @Test
   public void remote_simple(){
      RemoteMap<Integer, String> numbers = InfinispanAccess.embedded().get(RemoteMapApi.instance(), "numbers");

      numbers.put(1, "one").whenComplete((r, ex) -> System.out.println("put done"));
      numbers.get(1).whenComplete((v, ex) -> System.out.println("value " + v));
   }

   @Test
   public void remote_reactive(){
      RemoteMap<Integer, String> numbers = InfinispanAccess.embedded().get(RemoteMapApi.instance(), "numbers");

      new Random().ints(1000, 1, 1000)
            .forEach(num -> numbers.put(num, String.valueOf(num)));

      numbers.size().whenComplete((size,ex) -> System.out.println(size));

      class PrintSubscriber<T> implements Subscriber<T> {

         @Override
         public void onSubscribe(Subscription subscription) {
            System.out.println("On subscribe");
         }

         @Override
         public void onNext(T t) {
            System.out.println("On next " + t);
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

      System.out.println("---------------------------");
      System.out.println("          getKeys          ");
      System.out.println("---------------------------");
      numbers.getKeys().subscribe(new PrintSubscriber<>());

      System.out.println("---------------------------");
      System.out.println("         getValues         ");
      System.out.println("---------------------------");
      numbers.getValues().subscribe(new PrintSubscriber<>());
   }
}
