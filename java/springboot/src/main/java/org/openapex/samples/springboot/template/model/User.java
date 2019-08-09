package org.openapex.samples.springboot.template.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private UserStatusDto status;
}
