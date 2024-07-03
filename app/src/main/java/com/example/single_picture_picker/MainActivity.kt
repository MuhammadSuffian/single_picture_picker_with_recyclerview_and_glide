package com.example.single_picture_picker


import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var btn: Button
    val dataobject = ArrayList<itemViewModel>()
    lateinit var recyclerAdapter: RecyclerItemViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recycleview)
        recyclerView.setItemViewCacheSize(20)
        btn = findViewById(R.id.button)


        Log.d("Tag", "Adapter and RecyclerView set up")
        recyclerAdapter = RecyclerItemViewModel(this, dataobject)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = recyclerAdapter
        val imagepickerLauncher = registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
            if (uri != null) {
                Log.d("Tag", "Image URI: $uri")
                dataobject.add(itemViewModel(uri))
                recyclerAdapter.notifyDataSetChanged()
            } else {
                Log.d("Tag", "Image URI is null")
            }
        }

        btn.setOnClickListener {
            Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show()
            imagepickerLauncher.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
            Log.d("Tag", "Button Clicked")
        }

    }
}
