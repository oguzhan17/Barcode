package com.trio.barcode

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductRecyclerAdapter(private val BarcodeNoArray: ArrayList<String>): RecyclerView.Adapter<ProductRecyclerAdapter.BarcodeNoHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BarcodeNoHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.recycler_view,parent,false)
        return BarcodeNoHolder(view)
          }

    override fun getItemCount(): Int {
        return  BarcodeNoArray.size
            }

    override fun onBindViewHolder(holder: BarcodeNoHolder, position: Int) {
       holder.recyclerBarcodeNo?.text = BarcodeNoArray[position]
        }

    class BarcodeNoHolder(view: View) : RecyclerView.ViewHolder(view){
        var recyclerBarcodeNo : TextView? = null
      //  var recyclerImageNo : ImageView? = null

        init {
            recyclerBarcodeNo = view.findViewById(R.id.recyclerBarcodeNo)
          //  recyclerImageNo = view.findViewById(R.id.recyclerImageNo)
        }
    }
}