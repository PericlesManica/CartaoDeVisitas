package bootcamp.inter.cartaovisitas.ui

import android.Manifest
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.app.ActivityCompat
import bootcamp.inter.cartaovisitas.App
import bootcamp.inter.cartaovisitas.databinding.ActivityMainBinding
import bootcamp.inter.cartaovisitas.util.Image

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }
    private val adapter by lazy { CartaoVisitaAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setUpPermissions()
        binding.rvCards.adapter = adapter
        buscaTudoCartaoVisita()
        insertListeners()
    }

    private fun setUpPermissions() {
        // write permission to access the storage
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
            1
        )
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
            1
        )
    }

    private fun insertListeners() {
        binding.fab.setOnClickListener {
            val intent = Intent(this, AddCartaoVisitaActivity::class.java)
            startActivity(intent)
        }
        adapter.listenerShare = { card ->
            Image.share(this@MainActivity, card)
        }
    }

    private fun buscaTudoCartaoVisita() {
        mainViewModel.buscaTudo().observe(this, { cartaoVisitas ->
            adapter.submitList(cartaoVisitas)
        })
    }
}