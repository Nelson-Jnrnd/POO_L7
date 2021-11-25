package util;

import java.util.EmptyStackException;

public class Stack<T> {
    private Element<T> beforeBegin;
    private Examinator<T> iterator;
    private int size = 0;

    public Stack() {
        beforeBegin = new Element<>(null, null);
        iterator = new Examinator<>(beforeBegin.next);
    }

    public void push(T object) throws RuntimeException {
        beforeBegin.next = new Element(object, beforeBegin.next);
        ++size;
    }

    public void pop() throws EmptyStackException {
        if(empty()){
            throw new EmptyStackException();
        }
        beforeBegin.next = beforeBegin.next.next;
    }

    /**
     *
     * @return
     */
    public T peek() throws EmptyStackException {
        if(empty())
            throw new EmptyStackException();
        return beforeBegin.next.data;
    }

    public Object[] toArray() throws EmptyStackException{
        if(empty())
            throw new EmptyStackException();
        Examinator<T> examinator = new Examinator<>(beforeBegin);
        Object[] objects = new Object[size];
        for(int i = 0; i < objects.length; ++i){
            objects[i] = examinator.next();
        }
        return objects;
    }

    /**
     *
     * @return
     */
    public boolean empty(){
        return beforeBegin.next == null;
    }

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