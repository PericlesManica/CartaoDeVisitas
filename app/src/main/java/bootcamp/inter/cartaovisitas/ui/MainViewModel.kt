package bootcamp.inter.cartaovisitas.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import bootcamp.inter.cartaovisitas.data.CartaoVisita
import bootcamp.inter.cartaovisitas.data.CartaoVisitaRepository

class MainViewModel(private val cartaoVisitaRepository: CartaoVisitaRepository): ViewModel() {

    fun inserir(cartaoVisita: CartaoVisita) {
        cartaoVisitaRepository.inserir(cartaoVisita)
    }

    fun buscaTudo(): LiveData<List<CartaoVisita>> {
        return cartaoVisitaRepository.buscaTudo()
    }
}

class MainViewModelFactory(private val repository: CartaoVisitaRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}