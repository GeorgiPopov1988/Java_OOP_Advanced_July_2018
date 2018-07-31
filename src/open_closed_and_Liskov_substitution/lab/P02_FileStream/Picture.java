package open_closed_and_Liskov_substitution.lab.P02_FileStream;

public class Picture implements Streamable {

    private String name;

    private int length;

    private int bytesSent;

    @Override
    public int getLength () {

        return this.length;
    }

    @Override
    public int getBytesSent () {

        return this.bytesSent;
    }
}
