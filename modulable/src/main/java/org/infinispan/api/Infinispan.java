package org.infinispan.api;

import java.util.ServiceLoader;
import java.util.function.Function;

import org.infinispan.api.map.v1.ApiCache;
import org.infinispan.api.map.v1.Cache;
import org.infinispan.api.map.v1.CacheConfig;

public final class Infinispan {

   public static <A, C> A get(Api<A,C> api, C cfg) {
      final Class<Function<C, A>> factory = api.classApi();
      final ServiceLoader<Function<C, A>> svcLoader = ServiceLoader.load(factory);
      return svcLoader.iterator().next().apply(cfg);
   }
}
