package org.infinispan.api.search;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

interface ContinuousQuerySubscriber<K, V> extends Subscriber<QueryEntry<K, V>> {

   void joining(K key, V value);

   void updated(K key, V value);

   void leaving(K key);

   @Override
   default void onSubscribe(Subscription subscription) {
      System.out.println("On subscribe");
   }

   @Override
   default void onNext(QueryEntry<K, V> entry) {
      if (entry.joining()) {
         joining(entry.key(), entry.value());
      } else if (entry.updated()) {
         updated(entry.key(), entry.value());
      } else if (entry.leaving()) {
         leaving(entry.key());
      }
   }

   @Override
   default void onError(Throwable t) {
      System.out.println("oops");
   }

   @Override
   default void onComplete() {
      System.out.println("end");
   }

}
