package comand.readirect.enums;

import comand.readirect.main.ActionCommand;
import comand.readirect.main.AddPersonnel;
import comand.readirect.main.Athentication;
import comand.readirect.main.CalendarMessage;
import comand.readirect.main.LocalServlet;
import comand.readirect.main.LoginServlet;
import comand.readirect.main.OrderServlet;

public enum CommandEnum {
	
	ADDPERSONNEL{
		{
			this.nActionC = new AddPersonnel();
		}
	},
	ATHENTICATION{
		{	this.nActionC = new Athentication();}
		
	}, 
	CALENDAR{
		   {this.nActionC = new CalendarMessage(); }
			
	},
	
	LOCALSERVLET{
		   {this.nActionC = new LocalServlet(); }
		
	},
	LOGINSERVLET{
		   {this.nActionC = new LoginServlet(); }
			
	},
	
	ORDERSERVLET{
		   {this.nActionC = new OrderServlet(); }
			
	};
	
	
	
	
	
	protected ActionCommand nActionC ;
	public ActionCommand  getCommand(){
		return nActionC;
	}
	
	
	

}
