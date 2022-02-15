package com.example.sharedprefk

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.oguzh.sharedprefk.R

val dosya_yolu = "com.example.sharedprefk"
val anahtar_isim = "isim"
val anahtar_yas = "yas"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println("onCreate Çağırıldı")

        var kaydet = findViewById<Button>(R.id.kaydet)
        var sil = findViewById<Button>(R.id.sil)
        var isim = findViewById<EditText>(R.id.isim)
        var yas = findViewById<EditText>(R.id.yas)
        var tutucu = getSharedPreferences(dosya_yolu, Context.MODE_PRIVATE)
        var tutucuedit = tutucu.edit()

        Toast.makeText(applicationContext,
            "İsim : ${tutucu.getString(anahtar_isim, "Deger Yok")} \n" +
                    "Yaş : ${tutucu.getInt(anahtar_yas,0)} \n "
            , Toast.LENGTH_LONG).show()

        kaydet.setOnClickListener {

            tutucuedit.putString(anahtar_isim, isim.text.toString())
            tutucuedit.putInt(anahtar_yas, yas.text.toString().toInt())
            tutucuedit.commit()
            Toast.makeText(applicationContext,"Kayıt Başarılı",Toast.LENGTH_SHORT).show()
        }

        sil.setOnClickListener {
            tutucuedit
                .remove(anahtar_isim)
                .remove(anahtar_yas)
                .commit()
            Toast.makeText(applicationContext,"Silme İşlemi Başarılı",Toast.LENGTH_SHORT).show()

        }
    }
}