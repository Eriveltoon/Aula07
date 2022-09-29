package com.example.aula07

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aula07.databinding.ActivityMainBinding
import com.example.aula07.databinding.ActivityPerguntaBinding

class PerguntaActivity : AppCompatActivity() {
    lateinit var binding: ActivityPerguntaBinding

    var idPergunta = 0
    var respCerta = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPerguntaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val idPergunta = intent.getIntExtra("pergunta", -1)
        configurarPergunta(idPergunta)

        binding.buttonA.setOnClickListener {
            responder(1)
        }
        binding.buttonB.setOnClickListener {
            responder(2)
        }
        binding.buttonC.setOnClickListener {
            responder(3)
        }
        binding.buttonD.setOnClickListener {
            responder(4)
        }
    }

    private fun responder(selecionado: Int) {
        val i = Intent()
        if (selecionado == respCerta) {
            i.putExtra("acertou", true)
        } else {
            i.putExtra("acertou", false)
        }
        i.putExtra("idPergunta", idPergunta)

        setResult(RESULT_OK, i)
        finish()
        //finishAffinity()
    }

    fun configurarPergunta(idPergunta:Int){
        this.idPergunta = idPergunta

        when(idPergunta){
            1 -> {
                binding.textNum.text = idPergunta.toString()
                binding.textPergunta.text = "Quantos estados há no Brasil?"

                binding.buttonA.text = "A. 20"
                binding.buttonB.text = "B. 26"
                binding.buttonC.text = "C. 50"
                binding.buttonD.text = "D. 30"
                respCerta = 2
            }
            2 -> {
                binding.textNum.text = idPergunta.toString()
                binding.textPergunta.text = "Quem colonizou o Brasil?"

                binding.buttonA.text = "A. Alemanha"
                binding.buttonB.text = "B. Portugal"
                binding.buttonC.text = "C. USA"
                binding.buttonD.text = "D. Alemanha"

                respCerta = 2
            }

            3 -> {
                binding.textNum.text = idPergunta.toString()
                binding.textPergunta.text = "Qual a cor do cavalo branco de Napoleao?"

                binding.buttonA.text = "A. Azul"
                binding.buttonB.text = "B. Cinza"
                binding.buttonC.text = "C. Branco"
                binding.buttonD.text = "D. Amarelo"

                respCerta = 3
            }
        }
    }
}