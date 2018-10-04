package org.infinispan.api.admistration;

import org.infinispan.expiration.ExpirationManager;
import org.infinispan.security.AuthorizationManager;

public interface InfinispanAdmin {

   // Do we want to expose something here ?
   ExpirationManager expirationManager(String name);

   AuthorizationManager authorizationManager(String dataName);
}
