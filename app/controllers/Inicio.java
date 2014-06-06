package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.inicio;

/**
 * Created by gilmar on 05/06/14.
 */
public class Inicio extends Controller {

    public static Result inicio(){
        return ok(views.html.inicio.render());
    }
}
