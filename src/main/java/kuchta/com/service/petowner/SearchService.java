package kuchta.com.service.petowner;

import kuchta.com.repository.PetSitterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchService {

    @Autowired
    private PetSitterRepository petSitterRepository;



}
