package com.hard.covid19india.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class DistrictData {
    @SerializedName("district")
    @Expose
    private var district: String? = null
    @SerializedName("confirmed")
    @Expose
    private var confirmed: Int? = null
    @SerializedName("lastupdatedtime")
    @Expose
    private var lastupdatedtime: String? = null
    @SerializedName("delta")
    @Expose
    private var delta: Delta? = null

    fun getDistrict(): String? {
        return district
    }

    fun setDistrict(district: String?) {
        this.district = district
    }

    fun getConfirmed(): Int? {
        return confirmed
    }

    fun setConfirmed(confirmed: Int?) {
        this.confirmed = confirmed
    }

    fun getLastupdatedtime(): String? {
        return lastupdatedtime
    }

    fun setLastupdatedtime(lastupdatedtime: String?) {
        this.lastupdatedtime = lastupdatedtime
    }

    fun getDelta(): Delta? {
        return delta
    }

    fun setDelta(delta: Delta?) {
        this.delta = delta
    }
}