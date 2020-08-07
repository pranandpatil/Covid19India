package com.hard.covid19india.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class Delta {
    @SerializedName("confirmed")
    @Expose
    private var confirmed: Int? = null

    fun getConfirmed(): Int? {
        return confirmed
    }

    fun setConfirmed(confirmed: Int?) {
        this.confirmed = confirmed
    }
}