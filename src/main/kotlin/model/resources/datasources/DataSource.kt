package model.resources.datasources

interface DataSource {
    
    fun startConnection()
    fun stopConnection()
}
