package org.infinispan.api.v1.admistration;

import java.util.Collection;
import java.util.concurrent.CompletionStage;

public interface Administration {

   CompletionStage<Void> defineConfiguration(Configuration config);

   Configuration getConfiguration(String name);

   boolean isDefined(String name);

   void remove(String name);

   Collection<String> getNames();

   //T getOrCreate(String name, String configTemplate);
}
