package com.tcs.zip.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ZipService {

	@Autowired
    private  RestTemplate restTemplate;


    public String getPlaceNameFromPostalCode(String postalCode) {

        // url for postal code
        String url = "https://api.zippopotam.us/us/" + postalCode;
        
        // Call the API
        try {
            String response = restTemplate.getForObject(url, String.class);
            if (response != null && !response.isEmpty()) {
                // Parse the JSON response
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode rootNode = objectMapper.readTree(response);
                
                System.out.println(rootNode);
                JsonNode placeNameNode = rootNode.path("places").get(0).path("place name");
                return placeNameNode.asText();
            } else {
                return "No data found for the postal code.";
            }
        } catch (Exception e) {
            return "Error retrieving data: " + e.getMessage();
        }
    }
    
    
}
