package org.infinispan.api;

import java.util.function.Function;

public interface Api<A, C> {

   <F extends Function<C, A>> Class<F> classApi();

}
