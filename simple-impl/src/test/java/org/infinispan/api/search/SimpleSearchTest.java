package org.infinispan.api.search;

import org.junit.jupiter.api.Test;

public class SimpleSearchTest {

   class MyCQSubscriber implements ContinuousQuerySubscriber<Integer, Person> {

      @Override
      public void joining(Integer key, Person value) {

      }

      @Override
      public void updated(Integer key, Person value) {

      }

      @Override
      public void leaving(Integer key) {

      }
   }

   @Test
   public void testEmbeddedSearchWithIckle() {

      try {
         InfinispanSearch infinispanSearch = InfinispanSearchAccess.getLocalSearch();

         SearchableMap<Integer, Person> people = infinispanSearch.getOrCreateMap("people");
         people.put(1, new Person("Mikel", "Laboa"));
         people.put(2, new Person("Kepa", "Junkera"));

         people.list("from Person p where p.name = 'Mikel'");

         ContinuousQueryPublisher<Integer, Person> continuousQueryPublisher = people.addContinuousQuery(QueryFactory.build());
         continuousQueryPublisher.subscribe(new MyCQSubscriber());

      } catch (Exception ex) {
         System.out.println("this is just api test");
      }

   }
}
