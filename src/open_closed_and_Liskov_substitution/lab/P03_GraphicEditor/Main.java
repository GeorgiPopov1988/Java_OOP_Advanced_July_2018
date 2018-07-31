package open_closed_and_Liskov_substitution.lab.P03_GraphicEditor;

public class Main {

    public static void main (String[] args) {

        GraphicEditor ge = new GraphicEditor();

        ge.drawShape(new Circle());
        ge.drawShape(new Picture());
    }

}
