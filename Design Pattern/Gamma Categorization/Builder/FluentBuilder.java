class Person {
    public String name;
    public String position;

    @Override
    public String toString() {
        return "Person [name=" + name + ", position=" + position + "]";
    }
}

class PersonBuilder<T extends PersonBuilder<T>> {
    protected Person person = new Person();

    public T withName(String name) {
        person.name = name;
        return (T) this;
    }
    
    public Person build() {
        return person;
    }

    // we did this because we want to override the self method in the sub class
    protected T self() {
        return self();
    }
    
}

class EmployeeBuilder extends PersonBuilder<EmployeeBuilder> {

    // this looks ok but its a problem because worksAt is not a method of PersonBuilder
    // when you create a new PersonBuilder, you can't use worksAt
    // as it returns a PersonBuilder
    // we solve it by making the PersonBuilder generic
    public EmployeeBuilder worksAt(String position) {
        person.position = position;
        return this;
    }

    @Override
    protected EmployeeBuilder self() {
        return this;
    }
}

public class FluentBuilder {
    public static void main(String[] args) {
        EmployeeBuilder pb = new EmployeeBuilder();
        Person person = pb.withName("John").worksAt("Developer").build();
        System.out.println(person);
    }
}
