package org.openapex.tvguide.model;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
@Data
public class ChannelAdditionalInfo {
    @NotEmpty
    private String description;
}
