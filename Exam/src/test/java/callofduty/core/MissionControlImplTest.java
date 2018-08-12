package callofduty.core;

import callofduty.domain.missions.AbstractMission;
import callofduty.interfaces.Mission;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class MissionControlImplTest {

    private Map<String, Mission> missionMapMock;

    public MissionControlImplTest () {

        this.missionMapMock = new LinkedHashMap<>();
    }

    @Before
    public void setUp () throws Exception {

    }

    @Test
    public void generateMission () {

    }
}