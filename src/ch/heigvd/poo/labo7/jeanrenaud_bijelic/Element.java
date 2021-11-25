package ch.heigvd.poo.labo7.jeanrenaud_bijelic;

public class Element<T> {
    protected T data;
    protected Element<T> next;

    public T getData() {
        return data;
    }

    public Element(T data, Element<T> next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
