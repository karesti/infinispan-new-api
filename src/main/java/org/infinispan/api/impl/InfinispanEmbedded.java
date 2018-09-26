package org.infinispan.api.impl;

import org.infinispan.api.Cache;
import org.infinispan.api.Infinispan;

public class InfinispanEmbedded<K,V> implements Infinispan {
   public Cache<K, V> getCache() {
      return new EmbeddedCache<>();
   }
}
