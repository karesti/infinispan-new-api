package org.infinispan.api.v1.admistration;

import java.util.function.Function;

import org.infinispan.api.Api;
import org.infinispan.api.ManagementApi;
import org.infinispan.api.v1.collection.map.MapConfig;
import org.infinispan.api.v1.collection.map.ReactiveMap;

public class AdministrationApi<K,V> implements ManagementApi<Administration> {
   private static final AdministrationApi INSTANCE = new AdministrationApi();

   private AdministrationApi() {
   }

   public static <K, V> AdministrationApi<K, V> instance() {
      return INSTANCE;
   }


   @Override
   public <F extends Function<String, Administration>> Class<F> classApiWithNameConfig() {
      return (Class) Administration.Factory.class;
   }
}
