package com.safa.temperature.api.services;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.safa.temperature.api.payload.requests.TemperatureRequest;
import com.safa.temperature.api.payload.responses.TemperatureResponse;

@Service
public class TemperatureService {
	
   public TemperatureResponse min(TemperatureRequest request) {
	   
	   TemperatureResponse response = new TemperatureResponse();
	   int tab[] = request.getTemperatures(); 
	    Arrays.sort(tab);
	   response.setResTemp(tab[0]);
	   return response;
   
   }
   public TemperatureResponse max(TemperatureRequest request) {
	   TemperatureResponse response = new TemperatureResponse();
	   int tab[] = request.getTemperatures();
	   Arrays.sort(tab);
	   response.setResTemp(tab[tab.length-1]);
	   return response;
	   
   }

}
