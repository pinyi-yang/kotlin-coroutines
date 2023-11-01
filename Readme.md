# Kotlin Coroutine Study Notes

**Reference:** https://kotlinlang.org/docs/coroutines-basics.html#structured-concurrency

**Library:**
```
<dependency>
    <groupId>org.jetbrains.kotlinx</groupId>
    <artifactId>kotlinx-coroutines-core</artifactId>
    <version>1.7.2</version>
</dependency>
```
## Terms
- coroutine builder
- suspending function
  - does not block the underlying thread
- structured concurrency
  - An outer scope cannot complete until all its children coroutines complete.
- 