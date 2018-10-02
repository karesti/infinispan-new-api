package org.infinispan.api;

import java.util.function.Function;

public interface Api<A> {

   // TODO What to use it for?
   Location location();

   <F extends Function<Object, A>> Class<F> classApi();

   enum Location {
      EMBEDDED,
      REMOTE,
      ANYWHERE;
   }

}
