package ch.heigvd.poo.labo7.jeanrenaud_bijelic;

import EX_ObjectList.src.Examinator;
import EX_ObjectList.src.ObjectList;

public class Stack<T> {
    private ObjectList<T> list;

    private Examinator<T> iterator;

    public Stack() {
        this.list = new ObjectList<>();
        //this.iterator = new Examinator((Element) values.get(0));
    }

    public void push(T object) throws RuntimeException {
        list.insert(object);
    }

    public void pop() throws RuntimeException {
        list.remove(list.front());
    }

    /**
     *
     * @return
     */
    public T peek(){
        if(list.isEmpty())
            throw new RuntimeException();
        return list.front().next().getData();
    }

    public Object[] toArray(){
        if(list.isEmpty())
            throw new RuntimeException();
        Examinator<T> examinator = list.front();
        Object[] objects = new Object[list.size()];
        for(int i = 0; i < objects.length; ++i){
            objects[i] = list.get(i);
        }
        return objects;
    }

    /**
     *
     * @return
     */
    public boolean empty(){
        return list.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ ");
        Examinator<T> iterator = list.front();
        while(iterator.hasNext()) {
            stringBuilder.append("<" + iterator.next() + "> ");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public Examinator<T> front(){
        return list.front();
    }
}