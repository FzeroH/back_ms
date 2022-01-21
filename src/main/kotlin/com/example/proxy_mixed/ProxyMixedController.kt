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
        val url = "https://currate.ru//api/?get=currency_list&key=${ProxyMixedApplication.CURRATE_KEY}"
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
        val url = "https://currate.ru/api/?get=rates&pairs=${pairs}&key=${ProxyMixedApplication.CURRATE_KEY}"
        converter.supportedMediaTypes = listOf(MediaType.ALL)
        messageConverters.add(converter)
        restTemplate.messageConverters = messageConverters
        val result = restTemplate.getForObject<CurrencyRateEntity>(url)
        return result
    }
/*
	@GetMapping("/api/get_weather")
	fun getWeather(): ResponseEntity<Array<WeatherEntity>> {
		val restTemplate = RestTemplate()
		val headers = HttpHeaders()
		val messageConverters: MutableList<HttpMessageConverter<*>> = ArrayList()
		val converter = MappingJackson2HttpMessageConverter()
		val url = "https://api.weather.yandex.ru/v2/informers?lat=52.6018624&lon=39.5906148&lang=ru_RU"

		headers.set("X-Yandex-API-Key","f2d2598e-7d56-48c5-961f-55db4a75167c")
		converter.supportedMediaTypes = listOf(MediaType.ALL)
		messageConverters.add(converter)
		restTemplate.messageConverters = messageConverters

		val entity = HttpEntity<String>(headers)

		val result = restTemplate.exchange(url,HttpMethod.GET,entity,Array<WeatherEntity>::class.java)
		return result
	}*/
}