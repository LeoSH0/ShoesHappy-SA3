package org.example;
import org.springframework.web.find.annotation.PostMapping;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {

    List<Person> persons = new ArrayList<>();
    int id =0;

    @PostMapping("/person")
    public Person addClient(@PathParam("id") int id, @PathParam("name") String name, @RequestParam("sex") String sex, @RequestParam("age") Integer age){
        Person person = new Person();
        person.setName(name);
        person.setSex(sex);
        person.setAge(age);
        id++;
        person.setId(id);
        persons.add(person);
        return person;

    }

    @GetMapping("/person")
    public Person findClient(@PathParam("id") int id, @PathParam("name") String name){
        for(Person p : persons){
            if(p.getName().equals(name)){
                return p;
            }

        }

        return null;
    }

    @PutMapping("/person")
    public Person updateClient(@PathParam("id") int id, @PathParam("name") String name){
        Person p = new Person();
        for(Person person :persons){
            if(person.getId() ==id){
                person.setName(name);
                p =person;
            }

        }

        return p;
    }

    @DeleteMapping("/person")
    public String removeClient(@PathParam("name") String name){
        Person person = new Person();
        for(Person p : persons){
            if(p.getName().equals(name)){
                person =p;
            }

        }
        persons.remove(person);
        return("O cliente: "+ name +", foi removido com sucesso!");


    }
}
