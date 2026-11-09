package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import modelo.Entity.Monitor;
import services.MonitorService;

class MonitorServiceTest {

	@Test
	void testGetMonitorById() {
		MonitorService monitorService=new MonitorService();
		Optional<Monitor> monitorById = monitorService.getMonitorById("22222222B");
		assertTrue(monitorById.isPresent());
		String name="Laura";
		assertEquals(monitorById.get().getNombre(),name);
	}

}
