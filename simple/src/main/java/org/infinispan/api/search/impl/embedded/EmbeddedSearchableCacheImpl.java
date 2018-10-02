package org.infinispan.api.search.impl.embedded;

import org.infinispan.api.data.map.impl.embedded.EmbeddedCache;
import org.infinispan.api.search.SearchManager;
import org.infinispan.api.search.SearchableCache;

public class EmbeddedSearchableCacheImpl<K, V> extends EmbeddedCache implements SearchableCache {

   @Override
   public SearchManager getSearchManager() {
      return new EmbeddedSearchManager();
   }
}
