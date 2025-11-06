package it.unibo.inner.api;

import java.util.Iterator;

public class IterableWithPolicyImpl<T> implements IterableWithPolicy<T>{

    private final T[] array; 
    private Predicate<T> filter;


    public IterableWithPolicyImpl(T[] elements, Predicate<T> filter) {
        this.array=elements;
        this.filter=filter;
    }

    public IterableWithPolicyImpl(T[] elements) {
        this(elements, new Predicate<T>() {
                @Override
                public boolean test(T elem) {
                    return true;
                }
            }
        );
    }

    private class FilterIterator implements Iterator<T>{

        private int index=0;

        public boolean hasNext() {
            while(index < array.length) {
                if(filter.test(array[index])) {
                    return true;
                }
                index++;
            }
            return false;
        }

        public T next() {
            if (hasNext()) {
                return array[index++];
            }
            throw new java.util.NoSuchElementException();
        }

    }
   
    public void setIterationPolicy(Predicate<T> filter) {
        this.filter = filter;
    }

    @Override
    public Iterator<T> iterator() {
        return new FilterIterator();
    }

}
