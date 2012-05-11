package uk.ac.notts.mdj.dissertation;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Main extends ListActivity {
    private static final int MENU_START = 0;
    ArrayList<String> listItems=new ArrayList<String>();
    ArrayAdapter<String> adapter;
    
    
    /* Creates the menu items */
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, MENU_START, 0, "Start");
        return true;
    }
    
//    @Override
//    public void onCreate(Bundle savedInstanceState) {  
//    super.onCreate(savedInstanceState);
//        setContentView(R.layout.main);        
//        matrixmult();
//    }
//    
//    /* Handles item selections */ 
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//    case MENU_START:
//    	matrixmult();
//    	return true;
//        }
//        return false;
//    }
//    
//    public void matrixmult() {
//    	boolean process = true;
//        LinearLayout linlay = (LinearLayout) this.findViewById(R.id.llayout);
//        final int N = 20;
//        int count = 0;
//        final TextView[] theResults = new TextView[N];        
//        
//        while (process) {
//        	String result = null;
//        	InputStream entitystream=null;
//        	try{
//               ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
//               HttpClient httpclient = new DefaultHttpClient();
//               HttpPost httppost = new HttpPost("http://10.0.2.2/Dissertation1/packet.php");
//               httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
//               HttpResponse response = httpclient.execute(httppost);
//               HttpEntity entity = response.getEntity();
//               entitystream = entity.getContent();
//       		}
//        	catch(Exception e){
//        		Log.e("log_tag", "Error in http connection "+e.toString());
//        	}
//
//       
//       
//       //convert response to string
//       try{
//               BufferedReader reader = new BufferedReader(new InputStreamReader(entitystream,"iso-8859-1"),8);
//               StringBuilder stringbuilder = new StringBuilder();
//               String line = null;
//               while ((line = reader.readLine()) != null) {
//                       stringbuilder.append(line + "\n");
//               }
//               entitystream.close();
//               result = stringbuilder.toString();     
//       }
//       catch(Exception e){
//               Log.e("log_tag", "Error converting result "+e.toString());
//       }
// 
//       //parse json data
//       try{
//               JSONArray jArray = new JSONArray(result);
//               JSONObject json_data = jArray.getJSONObject(0);    
//               int process_ID = Integer.parseInt(json_data.getString("_ID"));
//               String row_temp [];
//               row_temp = json_data.getString("ROWS").split(",");
//               
//               String col_temp[];
//               col_temp = json_data.getString("COL").split(",");
//               
//               String row_cor = json_data.getString("ROW_COR");
//               String col_cor = json_data.getString("COL_COR");
//               String matrix_id = json_data.getString("MATRIX_ID");
//               String httppostStr = "http://10.0.2.2/Dissertation1/packet.php?updateID="+process_ID; 
//               
//               double total = 0;
//               if (row_temp.length == col_temp.length) {
//                //Tell server to remove this data packet from the queue
//                try {
//	                    DefaultHttpClient hc=new DefaultHttpClient();  
//	                    ResponseHandler <String> res=new BasicResponseHandler();  
//	                    HttpPost postMethod=new HttpPost(httppostStr);  
//	                    //String response=
//	                    hc.execute(postMethod,res);
//                    }
//                catch (Exception e){
//                	Log.e("log_tag", "Error in http connection" + e.toString());
//                }                    
//                   
//                   for (int j = 0; j<row_temp.length; ++j) {
//                    total += Double.parseDouble(row_temp[j]) * Double.parseDouble(col_temp[j]); 
//                   }                              
//               }
//             try {
//               JSONObject json = new JSONObject();
//               try {
//                    json.put("data", total);
//                    json.put("matrix_id", matrix_id);
//                    json.put("row_cor", row_cor);
//                    json.put("col_cor", col_cor);
//                    }
//               catch (Exception e){
//                   Log.e("Error in HTTP", "HTTP Request error:" + e.toString());
//               }
//               
//               HttpClient httpclient = new DefaultHttpClient();
//               HttpPost httppost = new HttpPost("http://10.0.2.2/Dissertation1/packet.php");
//               try {
//                     List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
//         
//                    // Add two POST request variables
//                    nameValuePairs.add(new BasicNameValuePair("data", Double.toString(total)));
//                    nameValuePairs.add(new BasicNameValuePair("payload", json.toString()));
//                    httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
//                    
//                    // Execute HTTP Post Request
//                    HttpResponse response =httpclient.execute(httppost);
//                    String responsestr = EntityUtils.toString(response.getEntity());
//                    
//                    try {
//                    	final TextView rowTextView = new TextView(this);                    
//                    	rowTextView.setText("Returned Result: " + Double.toString(total));
//                    	linlay.addView(rowTextView);
//                    	theResults[count] = rowTextView;
//                    	count++;
//                    }
//                    catch (Exception e) {
//                    	count = 0;
//                    }
//            }
//            catch (Exception e){
//                Log.e("Error in HTTP Request", "HTTP Request error: " +e.toString());
//            }        
//        }
//        catch (Exception e){
//            Log.e("log_tag", "Error in http connection "+e.toString());
//        }
//    }
//    catch(JSONException e){
//        try {
//             final TextView rowTextView = new TextView(this);                    
//             rowTextView.setText("Nothing data returned from server");
//             linlay.addView(rowTextView);
//             theResults[count] = rowTextView;
//            }
//            catch (Exception e1) {
//                count = 0;
//            }
//        Log.e("log_tag", "Error parsing data "+e.toString());
//        break;
//       }
//     }
//   }
}
