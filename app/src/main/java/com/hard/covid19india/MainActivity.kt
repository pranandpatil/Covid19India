package com.hard.covid19india

import android.content.Intent
import android.graphics.Paint
import android.net.Uri
import android.os.Bundle
import android.text.Html
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.hard.covid19india.model.MainData
import com.hard.covid19india.model.StateWise
import com.hard.covid19india.services.GetDataService
import com.hard.covid19india.services.RetrofitClientInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    lateinit var tvConfirmedCount : TextView
    lateinit var tvActiveCount : TextView
    lateinit var tvRecoveredCount : TextView
    lateinit var tvConfirmed : TextView
    lateinit var tvRecovered : TextView
    lateinit var tvAppLink : TextView
    lateinit var buttonStateWise : Button
    lateinit var mSwipeRefreshLayout : SwipeRefreshLayout;
    lateinit var getDataService: GetDataService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        initListener()
        getDataService = RetrofitClientInstance.getRetrofitInstance()!!.create(GetDataService::class.java)

        getData()
        mSwipeRefreshLayout.isRefreshing = true

    }

    fun initViews(){
        tvConfirmedCount = findViewById(R.id.tvConfirmedCount)
        tvActiveCount = findViewById(R.id.tvActiveCount)
        tvRecoveredCount = findViewById(R.id.tvRecoveredCount)
        tvConfirmed = findViewById(R.id.tvConfirmed)
        tvRecovered = findViewById(R.id.tvRecovered)
        tvAppLink = findViewById(R.id.tvAppLink)
        buttonStateWise = findViewById(R.id.buttonStateWise)
        mSwipeRefreshLayout = findViewById(R.id.swiperefresh)
        tvAppLink.paintFlags = Paint.UNDERLINE_TEXT_FLAG
    }

    private fun initListener(){
        buttonStateWise.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                val stateWiseIntent = Intent(this@MainActivity, StateWiseActivity::class.java);
                startActivity(stateWiseIntent)
            }
        })

        mSwipeRefreshLayout.setOnRefreshListener(object : SwipeRefreshLayout.OnRefreshListener{
            override fun onRefresh() {
                getData()
            }
        })

        tvAppLink.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                intent = Intent(android.content.Intent.ACTION_VIEW);
                intent.data = Uri.parse("https://play.google.com/store/apps/details?id=nic.goi.aarogyasetu");
                startActivity(intent);
            }

        })
    }
    fun getData(){
        getDataService.getAllMainData()
            .enqueue(object: Callback<MainData> {
                override fun onFailure(call: Call<MainData>, t: Throwable) {
                    if(mSwipeRefreshLayout.isRefreshing){
                        mSwipeRefreshLayout.isRefreshing = false
                    }
                }
                override fun onResponse(call: Call<MainData>, response: Response<MainData>) {
                    val mainData : MainData? = response.body()
                    setDataToViews(mainData!!.getStateWise()!![0])
                    if(mSwipeRefreshLayout.isRefreshing){
                        mSwipeRefreshLayout.isRefreshing = false
                    }
                }
            })
    }

    fun setDataToViews(currentTotalData : StateWise?){
        tvConfirmedCount.text = currentTotalData!!.getConfirmed()
        tvActiveCount.text = currentTotalData!!.getActive()
        tvRecoveredCount.text = currentTotalData!!.getRecovered()

        if(currentTotalData!!.getDeltaconfirmed()!!.toInt() > 0){
            val updatedStr = getString(R.string.confirmed) + "  [+" +currentTotalData.getDeltaconfirmed()+"]"
            tvConfirmed.text = updatedStr
        }
        if(currentTotalData.getDeltarecovered()!!.toInt() > 0){
            val updatedStr = getString(R.string.recovered) + "  [+" +currentTotalData.getDeltarecovered()+"]"
            tvRecovered.text = updatedStr
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.option_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.about -> {
                startActivity(Intent(this, AboutActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
