import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import controllers.LivrosController;
import dao.LivrosDAO;
import models.Livro;
import org.junit.*;

import play.mvc.*;
import play.test.*;
import play.data.DynamicForm;
import play.data.validation.ValidationError;
import play.data.validation.Constraints.RequiredValidator;
import play.i18n.Lang;
import play.libs.F;
import play.libs.F.*;

import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;


/**
*
* Simple (JUnit) tests that can call all parts of a play app.
* If you are interested in mocking a whole application, see the wiki for more details.
*
*/
public class ApplicationTest {

    @Test
    public void simpleCheck() {
        int a = 1 + 1;
        assertThat(a).isEqualTo(2);
    }

    @Test
    public void testGetLivroId(){
        running(fakeApplication(), new Runnable() {
                    @Override
                    public void run() {
                        Assert.assertNotNull(Livro.find.byId(Long.parseLong("1")));
                    }
                });
    }

    @Test
    public void testGetAllLivros(){
        running(fakeApplication(), new Runnable() {
            @Override
            public void run() {
                Assert.assertNotNull(LivrosDAO.getListAllLivros());
            }
        });
    }

    @Test
    public void testGetLivrosMaisVotados(){
        running(fakeApplication(), new Runnable() {
            @Override
            public void run() {
                Assert.assertNotNull(LivrosDAO.getListMaisVotados());
            }
        });
    }

    public void testCadastrarUsuario(){
        running(testServer(9001, fakeApplication()), HTMLUNIT,
                new Callback<TestBrowser>() {
                    @Override
                    public void invoke(TestBrowser testBrowser) throws Throwable {
                        testBrowser.goTo("http://localhost:9000/usuario/novo");
                        testBrowser.fill("input[name='nomeUsuario']").with("Gilmar");
                        testBrowser.fill("input[name='emailUsuario']").with("linux.soares@gmail.com");
                    }
                });
    }

}
