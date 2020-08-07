package com.hard.covid19india

import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.hard.covid19india.adapter.DistrictListAdapter
import com.hard.covid19india.model.StateDistrictData
import com.hard.covid19india.services.GetDataService
import com.hard.covid19india.services.RetrofitClientInstance
import com.hard.covid19india.utils.VerticalSpaceItemDecoration
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DistrictWiseActivity : AppCompatActivity() {

    private lateinit var stateName: String
    lateinit var stateNameText: TextView
    lateinit var districtListRecyclerView: RecyclerView
    lateinit var getDataService: GetDataService
    lateinit var progressBar: ProgressBar
    lateinit var mSwipeRefreshLayout : SwipeRefreshLayout;
    lateinit var districtListAdapter : DistrictListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_district_wise)

        initIntentValues()
        initViews()
        initViewData()
        initListeners()

        getDataService = RetrofitClientInstance.getRetrofitInstance()!!.create(
            GetDataService::class.java
        )

        getData()
        progressBar!!.visibility = View.VISIBLE

    }

    private fun initIntentValues(){
        if (intent != null) {
            stateName = intent.getStringExtra("STATE_NAME")
        }
    }

    private fun initViews(){
        stateNameText = findViewById(R.id.textStateName)
        districtListRecyclerView = findViewById(R.id.rlDistrictList)
        districtListRecyclerView.layoutManager = LinearLayoutManager(this)

        districtListAdapter = DistrictListAdapter(this@DistrictWiseActivity)
        districtListRecyclerView.adapter = districtListAdapter
        districtListRecyclerView.addItemDecoration(VerticalSpaceItemDecoration(30));
        mSwipeRefreshLayout = findViewById(R.id.swiperefresh)
        progressBar = findViewById(R.id.simpleProgressBar)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true);
        supportActionBar!!.setDisplayShowHomeEnabled(true);
    }

    private fun initViewData() {
        stateNameText.text = stateName
    }

    private fun initListeners() {
        mSwipeRefreshLayout.setOnRefreshListener(object : SwipeRefreshLayout.OnRefreshListener{
            override fun onRefresh() {
                getData()
            }

        })
    }

    fun getData(){
        getDataService.getDistrictWiseData().enqueue(object : Callback<List<StateDistrictData>> {
            override fun onFailure(call: Call<List<StateDistrictData>>, t: Throwable) {
                progressBar.visibility = View.GONE
                if(mSwipeRefreshLayout.isRefreshing){
                    mSwipeRefreshLayout.isRefreshing = false
                }
            }

            @RequiresApi(Build.VERSION_CODES.N)
            override fun onResponse(call: Call<List<StateDistrictData>>, response: Response<List<StateDistrictData>>) {
                var stateDistrictDataList: List<StateDistrictData>? = response.body()
                if (stateDistrictDataList != null) {
                    for (item in stateDistrictDataList) {
                        if (item.getState().equals(stateName)) {
                            var selectedStateWithDistrictData: StateDistrictData = item;
                            districtListAdapter.updateData(selectedStateWithDistrictData.getDistrictData());
                            districtListAdapter.notifyDataSetChanged()
                        }
                    }
                }
                progressBar.visibility = View.GONE
                if(mSwipeRefreshLayout.isRefreshing){
                    mSwipeRefreshLayout.isRefreshing = false
                }

            }

        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            android.R.id.home -> finish()
        }
        return true
    }
}
