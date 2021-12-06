package controller

import model.request.ConversionRequest
import service.ConversionService
import io.javalin.Context

class ConversionController(
    private val conversionService: ConversionService
) {
    fun convertCurrency(ctx:Context){
        ctx.body<ConversionRequest>().apply {
            ctx.json(conversionService.convertCurrency
                (ctx.pathParam("id").toLong(),this))

        }
    }
}
