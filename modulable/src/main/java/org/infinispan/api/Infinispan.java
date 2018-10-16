package org.infinispan.api;

import java.util.ServiceLoader;
import java.util.function.Function;

public interface Infinispan {

   default <A, C> A get(Api<A, C> api, C cfg) {
      final Class<Function<C, A>> factory = api.classApi();
      final ServiceLoader<Function<C, A>> svcLoader = ServiceLoader.load(factory);
      return svcLoader.iterator().next().apply(cfg);
   }

   default <A, C> A get(Api<A, C> api, String name) {
      final Class<Function<String, A>> factory = api.classApiWithNameConfig();
      final ServiceLoader<Function<String, A>> svcLoader = ServiceLoader.load(factory);
      return svcLoader.iterator().next().apply(name);
   }
}
