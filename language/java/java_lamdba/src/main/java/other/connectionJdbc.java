package other;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class connectionJdbc {
	private String driver;
	private String url;
	private String user;
	private String password;
	private String sql;
	
	private Properties properties;
	
	private Connection con;
	private PreparedStatement pre;
	
	public connectionJdbc(Properties properties) throws IOException  {
		this.properties = properties;
			 try {
				 init();
				connectionDB();
			} catch (Exception e) {
				e.printStackTrace();
				Runtime.getRuntime().exec("cmd /c msg %username% /time:10 \"CONNECTION FAIL\"");
			}
	}
	
	public void init()  {
		 driver = properties.getProperty("driver");
		
		 url =properties.getProperty("url");
		
		 user =properties.getProperty("user");
		
		 password =properties.getProperty("password");
		
		 sql = properties.getProperty("sql");
		 
	}
	
	public void connectionDB() throws SQLException, ClassNotFoundException {
		Class.forName(driver);
		
		con = DriverManager.getConnection(url, user, password);
	}
	
	public void executeSql()  {
		 try {
			pre = con.prepareStatement(replaceSql(sql, properties));
			pre.executeQuery();
			Runtime.getRuntime().exec("cmd /c msg %username% /time:10 \"SUCCESS INSERT\"");
		} catch (Exception e) {
			 e.printStackTrace();
			try {
				Runtime.getRuntime().exec("cmd /c msg %username% /time:10 \"FAIL INSERT\"");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
		public  String replaceSql(String sql,Properties properties) throws UnsupportedEncodingException {
			
			sql = sql.replace("param0", properties.getProperty("param0")); 
			sql = sql.replace("param1", properties.getProperty("param1")); 
			sql = sql.replace("param2", properties.getProperty("param2"));
			sql = sql.replace("param3", properties.getProperty("param3"));
			sql = sql.replace("param4", properties.getProperty("param4"));
			sql = sql.replace("param5", properties.getProperty("param5"));
			sql = sql.replace("param6", properties.getProperty("param6"));
			sql = sql.replace("param7", properties.getProperty("param7"));
			sql = sql.replace("param8", properties.getProperty("param8"));
			sql = sql.replace("param9", properties.getProperty("param9"));
			sql = sql.replace("param10", properties.getProperty("param10"));
			sql = sql.replace("param11", properties.getProperty("param11"));
			sql = sql.replace("param12", properties.getProperty("param12"));
			sql = sql.replace("param13", properties.getProperty("param13"));
			sql = sql.replace("param14", properties.getProperty("param14"));
			sql = sql.replace("param15", properties.getProperty("param15"));
			sql = sql.replace("param16", properties.getProperty("param16"));
			sql = sql.replace("param17", properties.getProperty("param17"));
			sql = sql.replace("param18", properties.getProperty("param18"));
			sql = sql.replace("param19", properties.getProperty("param19"));
			sql = sql.replace("param20", properties.getProperty("param20"));
			sql = sql.replace("param21", properties.getProperty("param21"));
			
			//编码转换 20180308 BWD START
			return new String(sql.getBytes("ISO-8859-1"),"UTF-8");
			//编码转换 20180308 BWD END
		}
		
		public static void main(String[] args) throws IOException {
			InputStream inputStream = new FileInputStream("C:\\Users\\drx\\Desktop\\GOP.properties");
			Properties properties = new Properties();
			properties.load(inputStream);
			connectionJdbc connectionJdbc = new connectionJdbc(properties);
			
			connectionJdbc.executeSql();
		}
		
		
}
