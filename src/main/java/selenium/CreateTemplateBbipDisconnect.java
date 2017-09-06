package selenium;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public  class CreateTemplateBbipDisconnect implements DataSetTemplate  {
	
	public static Connection conn = null;
	public static ResultSet rs;
	public static String etlresult = null;
    public static String somaResult = null;
    public static String sql=null;
    
	
    
    ConnectToDatabase databaseConnection = new ConnectToDatabase();
    

	@Override
	public String EtlSuccess() throws SQLException {
		conn=  databaseConnection.dbConnection();
	    sql = "select * from bbip_Disconnect_stage";
		Statement s = conn.createStatement();
		rs = s.executeQuery(sql);
		while(rs.next()) {

			String Validation_result = rs.getString("validation_result");
			if (Validation_result.contains("SUCCESS")) {
				etlresult = "SUCCESS";

			}else if (rs.getString("validation_result") == null) {
				etlresult = "NULL";
				
			}else {
				etlresult = "FAILURE";
			}
		}
		return etlresult;
	}

	@Override
	public String harnessSuccess() throws SQLException {
		conn=databaseConnection.dbConnection();
		sql  = "select * from bbip_Disconnect_stage";
		Statement s = conn.createStatement();
	    rs = s.executeQuery(sql);
		while (rs.next()) {

			String Validation_result = rs.getString("SUBMISSION_RESULT");
			if (Validation_result.contains("SUCCESS")) {
				somaResult = "Success";

			}else if (rs.getString("SUBMISSION_RESULT") == null) {
				somaResult = "NULL";
				
			}else {
				somaResult = "FAILURE";
			}
			
		}
		System.out.println(etlresult);
		return somaResult;
	}

	@Override
	public Connection dbConnection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String SomaSuccess() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
