package py.com.roshka.listapokemones.models

data class ListaPokemones (

    val results: List<Result>
)

data class Result (
    val name: String
)