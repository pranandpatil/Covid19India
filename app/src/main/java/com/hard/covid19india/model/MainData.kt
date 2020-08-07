package com.hard.covid19india.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class MainData {
    @SerializedName("cases_time_series")
    @Expose
    private var casesTimeSeries: List<CasesTimeSeries?>? = null
    @SerializedName("statewise")
    @Expose
    private var statewise: List<StateWise?>? = null
    @SerializedName("tested")
    @Expose
    private var tested: List<Tested?>? = null

    fun getCasesTimeSeries(): List<CasesTimeSeries?>? {
        return casesTimeSeries
    }

    fun setCasesTimeSeries(casesTimeSeries: List<CasesTimeSeries?>?) {
        this.casesTimeSeries = casesTimeSeries
    }

    fun getStateWise(): List<StateWise?>? {
        return statewise
    }

    fun setStateWise(statewise: List<StateWise?>?) {
        this.statewise = statewise
    }

    fun getTested(): List<Tested?>? {
        return tested
    }

    fun setTested(tested: List<Tested?>?) {
        this.tested = tested
    }
}