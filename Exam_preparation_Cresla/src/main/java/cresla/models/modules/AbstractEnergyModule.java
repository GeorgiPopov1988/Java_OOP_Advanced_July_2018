package cresla.models.modules;

import cresla.interfaces.EnergyModule;

public abstract class AbstractEnergyModule extends AbstractModule implements EnergyModule {

    private int energyOutput;

    AbstractEnergyModule (int id, int energyOutput) {

        super(id);
        this.energyOutput = energyOutput;
    }

    @Override
    public int getEnergyOutput () {

        return this.energyOutput;
    }

    @Override
    public String toString () {
        StringBuilder output = new StringBuilder();
        // {moduleType} Module – {moduleId}
        //{additionalParam}: {additionalParamValue}
        output.append(String.format("%s Module - %d", this.getClass().getSimpleName(), super.getId()));
        output.append(System.lineSeparator());
        output.append(String.format("Energy Output: %d", this.energyOutput));
        //output.append(System.lineSeparator());

        return output.toString();
    }
}
