package jp.techacademy.kai.aisatsuapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.app.TimePickerDialog
import android.util.Log
import android.view.View

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener(this)
    }

    override fun onClick(v: View){
       if(v.id == R.id.button){
            showTimePickerDialog()
       }
    }


    private fun showTimePickerDialog(){

        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener{ view, hour, minute ->
                Log.d("UI_PARTS", "$hour:$minute")
                if(2 <= hour && hour < 10) {
                    textView.text = "おはよう"
                }else if(10 <= hour && hour < 18){
                    textView.text = "こんにちは"
                }else if(18 <= hour || hour < 2){
                    textView.text = "こんばんは"
                }
            },
            13, 0, true)
        timePickerDialog.show()
    }


}
