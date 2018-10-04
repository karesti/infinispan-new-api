package org.infinispan.api.reactive;

import java.util.Comparator;
import java.util.concurrent.CompletionStage;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import org.reactivestreams.Publisher;

public interface InfinispanPublisher<T> {

   // Intermediate methods
   <R> InfinispanPublisher<R> map(Function<? super T, ? extends R> function);

   <R> InfinispanPublisher<R> flatMap(Function<? super T, ? extends Publisher<? extends R>> function);

   InfinispanPublisher<T> filter(Predicate<? super T> predicate);

   InfinispanPublisher<T> distributedBatchSize(int batchSize);

   InfinispanPublisher<T> parallel();

   InfinispanPublisher<T> sequential();

   // Terminal Operations

   Publisher<T> min(Comparator<? super T> comparator, int amountToReturn);

   CompletionStage<Long> count();

   CompletionStage<Boolean> allMatch(Predicate<? super T> predicate);

   CompletionStage<Boolean> anyMatch(Predicate<? super T> predicate);

   CompletionStage<Boolean> noneMatch(Predicate<? super T> predicate);

   void subscribe(Consumer<? super T> consumer);

   Publisher<T> asPublisher() ;
}
