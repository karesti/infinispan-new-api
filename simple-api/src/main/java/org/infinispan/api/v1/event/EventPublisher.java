package org.infinispan.api.v1.event;

import java.util.Set;
import java.util.function.Consumer;

import org.reactivestreams.Publisher;

public interface EventPublisher<K> {

   EventPublisher<K> includeCurrentState();

   EventPublisher<K> filter(String ickleQuery);

//   <R> Publisher<ClientCacheEntryCustomEvent<R>> filterAndMap(Query query);

   EventPublisher<K> filterByEventType(Set<ClientEvent.Type> types);

//   Publisher<ClientCacheEntryCreatedEvent<K>> onlyCreatedEvents();

//   Publisher<ClientCacheEntryModifiedEvent<K>> onlyModifiedEvents();

//   Publisher<ClientCacheEntryRemovedEvent<K>> onlyRemovedEvents();
//
//   Publisher<ClientCacheEntryExpiredEvent<K>> onlyExpiredEvents();

   Publisher<ClientEvent> asPublisher();

   SafeClosable subscribe(Consumer<? super ClientEvent<K>> event);

   SafeClosable subscribe(Consumer<? super ClientEvent> event,
                          Consumer<? super Throwable> errorConsumer);

   SafeClosable subscribe(Consumer<? super ClientCacheEntryCreatedEvent<K>> createdConsumer,
                          Consumer<? super ClientCacheEntryModifiedEvent<K>> modifiedConsumer,
//                           Consumer<? super ClientCacheEntryRemovedEvent<K>> removedConsumer,
//                           Consumer<? super ClientCacheEntryExpiredEvent<K>> expiredConsumer,
                          Consumer<? super Throwable> errorConsumer);

   EventPublisher<K> onFailover(Runnable task);
}
