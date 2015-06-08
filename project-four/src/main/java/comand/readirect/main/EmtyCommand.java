package comand.readirect.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comand.readirect.login.CommandRedirectCustomer;

public class EmtyCommand implements ActionCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		new CommandRedirectCustomer().execute(response);
	}

}
