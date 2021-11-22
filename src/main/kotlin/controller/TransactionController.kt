package controller

import io.javalin.Context
import service.TransactionService

class TransactionController(private val transactionService: TransactionService) {

    fun getFindAll(ctx: Context) {
        ctx.json(transactionService.findAll())

    }

    fun getTransactionsByUser(ctx: Context) {
        transactionService.transactionsByUser(ctx.pathParam(":id").toLong())?.let {
            ctx.json(it) }
    }

}
