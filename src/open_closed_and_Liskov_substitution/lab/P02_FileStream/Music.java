package open_closed_and_Liskov_substitution.lab.P02_FileStream;

public class Music implements Streamable {

    private String name;

    private int length;

    private int bytesSent;

    public Music (String name, int length, int bytesSent) {

        this.name = name;
        this.length = length;
        this.bytesSent = bytesSent;
    }

    @Override
    public int getLength ( ) {

        return this.length;
    }

    @Override
    public int getBytesSent ( ) {

        return this.bytesSent;
    }
}
