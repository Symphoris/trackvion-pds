package business;
import  static org.junit.Assert.*;
import static org.junit.Assume.assumeNotNull;

import java.sql.Connection;

import org.junit.Test;

import common.Configuration;


	
public class NotificationsServiceTest {

	@Test
	public void getNbAlertsTest() {
		try {
		Connection connection = Configuration.connectionPool.getConnection();
		assumeNotNull(connection);
		assertEquals(5, NotificationsService.getNbAlerts());
		}catch(Exception e) {}
	}
	
}
