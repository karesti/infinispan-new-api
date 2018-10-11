package org.infinispan.api.map.v1;

import java.util.function.Function;

import org.infinispan.api.Api;

public class RemoteCacheApi<K,V> implements Api<RemoteCache<K, V>, CacheConfig> {
   private static final RemoteCacheApi INSTANCE = new RemoteCacheApi();

   private RemoteCacheApi() {
   }

   public static <K, V> RemoteCacheApi<K, V> instance() {
      return INSTANCE;
   }

   @Override
   public <F extends Function<CacheConfig, RemoteCache<K, V>>> Class<F> classApi() {
      return (Class) RemoteCache.Factory.class;
   }

}
