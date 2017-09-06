package selenium;


import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;

public class ExecuteELTAndSoma {

	public  String etlresult = null;
    public  String somaResult = null;
    public  String dataSet =null;
   
	

	public void readPropFile() {
		
		
		try {

			Properties properties = new Properties();
			properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("table.properties"));
			
			dataSet = properties.getProperty("dataSet");
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e);
			//return null;
		}
		
		
		
	}
	
	
	

	public String checkingEtl() throws SQLException {
		readPropFile();
		switch (dataSet) {


		case "hsns":
			DataSetTemplate hsns = new CrateTemplateHsns();
			etlresult = hsns.EtlSuccess();
			break;
			
		case "fds":
			DataSetTemplate fds = new CrateTemplateFds();
			etlresult = fds.EtlSuccess();
			break;
			
		case "baseband":
			DataSetTemplate baseband = new CreateTemplateBaseband();
			etlresult = baseband.EtlSuccess();
			break;
			
		case "bbipConnect":
			DataSetTemplate bbipConnect = new CrateTemplateBbipConnect();
			etlresult = bbipConnect.EtlSuccess();
			break;
			
		case "bbipDisconnect":
			DataSetTemplate bbipDisconnect = new CreateTemplateBbipDisconnect();
			etlresult = bbipDisconnect.EtlSuccess();
			break;
			
		case "eubaConnect":
			DataSetTemplate eubaConnect = new CreateTemplateEubaConnect();
			etlresult = eubaConnect.EtlSuccess();
			break;
			
		case "eubaDisconnect":
			DataSetTemplate eubaDisconnect = new CreateTemplateEubaDisconnect();
			etlresult = eubaDisconnect.EtlSuccess();
			break;
			
		case "broadband":
			DataSetTemplate broadband = new CreateTemplateBroadband();
			etlresult = broadband.EtlSuccess();
			break;
			
		case "buba":
			DataSetTemplate buba = new CreateTemplateBuba();
			etlresult = buba.EtlSuccess();
			break;
			
		case "locale":
			DataSetTemplate locale = new CreateTemplateLocale();
			etlresult = locale.EtlSuccess();
			break;
		
		case "ldbs":
			DataSetTemplate ldbs = new CreateTemplateLdbs();
			etlresult = ldbs.EtlSuccess();
			break;
		
		}
		System.out.println(etlresult);
		return etlresult;

	}
	
	public String checkingSoma() throws SQLException {
		readPropFile();
		switch(dataSet){
		
		case "hsns":
			DataSetTemplate hsns = new CrateTemplateFds();
			somaResult = hsns.SomaSuccess();
			break;
			
		case "fds":
			DataSetTemplate fds = new CrateTemplateFds();
			somaResult = fds.SomaSuccess();
			break;
			
		case "baseband":
			DataSetTemplate baseband = new CreateTemplateBaseband();
			somaResult = baseband.SomaSuccess();
			break;
			
		case "bbipConnect":
			DataSetTemplate bbipConnect = new CrateTemplateBbipConnect();
			somaResult = bbipConnect.SomaSuccess();
			break;
			
		case "bbipDisconnect":
			DataSetTemplate bbipDisconnect = new CreateTemplateBbipDisconnect();
			somaResult = bbipDisconnect.SomaSuccess();
			break;
			
		case "eubaConnect":
			DataSetTemplate eubaConnect = new CreateTemplateEubaConnect();
			somaResult = eubaConnect.SomaSuccess();
			break;
			
		case "eubaDisconnect":
			DataSetTemplate eubaDisconnect = new CreateTemplateEubaDisconnect();
			somaResult = eubaDisconnect.SomaSuccess();
			break;
			
		case "buba":
			DataSetTemplate buba = new CreateTemplateBuba();
			somaResult = buba.SomaSuccess();
			break;
			
		case "ldbs":
			DataSetTemplate ldbs = new CreateTemplateLdbs();
			somaResult = ldbs.SomaSuccess();
			break;
			
		}
		System.out.println(somaResult);

		return somaResult ;

	}

	
	
	

}
