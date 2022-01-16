package com.example.proxy_mixed.entity

data class WeatherEntity(
    val now: Long,
    val now_dt: String,
    val info: WeatherInfoEntity,
    val fact: WeatherFactEntity,
    val forecast: WeatherForecastEntity,

)
data class WeatherInfoEntity(
    val url: String,
    val lat: Double,
    val lon: Double
)
data class WeatherFactEntity(
    val obs_time: Long,
    val temp: Int,
    val feels_like: Int,
    val icon: String,
    val condition: String,
    val wind_speed: Int,
    val wind_dir: String,
    val pressure_mm: Int,
    val pressure_pa: Int,
    val humidity: Int,
    val daytime: String,
    val polar: Boolean,
    val season: String,
    val wind_gust: Double
)
data class WeatherForecastEntity(
    val date: String,
    val date_ts: Long,
    val week: Int,
    val sunrise: String,
    val sunset: String,
    val moon_code: Int,
    val moon_text: String,
    val parts: List<WeatherPartsEntity>
)
data class WeatherPartsEntity(
    val part_name: String,
    val temp_min: Int,
    val temp_avg: Int,
    val temp_max: Int,
    val wind_speed: Double,
    val wind_gust: Double,
    val wind_dir: String,
    val pressure_mm: Int,
    val pressure_pa: Int,
    val humidity: Int,
    val prec_mm: Double,
    val prec_prob: Int,
    val prec_period: Int,
    val icon: String,
    val condition: String,
    val feels_like: Int,
    val daytime: String,
    val polar: Boolean,

)