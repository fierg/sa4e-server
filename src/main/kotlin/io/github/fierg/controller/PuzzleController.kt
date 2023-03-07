package io.github.fierg.controller

import io.github.fierg.model.dto.GameDTO
import javax.enterprise.context.ApplicationScoped


@ApplicationScoped
class PuzzleController {
    private var currentPuzzle: GameDTO? = null

    fun setPuzzle(puzzle:GameDTO){
        currentPuzzle = puzzle
    }

    fun getPuzzle() = currentPuzzle
}