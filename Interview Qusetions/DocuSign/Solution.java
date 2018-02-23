import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

class Solution{

    public static boolean hotConditions( HotWeather hotWeatherDetails, String[] commands ){

        ArrayList<String> itemsWearing = new ArrayList<>();
    
        boolean allConditionsSatisfied = false;
        boolean pantsOn = false;
        boolean shirtOn = false;
        
        for( int i=2; i<commands.length; i++){
            switch ( commands[i] ) {
                case "1" :

                    if( itemsWearing.contains( hotWeatherDetails.getFootWear() )){
                        return false;
                    };

                    if( pantsOn ){
                        itemsWearing.add( hotWeatherDetails.getFootWear() );
                        break;
                    }else{
                        return false;
                    }
                               
                case "2":
                    
                    if( itemsWearing.contains( hotWeatherDetails.getHeadwear() )){
                        return false;
                    };

                    if( shirtOn ){
                        itemsWearing.add( hotWeatherDetails.getHeadwear() );
                        break;
                    }else{
                        return false;
                    }   
                    
                case "3":
                    return false;

                case "4":
                    
                    if( itemsWearing.contains( hotWeatherDetails.getShirt() )){
                        return false;
                    };

                    itemsWearing.add( hotWeatherDetails.getShirt() );
                    shirtOn = true;
                    break;
                
                case "5":
                    return false;    

                case "6":

                    if( itemsWearing.contains( hotWeatherDetails.getPants() )){
                        return false;
                    };

                    itemsWearing.add( hotWeatherDetails.getPants() );
                    pantsOn = true;
                    break;

                case "7":

                    if( itemsWearing.contains( hotWeatherDetails.getLeavingHouse() )){
                        return false;
                    };

                    if( i == commands.length - 1 ){
                        itemsWearing.add( hotWeatherDetails.getLeavingHouse());
                        break;
                    }else{
                        return false;
                    }
                    
                default:
                    break;
            }
        }

        return true;
    
    }

    public static boolean coldConditions( ColdWeather coldWeatherConditions, String[] commands ){

        ArrayList<String> itemsWearing = new ArrayList<>();

        boolean allConditionsSatisfied = false;
        boolean pantsOn = false;
        boolean shirtOn = false;
        boolean socksOn = false;
        
        for( int i=2; i<commands.length; i++){
            switch ( commands[i] ) {
                case "1" :

                    if( itemsWearing.contains( coldWeatherConditions.getFootWear() )){
                        return false;
                    };

                    if( socksOn ){
                        itemsWearing.add( coldWeatherConditions.getFootWear() );
                        break;
                    }else{
                        return false;
                    }
                               
                case "2":

                    if( itemsWearing.contains( coldWeatherConditions.getHeadwear() )){
                        return false;
                    };

                    if( shirtOn ){
                        itemsWearing.add( coldWeatherConditions.getHeadwear() );
                        break;
                    }else{
                        return false;
                    }   
                    
                case "3":

                    if( itemsWearing.contains( coldWeatherConditions.getSocks() )){
                        return false;
                    };

                    socksOn = true;
                    itemsWearing.add( coldWeatherConditions.getSocks() );
                    break;

                case "4":

                    if( itemsWearing.contains( coldWeatherConditions.getShirt() )){
                        return false;
                    };

                    shirtOn = true;
                    itemsWearing.add( coldWeatherConditions.getShirt() );
                    break;
                
                case "5":

                    if( itemsWearing.contains( coldWeatherConditions.getJacket() )){
                        return false;
                    };

                    if( shirtOn ){
                        itemsWearing.add( coldWeatherConditions.getJacket() );
                        break; 
                    }else{
                        System.out.println( "Wear shirt first ");
                        return false;
                    }   

                case "6":

                    if( itemsWearing.contains( coldWeatherConditions.getPants() )){
                        return false;
                    };

                    pantsOn = true;
                    itemsWearing.add( coldWeatherConditions.getPants() );
                    break;

                case "7":
                    
                    if( itemsWearing.contains( coldWeatherConditions.getLeavingHouse() )){
                        return false;
                    };

                    if( i == commands.length - 1 ){
                        itemsWearing.add( coldWeatherConditions.getLeavingHouse());
                        break;
                    }else{
                        return false;
                    }

                default:
                    break;
            }
        }

        return true;
    
    }

    public static boolean processCommand( String[] commands ){
        
        //System.out.println( Arrays.toString( commands ) );

        boolean validCommands = false;
        
        if( !commands[1].equals( "8" )){
            return false;
        }
        
        if( commands[0].equals( "HOT" )){

            HotWeather hotWeather = new HotWeather();
            validCommands = hotConditions( hotWeather, commands );

        }else if( commands[0].equals( "COLD" )){

            ColdWeather coldWeather = new ColdWeather();
            validCommands = coldConditions( coldWeather, commands );

        }

        return validCommands;
    }

    public static void main( String args[] ){

        System.out.println(" Enter Commands ");
        Scanner scan = new Scanner( System.in );
        String input = scan.nextLine().replaceAll(",", "");
        String[] commands = input.split(" ");
       
        System.out.println( processCommand( commands ) );    
    
    } 

}