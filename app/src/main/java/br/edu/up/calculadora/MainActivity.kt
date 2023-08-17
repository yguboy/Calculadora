package br.edu.up.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val valor1 = findViewById<EditText>(R.id.valor1)
        val valor2 = findViewById<EditText>(R.id.valor2)
        val resultado = findViewById<TextView>(R.id.resultado)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val executar = findViewById<Button>(R.id.botao)

        executar.setOnClickListener {
            val valor1 = valor1.text.toString().toDoubleOrNull()
            val valor2 = valor2.text.toString().toDoubleOrNull()

            if (valor1 != null && valor2 != null) {
                val operacaoResultado = when (radioGroup.checkedRadioButtonId) {
                    R.id.somar -> valor1 + valor2
                    R.id.subtrair -> valor1 - valor2
                    R.id.multiplicar -> valor1 * valor2
                    R.id.dividir -> if (valor2 != 0.0) valor1 / valor2 else Double.NaN
                    else -> Double.NaN
                }

                resultado.text = "Resultado: $operacaoResultado"
            } else {
                resultado.text = "Valores inválidos!"
            }
        }
    }
}
