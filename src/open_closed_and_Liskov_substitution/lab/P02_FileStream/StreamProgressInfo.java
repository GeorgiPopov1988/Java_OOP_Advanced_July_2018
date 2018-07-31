package open_closed_and_Liskov_substitution.lab.P02_FileStream;

public class StreamProgressInfo {
    private Streamable source;

    // If we want to stream a music file, we can't
    public StreamProgressInfo(Streamable sorce) {
        this.source = sorce;
    }

    public int calculateCurrentPercent() {
        return (this.source.getBytesSent() * 100) / this.source.getLength();
    }
}
