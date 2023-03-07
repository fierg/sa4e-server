package io.github.fierg.server

import io.github.fierg.resources.ExampleResource
import io.quarkus.scheduler.Scheduled
import org.jboss.logging.Logger
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class CronServer {

        private val log: Logger = Logger.getLogger(ExampleResource::class.java)

        @Scheduled(cron = "{cron.expr}")
        fun cronJobWithExpressionInConfig() {
            log.info("Executing job, cron expression configured in application.properties")
        }
}