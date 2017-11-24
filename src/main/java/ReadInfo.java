import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class ReadInfo {
	
	public static ArrayList<Plant> getPlantenlijst() {
		
		ArrayList<Plant> plantenlijst = new ArrayList<Plant>();
		
		int rows = 1000; // No of rows	    	    
	    for(int r = 2; r < rows; r++) {
	    	
	    	
	    	String plantnaam = readExcel(r,0);
	    	String maat = readExcel(r,1);
	    	String aantal = readExcel(r,2);
	    	String prijsPerStuk = readExcel(r,3);
	    	String prijsTotaal = readExcel(r,4);
	    	String referentie = readExcel(r,5);
	    	String tuin = readExcel(r,6);
	    	String coordinaten = String.valueOf(readExcel(r,7));
	    	
	    	//TODO int x,y;
	    	
	    	if (plantnaam != null) {
	    		Plant plant = new Plant(plantnaam, maat, aantal, prijsPerStuk, prijsTotaal, referentie, tuin, coordinaten);
	    	    plantenlijst.add(plant);
	    	    
	    	}
	    	
	    	
	    	if (plantnaam == null) {
	    		break;	    		
	    	}
	    	
	    }
	    return plantenlijst;
	}
	
	private static String readExcel(int r, int c) {
		
		try {
		    POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("Voorstel plantenlijst.xls"));
		    HSSFWorkbook wb = new HSSFWorkbook(fs);
		    HSSFSheet sheet = wb.getSheetAt(1);
		    HSSFRow row;		    	    
		   		    
		    row = sheet.getRow(r);
		    if(row != null ) {
		    	if(row.getCell(c) != null) {		    			
		    		return row.getCell(c).toString();        
		    	}
		    }
		    
		    
		    
		   	    
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}	
		return null;		
	}	
}
