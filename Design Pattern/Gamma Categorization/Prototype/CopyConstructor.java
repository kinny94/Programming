class Address {
    public String streetAddress;
    public String city;
    public String country;

    public Address(String streetAddress, String city, String country) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.country = country;
    }
    
    @Override
    public String toString() {
        return "Address [streetAddress=" + streetAddress + ", city=" + city + ", country=" + country + "]";
    }

    // Copy constructor are better than clone() method because they are more explicit and easier to understand.
    public Address(Address other) {
        this(other.streetAddress, other.city, other.country);
    }
}

class Employee {
    public String name;
    public Address address;

    public Employee(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", address=" + address + "]";
    }

    public Employee(Employee other) {
        name = other.name;
        address = new Address(other.address);
    }
}

public class CopyConstructor {
    public static void main(String[] args) {
        Employee john = new Employee("John", new Address("123 Main St", "New York", "USA"));
        Employee chris = new Employee(john);
        chris.name = "Chris";
        System.out.println(john);
        System.out.println(chris);
    }
}
