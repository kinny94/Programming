
 // The function that returns the length of the linkedList
 public int solution(){
    
    IntList temp = head;
    int count = 0;
    while(temp != null){
        count++;
        temp = temp.next;
    }

    return count;
}