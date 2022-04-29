package genderizeapp.kotlin.com.genderize

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadGender()
    }

    private fun loadGender() {
        val serviceGenerator = ServiceGenerator.buildService(ApiService::class.java)

        val recyclerView = findViewById<RecyclerView>(R.id.listLuc)

        serviceGenerator.getLuc().enqueue(object : Callback<GenderModel> {

            override fun onResponse(call: Call<GenderModel>, response: Response<GenderModel>) {

                if (response.isSuccessful) {
                    recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                    recyclerView.adapter = GenderAdapter(response.body()!!)
                }
            }

            override fun onFailure(call: Call<GenderModel>, t: Throwable) {
                t.printStackTrace()
                Log.e("error", t.message.toString())
            }
        })

    }
}