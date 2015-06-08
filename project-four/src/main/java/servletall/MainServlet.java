package servletall;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import comand.readirect.enums.CommandEnum;
import comand.readirect.main.ActionCommand;
import comand.readirect.main.EmtyCommand;

/** 
 * main servlet has done redirect other  command  
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final Logger logger1 = Logger.getLogger(MainServlet.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 ActionCommand current = getActionCommand(request, response);
	        current.execute(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        ActionCommand current = getActionCommand(request, response);
	        current.execute(request, response);
	}
         
	
	/**
	 *  method return current ActionCommand
	 * @param request
	 * @param response
	 * @return
	 */
	
	public ActionCommand getActionCommand(HttpServletRequest request, HttpServletResponse response){
        	 ActionCommand  actionCommand = new EmtyCommand();
        	  String action = request.getParameter("command");
        	   if(action == null || action.isEmpty()){
        		    return actionCommand;
        	   }
        	 try{
        		 CommandEnum command = CommandEnum.valueOf(action.toUpperCase()); 
        		actionCommand = command.getCommand();
        	 }catch(IllegalArgumentException e){
        		 logger1.info(e);
        		 
        	 }
        	  
        	  return actionCommand ;
          }
}
