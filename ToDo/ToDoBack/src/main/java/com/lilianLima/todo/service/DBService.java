package com.lilianLima.todo.service;

import com.lilianLima.todo.model.ToDo;
import com.lilianLima.todo.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Service
public class DBService {
    @Autowired
    private ToDoRepository toDoRepository;

    public void instaciaBaseDeDados() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        ToDo t1 = new ToDo(null, "Estudar", "Estudar Spring Boot", sdf.parse("15/05/2022"), false);
        ToDo t2 = new ToDo(null, "Organizar", "Organizar planilha", sdf.parse("09/10/2022"), false);
        ToDo t3 = new ToDo(null, "Meditar", "Meditar ou surtar", sdf.parse("09/08/2022"), true);
        ToDo t4 = new ToDo(null, "Descansar", "Descansar", sdf.parse("09/6/2022"), true);

        toDoRepository.saveAll(Arrays.asList(t1, t2, t3, t4));
    }
}
