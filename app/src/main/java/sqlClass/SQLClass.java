package sqlClass;

import java.sql.*;

public class SQLClass {
	
	/*
	 * ==================================================================================
	 *    
	 *    This class accesses the MySQL server using a secondary (background) thread.   
	 *    So this class works also in Android, setting the ip to "10.0.2.2".
	 *    
	 * ==================================================================================  
	 */
		
	private static String driver ="org.sqlite.JDBC";
	private static String urlPrefix ="jdbc:sqlite:..\\Loginbibliotheque\\bibliothequeMB_DB.db";
    //private static String ip = "localhost";
	private static String ip = "10.0.2.2";  // for Android
	private static String port="3306";
	private static String db ="";
	private static String user="root";
	private static String password ="root";
	private static boolean autoCommit=true;
	
	private static Connection con;
    private static Statement stmt;
    private static ResultSet rs=null;
    private static boolean result=false;
    
    public static void setIP(String s){
    	ip=s;
    }
    public static void setPort(String s){
    	port=s;
    }
    public static void setDb(String s){
    	db=s;
    }
    public static void setUser(String s){
    	user=s;
    }
    public static void setPassword(String s){
    	password=s;
    }
    public static void setAutoCommit(boolean flag){  
    	autoCommit=flag;
    }
    public static boolean connect(){  
    	result=false;
    	Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
            	try {
            		Class.forName(driver);
            		//
            		String url = urlPrefix + ip +":"+port+"/"+db;				 
            		con = DriverManager.getConnection(
            				url,user, password); 
            		//            		
            		con.setAutoCommit(autoCommit);            		
            		//	
            		stmt = con.createStatement();            		
            		result = true;
            	} catch (Exception e) {
            		// TODO Auto-generated catch block            		
            		e.printStackTrace();
            	}
            }
        });
        thread2.start();
        try {
			thread2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return result;	     
    }   
    public static boolean executeUpdate(final String command){
    	result=false;
    	Thread thread2 = new Thread(new Runnable() {
    		@Override
    		public void run() {
    			try {
    				stmt.executeUpdate(command);
    				result = true;
    			} catch (SQLException e) {
    				// TODO Auto-generated catch block            		
    				e.printStackTrace();
    			}
    		}
    	});
    	thread2.start();
    	try {
    		thread2.join();
    	} catch (InterruptedException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	return result;	     
    }
    public static boolean commit(){
    	result=false;
    	Thread thread2 = new Thread(new Runnable() {
    		@Override
    		public void run() {
    			try {
    				con.commit(); 
    				result = true;
    			} catch (SQLException e) {
    				// TODO Auto-generated catch block            		
    				e.printStackTrace();
    			}
    		}
    	});
    	thread2.start();
    	try {
    		thread2.join();
    	} catch (InterruptedException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	return result;	     
    }
    public static boolean rollback(){
    	result=false;
    	Thread thread2 = new Thread(new Runnable() {
    		@Override
    		public void run() {
    			try {
    				con.rollback(); 
    				result = true;
    			} catch (SQLException e) {
    				// TODO Auto-generated catch block            		
    				e.printStackTrace();
    			}
    		}
    	});
    	thread2.start();
    	try {
    		thread2.join();
    	} catch (InterruptedException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	return result;	     
    }
    public static ResultSet executeQuery(final String query){
    	rs=null;
    	Thread thread2 = new Thread(new Runnable() {
    		@Override
    		public void run() {
    			try {
    				rs=stmt.executeQuery(query);    		
    			} catch (SQLException e) {
    				// TODO Auto-generated catch block            		
    				e.printStackTrace();
    			}
    		}
    	});
    	thread2.start();
    	try {
    		thread2.join();
    	} catch (InterruptedException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	return rs;	     
    }
    public static boolean close(){
    	result=false;
    	Thread thread2 = new Thread(new Runnable() {
    		@Override
    		public void run() {
    			try {
    				if(rs!=null){rs.close();}
    				stmt.close();    				
    				con.close();    				
    				result = true;
    			} catch (SQLException e) {
    				// TODO Auto-generated catch block            		
    				e.printStackTrace();
    			}
    		}
    	});
    	thread2.start();
    	try {
    		thread2.join();
    	} catch (InterruptedException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	return result;	     
    }
}

    


