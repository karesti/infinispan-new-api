package org.infinispan.api.administration;

import org.infinispan.api.Infinispan;
import org.infinispan.api.v1.admistration.Administration;
import org.infinispan.api.v1.admistration.AdministrationApi;
import org.infinispan.api.v1.collection.map.MapConfig;
import org.junit.jupiter.api.Test;

public class AdminTest {

   @Test
   public void admin(){
      Administration administration = Infinispan.get(AdministrationApi.instance());
      administration.defineConfiguration(new MapConfig("map"));
   }
}
