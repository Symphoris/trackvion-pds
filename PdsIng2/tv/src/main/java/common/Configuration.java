package common;

import java.io.InputStream;
import java.util.Properties;

import business.ManageConnectedAccounts;

public class Configuration {
	
	public static Boolean startup = false;
	
	public static JDBCConnectionPool connectionPool;
	public static Thread connectionPoolThread;
	
	public static String db_url;
	public static String db_name;
	public static String db_user;
	public static String db_pwd;
	
	public static ManageConnectedAccounts connectedAccounts;
	
	public Configuration() {
		
		Properties properties=new Properties();
		try {
			InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties");
			properties.load(input);
			db_url = properties.getProperty("db_url");
			db_name = properties.getProperty("db_name");
			db_user = properties.getProperty("db_user");
			db_pwd = properties.getProperty("db_pwd");
		} catch (Exception e) {
			System.out.println("Error while loading the config file : " + e.getMessage());
		}
		
		connectionPool = new JDBCConnectionPool();
		connectionPoolThread = new Thread(connectionPool);
		connectionPoolThread.start();
		connectedAccounts = new ManageConnectedAccounts();
	}

}
