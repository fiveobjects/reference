package org.openapex.tvguide.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "channel")
public class Channel {
    @Id
    @SequenceGenerator(name="channel_number_seq", initialValue = 101)
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "channel_number_seq")
    private int channelNumber;
    private String name;
    private double price;
    private String channelGroup;

}
