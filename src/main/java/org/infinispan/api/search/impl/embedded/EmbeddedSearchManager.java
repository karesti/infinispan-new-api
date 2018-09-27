package org.infinispan.api.search.impl.embedded;

import org.infinispan.api.search.SearchManager;
import org.infinispan.query.dsl.QueryFactory;
import org.infinispan.query.dsl.embedded.impl.EmbeddedQueryFactory;

public class EmbeddedSearchManager implements SearchManager {

   @Override
   public QueryFactory getQueryFactory() {
      return new EmbeddedQueryFactory(null);
   }
}
