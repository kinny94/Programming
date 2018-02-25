import java.util.*;

class EncodeDecodeURL{
    
    HashMap<String, String> map = new HashMap<String, String>();

    public static String generateSessionKey(){
        String alphabet = 
                new String("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"); //9
        int n = alphabet.length(); //10
        
        String result = new String(); 
        Random r = new Random(); //11
        
        for (int i=0; i<8; i++) //12
            result = result + alphabet.charAt(r.nextInt(n)); //13
        
        return result;
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        StringBuilder url = new StringBuilder("https://tinyurl.com/");
        url.append(generateSessionKey());
        if(map.containsKey(url)){
            map.put(url.toString(), longUrl);
        }else{
            map.put(url.toString(), longUrl);
        }
        return url.toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String mainUrl = map.get(shortUrl);
        return mainUrl;
    }

    public static void main(String[] args) {
        EncodeDecodeURL obj = new EncodeDecodeURL();
        System.out.println(obj.decode(obj.encode("https://leetcode.com/problems/design-tinyurl")));
    }
}