package br.com.bibliotecavirtual.web.beans;

import org.apache.struts.action.ActionForm;

public class LoginBean extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7069584808947193317L;
	private String login;
	private String senha;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
