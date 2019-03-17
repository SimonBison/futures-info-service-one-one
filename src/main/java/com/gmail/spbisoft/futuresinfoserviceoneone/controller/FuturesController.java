package com.gmail.spbisoft.futuresinfoserviceoneone.controller;

import com.gmail.spbisoft.futuresinfoserviceoneone.model.FuturesModel;
import com.gmail.spbisoft.futuresinfoserviceoneone.repository.FuturesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4201")
@RestController
@RequestMapping(value = "/futures")
public class FuturesController {

    @Autowired
    FuturesRepository futuresRepository;

    @GetMapping(value = "/all")
    public List<FuturesModel> getAll() {
        return futuresRepository.findAll();
    }

    @PostMapping(value = "/create")
    public List<FuturesModel> persist(@RequestBody final FuturesModel futuresModel) {
        futuresRepository.save(futuresModel);

        return futuresRepository.findAll();
    }

    @GetMapping(value = "/affordable/{margin}")
    public List<FuturesModel> getAffordable(@PathVariable int margin){
        return futuresRepository.findByFuturesMarginLessThan(margin);
    }

    @DeleteMapping(value = "/delete/{id}")
    public List<FuturesModel> remove(@PathVariable int id) {
        futuresRepository.deleteById(id);

        return futuresRepository.findAll();
    }
}