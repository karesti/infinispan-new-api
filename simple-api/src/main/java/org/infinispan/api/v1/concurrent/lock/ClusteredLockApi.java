package org.infinispan.api.v1.concurrent.lock;

import java.util.function.Function;

import org.infinispan.api.ManagementApi;

public class ClusteredLockApi implements ManagementApi<ClusteredLockManager> {
   private static final ClusteredLockApi INSTANCE = new ClusteredLockApi();

   private ClusteredLockApi() {
   }

   public static ClusteredLockApi instance() {
      return INSTANCE;
   }

   @Override
   public <F extends Function<String, ClusteredLockManager>> Class<F> classApiWithNameConfig() {
      return (Class) ClusteredLockManager.Factory.class;
   }
}
