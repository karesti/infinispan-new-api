package org.infinispan.api.v1.collection.map;

import java.util.Map;

import org.infinispan.api.v1.reactive.IPublisher;

public interface EmbeddedMap<K, V> extends ReactiveMap {

   IPublisher<Map.Entry<K, V>> publisher();
}
