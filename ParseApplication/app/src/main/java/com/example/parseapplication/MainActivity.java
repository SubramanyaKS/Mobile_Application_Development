package com.example.parseapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class MainActivity extends AppCompatActivity {
    TextView disp;
    Button parseXML,parseJson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        disp = (TextView)findViewById(R.id.display);
        parseJson = (Button) findViewById(R.id.jsonbtn);
        parseXML = (Button) findViewById(R.id.xmlbtn);

        parseXML.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    InputStream is = getAssets().open("city.xml");
                    DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
                    Document document = documentBuilder.parse(is);
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("XML DATA");
                    stringBuilder.append("\n------------------");
                    NodeList nodeList = document.getElementsByTagName("place");
                    for (int i = 0; i < nodeList.getLength(); i++)
                    {
                        Node node = nodeList.item(i);
                        if (node.getNodeType() == Node.ELEMENT_NODE) {
                            Element element = (Element) node;
                            stringBuilder.append("\nCity_Name: ").append(getValue("name", element));
                            stringBuilder.append("\nLatitude: ").append(getValue("lat", element));
                            stringBuilder.append("\nLongitude: ").append(getValue("long", element));
                            stringBuilder.append("\nTemperature: ").append(getValue("temperature", element));
                            stringBuilder.append("\nHumidity: ").append(getValue("humidity", element));
                            stringBuilder.append("\n----------");
                        }
                    }
                    disp.setText(stringBuilder.toString());
                    is.close();
                }
                catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "XML Parse Failed", Toast.LENGTH_LONG).show();
                }

            }

        });
        parseJson.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {
                String json;
                StringBuilder stringBuilder = new StringBuilder();
                try{
                    InputStream is = getAssets().open("city.json");
                    int size = is.available();
                    byte[] buffer = new byte[size];
                    is.read(buffer);
                    json = new String(buffer, StandardCharsets.UTF_8);
                    JSONArray jsonArray = new JSONArray(json);
                    stringBuilder.append("JSON DATA");
                    stringBuilder.append("\n--------------------------");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        stringBuilder.append("\nCity_Name: ").append(jsonObject.getString("name"));
                        stringBuilder.append("\nLatitude: ").append(jsonObject.getString("lat"));
                        stringBuilder.append("\nLongitude: ").append(jsonObject.getString("long"));
                        stringBuilder.append("\nTemperature: ").append(jsonObject.getString("temperature"));
                        stringBuilder.append("\nHumidity: ").append(jsonObject.getString("humidity"));
                        stringBuilder.append("\n----------");
                    }
                    disp.setText(stringBuilder.toString());
                    is.close();
                }
                catch(IOException | JSONException e){
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this,"JSON Parsed  Failed",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    private String getValue(String tag, Element element)
    {
        return element.getElementsByTagName(tag).item(0).getChildNodes().item(0).getNodeValue();
    }
}
