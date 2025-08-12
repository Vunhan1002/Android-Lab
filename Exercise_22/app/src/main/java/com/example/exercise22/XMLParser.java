package com.example.exercise22;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class XMLParser {

    public String getXmlFromUrl(String url) {
        String xml = null;

        try {
            // Tạo đối tượng Client và mở kết nối HTTP
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(url);

            // Tiến hành request lên server và nhận response
            HttpResponse httpResponse = httpClient.execute(httpPost);

            // Lấy thực thể trong response, chuyển thành String (XML)
            HttpEntity httpEntity = httpResponse.getEntity();
            xml = EntityUtils.toString(httpEntity, "UTF-8");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return xml; // trả về XML
    }
}

