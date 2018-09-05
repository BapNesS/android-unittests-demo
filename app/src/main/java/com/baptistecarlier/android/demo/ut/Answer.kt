package com.baptistecarlier.android.demo.ut

class Answer(val value: String) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Answer) return false

        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }
}