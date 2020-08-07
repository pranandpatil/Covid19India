package com.hard.covid19india.services

import com.hard.covid19india.model.MainData
import com.hard.covid19india.model.StateDistrictData
import retrofit2.Call
import retrofit2.http.GET

interface GetDataService {

    @GET("data.json")
    fun getAllMainData(): Call<MainData>

    @GET("v2/state_district_wise.json")
    fun getDistrictWiseData(): Call<List<StateDistrictData>>
}