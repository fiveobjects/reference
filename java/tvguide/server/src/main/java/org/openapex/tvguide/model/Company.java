package org.openapex.tvguide.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Data
@Document
public class Company {

    public GeneralInfo info;
    public Map<String, List<Employee>> officeIdEmployeeMap;

    @Data
    public class GeneralInfo {
        @Id
        public String id;
        public String companyId;
        public String name;
    }

    @Data
    public class Employee {
        public String firstName;
        public String lastName;
    }
}
