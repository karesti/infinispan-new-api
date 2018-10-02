package org.infinispan.api.search.impl.embedded;

import org.infinispan.api.search.InfinispanSearch;
import org.infinispan.api.search.SearchableMap;

public class EmbeddedInfinispanSearch implements InfinispanSearch {

   @Override
   public <K, V> SearchableMap<K, V> getOrCreateMap(String people) {
      return new EmbeddedSearchableMapImpl<>();
   }
}
