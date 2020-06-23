package tn.medtech.portfolio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private Button Fiverr;
    private Button Contact;
    private Button Feedback;
    private Button About;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fiverr = (Button) findViewById(R.id.fiverr);
        Contact = (Button) findViewById(R.id.contact);
        Feedback = (Button) findViewById(R.id.feedback);
        About = (Button) findViewById(R.id.about);

        Feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFeedbackActivity();
            }
        });
        About.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAboutActivity();
            }
        });
    }

    private void openAboutActivity() {
        Intent about_intent = new Intent(this, AboutActivity.class);
        startActivity(about_intent);
    }

    public void goToFiverr(View view) {
        goToUrl("https://www.fiverr.com/mohamedaleya");
    }

    private void goToUrl(String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

    public void openFeedbackActivity() {
        Intent feedback_intent = new Intent(this, FeedbackActivity.class);
        startActivity(feedback_intent);

    }

    public void call(View v){
        Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:52612330"));
        if (callIntent.resolveActivity(getPackageManager()) != null){
            startActivity(callIntent);
            finish();
        }else{
            Toast.makeText(this,"The send action could not be performed!",Toast.LENGTH_LONG).show();
        }
    }
}
