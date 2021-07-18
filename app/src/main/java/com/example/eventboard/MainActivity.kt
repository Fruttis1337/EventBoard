package com.example.eventboard

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.eventboard.Interface.RetrofitServices
import com.example.eventboard.common.Common
import com.example.eventboard.databinding.ActivityMainBinding
import dmax.dialog.SpotsDialog
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var mService: RetrofitServices
    lateinit var adapter: Adapter
    lateinit var dialog: AlertDialog
    var binding = ActivityMainBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mService = Common.retrofitServices
        dialog = SpotsDialog.Builder()
            .setCancelable(true)
            .setContext(this)
            .build()


        val view = binding.root
        setContentView(R.layout.activity_main)

        binding.recycle.setHasFixedSize(true)
        binding.recycle.layoutManager = LinearLayoutManager(this)

        getAllEvents()
    }

    private fun getAllEvents() {
        dialog.show()
        mService.getEvents().enqueue(object : Callback<MutableList<Events>> {
            override fun onFailure(call: Call<MutableList<Events>>, t: Throwable) {

            }

            override fun onResponse(call: Call<MutableList<Events>>, response: Response<MutableList<Events>>) {
                adapter = Adapter(response.body() as MutableList<Events>)
                adapter.notifyDataSetChanged()
                binding.recycle.adapter = adapter

                dialog.dismiss()
            }
        })
    }
}