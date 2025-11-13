import java.util.ArrayList;
import java.util.List;
// These are not used in the real world but are a good example of an abstract factory

interface HotDrink {
    void consume();
}

class Tea implements HotDrink {
    @Override
    public void consume() {
        System.out.println("This tea is nice with lemon!");
    }
}

class Coffee implements HotDrink {
    @Override
    public void consume() {
        System.out.println("This coffee is delicious!");
    }
}

interface HotDrinkFactory {
    HotDrink prepare(int amount);
}

class TeaFactory implements HotDrinkFactory {
    @Override
    public HotDrink prepare(int amount) {
        System.out.println("Put in tea bag, boil water, pour " + amount + "ml, add lemon, enjoy!");
        return new Tea();
    }
}

class CoffeeFactory implements HotDrinkFactory {
    @Override
    public HotDrink prepare(int amount) {
        System.out.println("Grind some beans, boil water, pour " + amount + "ml, enjoy!");
        return new Coffee();
    }
}

class HotDrinkMachine {
   private List<HotDrinkFactory> factories = new ArrayList<>();

   public HotDrinkMachine() {
    factories.add(new TeaFactory());
    factories.add(new CoffeeFactory()); 
   }

   public HotDrink makeDrink() {
    System.out.println("Available drinks:");
    for (int i = 0; i < factories.size(); i++) {
        System.out.println("" + i + ": " + factories.get(i).getClass().getName());
    }
    return factories.get(0).prepare(200);
   }  
}

public class AbstractFactory {
    public static void main(String[] args) {
        HotDrinkMachine machine = new HotDrinkMachine();
        HotDrink drink = machine.makeDrink();
        drink.consume();
    }
}
