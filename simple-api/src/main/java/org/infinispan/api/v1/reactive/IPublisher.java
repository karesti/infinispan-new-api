package org.infinispan.api.v1.reactive;

import java.util.Comparator;
import java.util.concurrent.CompletionStage;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import org.reactivestreams.Publisher;

/**
 * I -> Infinispan xD
 *
 * @param <T>
 * @author wburns
 */
public interface IPublisher<T> {

   // Intermediate methods
   <R> IPublisher<R> map(Function<? super T, ? extends R> function);

   <R> IPublisher<R> flatMap(Function<? super T, ? extends Publisher<? extends R>> function);

   IPublisher<T> filter(Predicate<? super T> predicate);

   IPublisher<T> distributedBatchSize(int batchSize);

   IPublisher<T> parallel();

   IPublisher<T> sequential();

   // Terminal Operations

   Publisher<T> min(Comparator<? super T> comparator, int amountToReturn);

   CompletionStage<Long> count();

   CompletionStage<Boolean> allMatch(Predicate<? super T> predicate);

   CompletionStage<Boolean> anyMatch(Predicate<? super T> predicate);

   CompletionStage<Boolean> noneMatch(Predicate<? super T> predicate);

   void subscribe(Consumer<? super T> consumer);

   Publisher<T> asPublisher() ;
}
