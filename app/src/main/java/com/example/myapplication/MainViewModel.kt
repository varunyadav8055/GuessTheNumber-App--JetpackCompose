package com.example.myapplication

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class MainViewModel : ViewModel() {
    private val _state = MutableStateFlow(GuessingGameState())
    val state = _state.asStateFlow()

    fun updateTextField(userNo: String) {
        _state.update { it.copy(userNumber = userNo) }
    }

    fun onUserInput(userNumber: String, context: Context) {
        val userNumberInput = try {
            userNumber.toInt()
        } catch (e: Exception) {
            0
        }
        if (userNumberInput !in 1..99) {
            Toast.makeText(context, "please enter a number between 0 and 100", Toast.LENGTH_LONG)
                .show()
            return


        }
        val currentState = _state.value

        val newGuessLeft = currentState.nofGuessLeft - 1

        val newGuessNoList = currentState.guessedNumberList.plus(userNumberInput)

        val newGameStage = when {
            userNumberInput == currentState.mysteryNumber -> GameStage.WON
            newGuessLeft == 0 -> GameStage.LOSE

            else -> {
                GameStage.PLAYING
            }
        }
        val newHintDespcription = when {
            userNumberInput > currentState.mysteryNumber -> {
                "Hint\n You are guessing bigger number than mystery number"
            }

            userNumberInput < currentState.mysteryNumber -> {
                "Hint\n You are guessing smaller  number than mystery number "
            }

            else -> {
                ""
            }
        }
        _state.update {
            it.copy(
                userNumber = "",
                nofGuessLeft = newGuessLeft,
                guessedNumberList = newGuessNoList,
                hinDescription = newHintDespcription,
                gameStage = newGameStage
            )
        }
    }

    fun resetGame() {
        _state.value=GuessingGameState()
    }

}