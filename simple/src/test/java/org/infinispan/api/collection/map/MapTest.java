package org.infinispan.api.collection.map;

import static org.assertj.core.api.Assertions.assertThat;

import org.infinispan.api.collection.InfinispanCollectionManagement;
import org.infinispan.api.collection.InfinispanCollectionsAccess;
import org.junit.jupiter.api.Test;

public class MapTest {

   @Test
   public void testRemoteMap(){
      InfinispanCollectionManagement infinispan = InfinispanCollectionsAccess.getInfinispanRemote();

      MapManager mapManager = infinispan.getMapManager();
      InfinispanMap<String, String> map = mapManager.getOrCreateMap("numbers");
      map.put("1", "one");
      map.put("2", "two");
      assertThat(map.get("1")).isEqualTo("one");
   }

   @Test
   public void testEmbeddedMap(){
      InfinispanCollectionManagement infinispan = InfinispanCollectionsAccess.getInfinispanLocal();

      MapManager mapManager = infinispan.getMapManager();
      InfinispanMap<String, String> map = mapManager.getOrCreateMap("numbers");
      map.put("1", "one");
      map.put("2", "two");
      assertThat(map.get("1")).isEqualTo("one");
   }
}
