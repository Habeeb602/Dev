import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;



// A. High-level modules should not depend on low-level modules. 
// Both should depend on abstractions.

// B. Abstractions should not depend on details. 
// Details should depend on abstractions.

enum RelationType{
    PARENT,
    CHILD,
    SIBLING
}

class Person{
    String name;
    public Person(String name){
        this.name = name;
    }



    @Override
    public boolean equals(Object p){
        if(this == null || p == null || this.name == null)
            return false;

        return this.name == ((Person)p).name;
    }



    @Override
    public String toString() {
        return name;
    }

    
}


class Relation{
    Person relator;
    Person relatee;
    RelationType type;
    public Relation(Person relator, Person relatee, RelationType type) {
        this.relator = relator;
        this.relatee = relatee;
        this.type = type;
    }


    @Override
    public String toString() {
        return String.format("%s is a %s of %s", relator, type.toString().toLowerCase(), relatee);
    }   
}


interface RelationshipBrowser{
    List<Relation> findAllRelationOf(Person p); 
    void addRelation(Person p1, Person p2, RelationType type);
}

class Relationships implements RelationshipBrowser{
    List<Relation> relations = new ArrayList<>();

    public void addRelation(Person p1, Person p2, RelationType type){

        if(type == RelationType.CHILD){
            relations
            .add(new Relation(p1, p2, type));
            relations
            .add(new Relation(p2, p1, RelationType.PARENT));                
        }
        if(type == RelationType.PARENT){
            relations
            .add(new Relation(p1, p2, type));
            relations
            .add(new Relation(p2, p1, RelationType.CHILD));                
        }
        if(type == RelationType.SIBLING){
            relations
            .add(new Relation(p1, p2, type));
            relations
            .add(new Relation(p2, p1, type));                
        }
    }

    @Override
    public List<Relation> findAllRelationOf(Person p) {
        return relations
                .stream()
                .filter(relations -> relations.relator.equals(p))
                .collect(Collectors.toList());
    }
    
}


class Research{
    public Research(RelationshipBrowser rb, Person p){
        List<Relation> relations = rb.findAllRelationOf(p);
        relations.forEach(System.out::println);
    }
}

public class DependencyInversionPrinciple {
    public static void main(String[] args) {
        Person p1 = new Person("Jack");
        Person p2 = new Person("Adam");
        Person p3 = new Person("Noor");
        Person p4 = new Person("Imran");
        Person p5 = new Person("Fydor");
        Person p6 = new Person("Stephen");

        RelationshipBrowser rb = new Relationships();
        rb.addRelation(p1, p2, RelationType.PARENT);
        rb.addRelation(p1, p6, RelationType.PARENT);
        rb.addRelation(p2, p6, RelationType.SIBLING);
        rb.addRelation(p4, p3, RelationType.PARENT);
        rb.addRelation(p2, p5, RelationType.PARENT);

        new Research(rb, p5);
    }
}
