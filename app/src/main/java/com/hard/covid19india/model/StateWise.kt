package com.hard.covid19india.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class StateWise {

    @SerializedName("active")
    @Expose
    private var active: String? = null
    @SerializedName("confirmed")
    @Expose
    private var confirmed: String? = null
    @SerializedName("deaths")
    @Expose
    private var deaths: String? = null
    @SerializedName("deltaconfirmed")
    @Expose
    private var deltaconfirmed: String? = null
    @SerializedName("deltadeaths")
    @Expose
    private var deltadeaths: String? = null
    @SerializedName("deltarecovered")
    @Expose
    private var deltarecovered: String? = null
    @SerializedName("lastupdatedtime")
    @Expose
    private var lastupdatedtime: String? = null
    @SerializedName("recovered")
    @Expose
    private var recovered: String? = null
    @SerializedName("state")
    @Expose
    private var state: String? = null
    @SerializedName("statecode")
    @Expose
    private var statecode: String? = null

    fun getActive(): String? {
        return active
    }

    fun setActive(active: String?) {
        this.active = active
    }

    fun getConfirmed(): String? {
        return confirmed
    }

    fun setConfirmed(confirmed: String?) {
        this.confirmed = confirmed
    }

    fun getDeaths(): String? {
        return deaths
    }

    fun setDeaths(deaths: String?) {
        this.deaths = deaths
    }

    fun getDeltaconfirmed(): String? {
        return deltaconfirmed
    }

    fun setDeltaconfirmed(deltaconfirmed: String?) {
        this.deltaconfirmed = deltaconfirmed
    }

    fun getDeltadeaths(): String? {
        return deltadeaths
    }

    fun setDeltadeaths(deltadeaths: String?) {
        this.deltadeaths = deltadeaths
    }

    fun getDeltarecovered(): String? {
        return deltarecovered
    }

    fun setDeltarecovered(deltarecovered: String?) {
        this.deltarecovered = deltarecovered
    }

    fun getLastupdatedtime(): String? {
        return lastupdatedtime
    }

    fun setLastupdatedtime(lastupdatedtime: String?) {
        this.lastupdatedtime = lastupdatedtime
    }

    fun getRecovered(): String? {
        return recovered
    }

    fun setRecovered(recovered: String?) {
        this.recovered = recovered
    }

    fun getState(): String? {
        return state
    }

    fun setState(state: String?) {
        this.state = state
    }

    fun getStatecode(): String? {
        return statecode
    }

    fun setStatecode(statecode: String?) {
        this.statecode = statecode
    }
}