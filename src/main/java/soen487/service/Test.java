package soen487.service;
/**
 * Created by ericl on 2/28/2017.
 */
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
@Path("test")
public class Test
{
    @GET
    @Produces({MediaType.TEXT_PLAIN})
    public String find() {
        return "Hello Eric";
    }

}
