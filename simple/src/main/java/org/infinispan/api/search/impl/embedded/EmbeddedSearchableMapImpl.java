package org.infinispan.api.search.impl.embedded;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.infinispan.api.search.SearchableMap;
import org.infinispan.query.dsl.QueryFactory;
import org.infinispan.query.dsl.embedded.impl.EmbeddedQueryEngine;
import org.infinispan.query.dsl.embedded.impl.EmbeddedQueryFactory;

public class EmbeddedSearchableMapImpl<K, V> implements SearchableMap<K, V> {
   private Map<K, V> values = new HashMap<>();

   @Override
   public void put(K key, V value) {
      values.put(key, value);
   }

   @Override
   public List<V> list(String ickleQuery) {
      List<V> searchResult = new ArrayList<>();
      searchResult.addAll(values.values());
      return searchResult;
   }

   @Override
   public QueryFactory getQueryFactory() {
      return new EmbeddedQueryFactory(new EmbeddedQueryEngine(null, false));
   }
}
