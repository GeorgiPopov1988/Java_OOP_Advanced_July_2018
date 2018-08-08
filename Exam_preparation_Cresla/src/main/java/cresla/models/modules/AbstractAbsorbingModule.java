package cresla.models.modules;

import cresla.interfaces.AbsorbingModule;

public abstract class AbstractAbsorbingModule extends AbstractModule implements AbsorbingModule {
    
    private int heatAbsorbing;

    AbstractAbsorbingModule (int id, int heatAbsorbing) {

        super(id);
        this.heatAbsorbing = heatAbsorbing;
    }


    @Override
    public int getHeatAbsorbing () {

        return this.heatAbsorbing;
    }

    @Override
    public String toString () {
        StringBuilder output = new StringBuilder();
        // {moduleType} Module – {moduleId}
        //{additionalParam}: {additionalParamValue}
        output.append(String.format("%s Module - %d", this.getClass().getSimpleName(), super.getId()));
        output.append(System.lineSeparator());
        output.append(String.format("Heat Absorbing: %d", this.heatAbsorbing));
        //output.append(System.lineSeparator());

        return output.toString();
    }
}
