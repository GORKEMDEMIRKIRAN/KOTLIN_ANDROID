package com.gorkemdemirkiran.android_basics

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.gorkemdemirkiran.android_basics.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        enableEdgeToEdge()

        //setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // İlk açtığımız projelerde VIEW BINDING yapalım.


        println("onCreate çalıştırıldı.")
    }


    // İlk açtığımız projelerde VIEW BINDING yapalım.

    // ANDROID TEMELLERİ - ANDROID BASICS

    // Yaşam Döngüsü

    /*
    onCreate()
    onStart()
    onResume()
    onPause()
    onStop()
    onDestroy()
     */
    // Farklı yerlerden ne yazacağımızı bilmek zorundayız.

    // on yazarak override edeceğimiz fonksiyonlar geliyor.
    // yaşam döngüsünde olanları çağırıcaz.
    // on. start,resume gibi yazarak çağırıyoruz.

    override fun onStart() {
        super.onStart()
        println("onStart çalıştırıldı.")
    }

    override fun onResume() {
        super.onResume()
        println("onResume çalıştırıldı.")
    }

    override fun onPause() {
        super.onPause()
        println("onPause çalıştırıldı.")
    }

    override fun onStop() {
        super.onStop()
        println("onStop çalıştırıldı.")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("onDestroy çalıştırıldı.")
    }
    // onCreate kullanıcı görmez
    // kullanıcının birşeye bakmak isteyince oncreate verileri indirmiş oluyorum.
    // onStart kısa çalışan fonksiyondur.
    // onStart onresume hazırlıktır.
    // oncreate kullanıcı görmüyor.
    // onstart kullanıcı görüyor ama etkileşime başlamıyor.
    // onresume etkileşime geçiyor.
}