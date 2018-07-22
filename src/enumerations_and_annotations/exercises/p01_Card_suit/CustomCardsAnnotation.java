package enumerations_and_annotations.exercises.p01_Card_suit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface CustomCardsAnnotation {
  
  String type();
  String category();
  String description();
  
}
