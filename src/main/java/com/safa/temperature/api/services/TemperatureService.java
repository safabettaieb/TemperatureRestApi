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
		response.setResTemp(tab[tab.length - 1]);
		return response;

	}

	public TemperatureResponse avg(TemperatureRequest request) {
		TemperatureResponse response = new TemperatureResponse();
		int tab[] = request.getTemperatures();
		int average = (int) Arrays.stream(tab).average().getAsDouble();
		response.setResTemp(average);
		return response;
	}

	public TemperatureResponse closetToZero(TemperatureRequest request) {
		
		TemperatureResponse response = new TemperatureResponse();
		int tab[] = request.getTemperatures();
		Arrays.sort(tab);

		int pre=0, post=0, i = 0;
		boolean verif = false;
		
		while (i < tab.length && verif) {
			if (tab[i] == 0) {
				pre = tab[i - 1];
				post = tab[i + 1];
			} else {
				i++;
			}
		}
		if (pre < 0) {
			response.setResTemp(tab[post]);
		} else {
			response.setResTemp(tab[pre]);
		}
		return response;

	}

}
