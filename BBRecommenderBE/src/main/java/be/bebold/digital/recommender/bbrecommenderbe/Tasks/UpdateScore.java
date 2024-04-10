package be.bebold.digital.recommender.bbrecommenderbe.Tasks;

import be.bebold.digital.recommender.bbrecommenderbe.Services.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/***
 * Class that contains the scheduled tasks for the application
 * to update the score  after 8am or initialize the score after startup
 */
@Component
public class UpdateScore {

  @Autowired
  private RecommendationService recommendationService;

  /***
   * Updates the calculated score of the marketingtools in the database. This is done everyday at 08:00 am.
   */
  @Scheduled(cron = "0 0 8 * * *")
  public void updateScoresOfDatabaseTools() {
    recommendationService.updateCalculatedScoreForMarketingTools();
  }

  /***
   * Updates the calculated score of the marketingtools in the database. This is done after the application is started.
   */
  @EventListener(ApplicationReadyEvent.class)
  public void InititializeScoreAfterStartup() {
    recommendationService.updateCalculatedScoreForMarketingTools();
  }
}
