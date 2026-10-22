# Java & Spring Boot Interview Questions and Answers

**Topics:** Core Java, Spring Boot, Coding, Microservices, Cloud, and CI/CD  
**Purpose:** Interview-ready explanations with practical examples and Java code.

> **How to use this guide:** Explain the concept first, then how it works internally, and finally when you would use it. Adapt examples to your actual hands-on experience.

---

# 1. Core Java and Spring

## 1. Explain the internal working of `ConcurrentHashMap` in Java 8.

`ConcurrentHashMap` is a thread-safe map designed for concurrent access by multiple threads. Unlike a synchronized `HashMap`, it allows reads and updates to different parts of the map to proceed concurrently where possible.

### How it works in Java 8

- **Array of bins:** It stores entries in a hash table, similar to `HashMap`.
- **Hashing:** The key's hash is spread to help distribute entries across bins.
- **Empty bin insertion:** An insertion into an empty bin can use a compare-and-set (CAS) operation, avoiding a lock in that case.
- **Occupied bin:** If the target bin is occupied, updates may synchronize on that bin's first node while modifying its list or tree structure.
- **Collision handling:** Entries with the same bin index are stored in a linked list; heavily populated bins can be converted into red-black trees under the implementation's thresholds.
- **Resizing:** When the table grows, multiple threads can help transfer bins to the new table.
- **Reads:** Retrievals generally do not require locking. Internal use of volatile fields and other memory-ordering mechanisms helps make updates visible to readers.

Java 8 removed the older fixed-segment locking design used by earlier implementations.

### Why use it?

It is useful when many threads need to read and update a shared map, such as an in-memory cache or a registry of active sessions.

```java
ConcurrentHashMap<String, Integer> counts = new ConcurrentHashMap<>();

counts.put("login", 1);
counts.merge("login", 1, Integer::sum);

System.out.println(counts.get("login")); // 2
```

**Interview answer:**  
“Java 8 `ConcurrentHashMap` uses a hash table with CAS for certain insertions and bin-level synchronization for contended updates. Reads are generally non-blocking, and resizing can be helped by multiple threads. This provides thread safety with better concurrency than synchronizing the entire map.”

**Important:** Individual map operations are thread-safe, but a sequence of separate operations is not automatically atomic. Use methods such as `compute`, `merge`, or `putIfAbsent` when their atomic behavior matches the requirement.

---

## 2. `HashMap` vs. `ConcurrentHashMap`: why do we need `ConcurrentHashMap`?

| Feature | `HashMap` | `ConcurrentHashMap` |
|---|---|---|
| Thread safety | Not thread-safe for concurrent mutation | Supports concurrent access |
| Null keys/values | Allows one null key and null values | Does not allow null keys or values |
| Concurrent updates | Requires external coordination | Provides thread-safe map operations |
| Locking/concurrency | No built-in synchronization | Uses concurrency mechanisms such as CAS and bin-level locking |
| Iterators | Usually fail-fast on structural modification, on a best-effort basis | Weakly consistent; can reflect some concurrent changes without throwing `ConcurrentModificationException` |
| Typical use | Local or otherwise externally synchronized data | Shared maps accessed by multiple threads |

### Example

```java
Map<String, String> normalMap = new HashMap<>();

ConcurrentHashMap<String, String> concurrentMap =
        new ConcurrentHashMap<>();

concurrentMap.put("user-101", "Anupam");
String user = concurrentMap.get("user-101");
```

**Why not just use `Collections.synchronizedMap()`?**  
A synchronized wrapper generally coordinates map operations through a common lock. `ConcurrentHashMap` is designed to permit greater concurrency. However, compound workflows still need atomic map methods or appropriate external synchronization.

**Interview answer:**  
“I use `HashMap` when the map is confined to one thread or access is safely coordinated elsewhere. For a map shared across threads, I consider `ConcurrentHashMap` because it supports concurrent reads and updates without locking the entire map for every operation. It also rejects null keys and values, which avoids ambiguity in concurrent retrievals.”

---

## 3. Fail-fast vs. fail-safe iterators: how do they work internally?

“Fail-safe” is a commonly used informal term, not an official Java iterator category. It often refers to iterators that avoid failing because of concurrent modification, such as snapshot or weakly consistent iterators.

### Fail-fast

Collections such as `ArrayList` maintain a modification count. An iterator records the expected count when created and may throw `ConcurrentModificationException` if it detects an unexpected structural modification.

```java
List<String> names = new ArrayList<>(List.of("A", "B", "C"));

for (String name : names) {
    if (name.equals("B")) {
        names.add("D"); // Usually triggers ConcurrentModificationException
    }
}
```

Use the iterator's own `remove()` method when removing elements during iteration:

```java
Iterator<String> iterator = names.iterator();

while (iterator.hasNext()) {
    if (iterator.next().equals("B")) {
        iterator.remove();
    }
}
```

Fail-fast behavior is best-effort. It is not a thread-safety guarantee and must not be relied on for correctness.

### Snapshot iterator

`CopyOnWriteArrayList` creates a new backing array for mutations. An iterator works against the array snapshot that existed when the iterator was created.

```java
CopyOnWriteArrayList<String> items =
        new CopyOnWriteArrayList<>(List.of("A", "B"));

Iterator<String> iterator = items.iterator();
items.add("C");

while (iterator.hasNext()) {
    System.out.println(iterator.next()); // Snapshot: A, B
}
```

This is useful for read-heavy collections with relatively infrequent updates, because writes copy the array.

### Weakly consistent iterator

`ConcurrentHashMap` iterators do not throw `ConcurrentModificationException` merely because other threads update the map. They may reflect some updates that occur during iteration, but they are not a fixed snapshot.

**Interview answer:**  
“Fail-fast iterators detect certain structural modifications and may throw `ConcurrentModificationException`; they are a debugging aid, not a concurrency mechanism. Snapshot iterators, such as those from `CopyOnWriteArrayList`, iterate over a stable snapshot. Weakly consistent iterators, such as those from `ConcurrentHashMap`, tolerate concurrent updates and may reflect some of them.”

---

## 4. What is a functional interface? Can it contain default and static methods?

A functional interface has exactly one **abstract method**. It may also contain default methods, static methods, and methods matching public methods of `Object`. It is commonly used with lambda expressions and method references.

```java
@FunctionalInterface
interface Calculator {
    int calculate(int a, int b); // Single abstract method

    default void describe() {
        System.out.println("Calculator");
    }

    static int square(int value) {
        return value * value;
    }
}

public class Main {
    public static void main(String[] args) {
        Calculator addition = (a, b) -> a + b;

        System.out.println(addition.calculate(3, 4)); // 7
        addition.describe();
        System.out.println(Calculator.square(5)); // 25
    }
}
```

Common built-in functional interfaces include:

- `Predicate<T>` — takes a value and returns a boolean.
- `Function<T, R>` — transforms a value of type `T` into `R`.
- `Consumer<T>` — accepts a value and returns no result.
- `Supplier<T>` — supplies a value without taking an argument.
- `Runnable` — represents a task with no arguments or return value.

**Interview answer:**  
“A functional interface has one abstract method, so Java can infer that method when I pass a lambda. It can still have default and static methods because those do not add another abstract method. The `@FunctionalInterface` annotation is optional but helps the compiler verify the interface.”

---

## 5. Explain try-with-resources. What if both the `try` block and `close()` throw exceptions?

Try-with-resources automatically closes resources that implement `AutoCloseable` (including `Closeable`) when control leaves the block, including when an exception occurs.

```java
try (BufferedReader reader =
         Files.newBufferedReader(Path.of("input.txt"))) {
    System.out.println(reader.readLine());
} catch (IOException e) {
    e.printStackTrace();
}
```

The resource is closed automatically. Multiple resources are closed in reverse order of declaration.

### What if both the body and `close()` throw?

- The exception from the `try` body remains the **primary exception**.
- The exception thrown by `close()` is recorded as a **suppressed exception**.
- The suppressed exception can be retrieved with `getSuppressed()`.

```java
try (MyResource resource = new MyResource()) {
    throw new IOException("Failure in try block");
} catch (IOException e) {
    System.out.println("Primary: " + e.getMessage());

    for (Throwable suppressed : e.getSuppressed()) {
        System.out.println("Suppressed: " + suppressed.getMessage());
    }
}
```

For this example, assume `MyResource.close()` also throws an `IOException`.

**Interview answer:**  
“Try-with-resources closes `AutoCloseable` resources automatically, even if the body fails. If the body and `close()` both throw, the body exception is primary and the close exception is suppressed. I can inspect suppressed exceptions with `getSuppressed()` rather than losing the original failure.”

---

## 6. Explain major Java 8 features and practical use cases.

### Lambda expressions

Allow behavior to be passed as data, especially to functional interfaces.

```java
List<String> names = List.of("Anupam", "Stuti");
names.forEach(name -> System.out.println(name));
```

### Stream API

Supports declarative processing of collections using operations such as `filter`, `map`, `sorted`, and `collect`.

```java
List<String> result = names.stream()
        .filter(name -> name.startsWith("A"))
        .toList(); // Java 16+ terminal operation
```

For code specifically targeting Java 8, use `.collect(Collectors.toList())` instead of `.toList()`.

### Functional interfaces

Interfaces such as `Predicate`, `Function`, `Consumer`, and `Supplier` make lambda-based APIs possible.

### Method references

Provide a concise alternative when a lambda simply calls an existing method.

```java
names.forEach(System.out::println);
```

### Default and static interface methods

Let interfaces provide reusable behavior and utility methods without requiring every implementation class to add them.

### `Optional`

Represents a value that may be absent and encourages explicit handling of missing results.

```java
Optional<String> name = Optional.ofNullable(findName());
String displayName = name.orElse("Guest");
```

`Optional` is most commonly used for return values; it should not be applied indiscriminately to every field or parameter.

### New Date and Time API

`java.time`, including `LocalDate`, `LocalDateTime`, `Instant`, and `ZonedDateTime`, provides clearer and generally safer date/time handling than the older mutable date APIs.

### `CompletableFuture`

Introduced in Java 8 for composing asynchronous computations.

```java
CompletableFuture.supplyAsync(() -> "Hello")
        .thenApply(String::toUpperCase)
        .thenAccept(System.out::println);
```

**Interview answer:**  
“The most frequently used Java 8 features in my day-to-day code are lambdas, functional interfaces, Streams, method references, `Optional`, and the `java.time` API. Streams make collection transformations more readable, while `CompletableFuture` supports composing asynchronous tasks. I choose these features when they improve clarity rather than using them just to shorten code.”

---

## 7. What happens internally when `@SpringBootApplication` is executed?

`@SpringBootApplication` is a convenience annotation that combines three important annotations:

- `@SpringBootConfiguration` — identifies the class as a source of Spring configuration.
- `@EnableAutoConfiguration` — asks Spring Boot to configure beans based on the classpath, properties, and existing beans.
- `@ComponentScan` — scans for components in the package of the application class and its subpackages by default.

Example:

```java
@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
```

### Startup flow (simplified)

1. `SpringApplication.run()` creates and prepares the Spring application context.
2. It determines the application type and prepares the environment and configuration properties.
3. It registers the application configuration as a source.
4. Component scanning and auto-configuration identify bean definitions.
5. The context creates and wires required beans, applying lifecycle callbacks and post-processors.
6. For a web application, Spring Boot configures the web server and web infrastructure.
7. The application context is refreshed and startup runners are invoked.

Auto-configuration is conditional. For example, Boot may configure a `DataSource` when the appropriate classes and properties are present and no replacement bean makes the auto-configuration back off.

**Interview answer:**  
“`@SpringBootApplication` combines configuration, component scanning, and auto-configuration. `SpringApplication.run()` bootstraps the application context, loads configuration, discovers bean definitions, creates and wires beans, and starts the embedded web server for a web application. Auto-configuration is conditional on the classpath, properties, and existing beans.”

---

## 8. How does Spring Dependency Injection work internally?

Dependency Injection (DI) means an object receives its dependencies from a container rather than creating them itself. Spring's IoC container manages bean definitions, object creation, dependency resolution, lifecycle callbacks, and scope.

### Constructor injection example

```java
@Service
public class PaymentService {
    private final PaymentRepository repository;

    public PaymentService(PaymentRepository repository) {
        this.repository = repository;
    }

    public void processPayment() {
        repository.savePayment();
    }
}

@Repository
public class PaymentRepository {
    public void savePayment() {
        System.out.println("Payment saved");
    }
}
```

Spring discovers the annotated classes, registers bean definitions, creates the required beans, resolves `PaymentRepository` as a constructor argument, and injects it into `PaymentService`.

### Common injection styles

- **Constructor injection:** Best default for required dependencies; supports immutability and straightforward unit testing.
- **Setter injection:** Useful for optional or reconfigurable dependencies.
- **Field injection:** Concise but generally less desirable because dependencies are hidden and direct construction/testing is harder.

If multiple beans implement the same interface, use `@Qualifier` or a suitable `@Primary` bean to resolve ambiguity.

**Interview answer:**  
“Spring DI is managed by the IoC container. It discovers bean definitions, creates beans, resolves dependencies by type and qualifiers, and injects them. I prefer constructor injection because required dependencies are explicit, fields can be final, and the class is easy to unit-test without starting Spring.”

---

## 9. How does `@Transactional` work through Spring proxies?

In Spring's common proxy-based transaction model, `@Transactional` marks a method or class for transaction advice. A Spring proxy intercepts eligible calls and coordinates transaction boundaries through a transaction manager.

### Simplified flow

1. A caller invokes a method through the Spring-managed proxy.
2. Transaction advice checks the transaction attributes.
3. The transaction manager starts a transaction or joins an existing one, depending on propagation settings.
4. The target method executes.
5. On successful completion, the transaction is committed.
6. If an applicable exception occurs, the transaction is rolled back according to the configured rollback rules.

By default, Spring generally rolls back for unchecked exceptions (`RuntimeException` and `Error`), not every checked exception. Use `rollbackFor` when checked exceptions should also trigger rollback.

```java
@Service
public class TransferService {
    private final AccountRepository repository;

    public TransferService(AccountRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void transfer() {
        repository.debit();
        repository.credit();
    }
}
```

### Important caveats

- In default proxy mode, self-invocation (one method calling another method on `this`) bypasses the proxy, so the inner method's transactional annotation may not be applied independently.
- The method must be invoked through the Spring-managed proxy for proxy-based advice to apply.
- Transaction behavior depends on the transaction manager and resource configuration.
- A database transaction does not automatically make a distributed operation across multiple services atomic.

**Interview answer:**  
“Spring implements `@Transactional` commonly through AOP proxies. The proxy starts or joins a transaction before calling the target method and commits or rolls back afterward based on the outcome and rollback rules. I pay attention to proxy-based self-invocation, checked-exception rollback behavior, and the fact that a local database transaction does not cover a distributed workflow.”

---

## 10. Explain the Spring bean lifecycle and bean scopes.

### Bean lifecycle (simplified)

1. Spring reads configuration and registers bean definitions.
2. The bean is instantiated.
3. Dependencies are injected.
4. Aware callbacks, such as `BeanNameAware`, may be invoked.
5. Bean post-processors run before initialization.
6. Initialization callbacks run, such as `@PostConstruct`, `InitializingBean.afterPropertiesSet()`, and configured init methods.
7. Bean post-processors run after initialization; proxies may be created here.
8. The bean is ready for use.
9. On context shutdown, destruction callbacks such as `@PreDestroy`, `DisposableBean.destroy()`, and configured destroy methods may run.

Exact ordering depends on the callbacks and post-processors in use. Prototype-scoped beans do not receive the same automatic destruction management as singleton beans.

### Common scopes

- **Singleton (default):** One bean instance per Spring IoC container.
- **Prototype:** A new instance each time the container is asked to provide the bean; Spring does not fully manage its destruction afterward.
- **Request:** One instance per HTTP request in a web-aware context.
- **Session:** One instance per HTTP session in a web-aware context.
- **Application:** One instance per `ServletContext`.
- **WebSocket:** One instance per WebSocket lifecycle in supported web contexts.

**Interview answer:**  
“Spring creates a bean, injects its dependencies, runs aware callbacks and post-processors, executes initialization callbacks, and makes it available. Destruction callbacks are run when the context shuts down for managed singleton beans. Singleton is the default scope; prototype creates a new instance per lookup, while request and session scopes are tied to web lifecycles.”

---

## 11. What is the JPA N+1 query problem, and how do you solve it?

The N+1 query problem occurs when an application executes one query to load a list of entities and then runs an additional query for each entity to load related data. For `N` parent records, this can result in approximately `1 + N` queries.

For example, loading 100 orders and then accessing each order's customer may trigger 101 queries if the relationship is fetched lazily and not otherwise optimized.

### Solutions

1. **Fetch join:** Fetch related data in the same query when appropriate.
2. **Entity graph:** Specify relationships to fetch for a particular repository operation.
3. **DTO projection:** Query only the columns and relationships needed for the response.
4. **Batch fetching:** Fetch related entities in groups to reduce query count.
5. **Review access patterns:** Avoid traversing relationships unnecessarily and check generated SQL.

JPQL fetch-join example:

```java
@Query("""
    select o
    from Order o
    join fetch o.customer
    where o.status = :status
    """)
List<Order> findOrdersWithCustomerByStatus(
        @Param("status") OrderStatus status
);
```

This assumes `Order` has a `customer` relationship and `OrderStatus` is the relevant enum/type.

### What should you be careful about?

Fetch joins can duplicate parent rows in some relationship shapes, especially collection joins. Pagination combined with collection fetch joins needs particular care. Choose the fetching strategy based on the use case and verify query count and execution plans.

**Interview answer:**  
“The N+1 problem means a parent query is followed by one query per parent to load related entities. I detect it by inspecting SQL logs or query metrics, then consider fetch joins, entity graphs, DTO projections, or batch fetching. I also check pagination and result duplication when fetching collections.”

---

# 2. Coding Questions

The examples below use Java. Unless stated otherwise, they focus on readable solutions and typical interview inputs.

## 1. Write a Java program to check whether a number is prime.

A prime number is an integer greater than 1 with exactly two positive divisors: 1 and itself. It is sufficient to test divisors up to the square root of the number.

```java
public class PrimeCheck {
    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        if (number == 2) {
            return true;
        }

        if (number % 2 == 0) {
            return false;
        }

        for (int divisor = 3;
             divisor <= number / divisor;
             divisor += 2) {
            if (number % divisor == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int number = 29;
        System.out.println(isPrime(number)); // true
    }
}
```

**Complexity:** `O(√n)` time and `O(1)` extra space.

**Interview explanation:** “I handle numbers below 2 first, special-case 2, and reject other even numbers. Then I test odd divisors only up to the square root. If no divisor is found, the number is prime.”

---

## 2. Reverse the words in a string without reversing characters inside each word.

Example: `"Java is fun"` becomes `"fun is Java"`.

```java
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseWords {
    public static String reverseWords(String input) {
        if (input == null || input.isBlank()) {
            return input;
        }

        String[] words = input.trim().split("\\s+");
        List<String> wordList = Arrays.asList(words);
        Collections.reverse(wordList);

        return String.join(" ", wordList);
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("Java is fun"));
        // fun is Java
    }
}
```

**Complexity:** `O(n)` time and `O(n)` extra space, where `n` is the input length.

This solution normalizes repeated whitespace to single spaces. If the interviewer expects original spacing to be preserved exactly, clarify the requirement and use a different approach.

**Interview explanation:** “I split the input into words, reverse the word list, and join it back together. The characters within each word remain unchanged.”

---

## 3. Move all zeroes to the end of an array while maintaining the order of non-zero elements.

Example: `[0, 1, 0, 3, 12]` becomes `[1, 3, 12, 0, 0]`.

```java
import java.util.Arrays;

public class MoveZeroes {
    public static void moveZeroes(int[] numbers) {
        int writeIndex = 0;

        for (int number : numbers) {
            if (number != 0) {
                numbers[writeIndex++] = number;
            }
        }

        while (writeIndex < numbers.length) {
            numbers[writeIndex++] = 0;
        }
    }

    public static void main(String[] args) {
        int[] numbers = {0, 1, 0, 3, 12};
        moveZeroes(numbers);
        System.out.println(Arrays.toString(numbers));
        // [1, 3, 12, 0, 0]
    }
}
```

**Complexity:** `O(n)` time and `O(1)` extra space. The relative order of non-zero elements is preserved.

**Interview explanation:** “I copy each non-zero element to the next write position, then fill the remaining positions with zeroes. This is an in-place, stable solution.”

---

## 4. Find the third-highest salary from a list of employees using Java 8 Streams.

Clarify whether “third-highest” means the **third distinct salary** or the third employee after sorting. This example finds the third distinct salary.

```java
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

class Employee {
    private final String name;
    private final BigDecimal salary;

    Employee(String name, BigDecimal salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getSalary() {
        return salary;
    }
}

public class ThirdHighestSalary {
    public static Optional<BigDecimal> findThirdHighestSalary(
            List<Employee> employees) {
        return employees.stream()
                .map(Employee::getSalary)
                .filter(salary -> salary != null)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(2)
                .findFirst();
    }
}
```

Usage:

```java
Optional<BigDecimal> salary =
        ThirdHighestSalary.findThirdHighestSalary(employees);

salary.ifPresentOrElse(
        value -> System.out.println("Third-highest salary: " + value),
        () -> System.out.println("Fewer than three distinct salaries")
);
```

**Complexity:** Sorting makes this approximately `O(n log n)` time; additional space is used for stream processing/sorting.

**Interview explanation:** “I map employees to salaries, remove nulls and duplicates, sort in descending order, skip the first two distinct salaries, and take the next one. I return an `Optional` because the list may have fewer than three distinct salaries.”

---

## 5. Given a nested list, use `flatMap()` to flatten it into a single list.

Example: `[[1, 2], [3, 4], [5]]` becomes `[1, 2, 3, 4, 5]`.

```java
import java.util.List;
import java.util.stream.Collectors;

public class FlattenList {
    public static void main(String[] args) {
        List<List<Integer>> nested = List.of(
                List.of(1, 2),
                List.of(3, 4),
                List.of(5)
        );

        List<Integer> flattened = nested.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        System.out.println(flattened); // [1, 2, 3, 4, 5]
    }
}
```

**Interview explanation:** “`map()` would transform each inner list into another stream value, leaving a nested structure. `flatMap()` maps each inner list to a stream and merges those streams into one stream of integers.”

---

## 6. Find all unique triplets in an array whose sum equals a target.

This solution sorts the array, fixes one value, and uses two pointers to find the other two values. It returns unique **value triplets** rather than unique index combinations.

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumTarget {
    public static List<List<Integer>> findTriplets(
            int[] numbers, int target) {
        int[] sorted = numbers.clone();
        Arrays.sort(sorted);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < sorted.length - 2; i++) {
            if (i > 0 && sorted[i] == sorted[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = sorted.length - 1;

            while (left < right) {
                long sum = (long) sorted[i]
                        + sorted[left]
                        + sorted[right];

                if (sum == target) {
                    result.add(List.of(
                            sorted[i], sorted[left], sorted[right]
                    ));

                    left++;
                    right--;

                    while (left < right
                            && sorted[left] == sorted[left - 1]) {
                        left++;
                    }

                    while (left < right
                            && sorted[right] == sorted[right + 1]) {
                        right--;
                    }
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] numbers = {-1, 0, 1, 2, -1, -4};
        System.out.println(findTriplets(numbers, 0));
        // [[-1, -1, 2], [-1, 0, 1]]
    }
}
```

**Complexity:** `O(n²)` time after sorting; `O(n)` extra space for the sorted copy, excluding output.

**Interview explanation:** “I sort the array, then use a fixed index and two pointers. Depending on whether the sum is too small or too large, I move the left or right pointer. I skip duplicates to return unique triplets. I use a `long` sum to reduce the risk of integer overflow.”

---

## 7. Sort employees by salary using Java 8 Streams.

This example sorts from lowest to highest salary. Reverse the comparator for descending order.

```java
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

List<Employee> sortedEmployees = employees.stream()
        .sorted(Comparator.comparing(Employee::getSalary))
        .collect(Collectors.toList());
```

Descending order:

```java
List<Employee> sortedDescending = employees.stream()
        .sorted(Comparator.comparing(Employee::getSalary).reversed())
        .collect(Collectors.toList());
```

If salaries can be null, define the required null ordering explicitly:

```java
List<Employee> sortedEmployees = employees.stream()
        .sorted(Comparator.comparing(
                Employee::getSalary,
                Comparator.nullsLast(Comparator.naturalOrder())
        ))
        .collect(Collectors.toList());
```

**Interview explanation:** “I use `Comparator.comparing()` with the salary getter. The normal comparator sorts ascending; `reversed()` sorts descending. If salary values can be null, I define the null-handling behavior rather than allowing a `NullPointerException`.”

---

## 8. Find the first three odd numbers from a list using Streams.

“First” means preserving the list's encounter order. The example returns at most three numbers.

```java
import java.util.List;
import java.util.stream.Collectors;

List<Integer> firstThreeOddNumbers = numbers.stream()
        .filter(number -> number % 2 != 0)
        .limit(3)
        .collect(Collectors.toList());

System.out.println(firstThreeOddNumbers);
```

**Interview explanation:** “I filter odd values, limit the stream to three results, and collect them into a list. Since I don't sort the stream, the original encounter order is preserved.”

---

# 3. Microservices, Cloud, and CI/CD

## 1. How do independent microservices communicate with each other?

The two common approaches are synchronous communication and asynchronous messaging.

### Synchronous communication

One service calls another and waits for a response. Common examples include REST over HTTP and gRPC.

**Use it when:** The caller needs an immediate response, such as checking a shipping quote during checkout.

### Asynchronous communication

A service publishes an event or message to a broker such as Kafka or RabbitMQ. A consumer processes it independently.

**Use it when:** Work can happen later, such as publishing an `OrderCreated` event for notification, inventory, or analytics processing.

### Design considerations

- Define clear API contracts and versioning.
- Use timeouts and bounded retries.
- Make message consumers idempotent.
- Consider duplicate delivery and out-of-order events.
- Add correlation IDs, tracing, metrics, and structured logs.
- Avoid tight coupling to another service's internal database.

**Interview answer:**  
“Services communicate synchronously through APIs when an immediate response is needed, or asynchronously through a broker when the workflow can continue in the background. I choose based on latency, coupling, reliability, and consistency requirements. In either case, I plan for timeouts, observability, contract compatibility, and failure handling.”

---

## 2. REST vs. messaging-based communication: when would you choose each?

| Aspect | REST/API call | Messaging/event-based |
|---|---|---|
| Interaction | Usually request-response | Usually publish-consume |
| Response | Immediate response to the caller | Often processed later |
| Coupling | Caller depends on endpoint availability | Producer can often continue while consumers are temporarily unavailable |
| Failure handling | Timeouts, errors, retries, fallbacks | Broker persistence, acknowledgements, retries, dead-letter handling |
| Consistency | Often used when current response is needed | Often supports eventual consistency |
| Best fit | Querying data or validating a synchronous decision | Background work, event propagation, decoupled workflows |

REST is not inherently unreliable, and messaging does not automatically guarantee delivery exactly once. Reliability depends on implementation, configuration, and business design.

**Interview answer:**  
“I use REST when the caller needs a result immediately—for example, retrieving an account summary. I use messaging when a task can be processed asynchronously—for example, sending a notification after an order is created. Messaging improves decoupling, but it requires handling duplicate messages, retries, ordering, and eventual consistency.”

---

## 3. How would you handle failures between two microservices?

I would combine prevention, controlled recovery, and observability.

1. **Set timeouts:** Never allow calls to wait indefinitely.
2. **Retry selectively:** Retry transient failures, with a limit, backoff, and jitter. Avoid retrying non-idempotent operations unless they are protected.
3. **Circuit breaker:** Temporarily stop calls to a dependency that is repeatedly failing.
4. **Fallback or graceful degradation:** Return a safe alternative if the business requirement permits it.
5. **Bulkhead isolation:** Limit resource use so one failing dependency does not exhaust all threads or connections.
6. **Idempotency:** Prevent retries from performing a business action more than once.
7. **Observability:** Track error rate, latency, traces, logs, and dependency health.
8. **Asynchronous recovery:** For suitable workflows, use a durable queue and retry/dead-letter strategy.

**Interview answer:**  
“First I use bounded timeouts so requests do not hang. For transient errors, I retry with backoff and jitter, but only when retrying is safe. A circuit breaker prevents repeated calls to an unhealthy dependency, and fallbacks can preserve essential functionality. I also monitor the dependency and make write operations idempotent to avoid duplicate business effects.”

---

## 4. Explain the Circuit Breaker, Retry, and Timeout patterns.

### Timeout

Limits how long a call can wait. A timeout protects resources but does not necessarily mean the remote operation never completed.

### Retry

Repeats an operation after a failure that may be temporary. Retries should be bounded and usually use exponential backoff and jitter.

### Circuit breaker

Tracks failures and changes behavior when a dependency appears unhealthy. Common states are:

- **Closed:** Calls are allowed; failures are measured.
- **Open:** Calls are rejected or short-circuited for a period.
- **Half-open:** A limited number of trial calls check whether the dependency has recovered.

These patterns complement one another: timeouts bound waiting, retries recover from transient failures, and circuit breakers prevent repeated calls to a dependency that is persistently failing.

**Interview answer:**  
“A timeout limits waiting time, a retry attempts to recover from transient failures, and a circuit breaker stops repeatedly calling an unhealthy dependency. I combine them carefully: bounded retries, a realistic timeout, backoff with jitter, and circuit-breaker thresholds based on service behavior. I also make sure retries do not multiply across multiple service layers.”

---

## 5. How would you manage distributed transactions in microservices?

A traditional database transaction normally covers one transactional resource, not an entire multi-service workflow. Common approaches include **Saga**, transactional outbox, and idempotent event processing.

### Saga pattern

A business workflow is split into local transactions. If a later step fails, compensating actions reverse or mitigate earlier business effects.

Example order workflow:

1. Create order as pending.
2. Reserve inventory.
3. Authorize payment.
4. Confirm the order.
5. If payment fails, release inventory and cancel the order.

Compensation is a business action, not necessarily a literal rollback of history. For example, a refund may compensate for a payment but cannot erase the original payment event.

### Transactional outbox

The service writes its business change and an event record to the same local database transaction. A separate publisher sends the event to the broker and marks it as published. Consumers must still tolerate duplicates.

### Other considerations

- Use idempotency keys and unique business identifiers.
- Track workflow state and failures.
- Add retries, timeouts, monitoring, and recovery procedures.
- Use distributed two-phase commit only when its coordination, availability, and operational trade-offs are acceptable.

**Interview answer:**  
“I usually consider a Saga for a multi-service business workflow. Each service commits a local transaction and publishes or handles an event; if a later step fails, compensating actions restore a valid business state. I may use a transactional outbox to reliably publish events alongside database updates, and I design consumers to be idempotent.”

---

## 6. How would you design idempotent APIs in a distributed system?

An operation is idempotent when repeating the same request produces the same intended effect as performing it once. This is important because clients may retry after a timeout even if the server completed the original request.

### Common design

1. Accept an idempotency key for operations such as payment creation.
2. Store the key with a request fingerprint and operation status.
3. Enforce uniqueness in durable storage to prevent concurrent duplicates.
4. On a repeated request with the same key and same payload, return the stored result or current status.
5. Reject reuse of the same key with a different payload.
6. Define how long keys are retained and how in-progress requests are handled.

```java
@PostMapping("/payments")
public ResponseEntity<PaymentResponse> createPayment(
        @RequestHeader("Idempotency-Key") String idempotencyKey,
        @RequestBody PaymentRequest request) {
    // Delegate to a service that atomically checks/stores the key
    // and creates or retrieves the payment result.
    PaymentResponse response =
            paymentService.createIdempotently(idempotencyKey, request);

    return ResponseEntity.ok(response);
}
```

This is an illustrative controller; the actual guarantee must be implemented in the service and persistence layer, not by the header alone.

**Interview answer:**  
“I use a client-supplied idempotency key for operations that must not be duplicated. The backend stores the key, request fingerprint, and result with a uniqueness constraint or equivalent atomic coordination. Repeated requests with the same key return the same outcome, while a different payload under the same key is rejected. I also handle concurrent requests and key-retention policy.”

---

## 7. How would you deploy a Spring Boot application using Docker and Kubernetes?

### Typical workflow

1. Build and test the application using Maven or Gradle.
2. Package the application as a JAR.
3. Build a Docker image with a suitable Java runtime.
4. Run local or pipeline smoke tests against the image.
5. Push the versioned image to a container registry.
6. Deploy it to Kubernetes using a Deployment and Service, managed through manifests, Helm, or a similar tool.
7. Configure environment-specific settings and secrets securely.
8. Configure readiness and liveness probes, resource requests/limits, and replica counts.
9. Monitor rollout status and application health; roll back if the new version is unhealthy.

### Example Dockerfile

```dockerfile
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY target/app.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
```

Use a runtime version compatible with the application's compiled Java version. Production images should be built and scanned according to the organization's security standards; pinning image versions or digests improves reproducibility.

### Example Kubernetes Deployment (illustrative)

```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: spring-app
spec:
  replicas: 2
  selector:
    matchLabels:
      app: spring-app
  template:
    metadata:
      labels:
        app: spring-app
    spec:
      containers:
        - name: spring-app
          image: registry.example.com/spring-app:1.0.0
          ports:
            - containerPort: 8080
          readinessProbe:
            httpGet:
              path: /actuator/health/readiness
              port: 8080
            initialDelaySeconds: 10
            periodSeconds: 5
          livenessProbe:
            httpGet:
              path: /actuator/health/liveness
              port: 8080
            initialDelaySeconds: 20
            periodSeconds: 10
```

This assumes Spring Boot Actuator health endpoints are enabled and configured appropriately. A separate Kubernetes Service is normally needed to provide stable network access to the pods.

**Interview answer:**  
“I build and test the Spring Boot JAR, package it into a Docker image, and push a versioned image to a registry. Kubernetes deploys that image through a Deployment, while a Service provides stable access. I configure secrets, resource limits, readiness and liveness probes, and monitoring. I verify rollout health and keep a rollback path.”

---

## 8. Explain a typical CI/CD pipeline for a Spring Boot microservice.

A typical pipeline has these stages:

1. **Checkout:** Fetch the selected Git commit.
2. **Compile:** Compile the Java source.
3. **Unit tests:** Run JUnit/Mockito tests and fail the pipeline if required checks fail.
4. **Quality and security checks:** Run static analysis, dependency checks, and secret scanning.
5. **Package:** Build the JAR with Maven or Gradle.
6. **Integration tests:** Test database, API, or messaging interactions where appropriate.
7. **Build image:** Create the Docker image and tag it with a commit or release version.
8. **Image scanning and publishing:** Scan the image and push it to the registry.
9. **Deploy to a test/staging environment:** Apply configuration and run smoke or acceptance tests.
10. **Approval and production deployment:** Use the organization's release gates and deployment strategy.
11. **Verify and monitor:** Check health, error rates, logs, and metrics; roll back if necessary.

**Interview answer:**  
“My pipeline starts when code is pushed or a pull request is opened. It compiles the application, runs automated tests and quality/security checks, packages the JAR, builds and scans the container image, and publishes the image to a registry. It then deploys to a non-production environment, runs smoke tests, and promotes the same version through the required production approvals. Post-deployment health checks determine whether the rollout is successful.”

---

## 9. What happens from `git push` until the application is deployed to production?

The exact flow depends on the repository and CI/CD configuration, but a common sequence is:

1. A developer commits and pushes code to a remote branch.
2. The Git platform receives the commit and triggers a webhook or CI job.
3. The pipeline checks out the commit and loads its build configuration.
4. The build compiles the source and runs unit tests, integration tests, and quality/security checks.
5. The pipeline packages the application and builds a versioned container image.
6. The image is scanned and published to a registry.
7. The release workflow deploys the image to a test or staging environment.
8. Smoke tests and approval gates run.
9. The production deployment updates the relevant workloads, for example through a Kubernetes rollout.
10. Readiness checks, monitoring, and rollout verification determine whether to continue or roll back.

### How I would troubleshoot a failure

- Identify the first failing pipeline stage.
- Read the job logs and error messages.
- Confirm the commit, build artifact, image tag, and environment configuration.
- Check credentials, registry access, secrets, and deployment permissions.
- Inspect pod events, logs, readiness probes, and service connectivity if Kubernetes is involved.
- Fix the cause and rerun through the approved pipeline rather than manually bypassing required gates.

**Interview answer:**  
“After `git push`, the repository triggers CI. The pipeline checks out the commit, builds and tests the application, performs quality and security checks, packages it, and publishes a versioned image. CD deploys that artifact to staging, runs smoke tests and approval gates, and then rolls it out to production. I verify health and metrics afterward and use the established rollback process if the release is unhealthy.”

---

## 10. How would you monitor and troubleshoot a failed production deployment?

I would first establish impact and identify which release and components are affected, then use evidence to narrow the cause.

### Troubleshooting checklist

1. **Assess impact:** Check error rate, latency, availability, and affected endpoints or users.
2. **Check deployment status:** Inspect rollout history, deployment events, pod status, and recent configuration changes.
3. **Inspect logs:** Review application logs and platform logs around the failure time.
4. **Inspect metrics:** Check CPU, memory, restarts, thread pools, connection pools, database latency, and downstream dependencies.
5. **Trace requests:** Use distributed traces and correlation IDs to identify where requests fail.
6. **Check readiness and liveness:** A failed readiness probe can keep a pod out of service; repeated liveness failures can restart it.
7. **Compare versions/configuration:** Verify image tags, environment variables, secrets, database migrations, and feature flags.
8. **Mitigate:** Roll back or disable the problematic feature if the risk and release process justify it.
9. **Verify recovery:** Confirm health metrics return to normal and perform smoke tests.
10. **Prevent recurrence:** Record the root cause, add tests/alerts, and improve rollout or rollback procedures.

### Useful Kubernetes commands

```bash
kubectl rollout status deployment/spring-app
kubectl rollout history deployment/spring-app
kubectl get pods
kubectl describe pod <pod-name>
kubectl logs <pod-name>
kubectl get events --sort-by=.metadata.creationTimestamp
```

Use the correct namespace and context. For a container that has restarted, `kubectl logs <pod-name> --previous` can help inspect the prior container's logs.

**Interview answer:**  
“I start by assessing impact and checking deployment status, pod events, logs, metrics, and traces. I compare the current release with the last healthy version and check configuration, probes, resource limits, and downstream dependencies. If the release is causing significant impact, I follow the rollback or mitigation procedure, verify recovery, and then document the root cause and add preventive checks.”

---

# 4. Quick Revision: One-Line Answers

- **`ConcurrentHashMap`:** A concurrent map that uses CAS and bin-level synchronization for thread-safe operations.
- **`HashMap` vs. `ConcurrentHashMap`:** Use `HashMap` for non-concurrent or externally coordinated access; use `ConcurrentHashMap` for shared concurrent access.
- **Fail-fast iterator:** May detect unexpected structural modification and throw `ConcurrentModificationException`; this is best-effort.
- **Functional interface:** Has one abstract method and may also have default and static methods.
- **Try-with-resources:** Automatically closes `AutoCloseable` resources; close failures are suppressed when a body exception is already primary.
- **Java 8:** Lambdas, Streams, functional interfaces, method references, `Optional`, `java.time`, and `CompletableFuture`.
- **`@SpringBootApplication`:** Combines configuration, component scanning, and conditional auto-configuration.
- **Dependency Injection:** The Spring container creates beans and supplies their dependencies.
- **`@Transactional`:** Commonly uses proxy-based transaction advice around eligible method calls.
- **Bean scope:** Defines how and for how long Spring creates/manages bean instances.
- **N+1 query:** One query for parents plus extra queries for each parent's related data.
- **`flatMap()`:** Flattens nested streams into one stream.
- **Saga:** Coordinates local transactions with compensating actions.
- **Idempotency:** Repeating the same operation does not duplicate its intended effect.
- **Circuit breaker:** Temporarily blocks calls to a failing dependency.
- **CI/CD:** Automates build, test, package, release, deployment, and verification.

---

# 5. Interview Answering Strategy

For scenario questions, structure the answer as:

1. **Situation:** What were you building or testing?
2. **Problem:** What failed or what requirement did you have?
3. **Action:** What technical steps did you take?
4. **Result:** What improved, and how did you verify it?

For design questions, discuss trade-offs. For coding questions, explain assumptions, edge cases, complexity, and why the chosen algorithm works.

**Be accurate about experience:** If a tool or pattern is something you have studied rather than implemented in production, describe it as knowledge or a practice example rather than claiming professional hands-on experience.
