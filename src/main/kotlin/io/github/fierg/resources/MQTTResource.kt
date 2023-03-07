package io.github.fierg.resources

import io.github.fierg.controller.PuzzleController
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/mqtt")
class MQTTResource {

    @Inject
    lateinit var puzzleController: PuzzleController

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun getPuzzle(): Response {
        return if (puzzleController.getPuzzle() == null){
            Response.noContent().build()
        }else {
            Response.ok(puzzleController.getPuzzle()).build()
        }
    }
}