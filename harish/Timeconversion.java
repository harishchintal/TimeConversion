package application;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.TimeZone;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
	
public class TimeController implements Initializable {
	@FXML
	ComboBox<String> countries;
	ObservableList<String> list=FXCollections.observableArrayList("india","nepal","america","pakistan","srilanka","australia","china","russian","japan","france","bangladesh","iraq","united kingdom","Hong Kong");
	
	@FXML
	Label time_initialize=new Label();
	
	@FXML
	Label time_result=new Label();
	
     private static final String DATE_FORMAT = "dd-M-yyyy hh:mm:ss a";
	SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);

	Date date1 = new Date(); 
	String dateInString = formatter.format(date1)+""; 
    Date date;
    TimeZone tz = TimeZone.getDefault();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		countries.setItems(list);
		try {
			date = formatter.parse(dateInString);
		} catch (ParseException e) {
			e.printStackTrace();
		}

	    time_initialize.setText(formatter.format(date1));
	}
	public void timeDisplay(){
		String selectTimeZone=countries.getValue();
		String timeZone=getSelectTimeZone(selectTimeZone);
		SimpleDateFormat sdfAmerica = new SimpleDateFormat(DATE_FORMAT);
        TimeZone tzInAmerica = TimeZone.getTimeZone(timeZone);
        sdfAmerica.setTimeZone(tzInAmerica);
        String sDateInAmerica = sdfAmerica.format(date);
        Date dateInAmerica = null;
		try {
			dateInAmerica = formatter.parse(sDateInAmerica);
		} catch (ParseException e) {
			e.printStackTrace();
		}
        time_result.setText(formatter.format(dateInAmerica)+"");
	}
	
	private String getSelectTimeZone(String selectTimeZone) {
		switch (selectTimeZone) {
		case "india":	
			return "Asia/Kolkata";
		case "nepal":	
			return "Asia/Kathmandu";
		case "america":	
			return "America/New_York";
		case "pakistan":	
			return "Asia/Karachi";
		case "srilanka":	
			return "Asia/Colombo";
		case "australia":	
			return "Europe/Vienna";
		case "china":	
			return "Asia/Shanghai";
		case "russian":	
			return "Europe/Moscow";
		case "japan":	       
			return "Asia/Tokyo";
		case "france":	
			return "Europe/Paris";
		case "bangladesh":	
			return "Asia/Dhaka";
		case "iraq":	
			return "Asia/Baghdad";
		case "united kingdom":	
			return "Europe/London";
		case "Hong Kong":	
			return "Asia/Hong_Kong";
		default:
			break;
		}
		return "Asia/Kolkata";
	}
}


