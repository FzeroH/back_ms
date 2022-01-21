package com.example.proxy_mixed

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.servlet.config.annotation.CorsRegistry

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer




@SpringBootApplication
class ProxyMixedApplication() {


	companion object{
		@JvmStatic
		fun main(args: Array<String>) {
			SpringApplication.run(ProxyMixedApplication::class.java, *args)
		}

		@Bean
		fun corsConfigurer(): WebMvcConfigurer? {
			return object : WebMvcConfigurer {
				override fun addCorsMappings(registry: CorsRegistry) {
					registry.addMapping("/**").allowedOrigins("http://localhost:3000")
				}
			}
		}
		val CURRATE_KEY = "b97d2a4b56b2c650928004336ecec291"
	}
}
