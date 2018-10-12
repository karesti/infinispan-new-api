package org.infinispan.api;

import org.infinispan.api.admistration.InfinispanAdmin;
import org.infinispan.api.collection.InfinispanCollectionManagement;
import org.infinispan.api.search.InfinispanSearch;

// We acted we did not want a super mama interface, let's discuss it
// SUPER MAMA INFINISPAN
public interface Infinispan {

   InfinispanCollectionManagement getCollectionsManagement();

   InfinispanSearch getSearch();

   InfinispanAdmin getAdministration();

}
