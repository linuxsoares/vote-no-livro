package controllers;

import models.Usuario;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by gilmar on 09/06/14.
 */

public class UsuarioController extends Controller{

    private static Form<Usuario> formUsuario = Form.form(Usuario.class);

    public static Result formCadastroUsuario() {
        if (formUsuario.hasErrors()) {
            flash("erro","Foram identificados problemas no cadastro");
            return ok(views.html.usuario.render(formUsuario));
        }
        return ok(views.html.usuario.render(formUsuario));
    }

    public static Result salvarUsuario(){
        Form<Usuario> form = formUsuario.bindFromRequest();
        Usuario diretor = form.get();
        diretor.save();
        flash("sucesso","Registro gravado com sucesso");
        return redirect(routes.InicioController.inicio());
    }

}
