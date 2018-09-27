package org.infinispan.api.search;

import org.infinispan.api.map.InfinispanMap;

public interface SearchableCache<K, V> extends InfinispanMap<K, V> {

   SearchManager getSearchManager();
}
