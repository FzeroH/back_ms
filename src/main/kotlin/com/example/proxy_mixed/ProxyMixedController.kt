package com.example.proxy_mixed

import com.example.proxy_mixed.entity.CurrencyEntity
import com.example.proxy_mixed.entity.CurrencyRateEntity
import org.springframework.http.MediaType
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject

@RestController
class ProxyMixedController {

    @CrossOrigin("http://localhost:3000")
    @GetMapping("/api/get_currency_list")
    fun getCurrencyList(): CurrencyEntity {
        val restTemplate = RestTemplate()
        val messageConverters: MutableList<HttpMessageConverter<*>> = ArrayList()
        val converter = MappingJackson2HttpMessageConverter()
        val url = "https://currate.ru//api/?get=currency_list&key=${CURRATE_KEY}"
        converter.supportedMediaTypes = listOf(MediaType.ALL)
        messageConverters.add(converter)
        restTemplate.messageConverters = messageConverters
        val result = restTemplate.getForObject<CurrencyEntity>(url)
        return result
    }

    @CrossOrigin("http://localhost:3000")
    @GetMapping("/api/get_currency_rate")
    fun getCurrencyRate(@RequestParam(value="pairs") pairs:String): CurrencyRateEntity {
        val restTemplate = RestTemplate()
        val messageConverters: MutableList<HttpMessageConverter<*>> = ArrayList()
        val converter = MappingJackson2HttpMessageConverter()
        val url = "https://currate.ru/api/?get=rates&pairs=${pairs}&key=${CURRATE_KEY}"
        converter.supportedMediaTypes = listOf(MediaType.ALL)
        messageConverters.add(converter)
        restTemplate.messageConverters = messageConverters
        val result = restTemplate.getForObject<CurrencyRateEntity>(url)
        return result
    }
    companion object {
        val CURRATE_KEY = "32c3e89bc4826d7ce09c2c1c9dee0bf6"
    }
}