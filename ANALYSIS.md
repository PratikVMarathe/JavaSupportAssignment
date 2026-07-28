# Task 2 Analysis

## 1. What is the exact cause of ConcurrentModificationException in Java?

ConcurrentModificationException occurs when a collection is structurally modified while it is being iterated using an Iterator or an enhanced for-loop, without using the Iterator's own modification methods. The iterator detects the unexpected structural modification through its internal modification count (`modCount`) and throws the exception.

## 2. What code pattern at line 142 most likely triggered this error?

The most likely cause is removing or adding elements directly to the same ArrayList while iterating over it, for example:

```java
for (Transaction transaction : transactions) {
    if (condition) {
        transactions.remove(transaction);
    }
}
```

## 3. Provide the minimal code change (one or two lines) that resolves this safely.

Iterate using an Iterator and remove elements through the iterator instead of the collection.

```java
Iterator<Transaction> iterator = transactions.iterator();

while (iterator.hasNext()) {
    Transaction transaction = iterator.next();

    if (shouldRemove(transaction)) {
        iterator.remove();
    }
}
```
