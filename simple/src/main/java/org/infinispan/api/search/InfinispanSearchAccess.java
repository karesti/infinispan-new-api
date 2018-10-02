package org.infinispan.api.search;


import org.infinispan.api.search.impl.embedded.EmbeddedInfinispanSearch;

public final class InfinispanSearchAccess {

   public static InfinispanSearch getLocalSearch() {
      return new EmbeddedInfinispanSearch();
   }

   public static InfinispanSearch getRemoteSearch() {
      throw new UnsupportedOperationException("Remote search not implemented yet");
   }
}
