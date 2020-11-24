package es.um.asio.service.service.sparql.impl;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.um.asio.service.service.sparql.SparqlExecQuery;

@Service
public class SparqlExecQueryImpl implements SparqlExecQuery {

	@Value("${app.trellis.url}")
	private String urlTrellis;

	private static HttpURLConnection con;

	@Override
	public Page<String> getResponseTrellis(String query, Pageable pageable) {

		var urlParameters = "query=".concat(query);

		String response = null;

		Page<String> page = null;

		String sparqlService = "http://localhost:3030/trellis/sparql";

		byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);

		try {
			// TODO cambiar por urlTrellis
			var myurl = new URL(sparqlService);
			con = (HttpURLConnection) myurl.openConnection();

			con.setDoOutput(true);
			con.setRequestMethod("POST");
			con.setRequestProperty("User-Agent", "Java client");
			con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

			try (var wr = new DataOutputStream(con.getOutputStream())) {

				wr.write(postData);
			}

			StringBuilder content;

			try (var br = new BufferedReader(new InputStreamReader(con.getInputStream()))) {

				String line;
				content = new StringBuilder();

				while ((line = br.readLine()) != null) {
					content.append(line);
					content.append(System.lineSeparator());
				}
			}

			response = content.toString();

			JSONObject json;
			int totalCount = 0;
			try {
				json = new JSONObject(response);
				JSONObject obj = (JSONObject) json.get("results");
				JSONArray arr = obj.getJSONArray("bindings");
				// looping through All Selections
				totalCount = arr.length();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			List<String> list = new ArrayList<String>();
			list.add(response);
			page = new PageImpl<>(list, pageable, totalCount);

			System.out.println(content.toString());

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			con.disconnect();
		}

		return page;
	}

}
