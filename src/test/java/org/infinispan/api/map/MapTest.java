package org.infinispan.api.map;

import static org.assertj.core.api.Assertions.*;

import org.infinispan.api.ClusteredDataStructures;
import org.infinispan.api.Infinispan;
import org.infinispan.api.InfinispanRemote;
import org.infinispan.api.InfinispanLocal;
import org.junit.jupiter.api.Test;

public class MapTest {

   @Test
   public void testRemoteCache(){
      Infinispan infinispan = InfinispanRemote.getInfinispan();

      testMap(infinispan);
   }

   @Test
   public void testEmbeddedCache(){
      Infinispan infinispan = InfinispanLocal.getInfinispan();

      testMap(infinispan);
   }

   private void testMap(Infinispan infinispan) {
      MapManager mapManager = infinispan.getManager(ClusteredDataStructures.MAP);
      InfinispanMap<String, String> cache = mapManager.getMap("numbers");

      cache.put("1", "one");
      cache.put("2", "two");
      assertThat(cache.get("1")).isEqualTo("one");
   }
}
