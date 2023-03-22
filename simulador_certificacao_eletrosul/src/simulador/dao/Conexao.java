package simulador.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexao {

	//private String framework = "embedded";
	private String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    private String protocol = "jdbc:derby:";
    
    public Connection getConexao() throws Exception{
    	Connection conn = null;
       
        //System.out.println("SimpleApp starting in " + framework + " mode");
        loadDriver();
        
        Properties props = new Properties(); 
        props.put("user", "root");
        props.put("password", "root");
        String dbName = "simuladordb"; // the name of the database
        conn = DriverManager.getConnection(protocol + dbName
               + ";create=true; codeset=8859_1", props);
        //System.out.println("Connected to and created database " + dbName);
        conn.setAutoCommit(true);    
        System.out.println("Conectado!!!");
      
        return conn;
    }

            //DriverManager.getConnection("jdbc:derby:;shutdown=true");
            //conn.setAutoCommit(false);
            
            //s = conn.createStatement();
            
           
            //conn.commit();
            //System.out.println("Committed the transaction");
            /*
            if (framework.equals("embedded"))
            {
                try
                {
                    DriverManager.getConnection("jdbc:derby:;shutdown=true");
                }
                catch (SQLException se)
                {
                    if (( (se.getErrorCode() == 50000)
                            && ("XJ015".equals(se.getSQLState()) ))) {
                        System.out.println("Derby shut down normally");
                    } else {
                        System.err.println("Derby did not shut down normally");
                        printSQLException(se);
                    }
                }
            }
        }
        catch (SQLException sqle)
        {
            printSQLException(sqle);
        } finally {
            // release all open resources to avoid unnecessary memory usage

            // ResultSet
            try {
                if (rs != null) {
                    rs.close();
                    rs = null;
                }
            } catch (SQLException sqle) {
                printSQLException(sqle);
            }

            // Statements and PreparedStatements
            int i = 0;
            while (!statements.isEmpty()) {
                // PreparedStatement extend Statement
                Statement st = (Statement)statements.remove(i);
                try {
                    if (st != null) {
                        st.close();
                        st = null;
                    }
                } catch (SQLException sqle) {
                    printSQLException(sqle);
                }
            }

           
            try {
                if (conn != null) {
                    conn.close();
                    conn = null;
                }
            } catch (SQLException sqle) {
                printSQLException(sqle);
            }
        }
        */
        
    
    
    private void loadDriver() {
        try {
            Class.forName(driver).newInstance();
            System.out.println("Loaded the appropriate driver");
        } catch (ClassNotFoundException cnfe) {
            System.err.println("\nUnable to load the JDBC driver " + driver);
            System.err.println("Please check your CLASSPATH.");
            cnfe.printStackTrace(System.err);
        } catch (InstantiationException ie) {
            System.err.println(
                        "\nUnable to instantiate the JDBC driver " + driver);
            ie.printStackTrace(System.err);
        } catch (IllegalAccessException iae) {
            System.err.println(
                        "\nNot allowed to access the JDBC driver " + driver);
            iae.printStackTrace(System.err);
        }
    }
    @SuppressWarnings("unused")
	private void reportFailure(String message) {
        System.err.println("\nData verification failed:");
        System.err.println('\t' + message);
    }
    public static void printSQLException(SQLException e)
    {
        while (e != null)
        {
            System.err.println("\n----- SQLException -----");
            System.err.println("  SQL State:  " + e.getSQLState());
            System.err.println("  Error Code: " + e.getErrorCode());
            System.err.println("  Message:    " + e.getMessage());
            e = e.getNextException();
        }
    }
}


/*public Connection getConexao() throws Exception{
Connection con;
Configuracao_xml server = new Configuracao_xml();
Server_xml s1 = server.LeroXml();
Class.forName(s1.getDriver());

con = DriverManager.getConnection(s1.getUrl(),s1.getUser(),s1.getPassword());

System.out.println("Conectado!!!");

return con;
}*/