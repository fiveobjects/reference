package org.openapex.samples.springboot.template.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
@Data
@AllArgsConstructor
public class UserStatusDto implements Serializable {
    private Long id;
    private String name;
}
