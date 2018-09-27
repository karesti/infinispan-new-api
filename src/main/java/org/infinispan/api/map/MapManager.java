package org.infinispan.api.map;

import org.infinispan.api.ClusteredDataManager;
import org.infinispan.configuration.cache.Configuration;

public interface MapManager extends ClusteredDataManager {

   <K, V> InfinispanMap<K, V> getMap(String name);

   <K, V> InfinispanMap<K, V> getMap(Configuration configuration);
}
