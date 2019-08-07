package com.stackroute.muzixapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "Track")
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Track {
    @Id
    private int id;
    private String name;
    private String artist;

}
