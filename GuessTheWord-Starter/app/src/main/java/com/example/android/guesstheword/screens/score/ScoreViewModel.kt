package com.example.android.guesstheword.screens.score

import android.util.Log
import androidx.lifecycle.ViewModel

class ScoreViewModel(finalScore: Int) : ViewModel() {
    var score = finalScore
    init{
        Log.i("ScoreModelView", "Final score is $finalScore")
    }
}
//score에 필요한 프로퍼티