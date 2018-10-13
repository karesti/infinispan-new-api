package org.infinispan.api.search;

public interface QueryFactory {
   static Query build() {
      return new Query();
   }
}
