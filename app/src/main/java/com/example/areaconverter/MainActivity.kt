package com.example.areaconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity()
{
    private var op: Int = 0
    private var pos1: Int = 0
    private var pos2: Int = 0
    private var arrayAdapter: ArrayAdapter<String>? = null

    private var AreaArr = arrayOf("Sq.m","Sq.ft","Cent","Acre","Hectare")

    private var spinner1 : Spinner? = null
    private var spinner2 : Spinner? = null
    private var textinput : EditText? = null
    private var textoutput : TextView? = null

    private var button : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinner1 = findViewById(R.id.spinner1)
        spinner2 = findViewById(R.id.spinner2)

        textinput = findViewById(R.id.textinput)
        textoutput = findViewById(R.id.textoutput)


        op = 1

        when (op) {

            1 -> {
                arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, AreaArr)
                spinner1?.adapter = arrayAdapter
                spinner2?.adapter = arrayAdapter


                spinner1?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                        pos1 = p2
                    }

                    override fun onNothingSelected(p0: AdapterView<*>?) {
                        Toast.makeText(this@MainActivity, "Select an Option", Toast.LENGTH_LONG).show()
                    }

                }


                spinner2?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                        pos2 = p2
                    }

                    override fun onNothingSelected(p0: AdapterView<*>?) {
                        Toast.makeText(this@MainActivity, "Select an Option", Toast.LENGTH_LONG).show()
                    }
                }
            }




        }

        button = findViewById(R.id.button)

        button?.setOnClickListener {
            Toast.makeText(this, "Converted", Toast.LENGTH_SHORT).show()


            val text1 = textinput?.text.toString().toDouble()

            if (op == 1)
            {
                if (pos1 == 0) //sq.m
                {
                    if (pos2 == 0) //sq.m
                    {
                        textoutput?.text = (text1).toString()
                    } else if (pos2 == 1) //sq.ft
                    {
                        textoutput?.text = (text1 * 10.7639).toString()
                    } else if (pos2 == 2) //cent
                    {
                        textoutput?.text = (text1 * 0.02471).toString()
                    } else if (pos2 == 3) //acre
                    {
                        textoutput?.text = (text1 * 0.000247105).toString()
                    } else if (pos2 == 4) //hectare
                    {
                        textoutput?.text = (text1 * 0.0001 ).toString()
                    }
                } else if (pos1 == 1)//sq.ft
                {
                    if (pos2 == 0)//sq.meter
                    {
                        textoutput?.text = (text1 * 0.092903).toString()
                    } else if (pos2 == 1)//sq.ft
                    {
                        textoutput?.text = (text1).toString()
                    } else if (pos2 == 2)//cent
                    {
                        textoutput?.text = (text1 * 0.0023).toString()
                    } else if (pos2 == 3)//acre
                    {
                        textoutput?.text = (text1 / 43560).toString()
                    } else if (pos2 == 4) //hectare
                    {
                        textoutput?.text = (text1 / 107639).toString()
                    }
                } else if (pos1 == 2)//cent
                {
                    if (pos2 == 0)//sq.m
                    {
                        textoutput?.text = (text1 * 40.46).toString()
                    } else if (pos2 == 1)//sq.ft
                    {
                        textoutput?.text = (text1 * 435.6).toString()
                    } else if (pos2 == 2)//cent
                    {
                        textoutput?.text = (text1).toString()
                    } else if (pos2 == 3)//acre
                    {
                        textoutput?.text = (text1 * 0.01).toString()
                    } else if (pos2 == 4) //hectare
                    {
                        textoutput?.text = (text1 * 0.004 ).toString()
                    }
                } else if (pos1 == 3)//acre
                {
                    if (pos2 == 0)//sq.m
                    {
                        textoutput?.text = (text1 * 4046.86).toString()
                    } else if (pos2 == 1)//sq.ft
                    {
                        textoutput?.text = (text1 * 43560).toString()
                    } else if (pos2 == 2)//cent
                    {
                        textoutput?.text = (text1 * 100).toString()
                    } else if (pos2 == 3) //acre
                    {
                        textoutput?.text = (text1).toString()
                    } else if (pos2 == 4) //hectare
                    {
                        textoutput?.text = (text1 * 0.404686 ).toString()
                    }
                } else if (pos1 == 4)//hectare
                {
                    if (pos2 == 0)//sq.m
                    {
                        textoutput?.text = (text1 * 10000).toString()
                    } else if (pos2 == 1)//sq.ft
                    {
                        textoutput?.text = (text1 * 107639).toString()
                    } else if (pos2 == 2)//cent
                    {
                        textoutput?.text = (text1 * 247.157).toString()
                    } else if (pos2 == 3) //acre
                    {
                        textoutput?.text = (text1 * 2.47105).toString()
                    } else if (pos2 == 4) //hectare
                    {
                        textoutput?.text = (text1).toString()
                    }

                }

            }

        }
    }
}
