package org.infinispan.api.v1.search;

public interface InfinispanSearch {
   <K, V> SearchableMap<K, V> getOrCreateMap(String people);
}
