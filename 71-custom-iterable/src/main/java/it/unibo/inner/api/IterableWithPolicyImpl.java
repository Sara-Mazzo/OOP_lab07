package it.unibo.inner.api;

import java.util.Iterator;

public class IterableWithPolicyImpl<T> implements IterableWithPolicy<T>{

    private final T[] list; 

    public IterableWithPolicyImpl(T[] elements) {
        list=elements; 
    }

    private class IteratorImpl implements Iterator<T>{

        private int index=0;

        public boolean hasNext() {
            return index < list.length-1;
        }

        public T next() {
            if (hasNext()) {
                index++;
            }
            return list[index];
        }

    }
   
    public void setIterationPolicy(Predicate<T> filter) {

    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorImpl();
    }

    public String toString() {
        String tmp="[";
        for( int i=0;i<list.length-1;i++){
            tmp = tmp + "" + list[i] +", ";
        }
        tmp=tmp + list[list.length-1] +"]";
        return tmp;
    }

}
