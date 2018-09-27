package org.infinispan.api.search;

public interface QueryManager {

   <K, V> SearchableCache<K, V> getCache(String name);
}
