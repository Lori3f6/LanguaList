package moe.langua.lab;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.prefs.PreferenceChangeEvent;

public class Langualist<T> implements List<T> {
    private Node<T> initialNode;
    private Node<T> lastNode;

    public int size() {
        return 0;
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean contains(Object o) {
        return false;
    }

    public Iterator<T> iterator() {
        return null;
    }

    public Object[] toArray() {
        return new Object[0];
    }

    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    public boolean add(T t) {
        if (lastNode == null) {
            lastNode = initialNode = new Node<T>(null, t);
        } else {
            lastNode = lastNode.setNext(new Node<T>(lastNode, t));
        }
        return true;
    }

    public boolean remove(Object o) {
        return false;
    }

    public boolean containsAll(Collection<?> c) {
        return false;
    }

    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    public boolean removeAll(Collection<?> c) {
        return false;
    }

    public boolean retainAll(Collection<?> c) {
        return false;
    }

    public void clear() {

    }

    public T get(int index) {
        Node<T> target = getNodeByIndex(index);
        if(target == null){
            throw new IndexOutOfBoundsException();
        }else {
            return target.getData();
        }
    }

    public T set(int index, T element) {
        return null;
    }

    public void add(int index, T element) {

    }

    public T remove(int index) {
        return null;
    }

    public int indexOf(Object o) {
        return 0;
    }

    public int lastIndexOf(Object o) {
        return 0;
    }

    public ListIterator<T> listIterator() {
        return null;
    }

    public ListIterator<T> listIterator(int index) {
        return null;
    }

    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    private Node<T> getNodeByIndex(int index) {
        Node<T> target = initialNode;
        for (int i = 0; i < index; i++) {
            try {
                target = target.getNext();
            } catch (NullPointerException e) {
                return null;
            }
        }
        return target;
    }

    private final class Node<T> {
        private Node<T> previous;
        private Node<T> next;
        private final T data;

        private Node(Node previousNode, T data) {
            this.previous = previousNode;
            this.data = data;
        }

        private Node<T> setPrevious(Node<T> previous) {
            this.previous = previous;
            return previous;
        }

        private Node<T> setNext(Node<T> next) {
            this.next = next;
            return next;
        }

        private Node<T> getPrevious() {
            return previous;
        }

        private Node<T> getNext() {
            return next;
        }

        private T getData() {
            return data;
        }
    }
}
