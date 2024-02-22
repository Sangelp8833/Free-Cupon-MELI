package com.freecupon.MELI.helpers.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.freecupon.MELI.domain.dto.ItemPrice;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Objects;

@Component
public class ItemsPrices {

    private final HttpClient httpClient = HttpClient.newHttpClient();

    @Autowired
    private ObjectMapper objectMapper;

    @Value("${base.uri}")
    private String baseUri;

    public Double getItemsPrice(String itemId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUri + itemId ))
                .GET()
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());
        ItemPrice itemPrice = objectMapper.readValue(response.body(), ItemPrice.class);
        if(itemPrice != null){
            return itemPrice.getPrice();
        }
        return 0.0;
    }



}
