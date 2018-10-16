package org.infinispan.api.v1;

import org.infinispan.api.Infinispan;
import org.infinispan.api.v1.impl.EmbeddedInfinispan;
import org.infinispan.api.v1.impl.RemoteInfinispan;

public class InfinispanAccess {
   public static Infinispan embedded() {
      return new EmbeddedInfinispan();
   }

   public static Infinispan remote() {
      return new RemoteInfinispan();
   }
}
