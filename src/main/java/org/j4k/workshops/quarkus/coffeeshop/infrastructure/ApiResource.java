package org.j4k.workshops.quarkus.coffeeshop.infrastructure;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.j4k.workshops.quarkus.coffeeshop.domain.OrderInCommand;
import org.j4k.workshops.quarkus.coffeeshop.favfood.domain.FavFoodOrder;
import org.j4k.workshops.quarkus.coffeeshop.favfood.domain.FavFoodOrderHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ApiResource {

    Logger logger = LoggerFactory.getLogger(ApiResource.class);

    @Inject
    FavFoodOrderRepository favFoodOrderRepository;

//    @Inject @RestClient
//    RESTService restClient;

//    @Inject
//    KafkaService kafkaService;

    @POST
    @Path("/favfood")
    @Transactional
    public Response placeFavFoodOrder(final FavFoodOrder favFoodOrder) {
        logger.debug("FavFood Order received {}", favFoodOrder.toString());

//        favFoodOrderRepository.persist(favFoodOrder);

        OrderInCommand orderInCommand = FavFoodOrderHandler.createFromFavFoodOrder(favFoodOrder);
        logger.debug("sending:{}", orderInCommand);

//        kafkaService.placeOrder(orderInCommand);

//        restClient.placeOrders(orderInCommand);

        return Response.accepted(favFoodOrder).build();
    }
}
