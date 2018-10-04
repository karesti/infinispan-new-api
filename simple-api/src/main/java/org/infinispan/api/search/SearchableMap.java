package org.infinispan.api.search;

import java.util.List;

import org.infinispan.query.dsl.QueryFactory;

public interface SearchableMap<K, V> {

   void put(K key, V value);

   List<V> list(String ickleQuery);

   QueryFactory getQueryFactory();
}
