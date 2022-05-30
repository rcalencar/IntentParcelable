package com.rcalencar.intentparcelable

import java.io.Serializable

data class UserSerializableData(val name: String, val address: List<String>) : Serializable