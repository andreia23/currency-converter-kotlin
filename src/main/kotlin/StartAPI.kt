import config.modules.*
import io.javalin.Javalin
import io.javalin.JavalinEvent
import model.resources.datasources.DataSource
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.context.stopKoin
import routes.ConversionRoutes

class StartAPI : KoinComponent {
    private val conversionRoutes: ConversionRoutes by inject()
    private val dataSource by inject<DataSource>()

    fun init() {
        startModules()
        startDBConection()

        startServer()
    }

    private fun startModules() {
        startKoin {
            modules(
                ConfigModule.modules(),
                DataSourceModule.modules(),
                RoutesModule.modules(),
                ControllerModule.modules(),
                ServicesModule.modules(),
                RepositoryModule.modules()
            )
        }
    }

    private fun startServer() {
        Javalin.create().routes {
            conversionRoutes.registerRoutes()
        }.also {
            it.event(JavalinEvent.SERVER_STOPPED) {
                stopKoin()
                stopDBConection()
            }
        }.start(7000)
    }

    private fun startDBConection() = dataSource.startConnection()

    private fun stopDBConection() = dataSource.stopConnection()

}
