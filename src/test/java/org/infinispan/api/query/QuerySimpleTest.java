package org.infinispan.api.query;

import org.infinispan.api.Infinispan;
import org.infinispan.api.InfinispanLocal;
import org.infinispan.api.search.QueryManager;
import org.infinispan.api.search.SearchManager;
import org.infinispan.api.search.SearchableCache;
import org.infinispan.query.dsl.Query;
import org.infinispan.query.dsl.QueryFactory;
import org.junit.jupiter.api.Test;

public class QuerySimpleTest {

   @Test
   public void testEmbeddedSearch() {
//      Infinispan infinispan = InfinispanLocal.getInfinispan();
//
//      QueryManager queryManager = infinispan.getQueryManager();
//      SearchableCache<Integer, Person> people = queryManager.getCache("people");
//      people.put(1, new Person("Mikel", "Laboa"));
//      people.put(2, new Person("Kepa", "Junkera"));
//
//      SearchManager searchManager = people.getSearchManager();
//      QueryFactory queryFactory = searchManager.getQueryFactory();
//      Query query = queryFactory.from(Person.class).having("name").eq("Mikel").build();
//      query.list();
   }
}
