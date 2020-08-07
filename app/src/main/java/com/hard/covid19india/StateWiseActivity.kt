package com.hard.covid19india

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.hard.covid19india.adapter.StateListAdapter
import com.hard.covid19india.model.MainData
import com.hard.covid19india.model.StateWise
import com.hard.covid19india.services.GetDataService
import com.hard.covid19india.services.RetrofitClientInstance
import com.hard.covid19india.utils.VerticalSpaceItemDecoration
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StateWiseActivity : AppCompatActivity(), StateListAdapter.OnItemClickListener {
    lateinit var stateListRecyclerView : RecyclerView
    lateinit var getDataService: GetDataService
    lateinit var progressBar: ProgressBar
    lateinit var mSwipeRefreshLayout : SwipeRefreshLayout;
    lateinit var stateListAdapter : StateListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_state_wise)

        initViews()
        initListeners()
        getDataService = RetrofitClientInstance.getRetrofitInstance()!!.create(
            GetDataService::class.java)

        getData()
        progressBar!!.visibility = View.VISIBLE
    }

    private fun initViews(){
        stateListRecyclerView = findViewById(R.id.rlStateList)
        stateListRecyclerView.layoutManager = LinearLayoutManager(this)
        stateListAdapter = StateListAdapter(this@StateWiseActivity, this@StateWiseActivity)
        stateListRecyclerView.adapter = stateListAdapter
        stateListRecyclerView.addItemDecoration(VerticalSpaceItemDecoration(30));
        mSwipeRefreshLayout = findViewById(R.id.swiperefresh)
        progressBar = findViewById(R.id.simpleProgressBar)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true);
        supportActionBar!!.setDisplayShowHomeEnabled(true);
    }

    private fun initListeners() {
        mSwipeRefreshLayout.setOnRefreshListener(object : SwipeRefreshLayout.OnRefreshListener{
            override fun onRefresh() {
                getData()
            }

        })
    }

    fun getData(){
        getDataService.getAllMainData()
            .enqueue(object: Callback<MainData> {
                override fun onFailure(call: Call<MainData>, t: Throwable) {
                    progressBar.visibility = View.GONE
                    if(mSwipeRefreshLayout.isRefreshing){
                        mSwipeRefreshLayout.isRefreshing = false
                    }
                }

                override fun onResponse(call: Call<MainData>, response: Response<MainData>) {
                    val mainData : MainData? = response.body()
                    val size : Int = mainData!!.getStateWise()!!.size
                    var onlyStateData : List<StateWise?>? =  mainData!!.getStateWise()!!.subList(1, size -1)
                    stateListAdapter.updateData(onlyStateData);
                    stateListAdapter.notifyDataSetChanged()
                    progressBar.visibility = View.GONE
                    if(mSwipeRefreshLayout.isRefreshing){
                        mSwipeRefreshLayout.isRefreshing = false
                    }
                }
            })
    }

    override fun onItemClick(item: StateWise?) {
        val distWiseIntent : Intent = Intent(this@StateWiseActivity, DistrictWiseActivity::class.java)
        distWiseIntent.putExtra("STATE_NAME", item!!.getState());
        startActivity(distWiseIntent)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            android.R.id.home -> finish()
        }
        return true
    }
}
