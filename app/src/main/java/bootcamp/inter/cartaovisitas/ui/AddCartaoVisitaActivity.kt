package bootcamp.inter.cartaovisitas.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import bootcamp.inter.cartaovisitas.App
import bootcamp.inter.cartaovisitas.R
import bootcamp.inter.cartaovisitas.data.CartaoVisita
import bootcamp.inter.cartaovisitas.databinding.ActivityAddCartaoVisitaBinding


class AddCartaoVisitaActivity : AppCompatActivity(){
    private var tilCor : String = "#00FF00"
    private val binding by lazy { ActivityAddCartaoVisitaBinding.inflate(layoutInflater) }

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListeners()
    }

    private fun insertListeners() {
        corCartao()
        binding.btnConfirm.setOnClickListener {
            val cartaoVisita = CartaoVisita(
                nome = binding.tilNome.editText?.text.toString(),
                empresa = binding.tilEmpresa.editText?.text.toString(),
                telefone = binding.tilTelefone.editText?.text.toString(),
                email = binding.tilEmail.editText?.text.toString(),
                fundoPersonalizado = tilCor
            )
            mainViewModel.inserir(cartaoVisita)
            Toast.makeText(this, R.string.label_show_success, Toast.LENGTH_SHORT).show()
            finish()
        }

        binding.btnClose.setOnClickListener {
            finish()
        }
    }
    fun corCartao(){
        binding.azul.setOnClickListener { tilCor = "#2796EA" }
        binding.amarelo.setOnClickListener { tilCor = "#E6CF3B" }
        binding.verde.setOnClickListener { tilCor = "#49DA4E" }
        binding.branco.setOnClickListener { tilCor = "#FFFFFFFF" }
        binding.cinza.setOnClickListener { tilCor = "#858585" }
        binding.laraja.setOnClickListener { tilCor = "#DA5A29" }
        binding.rosa.setOnClickListener { tilCor = "#A549BF" }
   }

}