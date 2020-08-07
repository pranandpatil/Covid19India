package com.hard.covid19india.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class StateDistrictData {

    @SerializedName("state")
    @Expose
    private var state: String? = null
    @SerializedName("districtData")
    @Expose
    private var districtData: List<DistrictData?>? = null

    fun getState(): String? {
        return state
    }

    fun setState(state: String?) {
        this.state = state
    }

    fun getDistrictData(): List<DistrictData?>? {
        return districtData
    }

    fun setDistrictData(districtData: List<DistrictData?>?) {
        this.districtData = districtData
    }

}