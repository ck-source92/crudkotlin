package com.dwicandra.crud_kotlin_learning

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dwicandra.crud_kotlin_learning.Adapter.AdapterEmployes
import com.dwicandra.crud_kotlin_learning.DAO.DAOEmployess
import com.dwicandra.crud_kotlin_learning.Model.Employes
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.FirebaseException
import com.google.firebase.database.*


class MainActivity : AppCompatActivity(){
    lateinit var fab:FloatingActionButton
    lateinit var mRecyclerView: RecyclerView
    lateinit var adapterEmployes: AdapterEmployes

    var arrayListEmployes : ArrayList<Employes>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fab = findViewById(R.id.feb)
        fab.setOnClickListener(listener)
        addData()

        mRecyclerView = findViewById(R.id.list_employes)
        adapterEmployes = AdapterEmployes(arrayListEmployes)
//        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(this)
        mRecyclerView.layoutManager =  LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mRecyclerView.adapter = adapterEmployes


    }
    val listener = View.OnClickListener { view ->
        when(view.id){
            R.id.feb ->{
                val intent = Intent(this@MainActivity,InputActivity::class.java )
                startActivity(intent)
            }
        }
    }
    fun addData(){
        arrayListEmployes?.add(Employes("","hello",1))
    }

}

