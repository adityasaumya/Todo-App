package com.claykab.todo_api.todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
