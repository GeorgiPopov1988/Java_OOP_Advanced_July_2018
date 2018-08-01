package open_closed_and_Liskov_substitution.exercises.blob_s.factories;

import open_closed_and_Liskov_substitution.exercises.blob_s.interfaces.Attack;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class AttackFactory {

    public static final String ATTACKS_PATH =
            "open_closed_and_Liskov_substitution.exercises.blob_s.models.attacks.";

    protected AttackFactory() {

    }

    public static Attack create(String attackType) {

        Attack attack = null;

        try {
            Class<?> attackClass = Class.forName(ATTACKS_PATH + attackType);

            Constructor<?> declaredConstructor = attackClass.getDeclaredConstructor();

            return (Attack) declaredConstructor.newInstance();

        } catch (ClassNotFoundException |
                InvocationTargetException |
                InstantiationException |
                IllegalAccessException |
                NoSuchMethodException e) {
            e.printStackTrace();

            return attack;
        }


    }
}
