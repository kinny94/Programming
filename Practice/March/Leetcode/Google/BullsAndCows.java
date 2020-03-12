import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class BullsAndCows {
  
  private Map<Character, Integer> map;
  
  BullsAndCows() {
    this.map = new HashMap<Character, Integer>();
  }
  
  public String getHint(String secret, String guess) {
   
    int b = 0;
    int c = 0;

    StringBuilder newSecret = new StringBuilder("");
    StringBuilder newGuess = new StringBuilder("");

    for (int i=0; i<secret.length(); i++) {
      if (secret.charAt(i) == guess.charAt(i)) {
        b++;
      } else {
        newSecret.append(secret.charAt(i));
        newGuess.append(guess.charAt(i));
      }
    }

    for (int i=0; i<newSecret.length(); i++) {
      if (this.map.containsKey(newSecret.charAt(i))) {
        this.map.put(newSecret.charAt(i), this.map.get(newSecret.charAt(i)) + 1);
      } else {
        this.map.put(newSecret.charAt(i), 1);
      }
    }

    for (int i=0; i<newGuess.length(); i++) {
      if (this.map.containsKey(newGuess.charAt(i))) {
        if (this.map.get(newGuess.charAt(i)) != 0) {
          c++;
          this.map.put(newGuess.charAt(i), this.map.get(newGuess.charAt(i)) - 1);
        }
      }
    }

    return Integer.toString(b) + "A" + Integer.toString(c) + "B";
  }
  
  public static void main(String[] args) {
    BullsAndCows bc= new BullsAndCows();
    System.out.println(bc.getHint("1122", "1222"));
  }
}