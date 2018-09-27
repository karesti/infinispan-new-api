package org.infinispan.api;

import org.infinispan.api.impl.embedded.EmbeddedInfinispan;

public final class InfinispanLocal {

   public static Infinispan getInfinispan() {
      return new EmbeddedInfinispan();
   }

}
