package com.example.androiddasar

import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var sayHelloButton: Button
    private lateinit var sayHelloTextView: TextView

    private fun initComponents() {
        nameEditText = findViewById(R.id.nameEditText)
        sayHelloButton = findViewById(R.id.sayHelloButton)
        sayHelloTextView = findViewById(R.id.sayHelloTextView)
    }

    private fun checkFingerprint() {
        if (packageManager.hasSystemFeature(PackageManager.FEATURE_FINGERPRINT)) {
            Log.i("FINGERPRINT", "Feature fingerprint ON")
        } else {
            Log.w("FINGERPRINT", "Feature fingerprint OFF")
        }
    }

    private fun checkPlatformVersion() {
        Log.i("SDK", Build.VERSION.SDK_INT.toString())
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S) {
            Log.i("SDK", "Disabled feature, because SDK version is lower than ${Build.VERSION_CODES.S}")
        }
    }

    private fun printHello(name: String) {
        Log.i("DEBUG", name)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // enableEdgeToEdge()
        setContentView(R.layout.hello_world)
        initComponents()

        sayHelloTextView.text = resources.getString(R.string.app_name)

        sayHelloButton.setOnClickListener {

            val firstName = "Chris"
            printHello(firstName)

            checkFingerprint()
            checkPlatformVersion()

            val sample = resources.openRawResource(R.raw.sample)
                .bufferedReader()
                .use { it.readText() }
            Log.i("RAW", sample)

            val json = assets.open("sample.json")
                .bufferedReader()
                .use { it.readText() }
            Log.i("ASSETS", json)

            // resources.getDrawable(R.drawable.flag, theme)

            Log.v("ME", "this is verbose log")
            Log.d("ME", "this is debug log")
            Log.i("ME", "this is info log")
            Log.w("ME", "this is warn log")
            Log.e("ME", "this is error log")

            Log.i("ValueResource", resources.getInteger(R.integer.maxPage).toString())
            Log.i("ValueResource", resources.getBoolean(R.bool.isProductionMode).toString())
            Log.i("ValueResource", resources.getIntArray(R.array.numbers).joinToString(","))
            Log.i("ValueResource", resources.getColor(R.color.background, theme).toString())

            sayHelloButton.setBackgroundColor(resources.getColor(R.color.background, theme))

            val name = nameEditText.text.toString()
            sayHelloTextView.text = resources.getString(R.string.sayHelloTextView, name)

            resources.getStringArray(R.array.names).forEach {
                Log.i("ME", it)
            }
        }
        // ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
        //     val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
        //     v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
        //     insets
        // }
    }
}