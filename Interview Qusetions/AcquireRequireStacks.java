import java.util.*;
class AcquireRequireStacks{

    public static int lockCheck(ArrayList<String> locks){
        
        Stack<Integer> locks_stack = new Stack<Integer>();

        for(int i=0; i<locks.size(); i++){
            
            String lock_type = locks.get(i).split(" ")[0];
            int lock_id = Integer.parseInt(locks.get(i).split(" ")[1]);

            if(lock_type.equals("ACQUIRE")){
                if(locks_stack.search(lock_id) == -1){
                    locks_stack.push(lock_id);
                }else{
                    System.out.println("Already Acquired lock - Deadlock @ "  + i+1);
                    return -1;
                }
            }else if(lock_type.equals("RELEASE")){

                if(!locks_stack.isEmpty()){
                    if(locks_stack.peek() == lock_id){
                        locks_stack.pop();
                    }else{
                        System.out.println(locks_stack);
                        if(locks_stack.search(locks.get(i)) == -1){
                            System.out.println("Can't release unacquired lock " + lock_id + " @ " + (i+1));
                            return -2;
                        }else{
                            System.out.println("Can't release the current lock. @ " + i+1);
                            return -1;
                        }
                        
                    }
                }else{
                    System.out.println("Can't release uncquired lock!");
                    break;
                }
                
            }
        }

        if(!locks_stack.isEmpty()){
            System.out.println("Following locks were not relased");
            System.out.println(locks_stack.toString());
            return -2;
        }else{
            System.out.println("All locks released!");
            return 0;
        }
    }

    public static void main(String args[]){

        ArrayList<String> locks = new ArrayList<String>();
        
        locks.add("ACQUIRE 364");
        locks.add("ACQUIRE 84");
        locks.add("RELEASE 84");
        locks.add("RELEASE 364");

        System.out.println(lockCheck(locks));
    }
}