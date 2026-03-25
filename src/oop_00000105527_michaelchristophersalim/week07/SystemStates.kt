package oop_00000105527_michaelchristophersalim.week07

enum class AppState {
    STARTING,
    RUNNING,
    STOPPED
}

sealed class ApiResponse{
    data class Success(val data: DataUser) : ApiResponse()
    data class Error(val message: String) : ApiResponse()
    object Loading : ApiResponse()
}