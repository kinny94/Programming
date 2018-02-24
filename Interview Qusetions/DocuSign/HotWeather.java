// Creating a hotweather class to store details of what to wear when its hot outside.= with getters.
class HotWeather{

    private String footwear;
    private String headwear;
    private String socks;
    private String shirt;
    private String jacket;
    private String pants;
    private String leaveHouse;
    private String pajamas;

    HotWeather(){
        
        footwear = "sandals";
        headwear = "sun visor";
        socks = "fail";
        shirt = "t-shirt";
        jacket = "fail";
        pants = "shorts";
        leaveHouse = "leaving house";
        pajamas = "Removing PJs";
    
    }

    public String getFootWear(){
        return this.footwear;
    }

    public String getHeadwear(){
        return this.headwear;
    }

    public String getSocks(){
        return this.socks;
    }

    public String getShirt(){
        return this.shirt;
    }

    public String getJacket(){
        return this.getJacket();
    }

    public String getPants(){
        return this.pants;
    }

    public String getLeavingHouse(){
        return this.leaveHouse;
    }

    public String getPajamas(){
        return this.pajamas;
    }
}