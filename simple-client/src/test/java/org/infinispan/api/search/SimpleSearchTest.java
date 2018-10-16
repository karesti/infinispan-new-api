package org.infinispan.api.search;

import org.infinispan.api.Infinispan;
import org.infinispan.api.v1.search.ContinuousQueryPublisher;
import org.infinispan.api.v1.search.ContinuousQuerySubscriber;
import org.infinispan.api.v1.search.Query;
import org.infinispan.api.v1.search.QueryFactory;
import org.infinispan.api.v1.search.SearchApi;
import org.infinispan.api.v1.search.SearchableMap;
import org.junit.jupiter.api.Test;

import io.reactivex.Flowable;
import io.reactivex.Single;

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
   public void continuous_query() {
      SearchableMap<Integer, Person> people = Infinispan.get(SearchApi.instance(), "people");

      people.put(1, new Person("Mikel", "Laboa"));
      people.put(2, new Person("Kepa", "Junkera"));
      people.put(2, new Person("Ainhoa", "Junkera"));

      people.addContinuousQuery("from Person p where p.name = 'Mikel'").subscribe(new MySubscriber());
   }

   @Test
   public void continuous_query_rxjava2() {
      SearchableMap<Integer, Person> people = Infinispan.get(SearchApi.instance(), "people");

      people.put(1, new Person("Mikel", "Laboa"));
      people.put(2, new Person("Kepa", "Junkera"));
      people.put(2, new Person("Ainhoa", "Junkera"));

      Flowable.fromPublisher(people.addContinuousQuery(QueryFactory.build()))
            .map(entry -> transform(entry.value()))
            .count()
            .subscribe();
   }

   private <R> R transform(Person value) {
      return null;
   }
}
