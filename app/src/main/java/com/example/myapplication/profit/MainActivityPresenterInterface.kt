package com.example.myapplication.profit

interface MainActivityPresenterInterface {
    interface View {
        fun setDrawState()
        fun setProfitState(amount : Float)
        fun setLosState(amount : Float)
    }

    interface Presenter{
        fun calculate(productPrice: Float, sellingPrice: Float)
    }
}