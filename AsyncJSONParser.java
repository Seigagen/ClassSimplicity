package com.verys.saumiljobalia.androidmpermissions;

import android.os.AsyncTask;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by saumiljobalia on 8/3/15.
 */
public class AsyncJSONParser extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... url){
        String response = null;
        String address = url[0];

        URL urlRequest = null;
        try{
            urlRequest = new URL(address);
            response = transfer(urlRequest);

        } catch (MalformedURLException e){

        } catch (IOException e){

        }
        return response;
    }

    @Override
    protected void onPostExecute (String result){

    }

    public String transfer(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
        InputStream is = urlConnection.getInputStream();
        BufferedReader bin = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        String line = bin.readLine();
        StringBuffer sb = new StringBuffer();
        while (line != null){
            sb.append(line);
            sb.append("\r\n");
            line = bin.readLine();
        }
        is.close();
        return sb.toString();

    }
}
