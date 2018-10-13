package org.infinispan.api.search;

public class QueryEntry<K,V> {
   public boolean joining() {
      return false;
   }

   public boolean updated() {
      return false;
   }

   public boolean leaving() {
      return false;
   }

   public V value() {
      return null;
   }

   public K key() {
      return null;
   }
}
