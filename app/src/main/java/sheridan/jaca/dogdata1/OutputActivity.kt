package sheridan.jaca.dogdata1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import sheridan.jaca.dogdata1.databinding.ActivityOutputBinding
import sheridan.jaca.dogdata1.model.DogData

class OutputActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOutputBinding

    companion object{
        const val DOG_DATA = "data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOutputBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //get and display dog data
        binding.dogData = intent.getSerializableExtra(DOG_DATA) as? DogData

        binding.btnBack.setOnClickListener { finish() }
    }
}