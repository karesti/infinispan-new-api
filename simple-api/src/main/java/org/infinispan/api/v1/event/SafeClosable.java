package org.infinispan.api.v1.event;

public interface SafeClosable extends AutoCloseable {

   @Override
   void close();
}
