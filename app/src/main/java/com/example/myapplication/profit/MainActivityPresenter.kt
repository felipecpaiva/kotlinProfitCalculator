package com.example.myapplication.profit

class MainActivityPresenter(private val View : MainActivityPresenterInterface.View) : MainActivityPresenterInterface.Presenter{
    override fun calculate(productPrice: Float, sellingPrice: Float) {
        when {
            sellingPrice > productPrice -> { calculateProfit(sellingPrice, productPrice) }
            productPrice  > sellingPrice -> { calculateLoss(sellingPrice, productPrice) }
            else -> { calculateDraw() }
        }
    }

    private fun calculateDraw() {
        View.setDrawState()
    }

    private fun calculateLoss(sellingPrice: Float, productPrice: Float) {
        val amount = productPrice - sellingPrice
        View.setLosState(amount)
    }

    private fun calculateProfit(sellingPrice: Float, productPrice: Float) {
        val amount = sellingPrice - productPrice
        View.setProfitState(amount)
    }
}