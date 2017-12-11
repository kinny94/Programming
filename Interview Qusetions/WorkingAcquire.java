class WorkingAcquire{
    
    static int check_log_history(String[] events) {
        Stack<Integer> locks_stack = new Stack<Integer>();
        
        for(int i=0; i<events.length; i++){
            String lock_type = events[i].split(" ")[0];
            int lock_id = Integer.parseInt(events[i].split(" ")[1]);
            
            if(lock_type.equals("ACQUIRE")){
                if(locks_stack.search(lock_id) == -1){
                    locks_stack.push(lock_id);
                }else{
                    return i+1;
                }
            }else{
                if(!locks_stack.empty()){
                    System.out.println(events[i]);
                    if(locks_stack.peek() == lock_id){
                        locks_stack.pop();
                    }else{
                        if(locks_stack.search(events[i]) == -1){
                            return i+1;
                        }else{
                            return i+1;
                        }
                    }
                }else{
                    break;
                }
                
            }
        }
        
        if(!locks_stack.empty()){
            return events.length + 1;
        }else{
            return 0;
        }
        
    }
    
    
}
}

public static void main(){
}
}


