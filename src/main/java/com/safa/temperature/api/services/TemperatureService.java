package com.safa.temperature.api.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

	public TemperatureResponse closestToZero(TemperatureRequest request) {

		TemperatureResponse response = new TemperatureResponse();
		int tab[] = request.getTemperatures();
		List<Integer> liste  = Arrays.stream(tab)
				                         .boxed()
			                             .collect(Collectors.toList());
		 liste.add(0);
		 liste.sort(Comparator.naturalOrder());
		int pre=0, post=0, i = 0;
		boolean verif = false;
		
		while (i < liste.size() && !verif) {
			if (liste.get(i) == 0) {
				pre = liste.get(i - 1);
				post = liste.get(i + 1);
				verif = true;
			} else {
				i++;
			}
		}
		
		if (pre < 0) {
			response.setResTemp(post);		
		} else {
			response.setResTemp(pre);
		}
		return response;

	}

}
