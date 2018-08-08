package cresla;

import cresla.entities.containers.ModuleContainer;
import cresla.interfaces.AbsorbingModule;
import cresla.interfaces.Container;
import cresla.interfaces.EnergyModule;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class ModuleContainerTests {

    private AbsorbingModule absorbingModuleMocked1;
    private AbsorbingModule absorbingModuleMocked2;
    private EnergyModule energyModuleMocked1;
    private EnergyModule energyModuleMocked2;
    private Container containerMocked;

    @Before
    public void before () {

        this.containerMocked = new ModuleContainer(3);
        this.absorbingModuleMocked1 = Mockito.mock(AbsorbingModule.class);
        this.absorbingModuleMocked2 = Mockito.mock(AbsorbingModule.class);
        this.energyModuleMocked1 = Mockito.mock(EnergyModule.class);
        this.energyModuleMocked2 = Mockito.mock(EnergyModule.class);

        Mockito.when(absorbingModuleMocked1.getHeatAbsorbing()).thenReturn(2_000_000_000);
        Mockito.when(absorbingModuleMocked2.getHeatAbsorbing()).thenReturn(2_000_000_000);
        Mockito.when(energyModuleMocked1.getEnergyOutput()).thenReturn(2_000_000_000);
        Mockito.when(energyModuleMocked2.getEnergyOutput()).thenReturn(2_000_000_000);

        Mockito.when(absorbingModuleMocked1.getId()).thenReturn(1);
        Mockito.when(absorbingModuleMocked2.getId()).thenReturn(2);
        Mockito.when(energyModuleMocked1.getId()).thenReturn(3);
        Mockito.when(energyModuleMocked2.getId()).thenReturn(4);


    }

    @Test(expected = IllegalArgumentException.class)
    public void addEnergyModuleException() {
        this.containerMocked.addEnergyModule(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addAbsorbingModuleException() {
        this.containerMocked.addAbsorbingModule(null);
    }

    @Test
    public void expectToRemoveModel() {
        this.containerMocked.addAbsorbingModule(absorbingModuleMocked1);
        this.containerMocked.addAbsorbingModule(absorbingModuleMocked2);
        this.containerMocked.addEnergyModule(energyModuleMocked1);
        this.containerMocked.addEnergyModule(energyModuleMocked2);

        Assert.assertEquals(containerMocked.getTotalEnergyOutput(), 4_000_000_000L);
        Assert.assertEquals(containerMocked.getTotalHeatAbsorbing(), 2_000_000_000L);
    }

    @Test
    public void absorbingModelWorkingWithLong() {
        this.containerMocked.addAbsorbingModule(this.absorbingModuleMocked1);
        this.containerMocked.addAbsorbingModule(this.absorbingModuleMocked2);

        Assert.assertEquals(this.containerMocked.getTotalHeatAbsorbing(), 4_000_000_000L);
    }

    @Test
    public void emptyContainerReturn() {

        Assert.assertEquals(this.containerMocked.getTotalHeatAbsorbing(), 0);
        Assert.assertEquals(this.containerMocked.getTotalEnergyOutput(), 0);
    }

}
