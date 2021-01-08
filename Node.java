public class Node{
  private String data;
  private Node next,prev;
  public Node(String value){
     data = value;
     next = null;
     prev = null;
   }


  public String getData(){
     return(data);
   }

  public Node getNext(){
     return(next);
   }

  public Node getPrev(){
     return(prev);
   }

  public String setData(String value){
    String oldval = data;
    data = value;
    return(oldval);
   }

  public void setNext(Node value){
    next = value;
    value.setPrev(this);
   }

  public void setPrev(Node value){
    prev = value;
    value.setNext(this);
   }
}
