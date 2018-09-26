package org.infinispan.api;

import org.infinispan.api.impl.InfinispanEmbedded;

public final class InfinispanManager {

   public static Infinispan getInfinispan() {
      return new InfinispanEmbedded();
   }

}
