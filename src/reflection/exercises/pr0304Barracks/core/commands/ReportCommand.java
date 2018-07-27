package reflection.exercises.pr0304Barracks.core.commands;

import reflection.exercises.pr0304Barracks.annotations.Inject;
import reflection.exercises.pr0304Barracks.contracts.Executable;
import reflection.exercises.pr0304Barracks.contracts.Repository;

public class ReportCommand implements Executable {

@Inject
private Repository repository;

@Override
public String execute() {
  
  return this.repository.getStatistics();
  
}
}
