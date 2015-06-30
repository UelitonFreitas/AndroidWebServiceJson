package br.com.AndroidMapWebServiceJson.controller;

import java.util.ArrayList;

import br.com.AndroidMapWebServiceJson.dao.UserDAO;
import br.com.AndroidMapWebServiceJson.model.User;

public class UserController {

	public ArrayList<User> listAllUsers(){
			return UserDAO.getInstance().listAllUsers();
	}
}
