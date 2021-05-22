package com.graduation.util;

import com.graduation.util.exception.IdNotFoundException;
import org.springframework.data.repository.CrudRepository;

public class MainUtil {

    public static <T> T findByIdThrowExceptionIfNotFound(CrudRepository<T, Integer> repository, Integer id) {
        return repository.findById(id).orElseThrow(() -> new IdNotFoundException(id));
    }
}
