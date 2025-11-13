// People canc reate as many instances of the class as they want
// But all instances will have the same state - they will all point to the same static fields
// It becomes really confusing when you have a lot of static fields and you need to manage them
// It is a bad design to have a lot of static fields
class ChiefExecutiveOfficer {
    private static String name;
    private static int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        ChiefExecutiveOfficer.name = name;
    }

    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        ChiefExecutiveOfficer.age = age;
    }

    @Override
    public String toString() {
        return "ChiefExecutiveOfficer [name=" + name + ", age=" + age + "]";
    }
}

public class Monostate {
    public static void main(String[] args) {
        ChiefExecutiveOfficer ceo = new ChiefExecutiveOfficer();
        ceo.setName("John Doe");
        ceo.setAge(55);
        System.out.println(ceo);

        ChiefExecutiveOfficer ceo2 = new ChiefExecutiveOfficer();
        System.out.println(ceo2);
    }
}
