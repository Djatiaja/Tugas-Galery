package com.example.tugasgaleri

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.helper.widget.Grid
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tugasgaleri.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageAdapter =ImageAdapter(generateDummyData())

        with(binding){
            rvImage.apply {
                    adapter =imageAdapter
                    layoutManager = GridLayoutManager(this@MainActivity, 3)
            }
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun generateDummyData(): List<Image>{
        return listOf(
                Image("https://images.unsplash.com/photo-1506748686214-e9df14d4d9d0"),
                Image("https://images.unsplash.com/photo-1506748686214-e9df14d4d9d0"),
                Image("https://images.unsplash.com/photo-1506748686214-e9df14d4d9d0"),
                Image("https://images.unsplash.com/photo-1506748686214-e9df14d4d9d0"),
                Image("https://images.unsplash.com/photo-1506748686214-e9df14d4d9d0"),
                Image("https://images.unsplash.com/photo-1506748686214-e9df14d4d9d0"),
        )
    }

}