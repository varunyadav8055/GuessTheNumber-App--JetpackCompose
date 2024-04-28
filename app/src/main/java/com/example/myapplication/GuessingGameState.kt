package com.example.myapplication

data class GuessingGameState(
    val userNumber:String="",
    val nofGuessLeft:Int=5,
    val guessedNumberList:List<Int> = emptyList(),
    val mysteryNumber:Int =(1..99).random(),
    val hinDescription: String="Guess\n the mystery number between\n 0 and 100",
    val gameStage: GameStage=GameStage.PLAYING
)
enum class GameStage {
  WON,
  LOSE,
  PLAYING
}