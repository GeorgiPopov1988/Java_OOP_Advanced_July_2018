package reflection.exercises.pr0304Barracks.core.commands;

import reflection.exercises.pr0304Barracks.annotations.Inject;
import reflection.exercises.pr0304Barracks.contracts.Executable;
import reflection.exercises.pr0304Barracks.contracts.Repository;

public class RetireCommand implements Executable {

@Inject
private String[] data;

@Inject
private Repository repository;

@Override
public String execute() {
  String unitType = this.data[1];
  try {
    this.repository.removeUnit(unitType);
    
    return unitType + " retired!";
    
  } catch (IllegalArgumentException e) {
    return e.getMessage();
  }
}
}
