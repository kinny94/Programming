// Dependency Inversion Principle - A high level module should not depend on a low level module
// Both should depend on abstractions
// Abstractions should not depend on details. Details should depend on abstractions

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

enum Relationship {
    PARENT,
    CHILD,
    SIBLING
}

class Person {
    public String name;
    public Relationship relationship;

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, Relationship relationship) {
        this.name = name;
        this.relationship = relationship;
    }
}

interface RelationshipBrowser {
    List<Person> findAllChildrenOf(String name);
}

class Relationships implements RelationshipBrowser {
    private List<Triplet<Person, Relationship, Person>> relations = new ArrayList<>();

    public void addParentAndChild(Person parent, Person child) {
        relations.add(new Triplet<>(parent, Relationship.PARENT, child));
        relations.add(new Triplet<>(child, Relationship.CHILD, parent));
    }

    // We are exposing an internal storage of relationships as a public method
    // Realtionships is a low level module and its just storing the relationships
    // Research is a high level module and its using the relationships
    // So, Research is dependent on Relationships
    // But Relationships is not dependent on Research
    // So, we are violating the Dependency Inversion Principle
    // We should not depend on low level modules
    // We should depend on abstractions
    public List<Triplet<Person, Relationship, Person>> getRelations() {
        return relations;
    }

    // Now the search is happening in the low level module and not in the high level module
    // This is better because if we need to change the search logic, we can do it in the low level module and not in the high level module
    // for eg changing it to a stream for a list
    @Override
    public List<Person> findAllChildrenOf(String name) {
        return relations.stream().filter(r -> r.getFirst().name.equals(name) && r.getSecond() == Relationship.PARENT).map(r -> r.getThird()).collect(Collectors.toList());
    }
}

class Research {
    public Research(Relationships relationships) {
        List<Triplet<Person, Relationship, Person>> relations = relationships.getRelations();
        relations.forEach(relation -> {
            System.out.println(relation.getFirst().name + " is a " + relation.getSecond() + " of " + relation.getThird().name);
        });
    }

    public Research(RelationshipBrowser relationshipBrowser) {
        List<Person> children = relationshipBrowser.findAllChildrenOf("John");
        children.forEach(child -> {
            System.out.println("John has a child called " + child.name);
        });
    }
}

public class DependencyInversionPrinciple {
    public static void main(String[] args) {
        Person parent = new Person("John");
        Person child = new Person("Chris");
        Person child2 = new Person("Jane");
        Relationships relationships = new Relationships();
        relationships.addParentAndChild(parent, child);
        relationships.addParentAndChild(parent, child2);
        new Research(relationships);
    }
}
