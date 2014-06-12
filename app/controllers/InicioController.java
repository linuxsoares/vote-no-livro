package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.inicio.inicio;

/**
 * Created by gilmar on 05/06/14.
 */
public class InicioController extends Controller {

    public static Result inicio(){
        return redirect(controllers.routes.LivrosController.list());
    }

    public static Result home(){
        return ok(views.html.inicio.inicio.render());
    }

    public static Result sobre() {
        return ok(views.html.inicio.sobre.render());
    }
}
