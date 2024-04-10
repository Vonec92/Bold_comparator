package be.bebold.digital.recommender.bbrecommenderbe.Model;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/***
 * enity class for to store the recommendation in the data base
 * It has a one to one relation with the filter options and a many to one relation with the toolinfo  
 * @author [Baeten Jens]
 * @version 1.0
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Recommendation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String uid;

    @Column
    private String creator;
    
    @Column
    private Date date;

    @Column
    private String toolName;

    @Column
    private String companyName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_filterOptions_id")
    private FilterOptions filterOptions;

    @ManyToOne
    @JoinColumn(name = "tool_id")
    private ToolDetailedInfo toolInfo;    
}
