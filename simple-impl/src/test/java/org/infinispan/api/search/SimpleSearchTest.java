package org.infinispan.api.search;

import org.junit.jupiter.api.Test;

public class SimpleSearchTest {

   @Test
   public void testEmbeddedSearchWithIckle() {

      try {
         InfinispanSearch infinispanSearch = InfinispanSearchAccess.getLocalSearch();

         SearchableMap<Integer, Person> people = infinispanSearch.getOrCreateMap("people");
         people.put(1, new Person("Mikel", "Laboa"));
         people.put(2, new Person("Kepa", "Junkera"));

         people.list("from Person p where p.name = 'Mikel'");

      } catch (Exception ex) {
         System.out.println("this is just api test");
      }

   }
}
