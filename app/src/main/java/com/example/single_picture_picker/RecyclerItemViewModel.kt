package com.example.single_picture_picker

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.util.ArrayList

class RecyclerItemViewModel(val context: Context, val arrContact: ArrayList<itemViewModel>) : RecyclerView.Adapter<RecyclerItemViewModel.ViewHolder>() {

    class ViewHolder(itemViewModel: View) : RecyclerView.ViewHolder(itemViewModel) {
        val imageView: ImageView = itemViewModel.findViewById(R.id.Image_View)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.d("Tag", "Holder Created")
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list, parent, false))
    }

    override fun getItemCount(): Int {
        Log.d("Tag", "Size Taken")
        return arrContact.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("Tag", "Hello Suffian")
        holder.imageView.setImageURI(arrContact[position].uri)
        Glide.with(context)
            .load(arrContact[position].uri)
            //.override(300, 200)
            .error(R.drawable.ic_launcher_background)
            .into(holder.imageView);
    }
}
