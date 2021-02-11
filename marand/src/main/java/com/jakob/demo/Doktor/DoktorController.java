package com.jakob.demo.Doktor;

import com.jakob.demo.NotFoundExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DoktorController {
    @Autowired
    private DoktorRepository doktorRepository;

    @GetMapping("/doktors/{id}")
    public Doktor getDoktorByID(@PathVariable Long id){
        Optional<Doktor> optionalDoktor = doktorRepository.findById(id);
        if(optionalDoktor.isPresent()){
            return optionalDoktor.get();
        }else {
            throw new NotFoundExeption("ne dela");
        }
    }
    @PostMapping("/doktors")
    public Doktor createDoktor(@Validated @RequestBody Doktor doktor){
        return doktorRepository.save(doktor);
    }


    /*
    @PostMapping("/doktors")
    public String postBody(@RequestBody String ime){
        return ime;
    }

     */

    @PutMapping("/doktors/{id}")
    public Doktor updateDoktor(@PathVariable Long id,
                               @Validated @RequestBody Doktor doktorUpdated ){
        return doktorRepository.findById(id).
                map(doktor -> {
                    doktor.setDepartment(doktorUpdated.getDepartment());
                    // tale bo moogče error ker je nekej novga
                    doktor.setPatients(doktorUpdated.getPatients());
                    return doktorRepository.save(doktor);
                        }).orElseThrow(()-> new NotFoundExeption("doktor ni najden"));


    }

}
