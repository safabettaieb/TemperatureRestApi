package com.safa.temperature.api.ws.services;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.safa.temperature.api.ws.payload.requests.TemperatureRequest;
import com.safa.temperature.api.ws.payload.responses.TemperatureResponse;

@Service
public class TemperatureService {
	
   public TemperatureResponse min(TemperatureRequest request) {
	   
	   TemperatureResponse response = new TemperatureResponse();
	   int tab[] = request.getTemperature(); 
	    Arrays.sort(tab);
	   response.setResTemp(tab[0]);
	   return response;
   
   }

}
