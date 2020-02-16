package com.trio.barcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.util.isNotEmpty
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.vision.Detector
import com.google.android.gms.vision.barcode.Barcode
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_product.*
import java.util.ArrayList

private lateinit var db: FirebaseFirestore

class ProductActivity : AppCompatActivity() {
    private lateinit var db: FirebaseFirestore

    var barcodeNoFromFB :ArrayList<String> = ArrayList()
    var imageFromFB: ArrayList<String> = ArrayList()

    var adapter: ProductRecyclerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)
        db = FirebaseFirestore.getInstance()
        getDataFromFirestore()

        //recycler view
        var layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        adapter = ProductRecyclerAdapter(barcodeNoFromFB)
        recyclerView.adapter = adapter


        }



fun getDataFromFirestore() {
    db.collection("BarcodeId").orderBy("barcodeNo",
        Query.Direction.DESCENDING).addSnapshotListener { snapshot, exception ->
        if (exception != null) {
            Toast.makeText(applicationContext,exception.localizedMessage.toString(),Toast.LENGTH_LONG).show()
        } else {

            if (snapshot != null) {
                if (!snapshot.isEmpty) {

                    barcodeNoFromFB.clear()
                  //  imageFromFB.clear()


                    val documents = snapshot.documents
                    for (document in documents) {
                        val barcodeNo = document.get("barcodeNo") as String
                    //    val useremail = document.get("userEmail") as String
                     //   val date = timestamp.toDate()

                        barcodeNoFromFB.add(barcodeNo)
                       // imageFromFB.add(comment)


                        adapter!!.notifyDataSetChanged()

                    }


                }
            }

        }
    }

}
}



