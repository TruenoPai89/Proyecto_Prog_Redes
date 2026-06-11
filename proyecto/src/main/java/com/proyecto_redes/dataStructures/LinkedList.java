package com.proyecto_redes.dataStructures;

public class LinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // Añade al final
    public void add(E element) throws ExceptionLinkedList {
        if (element == null) {
            throw new ExceptionLinkedList("No se permiten elementos nulos");
        }
        Node<E> newNode = new Node<>(element);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    // Inserta en posición específica
    public void add(int index, E element) throws ExceptionLinkedList {
        if (element == null) {
            throw new ExceptionLinkedList("No se permiten elementos nulos");
        }
        if (index < 0 || index > size) {
            throw new ExceptionLinkedList("Índice fuera de rango: " + index);
        }
        if (index == size) {
            add(element);
            return;
        }
        if (index == 0) {
            Node<E> newNode = new Node<>(element, head);
            head = newNode;
            if (tail == null) {
                tail = head;
            }
            size++;
            return;
        }
        Node<E> prev = getNodeAt(index - 1);
        Node<E> newNode = new Node<>(element, prev.getNext());
        prev.setNext(newNode);
        size++;
    }

    // Obtiene elemento por índice
    public E get(int index) throws ExceptionLinkedList {
        if (index < 0 || index >= size) {
            throw new ExceptionLinkedList("Índice fuera de rango: " + index);
        }
        return getNodeAt(index).getInfo();
    }

    // Elimina por índice
    public E remove(int index) throws ExceptionLinkedList {
        if (index < 0 || index >= size) {
            throw new ExceptionLinkedList("Índice fuera de rango: " + index);
        }
        E removed;
        if (index == 0) {
            removed = head.getInfo();
            head = head.getNext();
            if (head == null) {
                tail = null;
            }
        } else {
            Node<E> prev = getNodeAt(index - 1);
            Node<E> toRemove = prev.getNext();
            removed = toRemove.getInfo();
            prev.setNext(toRemove.getNext());
            if (prev.getNext() == null) {
                tail = prev;
            }
        }
        size--;
        return removed;
    }

    // Elimina la primera ocurrencia del elemento
    public boolean remove(E element) throws ExceptionLinkedList {
        if (element == null) {
            throw new ExceptionLinkedList("No se puede buscar un elemento nulo");
        }
        int index = indexOf(element);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    // Busca índice del elemento
    public int indexOf(E element) throws ExceptionLinkedList {
        if (element == null) {
            throw new ExceptionLinkedList("No se puede buscar un elemento nulo");
        }
        Node<E> current = head;
        int pos = 0;
        while (current != null) {
            if (element.equals(current.getInfo())) {
                return pos;
            }
            current = current.getNext();
            pos++;
        }
        return -1;
    }

    // Reemplaza elemento en una posición
    public E set(int index, E element) throws ExceptionLinkedList {
        if (element == null) {
            throw new ExceptionLinkedList("No se permiten elementos nulos");
        }
        if (index < 0 || index >= size) {
            throw new ExceptionLinkedList("Índice fuera de rango: " + index);
        }
        Node<E> node = getNodeAt(index);
        E old = node.getInfo();
        node.setInfo(element);
        return old;
    }

    public boolean contains(E element) throws ExceptionLinkedList {
        return indexOf(element) != -1;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public String toString() {
        if (head == null) return "[]";
        StringBuilder sb = new StringBuilder("[");
        Node<E> current = head;
        while (current != null) {
            sb.append(current.getInfo());
            if (current.getNext() != null) sb.append(", ");
            current = current.getNext();
        }
        sb.append("]");
        return sb.toString();
    }

    // Método auxiliar para obtener nodo en una posición
    private Node<E> getNodeAt(int index) throws ExceptionLinkedList {
        if (index < 0 || index >= size) {
            throw new ExceptionLinkedList("Índice fuera de rango: " + index);
        }
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current;
    }

    // Clase anidada para la excepción personalizada
    public static class ExceptionLinkedList extends Exception {
        public ExceptionLinkedList(String message) {
            super(message);
        }
    }
}