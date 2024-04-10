package be.bebold.digital.recommender.bbrecommenderbe.Dtos.UpdateDTO;

import lombok.*;


/***
 * This class is used to store the data of the tool that is being updated
 * this is used as userinput data, to calcultate the score of the input
 */

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ToolDataDTO {

    private long id;
    private Integer budget;
    private Boolean hasFreeTrial;
    private Integer emailsPerMonth;
    private Integer contacts;
    private String[] features;
    private String levelOfSupport;
    private String  dbQuality;
    private String hasDragAndDrop;
    private String implementationModel;
}
