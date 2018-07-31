package open_closed_and_Liskov_substitution.lab.P02_FileStream;

public class File implements Streamable{

    private String name;
    private int length;
    private int bytesSent;

    public File (String name, int length, int bytesSent) {

        this.name = name;
        this.length = length;
        this.bytesSent = bytesSent;
    }

    public int getLength() {
        return this.length;
    }

    public int getBytesSent() {
    return this.bytesSent;
    }
}
