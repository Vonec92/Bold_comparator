package be.bebold.digital.recommender.bbrecommenderbe.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/***
 * enity class for to store the filter options (user input) in the data base
 * @author [Baeten Jens]
 * @version 1.0
 */


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FilterOptions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

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
    
}