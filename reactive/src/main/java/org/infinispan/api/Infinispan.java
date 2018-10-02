package org.infinispan.api;

import java.util.ServiceLoader;
import java.util.function.Function;

public final class Infinispan {

   public static <A> A get(Api<A> api, Object cfg) {
      final Class<Function<Object, A>> factory = api.classApi();
      final ServiceLoader<Function<Object, A>> svcLoader = ServiceLoader.load(factory);
      return svcLoader.iterator().next().apply(cfg);
   }


}
