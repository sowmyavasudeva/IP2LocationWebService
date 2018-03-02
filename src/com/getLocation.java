package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import java.net.*;
import java.io.*;



import org.json.*;
import org.json.JSONException;
import org.json.JSONObject;



import java.io.BufferedInputStream;

import java.net.HttpURLConnection;

import java.net.ProtocolException;


public class getLocation 
{
	 private static String url = "https://ipfind.co/?ip=104.156.99.192&auth=fdd15277-8fbf-42fe-9778-4ea3281b3a90";
	 

	
	public String IP2LocationRequest() {
		String jsonStr = makeServiceCall(url);
		
		
		return jsonStr;
	}
	
	private String makeServiceCall(String reqUrl) {
		
		String response = null;
        try {
            URL url = new URL(reqUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            // read the response
            InputStream in = new BufferedInputStream(conn.getInputStream());
            response = convertStreamToString(in);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
        		e.printStackTrace();
        } catch (IOException e) {
        		e.printStackTrace();
        } catch (Exception e) {
        		e.printStackTrace();
        }
        return response;
	}
	
	private String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}

