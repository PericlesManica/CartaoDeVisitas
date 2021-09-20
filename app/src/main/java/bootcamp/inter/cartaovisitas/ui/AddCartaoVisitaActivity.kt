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
        binding.azul.setOnClickListener {
            tilCor = "#9FC4F1"
            toastCor()
        }
        binding.amarelo.setOnClickListener {
            tilCor = "#F0E5A1"
            toastCor()
        }
        binding.verde.setOnClickListener {
            tilCor = "#ADE6AB"
            toastCor()
        }
        binding.branco.setOnClickListener {
            tilCor = "#FFFFFFFF"
            toastCor()
        }
        binding.cinza.setOnClickListener {
            tilCor = "#CECBCA"
            toastCor()
        }
        binding.laraja.setOnClickListener {
            tilCor = "#F1C197"
            toastCor()
        }
        binding.rosa.setOnClickListener {
            tilCor = "#E6ACEB"
            toastCor()
        }
     }

    fun toastCor(){
        Toast.makeText(this, "Cor selecionada!", Toast.LENGTH_SHORT).show()
    }

}