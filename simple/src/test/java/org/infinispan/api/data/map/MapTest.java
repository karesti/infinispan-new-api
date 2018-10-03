package org.infinispan.api.data.map;

import static org.assertj.core.api.Assertions.assertThat;

import org.infinispan.api.data.InfinispanData;
import org.infinispan.api.data.InfinispanDataAccess;
import org.junit.jupiter.api.Test;

public class MapTest {

   @Test
   public void testRemoteMap(){
      InfinispanData infinispan = InfinispanDataAccess.getInfinispanRemote();

      MapManager mapManager = infinispan.getMapManager();
      InfinispanMap<String, String> map = mapManager.getMap("numbers");
      map.put("1", "one");
      map.put("2", "two");
      assertThat(map.get("1")).isEqualTo("one");
   }

   @Test
   public void testEmbeddedMap(){
      InfinispanData infinispan = InfinispanDataAccess.getInfinispanLocal();

      MapManager mapManager = infinispan.getMapManager();
      InfinispanMap<String, String> map = mapManager.getMap("numbers");
      map.put("1", "one");
      map.put("2", "two");
      assertThat(map.get("1")).isEqualTo("one");
   }
}
