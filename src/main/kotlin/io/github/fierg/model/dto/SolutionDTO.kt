package io.github.fierg.model.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class SolutionDTO(
    @JsonProperty("server_id") val server_id: String? = "",
    @JsonProperty("raetsel_id") val raetsel_id: Int? = 0,
    @JsonProperty("row1") val row1: Array<String>? = arrayOf(),
    @JsonProperty("row2") val row2: Array<String>? = arrayOf(),
    @JsonProperty("row3") val row3: Array<String>? = arrayOf(),
    @JsonProperty("server_id") val time: String? = ""
)