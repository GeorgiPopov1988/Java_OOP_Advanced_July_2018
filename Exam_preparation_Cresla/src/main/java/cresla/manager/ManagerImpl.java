package cresla.manager;

import cresla.entities.containers.ModuleContainer;
import cresla.interfaces.*;
import cresla.interfaces.Module;
import cresla.models.modules.CooldownSystem;
import cresla.models.modules.CryogenRod;
import cresla.models.modules.HeatProcessor;
import cresla.models.reactor.CryoReactor;
import cresla.models.reactor.HeatReactor;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ManagerImpl implements Manager {

    private Map<Integer, Reactor> reactorsMap;
    private Map<Integer, Module> moduleMap;
    private int id;
    private int cryoReactorsCounter;
    private int heatReactorsCounter;
    private int energyModulesCounter;
    private int absorbingModulesCounter;

    public ManagerImpl () {

        this.reactorsMap = new LinkedHashMap<>();
        this.moduleMap = new LinkedHashMap<>();
        this.id = 1;
        this.cryoReactorsCounter = 0;
        this.heatReactorsCounter = 0;
        this.energyModulesCounter = 0;
        this.absorbingModulesCounter = 0;
    }

    @Override
    public String reactorCommand (List<String> arguments) {
        // •	Reactor {reactorType} {additionalParameter} {moduleCapacity}

        String reactorType = arguments.get(0);
        int additionalParameter = Integer.parseInt(arguments.get(1));
        int moduleCapacity = Integer.parseInt(arguments.get(2));

        Container container = new ModuleContainer(moduleCapacity);
        Reactor reactor = null;

        if ("Cryo".equals(reactorType)) {
            reactor = new CryoReactor(this.id, container, additionalParameter);
            this.reactorsMap.put(reactor.getId(), reactor);
            this.cryoReactorsCounter++;
        } else {
            reactor = new HeatReactor(this.id, container, additionalParameter);
            this.reactorsMap.put(reactor.getId(), reactor);
            this.heatReactorsCounter++;
        }


        return String.format("Created %s Reactor - %d", reactorType, this.id++);
    }

    @Override
    public String moduleCommand (List<String> arguments) {
        // •	Module {reactorId} {type} {additionalParameter}
        //  CryogenRod , HeatProcessor or CoolingSystem
        int reactorId = Integer.parseInt(arguments.get(0));
        String moduleType = arguments.get(1);
        int additionalParameter = Integer.parseInt(arguments.get(2));

        if ("CryogenRod".equals(moduleType)) {

            EnergyModule module = new CryogenRod(this.id, additionalParameter); ;
            this.moduleMap.put(this.id, module);
            this.reactorsMap.get(reactorId).addEnergyModule(module);
            this.energyModulesCounter++;

        } else if ("HeatProcessor".equals(moduleType)) {

            AbsorbingModule module = new HeatProcessor(this.id, additionalParameter); ;
            this.moduleMap.put(this.id, module);
            this.reactorsMap.get(reactorId).addAbsorbingModule(module);
            this.absorbingModulesCounter++;
        } else if ("CooldownSystem".equals(moduleType)) {

            AbsorbingModule module = new CooldownSystem(this.id, additionalParameter); ;
            this.moduleMap.put(this.id, module);
            this.reactorsMap.get(reactorId).addAbsorbingModule(module);
            this.absorbingModulesCounter++;

        } else {
            System.out.println("Module create - error!");
        }

        // Added {moduleType} - {moduleId} to Reactor - {reactorId}
        return String.format("Added %s - %d to Reactor - %d", moduleType, this.id++, reactorId);
    }

    @Override
    public String reportCommand (List<String> arguments) {
        int targetId = Integer.parseInt(arguments.get(0));

        if (this.reactorsMap.containsKey(targetId)) {

            return this.reactorsMap.get(targetId).toString();
        } else{
            return this.moduleMap.get(targetId).toString();
        }
    }

    @Override
    public String exitCommand (List<String> arguments) {
        StringBuilder exitComand = new StringBuilder();
        exitComand.append(String.format("Cryo Reactors: %d", this.cryoReactorsCounter));
        exitComand.append(System.lineSeparator());
        exitComand.append(String.format("Heat Reactors: %d", this.heatReactorsCounter));
        exitComand.append(System.lineSeparator());
        exitComand.append(String.format("Energy Modules: %d", this.energyModulesCounter));
        exitComand.append(System.lineSeparator());
        exitComand.append(String.format("Absorbing Modules: %d", this.absorbingModulesCounter));
        exitComand.append(System.lineSeparator());

        long totalEnergy = this.reactorsMap.entrySet().stream()
                .mapToLong(r -> r.getValue().getTotalEnergyOutput())
                .sum();
        exitComand.append(String.format("Total Energy Output: %d", totalEnergy));
        exitComand.append(System.lineSeparator());

        long totalHeat = this.reactorsMap.entrySet().stream()
                .mapToLong(r -> r.getValue().getTotalHeatAbsorbing())
                .sum();
        exitComand.append(String.format("Total Heat Absorbing: %d", totalHeat));
       // exitComand.append(System.lineSeparator());

        return exitComand.toString();
    }
}
