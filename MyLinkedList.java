public class MyLinkedList{
 private int size;
 private Node start,end;
 public MyLinkedList(){
   size = 0;
   start = null;
   end = null;
 }
 public int size(){
   return(size);
 }
 public boolean add(String value){
   if(size == 0){
     start.setData(value);
     end.setData(value);
     start.setNext(end);
   }else if(size == 1){
     end.setData(value);
     start.setNext(end);
   }else{
     Node current = new Node(value);
     end.setNext(current);
     end = current;
   }
   size += 1;
   return(true);
 }

 public boolean add(int index, String value){
   if(index >= size){
     throw new IndexOutOfBoundsException("Your index is too big for this LinkedList!");
   }
   Node newnode = new Node(value);
   if(index == 0){
     start.setPrev(newnode);
     start = newnode;
   }else if(index == size - 1){
     end.setNext(newnode);
     end = newnode;
   }else{
     getThisNode(index).setPrev(newnode);
   }
   size += 1;
   return(true);
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
   String linkedstring = "";
   for(int i = 0; i < size; i ++){
     linkedstring = linkedstring + getThisNode(i);
   }
   return(linkedstring);
 }

 private Node getThisNode(int index){
   Node newnode = new Node("");
   for(int i = 0; i < index; i ++){
     if(i == 0){
       newnode = start.getNext();
     }else{
       newnode = newnode.getNext();
     }
   }return(newnode);
 }
}
