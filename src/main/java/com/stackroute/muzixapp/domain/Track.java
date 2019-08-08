package com.stackroute.muzixapp.domain;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "track")
public class Track {
    @Id
    private int id;
    private String name;
    private String artist;

}
