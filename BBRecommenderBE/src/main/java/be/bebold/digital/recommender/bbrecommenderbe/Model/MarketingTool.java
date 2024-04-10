package be.bebold.digital.recommender.bbrecommenderbe.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/***
 * this is the entity class for the marketing tools that are stored in the database
 * @author [Baeten Jens]
 * @version 1.0
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MarketingToolData")
public class MarketingTool {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String toolName;

    @Column
    private Integer budget;

    @Column
    private Boolean hasFreeTrial;

    @Column
    private Integer emailsPerMonth;

    @Column
    private Integer contacts;

    @Column
    private String[] features;

    @Column
    private String levelOfSupport;

    @Column
    private String dbQuality;

    @Column
    private String hasDragAndDrop;

    @Column
    private String implementationModel;

    @Column
    private Double score;
}
