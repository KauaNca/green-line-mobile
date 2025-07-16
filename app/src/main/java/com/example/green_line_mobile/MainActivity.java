package com.example.green_line_mobile;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // Obtém a referência da WebView no layout XML
        WebView webView = findViewById(R.id.webview);

// Acessa as configurações da WebView
        WebSettings webSettings = webView.getSettings();

// Ativa o DOM Storage, necessário para funcionalidades como localStorage
        webSettings.setDomStorageEnabled(true);

// Permite acesso a arquivos locais no dispositivo
        webSettings.setAllowFileAccess(true);

// Permite acesso ao conteúdo, como arquivos embutidos
        webSettings.setAllowContentAccess(true);

// Faz a WebView carregar a página ajustando ao tamanho da tela
        webView.getSettings().setLoadWithOverviewMode(true);

// Permite que a WebView utilize o viewport para adaptar o site corretamente
        webView.getSettings().setUseWideViewPort(true);

// Habilita o JavaScript, essencial para sites dinâmicos modernos
        webSettings.setJavaScriptEnabled(true);

// Garante que os links e navegação ocorram dentro da própria WebView
        webView.setWebViewClient(new WebViewClient());

// Carrega o site dentro da WebView
        webView.loadUrl("https://kauanca.github.io/green_line_web/");
    }
}