class ColdWeather{

    private String footwear;
    private String headwear;
    private String socks;
    private String shirt;
    private String jacket;
    private String pants;
    private String leaveHouse;
    private String pajamas;

    ColdWeather(){
        
        footwear = "boots";
        headwear = "hat";
        socks = "socks";
        shirt = "shirt";
        jacket = "jacket";
        pants = "pants";
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
        return this.jacket;
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