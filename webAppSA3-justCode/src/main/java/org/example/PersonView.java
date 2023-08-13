package org.example;
import org.springframework.web.find.annotation.PostMapping;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonView {
    @Autowired
    Controller controller;

    @PostMapping("/person")
    public Person addClient(@PathParam("id") Integer id, @PathParam("name") String name, @RequestParam("sex") String sex, @RequestParam("age") Integer age){
        return controller.addClient(id, name, sex, age);


    }

    @GetMapping("/person")
    public Person findClient(@PathParam("name") String name){
        return controller.findClient(name);

    }

    @PutMapping("/person")
    public Person updateClient(@PathParam("id") Integer id, @PathParam("name") String name){
        return controller.updateClient(id, name);
    }

    @GetMapping("/all")
    public List<Person> listAll(){
        return controller.listAll();

    }

    @DeleteMapping("/person")
    public String removeClient(@PathParam("name") String name){
        return controller.removeClient(name);

        return"O cliente: "+ name +", foi removido com sucesso!";
    }

}
