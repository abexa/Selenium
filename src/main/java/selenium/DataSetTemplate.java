package selenium;

import java.sql.Connection;
import java.sql.SQLException;




public interface DataSetTemplate {
	
	

    
    public  String EtlSuccess() throws SQLException ;
    public  String SomaSuccess() throws SQLException;
	Connection dbConnection();
	public String harnessSuccess() throws SQLException;
    
    
}
