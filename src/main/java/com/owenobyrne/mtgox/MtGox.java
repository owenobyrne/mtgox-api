package com.owenobyrne.mtgox;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.owenobyrne.mtgox.api.model.Info;
import com.owenobyrne.mtgox.api.model.Order;
import com.owenobyrne.mtgox.api.model.Quote;
import com.owenobyrne.mtgox.api.model.TradeResult;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.util.MultivaluedMapImpl;

@Component
public class MtGox {
	static final Logger logger = Logger.getLogger(MtGox.class.getName());
	private String apiEndpoint = "https://data.mtgox.com/api/2/";
	private @Value("${apikey}") String apiKey;
	private @Value("${apisecret}") String apiSecret;
		
	public Info getInfo() throws Exception {

        MultivaluedMap<String, String> formData = new MultivaluedMapImpl();
        formData.add("nonce", String.valueOf(System.nanoTime()*1000)); // need the *1000 to make this nonce bigger than any other I ever used on this API
        
        ClientResponse response = doGet("money/info", formData);
        
        Info i = response.getEntity(new GenericType<Info>(){});
        
        logger.info(""+ i.getData().getWallets().get("BTC").getBalance().getDisplay());
        return i;
	}

	
	public TradeResult getTradeResult(String type, String orderId) throws Exception {

        MultivaluedMap<String, String> formData = new MultivaluedMapImpl();
        formData.add("nonce", String.valueOf(System.nanoTime()*1000)); // need the *1000 to make this nonce bigger than any other I ever used on this API
        formData.add("type", type);
        formData.add("order", orderId);
        
        ClientResponse response = doGet("BTCEUR/money/order/result", formData);
        
        TradeResult tr = response.getEntity(new GenericType<TradeResult>(){});
        return tr;
	}
	
	public Quote getQuote(String type) throws Exception {

        MultivaluedMap<String, String> formData = new MultivaluedMapImpl();
        formData.add("nonce", String.valueOf(System.nanoTime()*1000)); // need the *1000 to make this nonce bigger than any other I ever used on this API
        formData.add("type", type);
        formData.add("amount", "100000000");
        
        ClientResponse response = doGet("BTCEUR/money/order/quote", formData);
        
        Quote q = response.getEntity(new GenericType<Quote>(){});
        logger.info(""+ q.getData().getAmount());
        return q;
	}
	
	public Order trade(String type, BigInteger amount) throws Exception {

        MultivaluedMap<String, String> formData = new MultivaluedMapImpl();
        formData.add("nonce", String.valueOf(System.nanoTime()*1000)); // need the *1000 to make this nonce bigger than any other I ever used on this API
        formData.add("type", type);
        formData.add("amount_int", "" + amount);
        
        ClientResponse response = doGet("BTCEUR/money/order/add", formData);
        
        Order o = response.getEntity(new GenericType<Order>(){});
        logger.info(""+ o.getData());
        return o;
	}
	
	public ClientResponse doGet(String endpoint, MultivaluedMap<String, String> formData) throws Exception {
		logger.info("Testing " + apiKey);
		
		TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {

			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				return null;
			}

			public void checkClientTrusted(
					java.security.cert.X509Certificate[] certs, String authType) {
			}

			public void checkServerTrusted(
					java.security.cert.X509Certificate[] certs, String authType) {
			}
		} };

		try {

			SSLContext sc = SSLContext.getInstance("SSL");
			sc.init(null, trustAllCerts, new java.security.SecureRandom());
			HttpsURLConnection
					.setDefaultSSLSocketFactory(sc.getSocketFactory());
		} catch (Exception e) {

			logger.log(Level.SEVERE, null, e);
		}
		
		ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put("com.sun.jersey.api.json.POJOMappingFeature", Boolean.TRUE);
        
        Client client = Client.create(clientConfig);
        
        WebResource webResource = client.resource(apiEndpoint + endpoint);
        webResource.addFilter(new com.sun.jersey.api.client.filter.LoggingFilter()); 
        
        ClientResponse response = (ClientResponse)webResource
        		.accept(MediaType.APPLICATION_JSON_TYPE)
        		.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
        		.header("Rest-Key", apiKey)
        		.header("Rest-Sign", signRequest(endpoint, formData))
        		.post(ClientResponse.class, formData);
            
        if(response.getStatus() != 200)
            throw new RuntimeException((new StringBuilder()).append("Failed : HTTP error code : ").append(response.getStatus()).toString());
        
        return response;
	}
	
	public String signRequest(String path, MultivaluedMap<String, String> formData) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
		SecretKey secretKey = new SecretKeySpec(Base64.decodeBase64(apiSecret.getBytes()), "HmacSHA512");
        Mac mac = Mac.getInstance("HmacSHA512");
        mac.init(secretKey);
		
		String result = new String();
		for (String hashkey : formData.keySet()) {
			if (result.length() > 0) {
				result += '&';
			}
			result += URLEncoder.encode(hashkey, "UTF-8") + "="
					+ URLEncoder.encode(formData.get(hashkey).get(0), "UTF-8");

		}
		result = path + "\0" + result;
		logger.info("To Sign: " + result);

		mac.update(result.getBytes());
	    return Base64.encodeBase64String(mac.doFinal()).trim();
		
	}
}
