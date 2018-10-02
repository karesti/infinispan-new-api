package org.infinispan.api.search;

public interface Search {

   <K, V> SearchableCache<K, V> getCache(String name);
}
