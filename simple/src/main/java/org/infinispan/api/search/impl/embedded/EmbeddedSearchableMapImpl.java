package org.infinispan.api.search.impl.embedded;

import java.util.HashMap;
import java.util.Map;

import org.infinispan.api.search.SearchableMap;
import org.infinispan.query.dsl.QueryFactory;
import org.infinispan.query.dsl.embedded.impl.EmbeddedQueryFactory;

public class EmbeddedSearchableMapImpl<K, V> implements SearchableMap<K, V> {
   private Map<K, V> values = new HashMap<>();

   @Override
   public void put(K key, V value) {
      values.put(key, value);
   }

   @Override
   public QueryFactory getQueryFactory() {
      return new EmbeddedQueryFactory(null);
   }
}
