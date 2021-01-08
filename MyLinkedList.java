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
   }else{
     end.setNext(current);
     current.setPrev(end);
     end = current;
   }
   size ++;
   return(true);
 }

 public boolean add(int index, String value){
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
   }else if(index == size){
     end.setNext(newnode);
     newnode.setPrev(end);
     end = newnode;
   }else{
     Node newPrev = getThisNode(index - 1);
     Node newNext = getThisNode(index);
     newnode.setPrev(newPrev);
     newnode.setNext(newNext);
     newPrev.setNext(newnode);
     newNext.setPrev(newnode);
   }
   size += 1;
   return(true);
 }

 public String remove(int index){
   if(size == 0 || index >= size){
     throw new IndexOutOfBoundsException("That index is out of bounds for this LinkedList!");
   }String oldval = getThisNode(index).getData();
   if(index == 0 & size == 1){
     start = null;
     end = null;
   }else if(index == 0){
     start = start.getNext();
   }else if (index == size - 1){
     end = end.getPrev();
   }else{
     getThisNode(index - 1).setNext(getThisNode(index + 1));
     getThisNode(index + 1).setPrev(getThisNode(index - 1));
   }
   size --;
   return(oldval);
 }

 public void extend(MyLinkedList other){
   if(size == 0){
     start = other.start;
     end = other.end;
     size = other.size();
   }else if (other.size == 0){
     size = size;
   }else{
     end.setNext(other.start);
     other.start.setPrev(end);
     end = other.end;
     size = size + other.size();
     other.size = 0;
     other.start = null;
     other.end = null;
   }
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
   return(linkedstring);
 }

 private Node getThisNode(int index){
   if (index == 0) {
     return start;
  }if (index == size - 1) {
    return end;
  }
   Node newnode = start;
   for(int i = 0; i < index; i ++){
       newnode = newnode.getNext();
   }return(newnode);
 }
}
