package com.hard.covid19india.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class Tested {

    @SerializedName("positivecasesfromsamplesreported")
    @Expose
    private var positivecasesfromsamplesreported: String? = null
    @SerializedName("samplereportedtoday")
    @Expose
    private var samplereportedtoday: String? = null
    @SerializedName("source")
    @Expose
    private var source: String? = null
    @SerializedName("testsconductedbyprivatelabs")
    @Expose
    private var testsconductedbyprivatelabs: String? = null
    @SerializedName("totalindividualstested")
    @Expose
    private var totalindividualstested: String? = null
    @SerializedName("totalpositivecases")
    @Expose
    private var totalpositivecases: String? = null
    @SerializedName("totalsamplestested")
    @Expose
    private var totalsamplestested: String? = null
    @SerializedName("updatetimestamp")
    @Expose
    private var updatetimestamp: String? = null

    fun getPositivecasesfromsamplesreported(): String? {
        return positivecasesfromsamplesreported
    }

    fun setPositivecasesfromsamplesreported(positivecasesfromsamplesreported: String?) {
        this.positivecasesfromsamplesreported = positivecasesfromsamplesreported
    }

    fun getSamplereportedtoday(): String? {
        return samplereportedtoday
    }

    fun setSamplereportedtoday(samplereportedtoday: String?) {
        this.samplereportedtoday = samplereportedtoday
    }

    fun getSource(): String? {
        return source
    }

    fun setSource(source: String?) {
        this.source = source
    }

    fun getTestsconductedbyprivatelabs(): String? {
        return testsconductedbyprivatelabs
    }

    fun setTestsconductedbyprivatelabs(testsconductedbyprivatelabs: String?) {
        this.testsconductedbyprivatelabs = testsconductedbyprivatelabs
    }

    fun getTotalindividualstested(): String? {
        return totalindividualstested
    }

    fun setTotalindividualstested(totalindividualstested: String?) {
        this.totalindividualstested = totalindividualstested
    }

    fun getTotalpositivecases(): String? {
        return totalpositivecases
    }

    fun setTotalpositivecases(totalpositivecases: String?) {
        this.totalpositivecases = totalpositivecases
    }

    fun getTotalsamplestested(): String? {
        return totalsamplestested
    }

    fun setTotalsamplestested(totalsamplestested: String?) {
        this.totalsamplestested = totalsamplestested
    }

    fun getUpdatetimestamp(): String? {
        return updatetimestamp
    }

    fun setUpdatetimestamp(updatetimestamp: String?) {
        this.updatetimestamp = updatetimestamp
    }

}