package org.infinispan.api.search;

public interface Search {

   <K, V> SearchableMap<K, V> getOrCreate(String name);
}
