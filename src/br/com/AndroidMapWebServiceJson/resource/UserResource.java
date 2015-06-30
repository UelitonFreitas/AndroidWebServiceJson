package br.com.AndroidMapWebServiceJson.resource;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.AndroidMapWebServiceJson.controller.UserController;
import br.com.AndroidMapWebServiceJson.model.User;

@Path("/User")
public class UserResource {

	@GET
	@Path("/listAllUsers")
	@Produces("application/json")
	public ArrayList<User> listAllUsers(){
		return new UserController().listAllUsers();
	}
}
