package com.somoo.organizer.persistence.crud;

import java.util.Optional;

public interface CRUD<T, ID> {

    boolean create(T t);

    Optional<T> read(ID id);

    boolean update(T t);

    boolean delete(T t);
}
