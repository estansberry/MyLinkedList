public class Driver{
  public static void main(String[] args) {
    MyLinkedList newlist = new MyLinkedList();
    newlist.add("hello");
    newlist.add("hey");
    System.out.println(newlist.toString());
    System.out.println(newlist.getThisNode(0).getData());
  }
}
