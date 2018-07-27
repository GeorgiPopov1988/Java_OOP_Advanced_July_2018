package reflection.exercises.pr0304Barracks;

import reflection.exercises.pr0304Barracks.contracts.Repository;
import reflection.exercises.pr0304Barracks.contracts.Runnable;
import reflection.exercises.pr0304Barracks.contracts.UnitFactory;
import reflection.exercises.pr0304Barracks.core.Engine;
import reflection.exercises.pr0304Barracks.core.factories.UnitFactoryImpl;
import reflection.exercises.pr0304Barracks.data.UnitRepository;

public class Main {

	public static void main(String[] args) {
		Repository repository = new UnitRepository();
		UnitFactory unitFactory = new UnitFactoryImpl();
		Runnable engine = new Engine(repository, unitFactory);
		engine.run();
	}
}
