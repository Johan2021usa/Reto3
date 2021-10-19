package com.Retos.CicloTres.web;

import com.Retos.CicloTres.model.Partyroom;
import com.Retos.CicloTres.service.PartyroomService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Partyroom")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class PartyroomController {
    
    @Autowired
    private PartyroomService partyroomService;
    
    @GetMapping("/all")
    public List<Partyroom> getPartyroom(){
        return partyroomService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Partyroom> getPartyroom(@PathVariable("id") int id){
        return partyroomService.getPartyroom(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Partyroom save(@RequestBody Partyroom partyroom){
        return partyroomService.save(partyroom);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Partyroom update(@RequestBody Partyroom partyroom){
        return partyroomService.update(partyroom);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deletePartyroom(@PathVariable("id") int id){
        return partyroomService.deletePartyroom(id);
    }
    
}
