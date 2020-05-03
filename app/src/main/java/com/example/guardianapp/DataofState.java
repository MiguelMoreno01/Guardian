package com.example.guardianapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DataofState extends AppCompatActivity {
    private RequestQueue mQueue;
    private String state;
    private int yeard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dataof_state);

        Intent intent = getIntent();
        state = intent.getStringExtra("State");
        mQueue = Volley.newRequestQueue(this);
        jsonParse();





    }
    private void jsonParse() {
        String url = "https://api.usa.gov/crime/fbi/sapi/api/summarized/estimates/states/" + state + "/2001/2021?api_key=Pr2eCj1ZWdnoog0ocfP0PNl4nu4MsPmbX62PyafF";

        JsonObjectRequest request= new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray results = response.getJSONArray("results");
                    JSONObject year = results.getJSONObject(0);
                    yeard = year.getInt("year");
                    for (int i = 1; i < results.length(); i++ ) {
                        if (results.getJSONObject(i).getInt("year") > year.getInt("year")) {
                            year = results.getJSONObject(i);
                            yeard = year.getInt("year");
                        }
                    }
                    TextView theStateView = findViewById(R.id.theState);
                    theStateView.setText(getState(state) + " : Reported Data as of " + yeard);

                    TextView theStatsView = findViewById(R.id.stats);
                    theStatsView.setText(year.getString("population") );

                    TextView theStats2 = findViewById(R.id.stats2);
                    theStats2.setText(year.getString("violent_crime"));

                    TextView theStats3 = findViewById(R.id.stats3);
                    theStats3.setText(year.getString("robbery"));

                    TextView theStats4 = findViewById(R.id.stats4);
                    theStats4.setText(year.getString("homicide"));

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mQueue.add(request);
    }
    private String getState(String abr) {
        if (abr.equals("AL")) {
            return "Alabama";
        } else if (abr.equals("AK")) {
            return "Alaska";
        } else if (abr.equals("AZ")) {
            return "Arizona";
        } else if (abr.equals("AR")) {
            return "Arkansas";
        } else if (abr.equals("CA")) {
            return "California";
        } else if (abr.equals("CO")) {
            return "Colorado";
        } else if (abr.equals("CT")) {
            return "Connecticut";
        } else if (abr.equals("DE")) {
            return "Delaware";
        } else if (abr.equals("GA")) {
            return "Georgia";
        } else if (abr.equals("FL")) {
            return "Florida";
        } else if (abr.equals("HI")) {
            return "Hawaii";
        } else if (abr.equals("ID")) {
            return "Idaho";
        } else if (abr.equals("IL")) {
            return "Illinois";
        } else if (abr.equals("IA")) {
            return "Iowa";
        } else if (abr.equals("IN")) {
            return "Indiana";
        } else if (abr.equals("KS")) {
            return "Kansas";
        } else if (abr.equals("KY")) {
            return "Kentucky";
        } else if (abr.equals("LA")) {
            return "Louisiana";
        } else if (abr.equals("ME")) {
            return "Maine";
        } else if (abr.equals("MD")) {
            return "Maryland";
        } else if (abr.equals("MA")) {
            return "Massachusetts";
        } else if (abr.equals("MI")) {
            return "Michigan";
        } else if (abr.equals("MN")) {
            return "Minnesota";
        } else if (abr.equals("MS")) {
            return "Mississippi";
        } else if (abr.equals("MO")) {
            return "Missouri";
        } else if (abr.equals("MT")) {
            return "Montana";
        } else if (abr.equals("NE")) {
            return "Nebraska";
        } else if (abr.equals("NV")) {
            return "Nevada";
        } else if (abr.equals("NH")) {
            return "New Hampshire";
        } else if (abr.equals("NJ")) {
            return "New Jersey";
        } else if (abr.equals("NM")) {
            return "New Mexico";
        } else if (abr.equals("NY")) {
            return "New York";
        } else if (abr.equals("NC")) {
            return "North Carolina";
        } else if (abr.equals("ND")) {
            return "North Dakota";
        } else if (abr.equals("OH")) {
            return "Ohio";
        } else if (abr.equals("OK")) {
            return "Oklahoma";
        } else if (abr.equals("OR")) {
            return "Oregon";
        } else if (abr.equals("PA")) {
            return "Pennsylvania";
        } else if (abr.equals("RI")) {
            return "Rhode Island";
        } else if (abr.equals("SC")) {
            return "South Carolina";
        } else if (abr.equals("SD")) {
            return "South Dakota";
        } else if (abr.equals("TN")) {
            return "Tennessee";
        } else if (abr.equals("TX")) {
            return "Texas";
        }else if (abr.equals("UT")) {
            return "Utah";
        } else if (abr.equals("VT")) {
            return "Vermont";
        } else if (abr.equals("VA")) {
            return "Virginia";
        } else if (abr.equals("WA")) {
            return "Washington";
        } else if (abr.equals("WV")) {
            return "West Virginia";
        } else if (abr.equals("WI")) {
            return "Wisconsin";
        } else if (abr.equals("WY")) {
            return "Wyoming";
        }
        return "Inserted Unknown State Abreviation";
    }
}
