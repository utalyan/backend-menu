package com.restaurant.menu.entity;

        import com.fasterxml.jackson.annotation.JsonIgnore;
        import lombok.Data;

        import javax.persistence.*;
        import javax.validation.constraints.NotEmpty;
        import javax.validation.constraints.NotNull;

@Entity
@Data
public class Repast extends BaseEntity{

    @Id
    @GeneratedValue(generator = "seq",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq",sequenceName = "repast_seq")
    private Long id;

    @Column(length = 50)
    @NotNull
    @NotEmpty
    private String name;

    @JsonIgnore
    @ManyToOne
    Firm firm;
}
