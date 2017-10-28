package com.example.sreeharirammohan.googlebooksapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "Sreehari";
    private EditText mBookInput;
    private TextView mAuthor, mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBookInput = (EditText) findViewById(R.id.bookInput);
        mAuthor = (TextView) findViewById(R.id.authorText);
        mTitle = (TextView) findViewById(R.id.titleText);

    }

    public void searchBooks(View view) {
        String queryString = mBookInput.getText().toString().trim();
        Log.i(TAG, "Search books: " + queryString);

        new FetchBook(mAuthor, mTitle).execute(queryString);



    }
}
