package br.com.bibliotecavirtual.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.bibliotecavirtual.lib.funcionarios.Funcionario;
import br.com.bibliotecavirtual.web.beans.LoginBean;

public class LogarAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		LoginBean loginForm = (LoginBean) form;
		String login = loginForm.getLogin();
		String senha = loginForm.getSenha();

		if (login.equals("Funcionario") && senha.equals("098")) {
			Funcionario funcionario = new Funcionario(login, senha, 1);
			HttpSession session = request.getSession(true);
			session.setAttribute("func", funcionario);
			return mapping.findForward("sucesso");
		} else
			return mapping.findForward("erro");
	}
}
