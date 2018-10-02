package org.infinispan.api.search;

public interface InfinispanSearch {
   <K, V> SearchableMap<K, V> getOrCreateMap(String people);
}
