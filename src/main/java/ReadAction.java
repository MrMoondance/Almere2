import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class ReadAction {
	public static ArrayList<Action> getActionlijst() {
		
		ArrayList<Action> actionLijst = new ArrayList<Action>();
		
		int rows = 1000; // No of rows	    	    
	    for(int r = 2; r < rows; r++) {
	    	
	    	String plant = readExcel(r,0);
	    	String maand = String.valueOf(readExcel(r,1));
	    	String actie = readExcel(r,2);
	    
	    
	    	if (plant != null) {
	    		Action action = new Action(plant,maand,actie);
	    		actionLijst.add(action);    	    
	    	}    	
	    	if (plant == null) {
	    		break;	    		
	    	}
	    }
		return actionLijst;
	
	}
	
	public static ArrayList<Action> getSpecificColumn(String name, int reqC) {
		
		ArrayList<Action> actionLijst = new ArrayList<Action>();
		int rows = 1000;
		for (int r=2; r< rows; r++) {
			
			if (readExcel(r,0) == null) {
	    		break;	    		
	    	}
			if (name.equals(String.valueOf(readExcel(r,reqC)))) {
				
				
				
				String plant = readExcel(r,0);
		    	String maand = String.valueOf(readExcel(r,1));
		    	String actie = readExcel(r,2);
		    
		    
		    	
		    	Action action = new Action(plant,maand,actie);
		    	actionLijst.add(action);    	    
		    	    	
		    	
			}
			
			
			
		}
		return actionLijst;		
	}
		
	
	
	
	
	
	
	
	private static String readExcel(int r, int c) {
		
		try {
		    POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("Voorstel plantenlijst.xls"));
		    HSSFWorkbook wb = new HSSFWorkbook(fs);
		    HSSFSheet sheet = wb.getSheetAt(2);
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
