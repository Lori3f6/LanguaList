package moe.langua.lab;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Langualist<T> implements List<T> {
    private Node<T> initialNode;
    private Node<T> lastNode;
    private int size = 0;
    private boolean modified = true;

    public int size() {
        if (!modified) return size;
        if (initialNode == null) {
            size = 0;
            modified = false;
            return size;
        } else {
            int count = 0;
            Node<T> pointer = initialNode;
            while (true) {
                count++;
                pointer = pointer.next;
                if (pointer == null) break;
            }
            size = count;
            modified = false;
            return count;
        }
    }

    public boolean isEmpty() {
        if (initialNode == null) {
            return true;
        } else {
            return false;
        }
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
        modified = true;
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
        initialNode = null;
        lastNode = null;
        modified = true;
    }

    public T get(int index) {
        Node<T> target = getNodeByIndex(index);
        if (target == null) {
            throw new IndexOutOfBoundsException();
        } else {
            return target.getData();
        }
    }

    public T set(int index, T element) {
        Node<T> target = getNodeByIndex(index);
        if (target == null) {
            throw new IndexOutOfBoundsException();
        } else {
            if (index != 0) {
                T t = target.data;
                Node<T> previous = target.getPrevious();
                Node<T> next = target.getNext();
                previous.setNext(new Node<T>(previous, element)).setNext(next);
                if (target == lastNode) {
                    lastNode = previous.next;
                }
                return t;
            } else {
                T t = target.data;
                Node<T> next = target.getNext();
                Node<T> n = new Node<T>(null, element);
                initialNode = n;
                if (target == lastNode) {
                    lastNode = n;
                }
                return t;
            }

        }
    }

    public void add(int index, T element) {
        modified = true;
        Node<T> target = getNodeByIndex(index);
        if (target == null) {
            throw new IndexOutOfBoundsException();
        } else {
            if (index != 0) {
                Node<T> p = target.getPrevious();
                Node<T> n = new Node<T>(p, element);
                n.setNext(target);
                target.setPrevious(n);
                p.setNext(n);
            } else {
                Node<T> n = new Node<T>(null, element);
                n.setNext(target);
                target.setPrevious(n);
                initialNode = n;
            }

        }
    }

    public T remove(int index) {
        return null;
    }

    public int indexOf(Object o) {
        int index = 0;
        Node<T> pointer = initialNode;
        while (true) {
            if (pointer.data.equals(o)) break;
            index++;
            pointer = pointer.next;
            if (pointer == null) return -1;
        }
        return index;
    }

    public int lastIndexOf(Object o) {
        int reverseIndex = 0;
        Node<T> pointer = lastNode;
        while (true) {
            if (pointer.data.equals(o)) break;
            reverseIndex++;
            pointer = pointer.previous;
            if (pointer == null) return -1;
        }
        int index = 0;
        if(modified){
            while (true) {
                pointer = pointer.previous;
                if (pointer != null) {
                    index++;
                } else {
                    return index;
                }
            }
        }else {
            return size-reverseIndex;
        }
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
        if (index < 0) throw new IndexOutOfBoundsException("Index must be greater than or equal to zero.");
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
