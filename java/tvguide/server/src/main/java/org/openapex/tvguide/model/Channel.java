package org.openapex.tvguide.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "channel")
@Validated
public class Channel {
    @Id
    @SequenceGenerator(name="channel_number_seq", initialValue = 101)
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "channel_number_seq")
    private int channelNumber;
    private String name;
    private double price;
    private String channelGroup;
    private LocalDateTime marker;
    private boolean isRegional;
    @Transient
    @NotNull
    @Valid
    private ChannelAdditionalInfo additionalInfo;

}
