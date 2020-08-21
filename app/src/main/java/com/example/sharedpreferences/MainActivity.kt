package com.example.sharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var preferencesProvider: PreferencesProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        preferencesProvider = PreferencesProvider(applicationContext)

        buttonSave.setOnClickListener {
            preferencesProvider.putString(Constants.KEY_FIRST_NAME,inputFirstName.text.toString())
            preferencesProvider.putString(Constants.KEY_LAST_NAME,inputLastName.text.toString())
            preferencesProvider.putInt(Constants.KEY_AGE,inputAge.text.toString().toInt())
            preferencesProvider.putBoolean(Constants.KEY_MARRIED,radioGroupMarried.checkedRadioButtonId == R.id.radioButtonYes)

            Toast.makeText(applicationContext,"Data saved",Toast.LENGTH_SHORT).show()
        }
        buttonLoad.setOnClickListener {
            inputFirstName.setText(preferencesProvider.getString(Constants.KEY_FIRST_NAME))
            inputLastName.setText(preferencesProvider.getString(Constants.KEY_LAST_NAME))
            inputAge.setText(preferencesProvider.getInt(Constants.KEY_AGE).toString())
            if(preferencesProvider.getBoolean(Constants.KEY_MARRIED)){
                radioButtonYes.isChecked = true
            }else{
                radioButtonNo.isChecked = true
            }
            Toast.makeText(applicationContext,"Data Load",Toast.LENGTH_SHORT).show()

        }
        buttonClear.setOnClickListener {
            preferencesProvider.clear()
            Toast.makeText(applicationContext,"Data clear",Toast.LENGTH_SHORT).show()
        }
    }
}