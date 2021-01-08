public class MyLinkedList{
 private int size;
 private Node start,end;
 public MyLinkedList(){
   size = 0;
 }
 public int size(){
   return(size);
 }
 public boolean add(String value){
   Node current = new Node(value);
   if(size == 0){
     start = current;
     end = current;
     start.setNext(end);
     end.setPrev(start);
   }else if(size == 1){
     end = current;
     start.setNext(end);
     end.setPrev(start);
     System.out.println(this.toString());

   }else{
     end.setNext(current);
     current.setPrev(end);
     end = current;
   }
   size ++;
   return(true);
 }

 public void add(int index, String value){
   if(index > size){
     throw new IndexOutOfBoundsException("Your index is too big for this LinkedList!");
   }
   Node newnode = new Node(value);
   if (size == 0){
     start = newnode;
     end = newnode;
     start.setNext(end);
     end.setPrev(start);
   }
   if(index == 0){
     start.setPrev(newnode);
     newnode.setNext(start);
     start = newnode;
   }else if(index == size - 1){
     end.setNext(newnode);
     newnode.setPrev(end);
     end = newnode;
   }else{
     getThisNode(index).setPrev(newnode);
     newnode.setNext(getThisNode(index));
   }
   size += 1;
 }
 public String get(int index){
   if(index >= size){
     throw new IndexOutOfBoundsException("Your index is too big for this LinkedList!");
   }return(getThisNode(index).getData());
 }

 public String set(int index, String value){
   if(index >= size){
     throw new IndexOutOfBoundsException("Your index is too big for this LinkedList!");
   }
   String oldvalue = getThisNode(index).getData();
   getThisNode(index).setData(value);
   return(oldvalue);
 }
 public String toString(){
   if(size == 0){
     return("[]");
   }
   String linkedstring = "[";
   for(int i = 0; i < size - 1; i ++){
     linkedstring = linkedstring + getThisNode(i).getData();
     linkedstring = linkedstring + ", ";
   }linkedstring = linkedstring + getThisNode(size - 1).getData();
   linkedstring = linkedstring + "]";
   System.out.println(start.getData());
   System.out.println(end.getData());
   return(linkedstring);
 }

 public Node getThisNode(int index){
   Node newnode = start;
   for(int i = 0; i < index - 1; i ++){
       newnode = newnode.getNext();
   }return(newnode);
 }
}
