package io.github.fierg.mqtt

import com.fasterxml.jackson.databind.ObjectMapper
import io.github.fierg.controller.PuzzleController
import io.github.fierg.model.dto.GameDTO
import io.github.fierg.resources.MQTTResource
import org.eclipse.microprofile.reactive.messaging.Incoming
import org.jboss.logging.Logger
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject


@ApplicationScoped
class MQTTBean {

    private val log: Logger = Logger.getLogger(MQTTResource::class.java)

    @Inject
    lateinit var controller: PuzzleController

    @Incoming("Zahlenraetsel")
    fun receiveMQTT(byteArray: ByteArray){
        val gameString = String(byteArray)
        log.info("Received $gameString")
        val game = ObjectMapper().readValue(gameString, GameDTO::class.java)
        controller.setPuzzle(game)
    }
}