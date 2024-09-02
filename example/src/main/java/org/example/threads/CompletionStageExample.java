package org.example.threads;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletionStageExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Start an asynchronous computation
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> 10);

        // Chain multiple stages
        CompletableFuture<String> result = future
                .thenApply(result1 -> result1 * 2)        // Multiply by 2
                .thenApply(result2 -> "Result is: " + result2); // Convert to a String

        // Handle result or error
        result.handle((res, ex) -> {
            if (ex != null) {
                System.out.println("Error: " + ex.getMessage());
                return "Default Result";
            } else {
                return res;
            }
        }).thenAccept(finalResult -> System.out.println(finalResult)); // Print the final result

        // Ensure the main thread waits for the computation to finish
        result.get();
    }
}
