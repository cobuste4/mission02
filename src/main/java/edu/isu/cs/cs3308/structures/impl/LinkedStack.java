package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.Stack;

/**
 * @author Steve Coburn
 * DueDate: 27 January 2019
 * ISUCourse: CS3308
 * Instructor: Isaac Griffith
 * Project: mission02
 * Description: This class impliments a stack using a doubly linked list
 */

public class LinkedStack<E> implements Stack<E> {
    private DoublyLinkedList<E> DLL;

    // Constructor
    public LinkedStack(){
        DLL = new DoublyLinkedList<>();
    }

    @Override
    public void push(E element) {
        if (element != null) {
            DLL.addFirst(element);
        }
    }

    @Override
    public E peek() {
        return DLL.first();
    }

    @Override
    public E pop() {
        return DLL.removeFirst();
    }

    @Override
    public int size() {
        return DLL.size();
    }

    @Override
    public boolean isEmpty() {
        return DLL.isEmpty();
    }

    @Override
    public void transfer(Stack<E> to) {

    }

    @Override
    public void reverse() {

    }

    @Override
    public void merge(Stack<E> other) {

    }

    @Override
    public void printStack() {
        DLL.printList();
    }
}
