package com.gorkemdemirkiran.application_one

import android.os.Binder
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.gorkemdemirkiran.application_one.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // aktif ederken "binding" değişkenini tanımlıyoruz.
    // İlk satır örnek olarak verilmiştir.
    //  örnek:     private lateinit var binding: ResultProfileBinding
    // ResultProfileBinding değişken bizim "xml" uzantılı olan dosyamızdan geliyor.
    // "ActivityMainBinding" olur arav olsaydı "aravBinding" olurdu.
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        // BU kısımda active ediyoruz.
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)    // setcontentview binding tanımlıyoruz.



        enableEdgeToEdge()

        // serContentView anlamı
        // R = resource ifade ediyor.
        //R.layout.activity_main = "res" içindeki layout dosyası içindeki "activity_main.xml" bağlanıyor.
        // başka xml açıp onlarıda bağlayabiliriz.


        // R.layout ile bağlamaya gerek kalmıyor binding bağladık.
        // setContentView(R.layout.activity_main)

        // Bu kısım ilerde görücez ama telefon kısmında görünen üst bar ve alttaki şeyleri değiştiriyor.
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }




        // Şimdi activity layout sayfasında tasarladığımız görsele nasıl erişicez ona bakalım.

        // görsele eriştik ve değiştirdik.
        val image = findViewById<ImageView>(R.id.ıstanbul_ımage)
        image.setImageResource(R.drawable.istanbul2)
        // yazıya eriştik ve değiştirdik.
        val my_text= findViewById<TextView>(R.id.alt_yazı)
        my_text.text="KOTLIN"

        // findviewbyıd kullanmak verimli değildir. Çünkü bütün "ıd" gezerek eşitleme yapıyor.
        // binlerce ıd olunca çalışşırsa yavaşlayabilir.

        // View Binding ise her birini sınıflara bölerek sabit zamanda ulaşmayı sağlıyor.
        // view binding yapmak için ise  "Gradle Scripts" içinde "build.gradle.kts(module:app)
        // gidiyoruz.  Burada view binding aktif hale getirmek için giriyoruz.
        // kurulum için 2 seçenek var internete "Android View Binding"  aratarak kurulumunu görebiliriz.
        // Modern ve Kotlin olarak 2 tane gradle seçeneği var.

        // android altına ekleyerek kurulumu yapıyoruz.Daha sonra sağ üstte "syns Now" ile
        // aktif hale getiriyoruz.

        // buildFeatures {
        //        viewBinding = true
        //    }

        // 2 kullanım yöntemi var.
        // 1- etkinliklerde görünüm bağlamayı kullanma    (Use view binding in activities)
        // 2- Parçalar halinde görünüm bağlamayı kullanma ( use view binding in fragments)

        // fragments sonra öğrenicez.


        // Artık findviewbyıd gerek kalmadan "binding." ile elementlere ulaşabiliyoruz.
        // "findviewbyıd" ile veya "binding" her ikisiyle ulaşabiliriz.

        binding.altYaz.text="NEW KOTLIN"
        // Tek dezavantajı yeni bir projede baştan tanımlamamız gerekiyor.
        // avantajı ise sabit zamanda getirerek daha hızlı çalışma sağlar.






        // ŞİMDİ BUTONLARLA BUNU NASIL KULLANICAZ ONA BAKALIM.
        // button tıklanınca yapılacak şeyleri ögreniyoruz.



        // 1.yöntem

        /*
        binding.button.setOnClickListener {
            binding.altYaz.text="Butona tıklandı."
        }
        */

        // 2.yöntem
        // xml içinden buttonlara tıklayıp "onclick" bularak isim ver.
        // Orada verdiğin isimler o button için verdiğin isimde fonk oluşturacaktır.
        // xml içinde "android:onClick:"kaydet" gibi isimle tanımlıyoruz.




    }


    fun SAVE(view:View){
        // 3 koşul var bunlar;
        // 1 - private olmayacak
        // 2 - ismi birebir aynı olucak.
        // (view : View) olucak.
        // view : parametre ismi
        // View : görünüm sınıfı ismi
        binding.altYaz.text="Kaydedildi."
    }
    fun EXIT(view:View){
        binding.altYaz.text="Kaydedilmedi."
    }





}