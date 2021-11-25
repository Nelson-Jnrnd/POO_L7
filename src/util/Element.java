package util;

public class Element<T> {
    protected T data;
    protected Element<T> next;

    public Element(T data, Element<T> next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
