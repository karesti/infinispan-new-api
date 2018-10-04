package org.infinispan.api.collection.impl.embedded.map.impl.embedded;

import java.util.HashMap;
import java.util.Map;

import org.infinispan.api.collection.map.InfinispanMap;

public class EmbeddedCache<K, V> implements InfinispanMap<K, V> {

   private Map<K, V> map = new HashMap();

   public void put(K key, V value) {
      map.put(key, value);
   }

   public V get(K key) {
      return map.get(key);
   }
}
