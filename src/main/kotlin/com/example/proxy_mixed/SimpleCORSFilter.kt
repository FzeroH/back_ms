package com.example.proxy_mixed

import org.springframework.stereotype.Component
import java.io.IOException
import javax.servlet.*
import javax.servlet.http.HttpServletResponse


@Component
class SimpleCORSFilter : Filter {
	@Throws(IOException::class, ServletException::class)
	override fun doFilter(req: ServletRequest?, res: ServletResponse, chain: FilterChain) {
		val response = res as HttpServletResponse
		response.setHeader("Access-Control-Allow-Origin", "*")
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE")
		response.setHeader("Access-Control-Max-Age", "3600")
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with")
		chain.doFilter(req, res)
	}

	override fun init(filterConfig: FilterConfig?) {}
	override fun destroy() {}
}