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
* this is the entity class that stores the detailed info of the marketing tools in the database
* @author [Baeten Jens]
* @version 1.0
*/

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ToolDetailedInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String toolName;

    @Column(columnDefinition = "TEXT")
    private String toolDescription;

    @Column
    private String toolVideoUrl;
    
}
