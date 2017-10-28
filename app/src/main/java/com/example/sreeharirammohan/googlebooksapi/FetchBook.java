package com.example.sreeharirammohan.googlebooksapi;

import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by sreeharirammohan on 10/28/17.
 */

public class FetchBook extends AsyncTask<String, Void, String> {

    private TextView mAuthorText;
    private TextView mTitleText;

    public FetchBook(TextView mAuthorText, TextView mTitleText) {
        this.mAuthorText = mAuthorText;
        this.mTitleText = mTitleText;
    }

    @Override
    protected String doInBackground(String... params) {
        return NetworkUtils.getBookInfo(params[0]);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        try {
            JSONObject jsonObject = new JSONObject(s);
            JSONArray itemsArray = jsonObject.getJSONArray("items");


                JSONObject book = itemsArray.getJSONObject(0);
                String title = null;
                String authors = null;
                JSONObject volumeInfo = book.getJSONObject("volumeInfo");


                try {
                    title = volumeInfo.getString("title");
                    String[] all_athors = volumeInfo.getString("authors").split(",");
                    authors = all_athors[0].substring(2, all_athors[0].length()-1);
                } catch(Exception e) {
                    e.printStackTrace();
                }

                if(title != null && authors != null) {
                    mTitleText.setText(title);
                    mAuthorText.setText(authors);
                    return;
                }

                mTitleText.setText("No results found");



        } catch (Exception e) {
            e.printStackTrace();
            mTitleText.setText("No results found");
        }

    }
}
