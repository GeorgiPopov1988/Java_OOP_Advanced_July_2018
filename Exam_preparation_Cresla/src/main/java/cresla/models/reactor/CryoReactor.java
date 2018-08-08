package cresla.models.reactor;

import cresla.interfaces.Container;

public class CryoReactor extends AbstractReactor {

    private int cryoProductionIndex;

    public CryoReactor (int id, Container container, int index) {

        super(id, container);
        this.cryoProductionIndex = index;
    }

    @Override
    public long getTotalEnergyOutput () {

        long result = super.getContainer().getTotalEnergyOutput() * this.cryoProductionIndex;
        if (result > this.getTotalHeatAbsorbing()) {
            result = 0;
        }

        return result;
    }

    @Override
    public long getTotalHeatAbsorbing () {

        return super.getContainer().getTotalHeatAbsorbing();
    }

    @Override
    public String toString () {
        StringBuilder output = new StringBuilder();
        //  {reactorType} – {reactorId}
        output.append(String.format("CryoReactor - %d", this.getId()));
        output.append(System.lineSeparator());

        //Energy Output: {energyOutput}
        output.append(String.format("Energy Output: %d", this.getTotalEnergyOutput()));
        output.append(System.lineSeparator());

        //Heat Absorbing: {heatAbsorbing}
        output.append(String.format("Heat Absorbing: %d", this.getTotalHeatAbsorbing()));
        output.append(System.lineSeparator());

        //Modules: {moduleCount}
        output.append(String.format("Modules: %d", super.getModuleCount()));

        return output.toString();
    }
}
