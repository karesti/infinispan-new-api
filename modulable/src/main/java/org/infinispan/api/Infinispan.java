package org.infinispan.api;

import java.util.ServiceLoader;
import java.util.function.Function;

public class Infinispan {

   public static <A, C> A get(ManagementApi<A> api) {
      final Class<Function<String, A>> factory = api.classApiWithNameConfig();
      final ServiceLoader<Function<String, A>> svcLoader = ServiceLoader.load(factory);
      return svcLoader.iterator().next().apply("");
   }

   public static <A, C> A get(Api<A, C> api, C cfg) {
      final Class<Function<C, A>> factory = api.classApi();
      final ServiceLoader<Function<C, A>> svcLoader = ServiceLoader.load(factory);
      return svcLoader.iterator().next().apply(cfg);
   }

   public static <A, C> A get(Api<A, C> api, String name) {
      final Class<Function<String, A>> factory = api.classApiWithNameConfig();
      final ServiceLoader<Function<String, A>> svcLoader = ServiceLoader.load(factory);
      return svcLoader.iterator().next().apply(name);
   }
}
