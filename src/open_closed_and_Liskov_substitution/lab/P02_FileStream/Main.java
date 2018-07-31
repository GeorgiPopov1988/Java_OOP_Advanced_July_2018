package open_closed_and_Liskov_substitution.lab.P02_FileStream;

public class Main {

    public static void main (String[] args) {
        StreamProgressInfo spi1 = new StreamProgressInfo(new Music("Music", 100, 10));
        StreamProgressInfo spi2 = new StreamProgressInfo(new File("File", 200, 10));
        StreamProgressInfo spi3 = new StreamProgressInfo(new File("Picture", 300, 10));

        System.out.println(spi1.calculateCurrentPercent());
        System.out.println(spi2.calculateCurrentPercent());
        System.out.println(spi3.calculateCurrentPercent());

    }

}
