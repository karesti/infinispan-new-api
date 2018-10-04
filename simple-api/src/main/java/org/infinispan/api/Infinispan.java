package org.infinispan.api;

import javax.transaction.TransactionManager;

import org.infinispan.api.admistration.InfinispanAdmin;
import org.infinispan.api.collection.InfinispanCollectionManagement;
import org.infinispan.api.search.InfinispanSearch;

// We acted we did not want a super mama interface, let's discuss it
// SUPER MAMA INFINISPAN
public interface Infinispan {

   InfinispanCollectionManagement getCollectionsManagement();

   TransactionManager getTransactionManagement();

   InfinispanSearch getSearch();

   InfinispanAdmin getAdministration();
}
