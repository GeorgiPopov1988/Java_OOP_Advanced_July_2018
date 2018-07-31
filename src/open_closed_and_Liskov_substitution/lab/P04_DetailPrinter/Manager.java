package open_closed_and_Liskov_substitution.lab.P04_DetailPrinter;

public class Manager extends Employee {

    private Iterable<String> documents;

    private Manager(String name, Iterable<String> documents) {
        super(name);
        this.documents = documents;
    }
}
