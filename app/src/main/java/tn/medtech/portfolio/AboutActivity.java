package tn.medtech.portfolio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class AboutActivity extends AppCompatActivity {

    PDFView mPDFView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        mPDFView = (PDFView) findViewById(R.id.pdfView);
        mPDFView.fromAsset("cv.pdf").load();
    }



}
