package config.modules

import model.resources.TransactionRepositoryImpl
import model.resources.UserRepositoryImpl
import model.resources.repository.TransactionRepository
import model.resources.repository.UserRepository
import org.koin.dsl.module

object RepositoryModule {

    fun modules() = module {
        single { UserRepositoryImpl() as UserRepository }
        single { TransactionRepositoryImpl() as TransactionRepository}
    }
}
