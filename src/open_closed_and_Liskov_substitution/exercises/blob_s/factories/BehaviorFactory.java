package open_closed_and_Liskov_substitution.exercises.blob_s.factories;

import open_closed_and_Liskov_substitution.exercises.blob_s.interfaces.Behavior;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class BehaviorFactory {

    private static final String BEHAVIOR_PATH =
            "open_closed_and_Liskov_substitution.exercises.blob_s.models.behaviors.";

    protected BehaviorFactory () {

    }

    public static Behavior create(String behaviorType) {

        Behavior behavior = null;
        try {
            Class<?> behaviorClass = Class.forName(BEHAVIOR_PATH + behaviorType);

            Constructor<?> declaredConstructor = behaviorClass.getDeclaredConstructor();

            return (Behavior) declaredConstructor.newInstance();

        } catch (ClassNotFoundException e) {
            return null;
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
            return behavior;
        }

    }
}
