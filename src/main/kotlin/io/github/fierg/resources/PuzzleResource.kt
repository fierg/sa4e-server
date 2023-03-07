package io.github.fierg.resources

import io.github.fierg.controller.PuzzleController
import javax.enterprise.context.RequestScoped
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@RequestScoped
@Path("/mqtt")
class PuzzleResource {

    @Inject
    private lateinit var puzzleController: PuzzleController

    @GET
    @Path("/puzzle")
    @Produces(MediaType.APPLICATION_JSON)
    fun getPuzzle(): Response {
        return if (puzzleController.getPuzzle() == null){
            Response.noContent().build()
        } else {
            Response.ok(puzzleController.getPuzzle()).build()
        }
    }

    @GET
    @Path("/solutions")
    @Produces(MediaType.APPLICATION_JSON)
    fun getSolutions(): Response {
        return if (puzzleController.getSolutions().isEmpty()){
            Response.noContent().build()
        } else {
            Response.ok(puzzleController.getSolutions()).build()
        }
    }
}