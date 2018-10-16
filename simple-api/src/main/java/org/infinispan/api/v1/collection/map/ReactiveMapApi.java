package org.infinispan.api.v1.collection.map;

import java.util.function.Function;

import org.infinispan.api.Api;

public class ReactiveMapApi<K,V> implements Api<ReactiveMap<K, V>, MapConfig> {
   private static final ReactiveMapApi INSTANCE = new ReactiveMapApi();

   private ReactiveMapApi() {
   }

   public static <K, V> ReactiveMapApi<K, V> instance() {
      return INSTANCE;
   }

   @Override
   public <F extends Function<MapConfig, ReactiveMap<K, V>>> Class<F> classApi() {
      return (Class) ReactiveMap.Factory.class;
   }

   @Override
   public <F extends Function<String, ReactiveMap<K, V>>> Class<F> classApiWithNameConfig() {
      return (Class) ReactiveMap.Factory.class;
   }

}
