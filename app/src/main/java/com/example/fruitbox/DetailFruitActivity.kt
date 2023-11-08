package com.example.fruitbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fruitbox.databinding.ActivityDetailFruitBinding

class DetailFruitActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailFruitBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailFruitBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            val gambar = intent.getIntExtra("fruit_image", R.drawable.apel_fuji)
            val status = intent.getStringExtra("fruit_status")


            imgFruit.setImageResource(gambar)

            judulbuahTxt.text= intent.getStringExtra("fruit_name")
            jenisTxt.text= intent.getStringExtra("fruit_type")
            hargaTxt.text= intent.getStringExtra("fruit_price")
            statusTxt.text= intent.getStringExtra("fruit_status" )
            deskripsibuahTxt.text = intent.getStringExtra("fruit_desc")


            if (status == "TERSEDIA") {
                statusTxt.setBackgroundResource(R.drawable.fruit_label_avail)
            } else
                statusTxt.setBackgroundResource(R.drawable.fruit_label_sold)




        }




    }
}