package org.infinispan.api.search;

import org.infinispan.api.Infinispan;
import org.infinispan.api.v1.search.ContinuousQueryPublisher;
import org.infinispan.api.v1.search.ContinuousQuerySubscriber;
import org.infinispan.api.v1.search.Query;
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
      SearchableMap<Integer, Person> people = Infinispan.get(SearchApi.instance(), "people");

      people.put(1, new Person("Mikel", "Laboa"));
      people.put(2, new Person("Kepa", "Junkera"));

      Query query = QueryFactory.build();
      people.list("from Person p where p.name = 'Mikel'");
      people.list(query);

      ContinuousQueryPublisher<Integer, Person> continuousQueryPublisher = people.addContinuousQuery(query);
      continuousQueryPublisher.subscribe(new MySubscriber());
   }
}
