package com.example.apis.api.dtos

data class Resources(
    val `data`: List<ResourceData>,
    val page: Int,
    val per_page: Int,
    val total: Int,
    val total_pages: Int,
    val support : Support
)