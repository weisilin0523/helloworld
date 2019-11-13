

import java.util.Calendar;
import java.util.Date;

import javax.swing.JLabel;

public class Datethread extends Thread{
	JLabel ldate;
	Date date;
	Calendar c1;
	public Datethread(JLabel ldate){
			this.ldate=ldate;
	}
	public void run(){
		while(true){
			date=new Date();
			c1=Calendar.getInstance();
			c1.setTime(date);
			int year=c1.get(c1.YEAR);
			int month=c1.get(c1.MONTH)+1;
			int day=c1.get(c1.DATE);
			int hour=c1.get(c1.HOUR_OF_DAY);
			int minute=c1.get(c1.MINUTE);
			int second=c1.get(c1.SECOND);
			String str=year+"Äê"+month+"ÔÂ"+day+"ÈÕ"+"  "+hour+":"+minute+":"+second;
			ldate.setText(str);
			try{
				Thread.sleep(1000);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

}
