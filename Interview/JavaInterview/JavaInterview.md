# Java & Spring Boot Interview Questions

## Core Java and Spring

- Explain the internal working of `ConcurrentHashMap` in Java 8.
  - **HashMap implementation:** [GeeksforGeeks](https://www.geeksforgeeks.org/java/internal-working-of-hashmap-java/)
  - **ConcurrentHashMap implementation:** [Java Concept Of The Day](https://javaconceptoftheday.com/how-concurrenthashmap-works-internally-after-java-8/)
- HashMap vs. ConcurrentHashMap: why do we need ConcurrentHashMap?
  - **ConcurrentHashMap VS HashMap Difference:** [Java Concept Of The Day](https://javaconceptoftheday.com/hashmap-vs-concurrenthashmap-in-java/)
- Fail-fast vs. fail-safe iterators: how do they work internally?
  - **Fail-fast vs. fail-safe iterators:**
      - [Java Concept Of The Day](https://javaconceptoftheday.com/fail-fast-and-fail-safe-iterators-in-java-with-examples/)
      - [GeeksforGeeks](https://www.geeksforgeeks.org/java/fail-fast-fail-safe-iterators-java/)

- What is a functional interface? Can it contain default and static methods?
- Explain try-with-resources. What happens when both the `try` block and `close()` throw exceptions?
- Explain the major Java 8 features and their practical use cases.
- What happens internally when `@SpringBootApplication` is executed?
- How does Spring Dependency Injection work internally?
- How does `@Transactional` work through Spring proxies?
- Explain the Spring bean lifecycle and different bean scopes.
- What is the JPA N+1 query problem, and how would you solve it?

## Coding Questions

- Write a Java program to check whether a number is prime.
- Reverse the words in a string without reversing the characters inside each word.
- Move all zeroes to the end of an array while maintaining the order of non-zero elements.
- Find the third-highest salary from a list of employees using Java 8 Streams.
- Given a nested list, use `flatMap()` to flatten it into a single list.
- Find all unique triplets in an array whose sum equals a given target.
- Sort employees by salary using Java 8 Streams.
- Find the first three odd numbers from a list using Streams.

## Microservices, Cloud, and CI/CD

- How do independent microservices communicate with each other?
- REST vs. messaging-based communication: when would you choose each?
- How would you handle failures between two microservices?
- Explain the Circuit Breaker, Retry, and Timeout patterns.
- How would you manage distributed transactions in microservices?
- How would you design idempotent APIs in a distributed system?
- How would you deploy a Spring Boot application using Docker and Kubernetes?
- Explain a typical CI/CD pipeline for a Spring Boot microservice.
- What happens from `git push` until the application is deployed to production?
- How would you monitor and troubleshoot a failed production deployment?