package com.lilianLima.todo.service;

import com.lilianLima.todo.exception.ObjectNotFoundException;
import com.lilianLima.todo.model.ToDo;
import com.lilianLima.todo.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {
    @Autowired
    private ToDoRepository repository;

    public ToDo findById(Integer id){
        Optional<ToDo> obj = repository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: "+ ToDo.class.getName()));
    }

    public List<ToDo> findAllOpen() {
        List<ToDo> list =repository.findAllOpen();
        return list;
    }

    public List<ToDo> findAllClosed() {
        List<ToDo> list =repository.findAllClosed();
        return list;
    }

    public List<ToDo> findAll() {
        List<ToDo> list = repository.findAll();
        return list;
    }

    public ToDo create(ToDo obj) {
        obj.setId(null);
        return repository.save(obj);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public ToDo update(Integer id, ToDo obj) {
        ToDo newObj = findById(id);
        newObj.setTitulo(obj.getTitulo());
        newObj.setDataParaFinalizar(obj.getDataParaFinalizar());
        newObj.setDescricao(obj.getDescricao());
        newObj.setFinalizado(obj.getFinalizado());
        return repository.save(newObj);
    }
}
