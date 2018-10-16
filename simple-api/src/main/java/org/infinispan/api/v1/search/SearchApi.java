package org.infinispan.api.v1.search;

import java.util.function.Function;

import org.infinispan.api.Api;
import org.infinispan.api.v1.collection.map.MapConfig;

public class SearchApi<K,V> implements Api<SearchableMap<K, V>, MapConfig> {
   private static final SearchApi INSTANCE = new SearchApi();

   private SearchApi() {
   }

   public static <K, V> SearchApi<K, V> instance() {
      return INSTANCE;
   }

   @Override
   public <F extends Function<MapConfig, SearchableMap<K, V>>> Class<F> classApi() {
      return (Class) SearchableMap.Factory.class;
   }

   @Override
   public <F extends Function<String, SearchableMap<K, V>>> Class<F> classApiWithNameConfig() {
      return (Class) SearchableMap.Factory.class;
   }

}