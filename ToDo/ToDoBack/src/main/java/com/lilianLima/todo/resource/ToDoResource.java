package com.lilianLima.todo.resource;

import com.lilianLima.todo.model.ToDo;
import com.lilianLima.todo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/todos")
public class ToDoResource {

    @Autowired
    private ToDoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ToDo> findById(@PathVariable Integer id){
        ToDo obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/open")
    public ResponseEntity<List<ToDo>> listOpen(){
        List<ToDo> list = service.findAllOpen();
            return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/closed")
    public ResponseEntity<List<ToDo>> listClosed(){
        List<ToDo> list = service.findAllClosed();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping
    public ResponseEntity<List<ToDo>> listAll(){
        List<ToDo> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<ToDo>create(@RequestBody ToDo obj){
        obj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ToDo>delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<ToDo>update(@PathVariable Integer id, @RequestBody ToDo obj){
        ToDo newObj = service.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }

}
