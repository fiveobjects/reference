package org.openapex.tvguide.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "program")
public class ProgramDocument {
    @Id
    @JsonIgnore
    private String id;
    private String title;
    private String type;
    private String genre;
    private String certification;
    private List<String> actors;
    private String director;
    private String producer;

}
