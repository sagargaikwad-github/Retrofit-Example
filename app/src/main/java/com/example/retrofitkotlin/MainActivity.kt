package com.example.retrofitkotlin

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide

import com.example.retrofitkotlin.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        getData()


        binding.changeBTN.setOnClickListener {
            getData()
        }
    }

    private fun getData() {

        val progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Please wait...")
        progressDialog.show()


        RetrofitInstance.apiInterface.getData().enqueue(object : Callback<responseDataClass?> {
            override fun onResponse(
                call: Call<responseDataClass?>,
                response: Response<responseDataClass?>
            ) {
                var title = response.body()?.title
                var image = response.body()?.url
                var author = response.body()?.author

                binding.titleTV.text = title
                binding.authorTV.text = author


                Glide.with(this@MainActivity).load(image).into(binding.imgView)

                progressDialog.hide()


            }

            override fun onFailure(call: Call<responseDataClass?>, t: Throwable) {
                progressDialog.hide()
                Toast.makeText(this@MainActivity, t.localizedMessage, Toast.LENGTH_LONG).show()


            }
        })
    }
}