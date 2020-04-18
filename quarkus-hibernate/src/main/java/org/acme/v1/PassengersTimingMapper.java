package org.acme.v1;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * https://mapstruct.org/news/2019-12-06-mapstruct-and-quarkus/
 * https://mapstruct.org/documentation/stable/reference/html/#_apache_maven
 */
@Mapper(componentModel = "cdi")
@DecoratedWith(PassengersTimingMapperDecorator.class)
public interface PassengersTimingMapper {
    PassengersTimingFront toFront(PassengersTimingDto person);
}
