package com.company;

public class MyLinkedList<T> implements List<T> {

    private int size = 0;
    private Node<T> first;
    private Node<T> last;
    private StringBuilder stringBuilder = new StringBuilder();

    @Override
    public void add(T value) {
        Node<T> newNode = new Node<>(last, value, null);
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    @Override
    public void add(T value, int index) {
        checkIndex(index);
        if (index == size) {
            add(value);
        }
        Node<T> prevNode = currentNode(index - 1);
        Node<T> nextNode = prevNode.next;
        Node<T> newNode = new Node<>(prevNode, value, nextNode);
        prevNode.next = newNode;
        nextNode.prev = newNode;
        size++;
    }

    @Override
    public void addAll(List<T> list) {
        if (isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            for (int i = 0; i < list.size(); i++) {
                add(list.get(i));
            }
        }
    }

    @Override
    public T get(int index) {
        if (checkIndex(index)) {
            return currentNode(index).item;
        }
        return null;
    }

    @Override
    public void set(T value, int index) {
        if (checkIndex(index)) {
            currentNode(index).item = value;
        }
    }

    @Override
    public T remove(int index) {
        if (checkIndex(index) && !isEmpty()) {
            Node<T> removeNode = currentNode(index);
            T value = removeNode.item;
            if (removeNode == last) {
                removeNode.prev = last;
            } else if (removeNode == first) {
                removeNode.next = first;
            } else {
                removeNode.prev.next = removeNode.next;
                removeNode.next.prev = removeNode.prev;
            }
            removeNode = new Node<>(null, null, null);
            size--;
            return value;
        }
        return null;
    }

    @Override
    public T remove(T t) {
        if (!isEmpty()) {
            Node<T> newNode = first;
            for (int i = 0; i < size; i++) {
                if (newNode.item.equals(t)) {
                    return remove(i);
                }
                newNode = newNode.next;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private Node<T> currentNode(int index) {
        Node<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;

        }
        return current;
    }

    public void printList() {
        System.out.println("My Linked List: ");
        Node<T> node = first;
        for (int i = 0; i < size; i++) {
            stringBuilder.append(node.item).append(", ");
            node = node.next;
        }
        System.out.println(stringBuilder);
        stringBuilder.setLength(0);
    }

    private boolean checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("Error. Your index wrote incorrectly.");
        }
        return true;
    }

    private static class Node<T> {
        private Node<T> next;
        private Node<T> prev;
        private T item;

        Node(Node<T> prev, T element, Node<T> next) {
            this.prev = prev;
            this.item = element;
            this.next = next;
        }
    }
}
