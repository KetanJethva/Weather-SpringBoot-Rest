package com.weather.controller;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/openweather")
public class WeatherController {
	
	private static final String appId = "f3f202c445dfea8a25d0d2525dab914d";
	
	private URL generateUrl(String citi){
		URL url = null;
		try {
//			url = new URL("http://api.openweathermap.org/data/2.5/weather?q=London,uk&APPID=f3f202c445dfea8a25d0d2525dab914d");
			url = new URL("http://api.openweathermap.org/data/2.5/weather?q="+citi+"&APPID="+appId);
		} catch(MalformedURLException mfe) {
			mfe.printStackTrace();
		}
		return url;
	}
	
	@GetMapping(path = "/load/{citi}")
	public String loadWeather(@PathVariable(name="citi") String citi) {
		URL url = generateUrl(citi);
		StringBuilder strData = new StringBuilder();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()));
			String data = null;
			while((data = br.readLine()) != null) {
				strData.append(data);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return strData.toString();
	}
}
