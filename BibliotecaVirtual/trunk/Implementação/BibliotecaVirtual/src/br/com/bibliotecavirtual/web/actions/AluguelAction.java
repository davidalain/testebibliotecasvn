package br.com.bibliotecavirtual.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.bibliotecavirtual.fachada.Fachada;
import br.com.bibliotecavirtual.lib.alunos.Aluno;
import br.com.bibliotecavirtual.lib.exemplares.Exemplar;
import br.com.bibliotecavirtual.lib.funcionarios.Funcionario;
import br.com.bibliotecavirtual.lib.livros.Livro;
import br.com.bibliotecavirtual.web.beans.AluguelBean;

public class AluguelAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession(true);

		System.out.println(this.getServlet().getServletContext());

		AluguelBean bean = (AluguelBean) form;

		Aluno aluno = bean.getAluno();
		Livro livro = new Livro(1, "", "", "", "", 0, "");
		Exemplar exemplar = bean.getExemplar(livro);

		Fachada fachada = Fachada.getInstance();

		Funcionario funcionario = (Funcionario) session.getAttribute("func");

		System.out.println(funcionario.getId());

		try {
			fachada.alugar(aluno, funcionario, exemplar);
			return mapping.findForward("sucesso");
		} catch (Exception e) {
			e.printStackTrace();
			return mapping.findForward("erro");

		}
	}
}
