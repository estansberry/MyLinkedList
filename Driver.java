public class Driver{
  public static void main(String[] args) {
    MyLinkedList newlist = new MyLinkedList();
    newlist.add("hello");
    newlist.add("hey");
    MyLinkedList nextlist = new MyLinkedList();
    nextlist.add("yes");
    nextlist.add("no");
    newlist.extend(nextlist);
    System.out.println(newlist.toString());
    newlist.remove(3);
    System.out.println(newlist.toString());
  }
}
