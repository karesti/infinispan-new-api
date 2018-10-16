package org.infinispan.api.v1.event;

import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;

import org.reactivestreams.Publisher;

public interface EventPublisher<K> {

   EventPublisher<K> includeCurrentState();

   EventPublisher<K> filter(String ickleQuery);

   EventPublisher<K> filter(Predicate<ClientEvent> predicate);

   EventPublisher<K> filter(Set<ClientEvent.Type> types);

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
