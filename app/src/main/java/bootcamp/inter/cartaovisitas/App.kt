package bootcamp.inter.cartaovisitas

import android.app.Application
import bootcamp.inter.cartaovisitas.data.AppDatabase
import bootcamp.inter.cartaovisitas.data.CartaoVisitaRepository

class App : Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { CartaoVisitaRepository(database.cartaoVisitaDao()) }
}