package com.lilianLima.todo.repository;

import com.lilianLima.todo.model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Integer> {
    @Query("SELECT obj FROM ToDo obj WHERE obj.finalizado = false ORDER BY obj.dataParaFinalizar")
    List<ToDo> findAllOpen();

    @Query("SELECT obj FROM ToDo obj WHERE obj.finalizado = true ORDER BY obj.dataParaFinalizar")
    List<ToDo> findAllClosed();
}
