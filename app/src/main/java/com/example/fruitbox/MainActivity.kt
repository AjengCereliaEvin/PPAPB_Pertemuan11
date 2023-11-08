package com.example.fruitbox

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fruitbox.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate((layoutInflater))
        setContentView(binding.root)

        var adapterFruit = FruitAdapter(generateFruitsData()) {
                fruit ->
            Toast.makeText(this@MainActivity, "Anda memilih ${fruit.name}",
                Toast.LENGTH_SHORT).show()


            val intent = Intent(this, DetailFruitActivity::class.java)

            intent.putExtra("fruit_name", fruit.name)
            intent.putExtra("fruit_type", fruit.type)
            intent.putExtra("fruit_status", fruit.status)
            intent.putExtra("fruit_price", fruit.price)
            intent.putExtra("fruit_desc", fruit.desc)
            intent.putExtra("fruit_image", fruit.imageFruitId)

            startActivity(intent)
        }
        with(binding) {
            rvStudents.apply {
                adapter = adapterFruit
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }
    }

    fun generateFruitsData() : List<Fruit>{
        return listOf(
            Fruit(
                name = "Apel ",
                type = "Apel Fuji",
                status = "TERSEDIA",
                price = "Rp 25.000,-/kg",
                desc = "Apel Fuji adalah varietas apel Jepang yang diproduksi oleh penyerbukan silang varietas Red Delicious dan Virginia Ralls Janet pada akhir 1930-an. Apel ini dibedakan oleh kulit merah-kuning yang mengelilingi daging putih krem. Apel ini terkenal dengan rasa manis yang luar biasa, keasaman rendah, ketegasan, dan kerenyahan.",
                imageFruitId = R.drawable.apel_fuji),
            Fruit(
                name = "Pisang",
                type = "Cavendish",
                status = "KOSONG",
                price = "Rp 15.000,-/kg",
                desc = " Jeruk Siam memiliki rasa segar, manis, dan sedikit asam. Buah ini kaya akan vitamin C dan mendukung sistem kekebalan tubuh, serta baik untuk kesehatan jantung.",
                imageFruitId = R.drawable.banana
            ),
            Fruit(
                name = "Anggur",
                type = "Crimson",
                status = "TERSEDIA",
                price = "Rp 16.000,-/kg",
                desc = "Anggur adalah buah yang ditanam di berbagai wilayah dunia, dengan varietas Crimson berasal dari Amerika Serikat. Anggur Crimson memiliki rasa manis dan unik. Buah ini merupakan sumber antioksidan dan serat yang baik untuk kesehatan jantung dan melawan radikal bebas.",
                imageFruitId = R.drawable.anggur_merah),



            )
    }
}