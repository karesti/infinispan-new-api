package org.infinispan.api.search;

import org.infinispan.query.dsl.QueryFactory;

public interface SearchableMap<K, V> {

   void put(K key, V value);

   QueryFactory getQueryFactory();
}
