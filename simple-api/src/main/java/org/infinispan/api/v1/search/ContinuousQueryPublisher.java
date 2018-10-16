package org.infinispan.api.v1.search;

import org.reactivestreams.Publisher;

public interface ContinuousQueryPublisher<K, V> extends Publisher<QueryEntry<K,V>> {

}
