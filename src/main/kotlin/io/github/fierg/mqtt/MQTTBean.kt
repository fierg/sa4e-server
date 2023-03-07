package io.github.fierg.mqtt

import com.fasterxml.jackson.databind.ObjectMapper
import io.github.fierg.controller.PuzzleController
import io.github.fierg.model.dto.PuzzleDTO
import io.github.fierg.model.dto.SolutionDTO
import io.github.fierg.resources.PuzzleResource
import org.eclipse.microprofile.reactive.messaging.Incoming
import org.jboss.logging.Logger
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject


@ApplicationScoped
class MQTTBean {

    private val log: Logger = Logger.getLogger(PuzzleResource::class.java)

    @Inject
    private lateinit var controller: PuzzleController

    @Incoming("Zahlenraetsel")
    fun receivePuzzle(byteArray: ByteArray){
        val gameString = String(byteArray)
        log.info("Received Puzzle: $gameString")
        val game = ObjectMapper().readValue(gameString, PuzzleDTO::class.java)
        controller.setPuzzle(game)
    }

    @Incoming("Loesung")
    fun receiveSolution(byteArray: ByteArray){
        val gameString = String(byteArray)
        log.info("Received Solution: $gameString")
        val game = ObjectMapper().readValue(gameString, SolutionDTO::class.java)
        controller.addSolution(game)
    }


}