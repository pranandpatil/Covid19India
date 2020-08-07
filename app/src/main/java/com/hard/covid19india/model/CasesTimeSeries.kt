package com.hard.covid19india.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.math.BigInteger

class CasesTimeSeries {
    @SerializedName("dailyconfirmed")
    @Expose
    private var dailyconfirmed: String? = null
    @SerializedName("dailydeceased")
    @Expose
    private var dailydeceased: String? = null
    @SerializedName("dailyrecovered")
    @Expose
    private var dailyrecovered: String? = null
    @SerializedName("date")
    @Expose
    private var date: String? = null
    @SerializedName("totalconfirmed")
    @Expose
    private var totalconfirmed: String? = null
    @SerializedName("totaldeceased")
    @Expose
    private var totaldeceased: String? = null
    @SerializedName("totalrecovered")
    @Expose
    private var totalrecovered: String? = null
    private var totalactive: String? = null

    fun getDailyconfirmed(): String? {
        return dailyconfirmed
    }

    fun setDailyconfirmed(dailyconfirmed: String?) {
        this.dailyconfirmed = dailyconfirmed
    }

    fun getDailydeceased(): String? {
        return dailydeceased
    }

    fun setDailydeceased(dailydeceased: String?) {
        this.dailydeceased = dailydeceased
    }

    fun getDailyrecovered(): String? {
        return dailyrecovered
    }

    fun setDailyrecovered(dailyrecovered: String?) {
        this.dailyrecovered = dailyrecovered
    }

    fun getDate(): String? {
        return date
    }

    fun setDate(date: String?) {
        this.date = date
    }

    fun getTotalconfirmed(): String? {
        return totalconfirmed
    }

    fun setTotalconfirmed(totalconfirmed: String?) {
        this.totalconfirmed = totalconfirmed
    }

    fun getTotaldeceased(): String? {
        return totaldeceased
    }

    fun setTotaldeceased(totaldeceased: String?) {
        this.totaldeceased = totaldeceased
    }

    fun getTotalrecovered(): String? {
        return totalrecovered
    }

    fun setTotalrecovered(totalrecovered: String?) {
        this.totalrecovered = totalrecovered
    }

    fun getTotalactive(): String?{
        val closedCases : BigInteger = this.totalrecovered!!.toBigInteger() + this.totaldeceased!!.toBigInteger()
        val activeCases : BigInteger = this.totalconfirmed!!.toBigInteger() - closedCases
        return activeCases.toString()
    }
}