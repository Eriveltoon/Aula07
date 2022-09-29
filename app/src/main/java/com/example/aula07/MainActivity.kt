package com.example.aula07

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aula07.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding//binding Automatico

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener { perguntar(1) }
        binding.button2.setOnClickListener { perguntar(2) }
        binding.button3.setOnClickListener { perguntar(3) }
    }

    fun perguntar(idPergunta: Int){
        val i = Intent(this, PerguntaActivity::class.java)
        i.putExtra("pergunta", idPergunta)
        //Iniciar Aticidade
        //startActivity(i)

        //Iniciar Atividade esperando uma resposta
        startActivityForResult(i, 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == 1 && resultCode == RESULT_OK && data != null){
            val acertou = data.getBooleanExtra("acertou", false)
            val idPergunta = data.getIntExtra("idPergunta", -1)

            tratarResposta(idPergunta, acertou)
        }
    }

    private fun tratarResposta(idPergunta: Int, acertou: Boolean) {
        when (idPergunta) {
            1 -> {
                if (acertou) {
                    binding.button.setBackgroundColor(Color.GREEN)
                } else {
                    binding.button.setBackgroundColor(Color.RED)
                }
            }
            2 -> {
                if (acertou) {
                    binding.button2.setBackgroundColor(Color.GREEN)
                } else {
                    binding.button2.setBackgroundColor(Color.RED)
                }
            }
            3 -> {
                if (acertou) {
                    binding.button3.setBackgroundColor(Color.GREEN)
                } else {
                    binding.button3.setBackgroundColor(Color.RED)
                }
            }
        }
    }
}