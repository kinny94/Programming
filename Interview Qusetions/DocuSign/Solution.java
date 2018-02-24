import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

class Solution{

    // Creting an arraylist to store all the items to wear before leaving the house
    static ArrayList<String> itemsWearing = new ArrayList<>();

    public static void main( String args[] ){

        // Running the provided input first.
        System.out.println();
        ArrayList<String> inputs = new ArrayList<String>();
        System.out.println("Running provided input...");
        System.out.println();

        inputs.add("HOT 8, 6, 4, 2, 1, 7");
        inputs.add("COLD 8, 6, 3, 4, 2, 5, 1, 7");
        inputs.add("HOT 8, 6, 6");
        inputs.add("HOT 8, 6, 3");
        inputs.add("COLD 8, 6, 3, 4, 2, 5, 7");
        inputs.add("COLD 6");

        for(String current: inputs){
            System.out.println( current );
            String[] commands = current.replaceAll(",", "").split(" ");

            System.out.println( processCommand( commands ) );
            
            itemsWearing.clear();
            System.out.println();
        }


        // Getting inputs from the user 
        System.out.println(" Enter your custom input ");
        Scanner scan = new Scanner( System.in );

        // Removing all commas from the input string and creating an array of commands
        try{
            String input = scan.nextLine();
            String[] commands = input.replaceAll(",", "").split(" ");
       
            // Calling the process command function
            System.out.println( processCommand( commands ) );

        }catch( Exception e){
            System.out.println("You have entered invalid data");
        }

        
    
    }

    public static ArrayList hotConditions( HotWeather hotWeatherDetails, String[] commands ){

        // Creating variable to check pre-requisite conditions
        boolean pantsOn = false;
        boolean shirtOn = false;
        boolean shoesOn = false;
        
        for( int i=2; i<commands.length; i++){
            
            switch ( commands[i] ) {
                
                // Puttin on Socks
                case "1" :
                    
                    // It already wearing socks, cannot wear again, return fail 
                    if( itemsWearing.contains( hotWeatherDetails.getFootWear() )){
                        itemsWearing.add( "fail" );
                        return itemsWearing;
                    };

                    if( pantsOn ){
                        shoesOn = true;
                        itemsWearing.add( hotWeatherDetails.getFootWear() );
                        break;
                    }else{
                        itemsWearing.add( "fail" );
                        return itemsWearing;
                    }
                    
                // Putting on Headwear    
                case "2":
                    
                    if( itemsWearing.contains( hotWeatherDetails.getHeadwear() )){
                        
                        // If already wearig a headwear, cannot wear again, return fail
                        itemsWearing.add( "fail" );
                        return itemsWearing;
                    };

                    // Checking if wearing shirt before putting on headwear
                    if( shirtOn ){

                        // If wearing shirt, put on headwear
                        itemsWearing.add( hotWeatherDetails.getHeadwear() );
                        break;
      
                    }else{

                        // If not wearing shirt, return "fail"
                        itemsWearing.add( "fail" );
                        return itemsWearing;
                    }   
                    
                // Puttin on Socks
                case "3":

                    // Cannot wear socks, when its hot, return "fail"
                    itemsWearing.add( "fail" );
                    return itemsWearing;

                // Puttin on shirt
                case "4":
                    
                    // Checking if already wearing a shirt or not.
                    if( itemsWearing.contains( hotWeatherDetails.getShirt() )){
                       
                        // If already wearing shirt, return false
                        itemsWearing.add( "fail" );
                        return itemsWearing;
                    };

                    // If not wearing shirt, then wear shirt.
                    itemsWearing.add( hotWeatherDetails.getShirt() );
                    shirtOn = true;
                    break;
                
                // Putting on Jacket
                case "5":

                    // Cannot wear Jacket when its hot, return "fail"
                    itemsWearing.add( "fail" );
                    return itemsWearing;    
                
                // Put on Pants
                case "6":

                    // Check if its already wearing pants or not.
                    if( itemsWearing.contains( hotWeatherDetails.getPants() )){

                        // If already wearing pants,  return false
                        itemsWearing.add( "fail" );
                        return itemsWearing;
                    };

                    // If not wearing pants, wear pants
                    itemsWearing.add( hotWeatherDetails.getPants() );
                    pantsOn = true;
                    break;

                // Leave house
                case "7":

                    // Checking if wearing shoes or not
                    if( !shoesOn ){

                       // If not wearing shoes, cannot leave house, return "fail"
                       itemsWearing.add( "fail" );
                       return itemsWearing; 
                    
                    }

                    // Checking if already left house of not
                    if( itemsWearing.contains( hotWeatherDetails.getLeavingHouse()) || !shoesOn ){

                        // If already left house, return false
                        itemsWearing.add( "fail" );
                        return itemsWearing;
                    
                    };

                    // Checking if "Leaving the house" is the last thing to do
                    if( i == commands.length - 1 ){

                        // If it is the last thing to do, then leave house
                        itemsWearing.add( hotWeatherDetails.getLeavingHouse());
                        break;
                    
                    }else{

                        // If it is not, return fail
                        itemsWearing.add( "fail" );
                        return itemsWearing;
                    
                    }
                
                // Taking off Pyjamas
                case "8": 

                    // Cannot take off Pyjamas again
                    itemsWearing.add( "fail" );
                    return itemsWearing;
                    
                // Anything else
                default:

                    itemsWearing.add( "fail" );
                    return itemsWearing;
            }
        }

        return itemsWearing;
    
    }

    public static ArrayList coldConditions( ColdWeather coldWeatherConditions, String[] commands ){

        // Creating variable to check pre-requisite conditions
        boolean pantsOn = false;
        boolean shirtOn = false;
        boolean socksOn = false;
        boolean shoesOn = false;
        
        for( int i=2; i<commands.length; i++){
            switch ( commands[i] ) {

                // Putting on footwear
                case "1" :
                    
                    // If already wearing footwear, cannot wear again, return "fail" 
                    if( itemsWearing.contains( coldWeatherConditions.getFootWear() )){
                        itemsWearing.add( "fail" );
                        return itemsWearing;
                    };

                    // Checking if socks are on or not. If not, return "fail"
                    if( socksOn ){

                        // If wearing socks, then wear shoes
                        shoesOn = true;
                        itemsWearing.add( coldWeatherConditions.getFootWear() );
                        break;

                    }else{

                        // If not wearing any, return "fail"
                        itemsWearing.add( "fail" );
                        return itemsWearing;
                        
                    }
                
                // Putting on headwear
                case "2":

                    // If already wearing headwear, then return "fail"
                    if( itemsWearing.contains( coldWeatherConditions.getHeadwear() )){
                        itemsWearing.add( "fail" );
                        return itemsWearing;
                    };

                    // Can only wear headwear if waering shirt 
                    if( shirtOn ){
                        itemsWearing.add( coldWeatherConditions.getHeadwear() );
                        break;
                    }else{

                        // If not wearing shirt, return "fail"
                        itemsWearing.add( "fail" );
                        return itemsWearing;
                    }   
                    
                // Putting on Socks
                case "3":

                    // Cannot wear socks, it already wearing, return "fail"
                    if( itemsWearing.contains( coldWeatherConditions.getSocks() )){
                        
                        itemsWearing.add( "fail" );
                        return itemsWearing;
                    
                    };

                    // If not wearing socks, wear socks
                    socksOn = true;
                    itemsWearing.add( coldWeatherConditions.getSocks() );
                    break;

                // Putting on Shirt
                case "4":

                    // Checking if already wearing shirt of not
                    if( itemsWearing.contains( coldWeatherConditions.getShirt() )){
                        
                        itemsWearing.add( "fail" );
                        return itemsWearing;
                    };

                    // If not wearing shirt, then wear it.
                    shirtOn = true;
                    itemsWearing.add( coldWeatherConditions.getShirt() );
                    break;
                
                // Putting on Jacket
                case "5":

                    // Checking if already wearing jacket or not
                    if( itemsWearing.contains( coldWeatherConditions.getJacket() )){

                        itemsWearing.add( "fail" );
                        return itemsWearing;

                    };

                    // Can only wear jacket, if wearing shirt, else return "fail"
                    if( shirtOn ){
                        
                        itemsWearing.add( coldWeatherConditions.getJacket() );
                        break; 
                    
                    }else{

                        itemsWearing.add( "fail" );
                        return itemsWearing;
                    
                    }   

                // Putting on Pants
                case "6":

                    // Checking if already wearing pants
                    if( itemsWearing.contains( coldWeatherConditions.getPants() )){

                        itemsWearing.add( "fail" );
                        return itemsWearing;
                    
                    };

                    // If not wearing pants, then wear 
                    pantsOn = true;
                    itemsWearing.add( coldWeatherConditions.getPants() );
                    break;

                // Leave house
                case "7":
                    
                    // If not wearing shoes, cannot go out. Return "fail"
                    if( !shoesOn ){

                        itemsWearing.add( "fail" );
                        return itemsWearing; 
                    
                    }

                    // If already left house, cannot leave again
                    if( itemsWearing.contains( coldWeatherConditions.getLeavingHouse() )){

                        itemsWearing.add( "fail" );
                        return itemsWearing; 
                    
                    };

                    // Checking if Leaving house is the last thing to do or not.
                    if( i == commands.length - 1 ){

                        // If its the last thing to do, leave house
                        itemsWearing.add( coldWeatherConditions.getLeavingHouse());
                        break;

                    }else{

                        // If its not the last thing to do, return "fail"
                        itemsWearing.add( "fail" );
                        return itemsWearing;
                    
                    }
                
                // Removing PJS
                case "8": 
                    
                    // Cannot remove pyajamas again, return "fail"
                    itemsWearing.add( "fail" );
                    return itemsWearing;

                // For anything else, wrong input
                default:
                    itemsWearing.add( "fail" );
                    return itemsWearing;
            }
        }   

        return itemsWearing;
    }

    public static String processCommand( String[] commands ){

        // Checking if the first is "Removing PJS"or not.  
        if( !commands[1].equals( "8" )){
            
            // If not then add "fail" to the list and return
            itemsWearing.add("fail");
            String finalString = Arrays.toString( itemsWearing.toArray());
            return finalString.replaceAll("[\\[\\](){}]", "");
        
        }else{

            // If not then added the first task as "Removing PJs"
            itemsWearing.add("Removing PJs");

        }
        
        // Converting the first command to uppercase and check if its HOT ot COLD
        if( commands[0].toUpperCase().equals( "HOT" )){

            // Creating an object of the HotWeather Class
            HotWeather hotWeather = new HotWeather();
            hotConditions( hotWeather, commands );

        }else if( commands[0].toUpperCase().equals( "COLD" )){

            // Creating an object of the ColdWeather Class
            ColdWeather coldWeather = new ColdWeather();
            coldConditions( coldWeather, commands );

        }else{

            // Return false if its something else
            itemsWearing.add( "fail" );
        }

        // Returning string according to the output requirements
        String finalString = Arrays.toString( itemsWearing.toArray());
        return finalString.replaceAll("[\\[\\](){}]", "");
    }
}