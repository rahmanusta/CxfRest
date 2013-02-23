package com.kodcu;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/hello")
public class HelloWorld {

    @GET // Erişim için HTTP GET metodu
    @Path("/echo/{input}") // Erişim URL /hello/echo/{input}
    @Produces("text/plain") // Plain text üretir
    public String ping(@PathParam("input") String input) {
        // Gelen parametre bilgisini,
        // Plain text olarak kullanıcıya döndürür.
        return input;
    }

    @POST // Erişim için HTTP POST metodu
    @Produces("application/json") // Json üretir
    @Consumes("application/json") // Json tüketir
    @Path("/jsonBean") // Erişim URL /hello/jsonBean
    public Response modifyJson(JsonBean input) {

        // Val2 Val1'e eşitlenir.
        input.setVal2(input.getVal1());

        // 200 OK HTTP Status kodlu,
        // JSONBean entity nesnesine sahip
        // Http Response üretilir.

        return Response.ok().entity(input).build();
    }
}

