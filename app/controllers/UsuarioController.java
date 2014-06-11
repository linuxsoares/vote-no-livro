package controllers;

import models.Usuario;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by gilmar on 09/06/14.
 */

public class UsuarioController extends Controller{

    private static final Form<Usuario> formUsuario = Form.form(Usuario.class);

    public static Result formCadastroUsuario() {
        return ok(views.html.usuario.usuario.render(formUsuario));
    }

    public static Result salvarUsuario(){
        Form<Usuario> form = formUsuario.bindFromRequest();
        if (form.hasErrors()) {
            flash("erro","Foram identificados problemas no cadastro");
            return badRequest(views.html.usuario.usuario.render(form));
        }
        Usuario usuario = form.get();
        usuario.save();
        flash("sucesso","Registro gravado com sucesso");
        return redirect(routes.LivrosController.listMaisVotados());
    }

}

