package org.infinispan.api.v1.event;

public class ClientEvent<K> {
   public enum Type {CREATED, MODIFIED, REMOVED}

   public K getKey() {
      return null;
   }
}
