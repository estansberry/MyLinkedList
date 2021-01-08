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

  public String getNext(){
     return(next.getData());
   }

  public String getPrev(){
     return(prev.getData());
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
