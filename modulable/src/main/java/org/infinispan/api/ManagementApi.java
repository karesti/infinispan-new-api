package org.infinispan.api;

import java.util.function.Function;

public interface ManagementApi<A> {

   <F extends Function<String, A>> Class<F> classApiWithNameConfig();

}
