package iterators_and_comparatotrs.exercises.p08_Pet_clinics.implementations;

import static iterators_and_comparatotrs.exercises.p08_Pet_clinics.Validations.isValid;
import static iterators_and_comparatotrs.exercises.p08_Pet_clinics.Validations.isValidRoomsCnt;

public class Clinic {

private String name;
private int roomsCnt;

public Clinic(String name, int roomsCnt) throws IllegalAccessException {
  
  this.setName(name);
  this.setRoomsCnt(roomsCnt);
}

private void setName(String name) throws IllegalAccessException {
  
  if (isValid(name)) {
    this.name = name;
  } else {
    throw new IllegalAccessException();
  }
}

private void setRoomsCnt(int roomsCnt) throws IllegalAccessException {
  
  if (isValidRoomsCnt(roomsCnt)) {
    this.roomsCnt = roomsCnt;
  } else {
    throw new IllegalAccessException();
  }
}


}
