package org.infinispan.api.v1.impl.event;

import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;

import org.infinispan.api.v1.event.ClientCacheEntryCreatedEvent;
import org.infinispan.api.v1.event.ClientCacheEntryModifiedEvent;
import org.infinispan.api.v1.event.ClientEvent;
import org.infinispan.api.v1.event.EventPublisher;
import org.infinispan.api.v1.event.SafeClosable;
import org.reactivestreams.Publisher;

public class EmbeddedEventPublisher<K> implements EventPublisher<K> {
   @Override
   public EventPublisher<K> includeCurrentState() {
      return this;
   }

   @Override
   public EventPublisher<K> filter(String ickleQuery) {
      return this;
   }

   @Override
   public EventPublisher<K> filter(Predicate<ClientEvent> predicate) {
      return null;
   }

   @Override
   public EventPublisher<K> filter(Set<ClientEvent.Type> types) {
      return this;
   }

   @Override
   public Publisher<ClientEvent> asPublisher() {
      return null;
   }

   @Override
   public SafeClosable subscribe(Consumer<? super ClientEvent<K>> event) {
      return null;
   }

   @Override
   public SafeClosable subscribe(Consumer<? super ClientEvent> event, Consumer<? super Throwable> errorConsumer) {
      return null;
   }

   @Override
   public SafeClosable subscribe(Consumer<? super ClientCacheEntryCreatedEvent<K>> createdConsumer, Consumer<? super ClientCacheEntryModifiedEvent<K>> modifiedConsumer, Consumer<? super Throwable> errorConsumer) {
      return null;
   }

   @Override
   public EventPublisher<K> onFailover(Runnable task) {
      return null;
   }
}
