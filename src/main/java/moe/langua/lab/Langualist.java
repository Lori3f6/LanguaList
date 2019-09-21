package moe.langua.lab;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Langualist<T> implements List<T> {
    private Node<T> initial;

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
        Node<T> last = getTheLastNode();
        if(last==null){
            initial = new Node<T>(null,t);
        }else{
            last.setNext(new Node<T>(last,t));
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
        return null;
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

    private Node<T> getTheLastNode(){
        if(initial==null){
            return null;
        }else{
            Node<T> node = initial;
            while(true){
                if(initial.getNext()!=null){
                    node = initial.getNext();
                }else{
                    break;
                }
            }
            return node;
        }
    }

    private final class Node<T> {
        private Node<T> previous;
        private Node<T> next;
        private final T data;

        public Node(Node previousNode, T data) {
            this.previous = previousNode;
            this.data = data;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node<T> getPrevious() {
            return previous;
        }

        public Node<T> getNext() {
            return next;
        }

        public T getData() {
            return data;
        }
    }
}
