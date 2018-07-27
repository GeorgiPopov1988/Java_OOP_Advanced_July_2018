package reflection.exercises.pr0304Barracks.core.commands;

import jdk.jshell.spi.ExecutionControl;
import reflection.exercises.pr0304Barracks.annotations.Inject;
import reflection.exercises.pr0304Barracks.contracts.Executable;
import reflection.exercises.pr0304Barracks.contracts.Repository;
import reflection.exercises.pr0304Barracks.contracts.Unit;
import reflection.exercises.pr0304Barracks.contracts.UnitFactory;

public class AddCommand implements Executable {

@Inject
private String[] data;

@Inject
private Repository repository;

@Inject
private UnitFactory unitFactory;

@Override
public String execute() throws ExecutionControl.NotImplementedException {
  
  String unitType = this.data[1];
  Unit unitToAdd = this.unitFactory.createUnit(unitType);
  
  this.repository.addUnit(unitToAdd);
  
  return unitType + " added!";
  
}
}
