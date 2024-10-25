package mk.finki.ukim.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
public class Event
{
    private String name;
    private String description;
    private double popularityScore;
}
