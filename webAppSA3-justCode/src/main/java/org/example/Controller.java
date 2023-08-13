package org.example;

import java.util.ArrayList;
import java.util.List;
@service
public class Controller {

    @Autowired
    private PersonRepository personRepository;
    private List<Person> persons = new ArrayList<>();
    private int id =0;

    public Person findClient(String name){
        List<Person> persons = (List<Person>) personRepository.findAll();
        for(Person p : persons){
            if(p.getName().equals(name)){
                return p;
            }
        }
        return null;
    }

    public Person addClient(int id, String name, String sex, Integer age){
        Person person = new Person();
        person.setName(name);
        person.setSex(sex);
        person.setAge(age);
        id++;
        person.setId(id);
        personRepository.save(person);

        return person;
    }

    public Person updateClient(Integer id, String name){
        Person person = findClient(name);
        person.setId(id);
        personRepository.save(person);

        return person;

    }]public List<Person> listAll(){
    return (List<Person>)personRepository.findAll();
    }

    public String removeClient(String name) {
        Person p = new Person();
        personRepository.delete(p);

        return name;
    }

}
