package org.infinispan.api.search;


import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public class ContinuousQueryPublisher<K, V> implements Publisher<QueryEntry<K,V>> {

   @Override
   public void subscribe(Subscriber<? super QueryEntry<K, V>> s) {
      // get the data!

      s.onNext(null);
   }
}
