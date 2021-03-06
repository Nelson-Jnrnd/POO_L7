package util;

import java.util.EmptyStackException;

/**
 * Generic LIFO stack
 * @author Alen Bijelic
 * @author Nelson Jeanrenaud
 */
public class Stack<T> {

    private final Element<T> beforeBegin;

    private int size;

    /**
     * Stack constructor
     */
    public Stack() {
        beforeBegin = new Element<>(null, null);
        size = 0;
    }

    /**
     * Stack copy construcor
     * @param original Stack to copy from
     */
    public Stack(Stack<T> original) throws IllegalArgumentException {
        this();
        if(original == null)
            throw new IllegalArgumentException("Copy constructor was given null argument");
        Examinator<T> iterator = new Examinator<>(original.beforeBegin);
        while(iterator.hasNext()){
            push(iterator.next().getData());
        }
    }

    /**
     * Add new element in the stack containing the object
     * @param object Object to add into the stack
     */
    public T push(T object) {
        beforeBegin.next = new Element(object, beforeBegin.next);
        ++size;
        return object;
    }

    /**
     * Delete the top Element of the stack
     * @throws EmptyStackException If there is no Elements in the stack
     */
    public T pop() throws EmptyStackException {
        if(empty()){
            throw new EmptyStackException();
        }
        T returnVal = beforeBegin.next.getData();
        beforeBegin.next = beforeBegin.next.next;
        --size;
        return returnVal;
    }

    /**
     * Get Object on the top of the stack
     * @return Object on the top of the stack
     */
    public T peek() throws EmptyStackException {
        if(empty())
            throw new EmptyStackException();
        return beforeBegin.next.getData();
    }

    /**
     * Transoform Element of the stack to an array
     * @return Array containing all elements of the stack
     */
    public Object[] toArray() {
        // Return empty Object array if there is no elements in the stack
        if(empty())
            return new Object[]{};
        Object[] objects = new Object[size];
        Examinator<T> iterator = new Examinator<>(beforeBegin);
        int i = 0;
        while(iterator.hasNext()) {
            objects[i++] = iterator.next().getData();
        }
        return objects;
    }

    /**
     * Checks either the stack is empty or not
     * @return If the stack is empty
     */
    public boolean empty(){
        return beforeBegin.next == null;
    }

    /**
     * Get the stack size
     * @return Stack size
     */
    public int getSize() {
        return size;
    }

    /**
     * Return the stack formatted to string. Elements are separated with angle brackets
     * @return Stacke elements to string format
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ ");
        Examinator<T> iterator = new Examinator<>(beforeBegin);
        while(iterator.hasNext()) {
            stringBuilder.append("<" + iterator.next() + "> ");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}