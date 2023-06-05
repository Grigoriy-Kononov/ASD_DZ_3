import java.util.Iterator;

public class Main {

  public static void main(String[] args) {
    SingleLinkList<ElementList> listList = new SingleLinkList<>();

    listList.addToEnd(new ElementList(" Иван "));
    listList.addToEnd(new ElementList(" Сергей "));
    listList.addToEnd(new ElementList(" Андрей "));
    listList.addToEnd(new ElementList(" Тимофей "));
    listList.addToEnd(new ElementList(" Александр "));

    for (Object ElementList : listList) {
      System.out.println(ElementList);
    }
    listList.reverse();

    System.out.println("-------------------------------------");

    for (Object ElementList : listList) {
      System.out.println(ElementList);
    }
  }

  static class ElementList {

    String name;

    public ElementList(String name) {
      this.name = name;
    }

    @Override
    public String toString() {
      return "Element{" +
          ", name='" + name + '\'' +
          '}';
    }
  }

  public static class SingleLinkList<T> implements Iterable {

    ListItem<T> head;
    ListItem<T> tail;

    @Override
    public Iterator iterator() {
      return new Iterator<T>() {
        ListItem<T> current = head;

        @Override
        public boolean hasNext() {
          return current != null;
        }

        @Override
        public T next() {
          T data = current.data;
          current = current.next;
          return data;
        }
      };
    }

    private static class ListItem<T> {

      T data;
      ListItem<T> next;
    }

    public boolean isEmpty() {
      return head == null;
    }

    public void addToEnd(T item) {

      ListItem<T> newItem = new ListItem<>();
      newItem.data = item;

      if (isEmpty()) {
        head = newItem;
        tail = newItem;
      } else {
        tail.next = newItem;
        tail = newItem;
      }
    }

    public void reverse() {
      if (!isEmpty() && head.next != null) {
        tail = head;
        ListItem<T> current = head.next;
        head.next = null;
        while (current != null) {
          ListItem<T> next = current.next;
          current.next = head;
          head = current;
          current = next;
        }
      }
    }
  }
}

