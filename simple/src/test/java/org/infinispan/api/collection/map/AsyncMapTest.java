package org.infinispan.api.collection.map;

import org.infinispan.api.collection.InfinispanCollectionManagement;
import org.infinispan.api.collection.InfinispanCollectionsAccess;
import org.junit.jupiter.api.Test;

public class AsyncMapTest {

   @Test
   public void testEmbeddedAsyncMap(){
      InfinispanCollectionManagement infinispan = InfinispanCollectionsAccess.getInfinispanLocal();

      MapManager mapManager = infinispan.getMapManager();
      InfinispanAsyncMap<String, String> map = mapManager.getOrCreateAsynMap("numbers");
      map.put("1", "one").whenComplete((r, ex) -> System.out.println("put done"));
      map.get("k").whenComplete((v, ex) -> System.out.println("value " + v));
   }

   @Test
   public void testRemoteAsyncMap(){
      InfinispanCollectionManagement infinispan = InfinispanCollectionsAccess.getInfinispanRemote();

      MapManager mapManager = infinispan.getMapManager();
      InfinispanAsyncMap<String, String> map = mapManager.getOrCreateAsynMap("numbers");
      map.put("1", "one").whenComplete((r, ex) -> System.out.println("put done"));
   }
}
