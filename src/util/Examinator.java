package util;

import java.util.Iterator;

public class Examinator<T> implements Iterator<Element<T>> {
    private Element<T> current;

    public Examinator(Element<T> current) {
        this.current = current;
    }

    public boolean hasNext(){
        return current.next != null;
    }

    public Element<T> next(){
        if(!hasNext()){
            return null;
        }
        current = current.next;
        return current;
    }
}