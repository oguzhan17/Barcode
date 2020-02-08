package com.trio.barcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore

private lateinit var db: FirebaseFirestore

class ProductActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)
        db = FirebaseFirestore.getInstance()

    //    getDataFromFirestore()
    }
/*
     private fun getDataFromFirestore(){
        db.collection("BarcodeId").addSnapshotListener { snapshot, exception ->
            if (exception!= null){
                Toast.makeText(applicationContext,exception.localizedMessage.toString(),Toast.LENGTH_LONG).show()
            }
            else{
                if(snapshot != null){
                    if(!snapshot.isEmpty){

                        val documents = snapshot.documents
                        for (document in documents){

                            val barcodeNo = document.get("barcodeNo") as String

                            println(barcodeNo)

                }
            }
        }
    }
}}
*/
}