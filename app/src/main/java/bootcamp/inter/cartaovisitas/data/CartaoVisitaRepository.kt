package bootcamp.inter.cartaovisitas.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class CartaoVisitaRepository (private val dao: CartaoVisitaDao){

    fun inserir(cartaoVisita: CartaoVisita) = runBlocking {
        launch (Dispatchers.IO){
            dao.inserir(cartaoVisita)
        }
    }
    fun buscaTudo() = dao.buscaTudo()
}