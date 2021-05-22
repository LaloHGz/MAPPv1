package com.aplication.mapp.menu;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.aplication.mapp.ConectionManager;
import com.aplication.mapp.InternetConectionActivity;
import com.aplication.mapp.R;

public class CompilerFragment extends Fragment  {

    private WebView webView;


    @SuppressLint("SetJavaScriptEnabled")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         View view = inflater.inflate(R.layout.fragment_compiler, container, false);

        if (ConectionManager.checkConection(getContext()))
        {

        }
        else
        {
            Intent intent=new Intent(getContext(), InternetConectionActivity.class);
            startActivity(intent);
        }

        webView = view.findViewById(R.id.webview);

         return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.programiz.com/python-programming/online-compiler/");
    }
}
