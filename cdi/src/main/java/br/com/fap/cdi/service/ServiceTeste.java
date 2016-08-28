package br.com.fap.cdi.service;

/**
 * @author Crunchify
 */
import br.com.fap.cdi.fachada.FachadaTeste;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;

//@Named
@RequestScoped
@Path("/")
public class ServiceTeste {
    
    @Inject
    private FachadaTeste fachadaTeste;
   
    @GET
    @Produces("application/json")
    public Response mensagem(@QueryParam("nome") String nome) throws JSONException {

        JSONObject jsonObject = new JSONObject();
        
        jsonObject.put("mensagem", fachadaTeste.teste(nome));

        String result = jsonObject.toString();
        return Response.status(200).entity(result).build();
    }
}
