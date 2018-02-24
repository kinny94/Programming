import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

class Solution{

    // Creting an arraylist to store all the items to wear before leaving the house
    static ArrayList<String> itemsWearing = new ArrayList<>();

    public static void main( String args[] ){

        System.out.println(" Enter Commands ");
        Scanner scan = new Scanner( System.in );
        String input = scan.nextLine().replaceAll(",", "");
        String[] commands = input.split(" ");
       
        System.out.println( processCommand( commands ) );    
    
    }
    
    public static ArrayList hotConditions( HotWeather hotWeatherDetails, String[] commands ){

        //ArrayList<String> itemsWearing = new ArrayList<>();

        boolean pantsOn = false;
        boolean shirtOn = false;
        boolean shoesOn = false;
        
        for( int i=2; i<commands.length; i++){
            
            switch ( commands[i] ) {
                case "1" :

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
                               
                case "2":
                    
                    if( itemsWearing.contains( hotWeatherDetails.getHeadwear() )){
                        itemsWearing.add( "fail" );
                        return itemsWearing;
                    };

                    if( shirtOn ){
                        itemsWearing.add( hotWeatherDetails.getHeadwear() );
                        break;
                    }else{
                        itemsWearing.add( "fail" );
                        return itemsWearing;
                    }   
                    
                case "3":
                    itemsWearing.add( "fail" );
                    return itemsWearing;

                case "4":
                    
                    if( itemsWearing.contains( hotWeatherDetails.getShirt() )){
                        itemsWearing.add( "fail" );
                        return itemsWearing;
                    };

                    itemsWearing.add( hotWeatherDetails.getShirt() );
                    shirtOn = true;
                    break;
                
                case "5":
                    itemsWearing.add( "fail" );
                    return itemsWearing;    

                case "6":

                    if( itemsWearing.contains( hotWeatherDetails.getPants() )){
                        itemsWearing.add( "fail" );
                        return itemsWearing;
                    };

                    itemsWearing.add( hotWeatherDetails.getPants() );
                    pantsOn = true;
                    break;

                case "7":

                    if( itemsWearing.contains( hotWeatherDetails.getLeavingHouse()) || !shoesOn ){
                        itemsWearing.add( "fail" );
                        return itemsWearing;
                    };

                    if( i == commands.length - 1 ){
                        itemsWearing.add( hotWeatherDetails.getLeavingHouse());
                        break;
                    }else{
                        itemsWearing.add( "fail" );
                        return itemsWearing;
                    }
                    
                case "8": 
                    itemsWearing.add( "fail" );
                    return itemsWearing;
                    
                default:
                    itemsWearing.add( "fail" );
                    return itemsWearing;
            }
        }

        return itemsWearing;
    
    }

    public static ArrayList coldConditions( ColdWeather coldWeatherConditions, String[] commands ){

        boolean pantsOn = false;
        boolean shirtOn = false;
        boolean socksOn = false;
        boolean shoesOn = false;
        
        for( int i=2; i<commands.length; i++){
            switch ( commands[i] ) {
                case "1" :
                    
                    if( itemsWearing.contains( coldWeatherConditions.getFootWear() )){
                        itemsWearing.add( "fail" );
                        return itemsWearing;
                    };

                    if( socksOn ){
                        shoesOn = true;
                        itemsWearing.add( coldWeatherConditions.getFootWear() );
                        break;
                    }else{
                        itemsWearing.add( "fail" );
                        return itemsWearing;
                    }
                               
                case "2":

                    if( itemsWearing.contains( coldWeatherConditions.getHeadwear() )){
                        itemsWearing.add( "fail" );
                        return itemsWearing;
                    };

                    if( shirtOn ){
                        itemsWearing.add( coldWeatherConditions.getHeadwear() );
                        break;
                    }else{
                        itemsWearing.add( "fail" );
                        return itemsWearing;
                    }   
                    
                case "3":

                    if( itemsWearing.contains( coldWeatherConditions.getSocks() )){
                        itemsWearing.add( "fail" );
                        return itemsWearing;
                    };

                    socksOn = true;
                    itemsWearing.add( coldWeatherConditions.getSocks() );
                    break;

                case "4":

                    if( itemsWearing.contains( coldWeatherConditions.getShirt() )){
                        itemsWearing.add( "fail" );
                        return itemsWearing;
                    };

                    shirtOn = true;
                    itemsWearing.add( coldWeatherConditions.getShirt() );
                    break;
                
                case "5":

                    if( itemsWearing.contains( coldWeatherConditions.getJacket() )){
                        itemsWearing.add( "fail" );
                        return itemsWearing;
                    };

                    if( shirtOn ){
                        itemsWearing.add( coldWeatherConditions.getJacket() );
                        break; 
                    }else{
                        itemsWearing.add( "fail" );
                        return itemsWearing;
                    }   

                case "6":


                    if( itemsWearing.contains( coldWeatherConditions.getPants() )){
                        itemsWearing.add( "fail" );
                        return itemsWearing;
                    };

                    pantsOn = true;
                    itemsWearing.add( coldWeatherConditions.getPants() );
                    break;

                case "7":
                    
                    if( !shoesOn ){
                        itemsWearing.add( "fail" );
                        return itemsWearing; 
                    }

                    if( itemsWearing.contains( coldWeatherConditions.getLeavingHouse() )){
                        itemsWearing.add( "fail" );
                        return itemsWearing; 
                    };

                    if( i == commands.length - 1 ){
                        itemsWearing.add( coldWeatherConditions.getLeavingHouse());
                        break;
                    }else{
                        itemsWearing.add( "fail" );
                        return itemsWearing;
                    }

                case "8": 
                    itemsWearing.add( "fail" );
                    return itemsWearing;

                default:
                    itemsWearing.add( "fail" );
                    return itemsWearing;
            }
        }

        return itemsWearing;
    }

    public static String processCommand( String[] commands ){
        
        //System.out.println( Arrays.toString( commands ) );

        if( !commands[1].equals( "8" )){
            itemsWearing.add("fail");
            String finalString = Arrays.toString( itemsWearing.toArray());
            return finalString.replaceAll("[\\[\\](){}]", "");
        }else{
            itemsWearing.add("Removing PJs");
        }
        
        if( commands[0].toUpperCase().equals( "HOT" )){

            HotWeather hotWeather = new HotWeather();
            hotConditions( hotWeather, commands );

        }else if( commands[0].toUpperCase().equals( "COLD" )){

            ColdWeather coldWeather = new ColdWeather();
            coldConditions( coldWeather, commands );

        }

        String finalString = Arrays.toString( itemsWearing.toArray());
        return finalString.replaceAll("[\\[\\](){}]", "");
    }

     
}