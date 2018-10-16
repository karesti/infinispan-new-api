package org.infinispan.api.listeners;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.infinispan.api.Infinispan;
import org.infinispan.api.v1.collection.map.MapConfig;
import org.infinispan.api.v1.collection.map.ReactiveMap;
import org.infinispan.api.v1.collection.map.ReactiveMapApi;
import org.infinispan.api.v1.event.ClientEvent;
import org.infinispan.api.v1.event.SafeClosable;
import org.junit.jupiter.api.Test;

public class ListenerTest {

   @Test
   public void remote_listener() {

      ReactiveMap<Integer, String> map = Infinispan.get(ReactiveMapApi.instance(), new MapConfig("foobar-cache"));

      // Give me all
      SafeClosable subscribe = map.getEventPublisher().subscribe(e -> {
         System.out.println(e);
      });

      subscribe.close();

      // by event
      SafeClosable eventSusbcription = map.getEventPublisher()
            .filter(Set.of(ClientEvent.Type.CREATED))
            .subscribe(e -> System.out.println("toto"));
      eventSusbcription.close();

      List<Integer> nearCache = new ArrayList<>();

      map.getEventPublisher().onFailover(() -> nearCache.clear())
            .filter(Set.of(ClientEvent.Type.CREATED))
            .includeCurrentState()
            .subscribe(e -> {
               nearCache.add(e.getKey());
            });

      map.getEventPublisher().onFailover(() -> nearCache.clear())
            .filter(Set.of(ClientEvent.Type.MODIFIED, ClientEvent.Type.REMOVED))
            .subscribe(e -> {
         nearCache.remove(e.getKey());
      });
   }


}
