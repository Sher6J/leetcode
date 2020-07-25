package cn.sher6j.concurrrency;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * @author sher6j
 * @create 2020-07-24-16:44
 */
public class BoundedHashSet<T> {
    private final Set<T> set;
    private final Semaphore sem;

    public BoundedHashSet(int bount) {
        this.set = Collections.synchronizedSet(new HashSet<>());
        this.sem = new Semaphore(bount);
    }

    public boolean add(T o) throws InterruptedException {
        sem.acquire();
        boolean isAdded = false;
        try {
            isAdded = set.add(o);
            return isAdded;
        } finally {
          if (!isAdded) sem.release();
        }
    }

    public boolean remove(Object o) {
        boolean isRemoved = set.remove(o);
        if (isRemoved) sem.release();
        return isRemoved;
    }

    @Override
    public String toString() {
        return "BoundedHashSet{" +
                "set=" + set +
                '}';
    }
}
