package org.infinispan.api.v1.admistration;

import java.util.Collection;
import java.util.concurrent.CompletionStage;
import java.util.function.Function;

import org.infinispan.api.v1.collection.map.MapConfig;
import org.infinispan.api.v1.collection.map.ReactiveMap;

public interface Administration<T> {

   CompletionStage<Void> defineConfiguration(Configuration config);

   Configuration getConfiguration(String name);

   boolean isDefined(String name);

   void remove(String name);

   Collection<String> getNames();

   //T getOrCreate(String name, String configTemplate);

   interface Factory extends Function<Administration, Configuration> {}

}
