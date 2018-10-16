package org.infinispan.api.v1.search;

public interface QueryEntry<K, V> {
   default boolean joining() {
      return false;
   }

   default boolean updated() {
      return false;
   }

   default boolean leaving() {
      return false;
   }

   default V value() {
      return null;
   }

   default K key() {
      return null;
   }
}
