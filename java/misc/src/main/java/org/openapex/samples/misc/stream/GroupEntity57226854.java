package org.openapex.samples.misc.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupEntity57226854 {
    public static void main(String[] args) {
        List<Entity> entities = new ArrayList<>();
        entities.add(createEntity("Jan", "2019", "abc"));
        entities.add(createEntity("Jan", "2019", "xyz"));
        entities.add(createEntity("Jan", "2018", "ert"));
        entities.add(createEntity("Jan", "2018", "rty"));
        List<GroupOfEntity> groupEntities
                = entities.stream().collect(Collectors.groupingBy(Entity::getEntityPk)).entrySet()
                .stream().map(e -> new GroupOfEntity(e.getKey().getPeriodMonth(), e.getKey().getPeriodYear(), e.getValue()))
                .collect(Collectors.toList());
        System.out.println(groupEntities);

    }

    private static Entity createEntity(String month, String year, String value) {
        return new Entity(new EntityPK(month, year), value);
    }

    @Data
    @AllArgsConstructor
    @ToString
    public static class Entity {
        private EntityPK entityPk;
        private String someValue;
    }
    @Data
    @AllArgsConstructor
    @ToString
    public static class EntityPK {
        private String periodMonth;
        private String periodYear;
    }
    @Data
    @AllArgsConstructor
    @ToString
    public static class GroupOfEntity {
        private String periodMonth;
        private String periodYear;
        private List<Entity> entities;
    }
}
