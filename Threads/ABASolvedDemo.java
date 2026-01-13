package Threads;

import java.util.concurrent.atomic.AtomicStampedReference;

public class ABASolvedDemo {

    static AtomicStampedReference<Integer> ref =
            new AtomicStampedReference<>(10, 1);

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            int[] stampHolder = new int[1];
            Integer value = ref.get(stampHolder);

            int stamp = stampHolder[0];
            System.out.println("T1 read value = " + value + ", stamp = " + stamp);

            try { Thread.sleep(2000); } catch (InterruptedException e) {}

            boolean success = ref.compareAndSet(
                    value,
                    20,
                    stamp,
                    stamp + 1
            );

            System.out.println("T1 CAS success = " + success +
                    ", current value = " + ref.getReference() +
                    ", current stamp = " + ref.getStamp());
        });

        Thread t2 = new Thread(() -> {
            try { Thread.sleep(500); } catch (InterruptedException e) {}

            int[] stampHolder = new int[1];
            Integer v1 = ref.get(stampHolder);
            int s1 = stampHolder[0];

            ref.compareAndSet(v1, 30, s1, s1 + 1);
            System.out.println("T2 changed 10 → 30");

            int[] stampHolder2 = new int[1];
            Integer v2 = ref.get(stampHolder2);
            int s2 = stampHolder2[0];

            ref.compareAndSet(v2, 10, s2, s2 + 1);
            System.out.println("T2 changed 30 → 10");
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}

/*
🔑 Short Direct Answer (lock this first)
❓ Does AtomicInteger(0) have ABA problem?

👉 YES, theoretically it CAN have ABA problem

❓ Is ABA solved using versioning?

👉 YES

❓ Is this the same idea as Optimistic Concurrency Control?

👉 YES — conceptually SAME IDEA

Now let’s go step by step, cleanly.

1️⃣ Does AtomicInteger suffer from ABA?
✔ Yes — in theory
❌ Rare in simple counters
⚠ Very real in pointer / reference-based scenarios
Why AtomicInteger can have ABA

AtomicInteger uses CAS:

CAS(memory, expected, new)


CAS only checks:

Is memory == expected ?


It does NOT check history.

So this is possible:

Value = 10

Thread-1 reads expected = 10
Thread-2 changes 10 → 20 → 10
Thread-1 CAS(10 → 30) ✅ succeeds


➡ CAS thinks nothing changed
➡ But value changed twice ❌
➡ ABA occurred

Why you usually DON’T notice ABA with AtomicInteger

Because:

Counters usually monotonically increase

Rarely go back to old value

No semantic meaning to intermediate values

So ABA exists mathematically, but usually harmless for counters.

2️⃣ When ABA becomes a REAL problem

ABA is dangerous when:

Using references

Using lock-free stacks / queues

Value identity matters

Example:

Node A → Node B → Node A


CAS sees A again and thinks nothing changed ❌

3️⃣ How Java SOLVES ABA
🔐 VERSIONING (STAMP)

Exactly like Optimistic Concurrency Control in DBs.

Java tools that solve ABA
Class	Solves ABA?
AtomicInteger	❌
AtomicReference	❌
AtomicStampedReference	✅
AtomicMarkableReference	✅
4️⃣ AtomicStampedReference = CAS + VERSION

Instead of storing just:

value


It stores:

(value, stamp)


CAS now checks:

value == expectedValue
AND
stamp == expectedStamp

 */
