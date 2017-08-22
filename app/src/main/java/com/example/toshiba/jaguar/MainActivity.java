/*

welcome
project black cat
date 15/5/2017
place india gagan's labs
creator gaganklair


*/
package com.example.toshiba.jaguar;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;

public class MainActivity extends AppCompatActivity {

    WebView webView1;
    WebView webView2;
    ProgressBar progressBar2;
    ProgressBar progressBar1;
    FloatingActionButton fab2;
    DrawerLayout layout1;
    ViewSwitcher ViewSwitcher;
    int a;
    int height1=500;
    int b = 2;
    private ViewSwitcher vs;
    private ViewSwitcher vs1;


    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        layout1 = (DrawerLayout) findViewById(R.id.properLayout1);
        layout1.setVisibility(View.GONE);


        progressBar1 = (ProgressBar) findViewById(R.id.prograssbar1);
        progressBar1.setVisibility(View.INVISIBLE);
        progressBar2 = (ProgressBar) findViewById(R.id.prograssbar2);

        fab2 = (FloatingActionButton) findViewById(R.id.fab1);
        fab2.isInTouchMode();




        vs = (ViewSwitcher) findViewById(R.id.vs);



        //for web view 2
        webView2 = (WebView) findViewById(R.id.webview2);
        WebSettings websettings2 = webView2.getSettings();
        websettings2.setJavaScriptEnabled(true);
        webView2.setWebChromeClient(new WebChromeClient());
        webView2.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressBar2.setVisibility(View.VISIBLE);
                webView2.setVisibility(View.INVISIBLE);
                //ConstraintLayout constraint = (ConstraintLayout)findViewById(R.id.constraint);
               // constraint.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onPageCommitVisible(WebView view, String url) {
                super.onPageCommitVisible(view, url);
               progressBar2.setVisibility(View.INVISIBLE);
                webView2.setVisibility(View.VISIBLE);
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);

                Toast.makeText(MainActivity.this, "opps network problem",
                      Toast.LENGTH_LONG).show();

            }

        });
        webView2.loadUrl("https://google.com");



         //for web view 1
        webView1 = (WebView) findViewById(R.id.webview1);
        WebSettings websettings = webView1.getSettings();
        websettings.setJavaScriptEnabled(true);
        webView1.setWebChromeClient(new WebChromeClient());
        //webView1.loadUrl("https://google.com");
        webView1.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressBar1.setVisibility(view.VISIBLE);
                webView1.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onPageCommitVisible(WebView view, String url) {
                super.onPageCommitVisible(view, url);
                progressBar1.setVisibility(view.INVISIBLE);
                webView1.setVisibility(View.VISIBLE);
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);

                //Toast.makeText(MainActivity.this, "",
                //      Toast.LENGTH_LONG).show();
                progressBar1.setVisibility(view.GONE);
            }
        });

        //logic for back button


        final ConstraintLayout c1 = (ConstraintLayout) findViewById(R.id.con);
        c1.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {

                a = 3;
                return false;
            }

        });


        final ConstraintLayout c2 = (ConstraintLayout) findViewById(R.id.c2);
        c2.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {

                a = 1;
                return false;
            }
        });


        // fab 1 button for fullscreen in first web view
        final DrawerLayout propLayout = (DrawerLayout) findViewById(R.id.properLayout1);
        fab2 = (FloatingActionButton) findViewById(R.id.fab1);
        final DrawerLayout finalPropLayout = propLayout;
        fab2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (finalPropLayout.getVisibility() == View.VISIBLE) {
                    finalPropLayout.setVisibility(View.GONE);
                    ViewGroup.LayoutParams params = propLayout.getLayoutParams();
                    params.height = MATCH_PARENT;
                    propLayout.setLayoutParams(params);


                } else {
                    finalPropLayout.setVisibility(View.VISIBLE);
                    DrawerLayout layout = (DrawerLayout) findViewById(R.id.properLayout);
                    ViewGroup.LayoutParams params = layout.getLayoutParams();
                    layout.getHeight();
                    int i=2;
                    final int i1 = params.height / i;
                    layout.setLayoutParams(params);


                }


            }
        });



        // fullscreen button for second web view
        final DrawerLayout propLayout1 = (DrawerLayout) findViewById(R.id.properLayout);
        FloatingActionButton fab4 = (FloatingActionButton) findViewById(R.id.floatingActionButton2);
        fab4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (propLayout1.getVisibility() == View.VISIBLE) {
                    propLayout1.setVisibility(View.GONE);
                    DrawerLayout layout1 = (DrawerLayout) findViewById(R.id.properLayout);
                    ViewGroup.LayoutParams params = layout1.getLayoutParams();
                    params.height=MATCH_PARENT;
                    layout1.setLayoutParams(params);


                } else {
                    propLayout1.setVisibility(View.VISIBLE);
                    DrawerLayout layout1 = (DrawerLayout) findViewById(R.id.properLayout1);
                    ViewGroup.LayoutParams params = layout1.getLayoutParams();
                    final int i = params.height / 2;
                    layout1.setLayoutParams(params);
                   // Toast.makeText(MainActivity.this, "im in fab 2 else", Toast.LENGTH_LONG).show();

                }
            }
        });


        //refresh button for window1

        FloatingActionButton floatingrefreshbutton = (FloatingActionButton) findViewById(R.id.floatingrefreshbutton);
        floatingrefreshbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DrawerLayout close = (DrawerLayout) findViewById(R.id.properLayout);
                close.closeDrawers();
                webView1.reload();

            }
        });


        //refresh button for window1

        FloatingActionButton homebutton = (FloatingActionButton) findViewById(R.id.homebutton);
        homebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DrawerLayout close = (DrawerLayout) findViewById(R.id.properLayout);
                close.closeDrawers();
                vs.showNext();

            }
        });




        //home button for window 1

        ImageButton facebook = (ImageButton) findViewById(R.id.facebook);
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView1.loadUrl("https://facebook.com");
                vs.showNext();

            }
        });
        ImageButton google = (ImageButton) findViewById(R.id.google);
        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView1.loadUrl("https://google.com");
                vs.showNext();

            }
        });ImageButton youtube = (ImageButton) findViewById(R.id.youtube);
        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView1.loadUrl("https://youtube.com");
                vs.showNext();

            }
        });


        //home button for webview 2
        ImageButton imageButton11 = (ImageButton) findViewById(R.id.homebutton2);
        imageButton11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DrawerLayout close = (DrawerLayout) findViewById(R.id.properLayout1);
                close.closeDrawers();
                vs.showPrevious();

            }
        });



        //refresh button for webview 2
        ImageButton refreshbutton2 = (ImageButton) findViewById(R.id.refreshButton2);
        refreshbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DrawerLayout close = (DrawerLayout) findViewById(R.id.properLayout1);
                close.closeDrawers();
                webView2.reload();

            }
        });





        ImageButton bluedot = (ImageButton) findViewById(R.id.bluedot);
        bluedot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




            }
        });






    }





    @Override
    public void onBackPressed() {

        if (a>b) {

                       webView1.goBack();

                    }
                    else
                    {
                        webView2.goBack();

                    }
                    return;
            }}

