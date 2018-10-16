package org.infinispan.api.v1.collection.map;

import java.util.function.Function;

import org.infinispan.api.Api;

public class RemoteMapApi<K,V> implements Api<RemoteMap<K, V>, MapConfig> {
   private static final RemoteMapApi INSTANCE = new RemoteMapApi();

   private RemoteMapApi() {
   }

   public static <K, V> RemoteMapApi<K, V> instance() {
      return INSTANCE;
   }

   @Override
   public <F extends Function<MapConfig, RemoteMap<K, V>>> Class<F> classApi() {
      return (Class) RemoteMap.Factory.class;
   }

   @Override
   public <F extends Function<String, RemoteMap<K, V>>> Class<F> classApiWithNameConfig() {
      return (Class) RemoteMap.Factory.class;
   }

}
