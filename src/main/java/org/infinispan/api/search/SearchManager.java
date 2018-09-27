package org.infinispan.api.search;

import org.infinispan.query.dsl.QueryFactory;

public interface SearchManager {
   QueryFactory getQueryFactory();
}
