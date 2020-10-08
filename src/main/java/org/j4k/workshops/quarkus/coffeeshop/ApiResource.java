package org.j4k.workshops.quarkus.coffeeshop;

import jdk.jfr.ContentType;
import org.apache.commons.logging.Log;
import org.j4k.workshops.quarkus.coffeeshop.domain.FavFoodOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api") @Consumes(MediaType.APPLICATION_JSON) @Produces(MediaType.APPLICATION_JSON)
public class ApiResource {

    Logger logger = LoggerFactory.getLogger(ApiResource.class);

    @POST
    @Path("/favfood")
    public Response placeFavFoodOrder(final FavFoodOrder favFoodOrder) {
        logger.debug("FavFood Order received {}", favFoodOrder.toString());
        return Response.accepted(favFoodOrder).build();
    }
}
