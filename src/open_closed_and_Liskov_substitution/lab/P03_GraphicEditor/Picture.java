package open_closed_and_Liskov_substitution.lab.P03_GraphicEditor;

public class Picture implements Drawable{

    @Override
    public void draw () {

        System.out.println("I am Picture");
    }
}
