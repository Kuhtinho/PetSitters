package kuchta.com.controller;

import kuchta.com.model.petsitter.PetSitter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/petowners")
public class PetOwnerController {

    public List<PetSitter> getPetSittersByServiceId() {
        return null;
    }


}
