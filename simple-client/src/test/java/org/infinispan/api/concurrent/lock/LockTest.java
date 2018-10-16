package org.infinispan.api.concurrent.lock;

import org.infinispan.api.Infinispan;
import org.infinispan.api.v1.concurrent.lock.ClusteredLockApi;
import org.infinispan.api.v1.concurrent.lock.ClusteredLockManager;
import org.junit.jupiter.api.Test;

public class LockTest {

   @Test
   public void lock() {

      ClusteredLockManager clusteredLockManager = Infinispan.get(ClusteredLockApi.instance());

//      clusteredLockManager.get("lock").thenApply(l -> {
//
//      })


   }
}
