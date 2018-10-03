package org.infinispan.api.data.map;

import org.infinispan.api.data.InfinispanData;
import org.infinispan.api.data.InfinispanDataAccess;
import org.junit.jupiter.api.Test;

public class AsyncMapTest {

   @Test
   public void testEmbeddedAsyncMap(){
      InfinispanData infinispan = InfinispanDataAccess.getInfinispanLocal();

      MapManager mapManager = infinispan.getMapManager();
      InfinispanAsyncMap<String, String> map = mapManager.getAsynMap("numbers");
      map.put("1", "one").whenComplete((r, ex) -> System.out.println("put done"));
      map.get("k").whenComplete((v, ex) -> System.out.println("value " + v));
   }

   @Test
   public void testRemoteAsyncMap(){
      InfinispanData infinispan = InfinispanDataAccess.getInfinispanRemote();

      MapManager mapManager = infinispan.getMapManager();
      InfinispanAsyncMap<String, String> map = mapManager.getAsynMap("numbers");
      map.put("1", "one").whenComplete((r, ex) -> System.out.println("put done"));
   }
}
