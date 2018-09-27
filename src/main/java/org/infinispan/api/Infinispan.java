package org.infinispan.api;

public interface Infinispan {

   <T> T getManager(ClusteredDataStructures type);
}
