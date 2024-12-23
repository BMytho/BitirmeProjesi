package com.example.kataraktgztesti

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kataraktgztesti.GormeTesti.GozSagligiBaslamaActivity
import com.example.kataraktgztesti.GormeTesti.GozSagligiTestActivity
import com.example.kataraktgztesti.RenkKoru.RenkKoruTestiActivity
import com.example.kataraktgztesti.databinding.ActivityAnaSayfaBinding

class AnaSayfaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAnaSayfaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Binding ataması
        binding = ActivityAnaSayfaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // RecyclerView LayoutManager atama
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        // Liste elemanlarını tanımlama
        val items: MutableList<CardItem> = ArrayList()
        items.add(CardItem("Katarakt Nedir? Nasıl Anlaşılır", "Katarakt olduğunu nasıl anlarsınız? Belirtileri nelerdir?"))
        items.add(CardItem("Renk Körü Testi", "Renk körlüğü nedir, nasıl anlaşılır? Renk körü müsünüz?"))
        items.add(CardItem("Gözleriniz Ne Kadar İyi Görüyor", "Göz sağlığınız ne kadar yerinde? Test edin!"))

        // Adapter ve Click Listener bağlama
        val adapter = RecyclerViewAdapter(this, items) { selectedItem ->
            // Tıklanan elemanlara göre sayfa yönlendirmesi yap
            when (selectedItem.title) {
                "Katarakt Nedir? Nasıl Anlaşılır" -> {
                    startActivity(Intent(this, KataraktInfoActivity::class.java))
                }
                "Renk Körü Testi" -> {
                    startActivity(Intent(this, RenkKoruTestiActivity::class.java))
                }
                "Gözleriniz Ne Kadar İyi Görüyor" -> {
                    startActivity(Intent(this, GozSagligiBaslamaActivity::class.java))
                }
            }
        }
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

// RecyclerView'a boşluk eklemek
        val spaceDecoration = SpacesItemDecoration(16) // 16dp boşluk
        recyclerView.addItemDecoration(spaceDecoration)


        binding.recyclerView.adapter = adapter
    }
}
