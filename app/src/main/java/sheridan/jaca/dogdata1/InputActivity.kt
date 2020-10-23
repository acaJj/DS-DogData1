package sheridan.jaca.dogdata1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import sheridan.jaca.dogdata1.databinding.ActivityMainBinding
import sheridan.jaca.dogdata1.model.DogData

class InputActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState != null){
            val data = savedInstanceState.getSerializable("DOG_DATA") as DogData
            binding.txtName.setText(data.name)
        }

        binding.btnSubmit.setOnClickListener { submitData() }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val dogName : String = binding.txtName.text.toString()
        val isTrained: Boolean =binding.chkTrained.isChecked
        val isVaccinated: Boolean = binding.chkVaccinate.isChecked
        outState.putSerializable("data",DogData(dogName,isTrained,isVaccinated))
    }

    private fun submitData() {
        val dogName : String = binding.txtName.text.toString()
        val isTrained: Boolean =binding.chkTrained.isChecked
        val isVaccinated: Boolean = binding.chkVaccinate.isChecked

        if (dogName.isBlank()){
            Toast.makeText(this,"Please fill in the textbox.", Toast.LENGTH_LONG).show()
        }else{
            val intent =Intent(this,OutputActivity::class.java).apply {
                putExtra("data",DogData(dogName,isTrained,isVaccinated))
            }

            startActivity(intent)
        }
    }
}