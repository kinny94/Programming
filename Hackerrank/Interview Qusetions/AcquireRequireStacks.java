import java.util.*;
class AcquireRequireStacks{

    public static void lockCheck(ArrayList<String> locks){
        
        Stack<Integer> locks_stack = new Stack<Integer>();

        for(int i=0; i<locks.size(); i++){
            
            String lock_type = locks.get(i).split(" ")[0];
            int lock_id = Integer.parseInt(locks.get(i).split(" ")[1]);

            if(lock_type.equals("ACQUIRE")){
                if(locks_stack.search(lock_id) == -1){
                    locks_stack.push(lock_id);
                }else{
                    System.out.println("Already Acquired lock - Deadlock @ "  + i);
                }
            }else if(lock_type.equals("RELEASE")){

                if(locks_stack.peek() == lock_id){
                    locks_stack.pop();
                }else{
                    System.out.println("Can't release the current lock. @ " + i);
                }
            }
        }

        if(!locks_stack.isEmpty()){
            System.out.println("Not all locks released!");
        }else{
            System.out.println("All locks released!");
        }
    }

    public static void main(String args[]){

        ArrayList<String> locks = new ArrayList<String>();
        
        locks.add("ACQUIRE 123");
        locks.add("ACQUIRE 321");
        locks.add("RELEASE 123");

        lockCheck(locks);
    }
}