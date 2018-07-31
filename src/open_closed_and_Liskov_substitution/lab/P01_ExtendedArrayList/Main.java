package open_closed_and_Liskov_substitution.lab.P01_ExtendedArrayList;

public class Main {

    public static void main (String[] args) {

        ExtendedArrayList<Integer> myList = new ExtendedArrayList<>( );

        myList.add(10);
        myList.add(13);
        myList.add(2);
        myList.add(9);

        System.out.println(myList.min( ));
        System.out.println(myList.max( ));
    }

}
