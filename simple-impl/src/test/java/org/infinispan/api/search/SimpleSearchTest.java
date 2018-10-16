package org.infinispan.api.search;

import org.infinispan.api.v1.InfinispanAccess;
import org.infinispan.api.v1.search.ContinuousQueryPublisher;
import org.infinispan.api.v1.search.ContinuousQuerySubscriber;
import org.infinispan.api.v1.search.QueryFactory;
import org.infinispan.api.v1.search.SearchApi;
import org.infinispan.api.v1.search.SearchableMap;
import org.junit.jupiter.api.Test;

public class SimpleSearchTest {

   class MySubscriber implements ContinuousQuerySubscriber<Integer, Person> {

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

         SearchableMap<Integer, Person> people = InfinispanAccess.remote().get(SearchApi.instance(), "people");
         people.put(1, new Person("Mikel", "Laboa"));
         people.put(2, new Person("Kepa", "Junkera"));

         people.list("from Person p where p.name = 'Mikel'");

         ContinuousQueryPublisher<Integer, Person> continuousQueryPublisher = people.addContinuousQuery(QueryFactory.build());
         continuousQueryPublisher.subscribe(new MySubscriber());

      } catch (Exception ex) {
         System.out.println("this is just api test");
      }

   }
}
