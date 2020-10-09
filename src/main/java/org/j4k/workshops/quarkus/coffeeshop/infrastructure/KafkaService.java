package org.j4k.workshops.quarkus.coffeeshop.infrastructure;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.j4k.workshops.quarkus.coffeeshop.domain.OrderInCommand;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.util.concurrent.CompletableFuture;

@ApplicationScoped
public class KafkaService {

    @Inject
    @Channel("orders")
    Emitter<String> ordersEmitter;

    Jsonb jsonb = JsonbBuilder.create();

    public CompletableFuture<Void> placeOrder(final OrderInCommand orderInCommand) {
        return ordersEmitter.send(jsonb.toJson(orderInCommand)).toCompletableFuture();
    }
}
