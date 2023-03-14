package io.github.fierg.controller

import io.github.fierg.model.dto.PuzzleDTO
import io.github.fierg.model.dto.SolutionDTO
import javax.enterprise.context.ApplicationScoped


@ApplicationScoped
class PuzzleController {
    private var currentPuzzle: PuzzleDTO? = null
    private var solutions: MutableList<SolutionDTO?> = mutableListOf()

    fun setPuzzle(puzzle:PuzzleDTO){
        currentPuzzle = puzzle

        //DEBUG
        addSolution(SolutionDTO(puzzle.server_id, puzzle.raetsel_id, puzzle.row1, puzzle.row2, puzzle.row3, "42"))
    }

    fun getPuzzle() = currentPuzzle

    fun addSolution(solutionDTO: SolutionDTO) {
        solutions.add(0, solutionDTO)
        if (solutions.size > 5) solutions.removeLast()
    }

    fun getSolutions() = solutions
}