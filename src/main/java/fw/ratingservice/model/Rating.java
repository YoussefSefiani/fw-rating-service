package fw.ratingservice.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rating {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private Long id;

    private Long brandId;
    private Long influencerId;

    private Float amount;
    private String description;


}
