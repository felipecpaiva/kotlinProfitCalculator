package com.example.myapplication.profit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity(), MainActivityPresenterInterface.View {
    private lateinit var mainActivityPresenter : MainActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivityPresenter = MainActivityPresenter(this)

        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            mainActivityPresenter.calculate(product_price_edittext.text.toString().toFloat(),
                selling_price_edittext.text.toString().toFloat())
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    //region  presenter Interface Implementation
    override fun setDrawState() {
        profit_text_result.setText("")
        profit_price_result.setText("It's a draw")
    }

    override fun setProfitState(amount: Float) {
        profit_text_result.setText("Your Profit is: ")
        profit_price_result.setText(amount.toString())
    }

    override fun setLosState(amount: Float) {
        profit_text_result.setText("Your los is: ")
        profit_price_result.setText(amount.toString())
    }
    //endregion
}
