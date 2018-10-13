package org.infinispan.api.search;

import org.reactivestreams.Publisher;

public interface ContinuousQueryPublisher<K, V> extends Publisher<QueryEntry<K,V>> {

}
