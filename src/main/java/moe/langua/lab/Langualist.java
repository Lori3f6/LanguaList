package moe.langua.lab;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Langualist<T> implements List<T> {
    private Node<T> initialNode;
    private Node<T> lastNode;
    private int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (size == 0) {
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
        int size = this.size();
        Object[] arr = new Object[size];
        Node<T> pointer = initialNode;
        int index = 0;
        while (true) {
            arr[index] = pointer.data;
            pointer = pointer.next;
            index++;
            if (pointer == null) break;
        }
        return arr;
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
        size++;
        return true;
    }

    public boolean remove(Object o) {
        if (isEmpty()) return false;
        Node<T> pointer = initialNode;
        while (true) {
            if (pointer.data.equals(o)) break;
            pointer = pointer.next;
            if (pointer == null) return false;
        }
        Node<T> p = pointer.previous;
        Node<T> n = pointer.next;
        if (p == null) {
            n.setPrevious(null);
            initialNode = n;
        } else {
            if (n == null) {
                lastNode = p;
                p.setNext(null);
            } else {
                p.setNext(n);
                n.setPrevious(p);
            }
        }
        size--;
        return true;
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
        size = 0;
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
                Node<T> previous = target.previous;
                Node<T> next = target.next;
                previous.setNext(new Node<T>(previous, element)).setNext(next);
                if (target == lastNode) {
                    lastNode = previous.next;
                }
                return t;
            } else {
                T t = target.data;
                Node<T> next = target.next;
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
        Node<T> target;
        target = getNodeByIndex(index);
        if (target == null) {
            throw new IndexOutOfBoundsException();
        } else {
            if (index != 0) {
                Node<T> p = target.previous;
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
        size++;
    }

    public T remove(int index) {
        Node<T> target = getNodeByIndex(index);
        if (target == null) throw new IndexOutOfBoundsException();
        if (index == 0) {
            initialNode = target.next;
            target.next.setPrevious(null);
            size--;
            return null;
        } else {
            Node<T> p = target.previous;
            Node<T> n = target.next;
            if (n != null) {
                p.setNext(n);
                n.setPrevious(p);
            } else {
                lastNode = p;
                p.setNext(null);
            }
            size--;
            return p.data;
        }
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
        return size - reverseIndex;
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
        if (isEmpty()) throw new IndexOutOfBoundsException();
        if (index < 0) throw new IndexOutOfBoundsException("Index must be greater than or equal to zero.");
        if (index < size >> 1) {
            Node<T> pointer = initialNode;
            for (int i = 0; i < index; i++) {
                try {
                    pointer = pointer.next;
                } catch (NullPointerException e) {
                    return null;
                }
            }
            return pointer;
        } else {
            Node<T> pointer = lastNode;
            int reverseIndex = size - index;
            for (int i = 0; i < reverseIndex; i++) {
                try {
                    pointer = pointer.previous;
                } catch (NullPointerException e) {
                    return null;
                }
            }
            return pointer;
        }
    }


    private static final class Node<T> {
        private Node<T> previous;
        private Node<T> next;
        private final T data;

        private Node(Node<T> previousNode, T data) {
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

        private T getData() {
            return data;
        }
    }
}
