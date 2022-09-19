package com.portfolio.backend.basededatos.service;

import com.portfolio.backend.basededatos.model.PersonalDetails;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.backend.basededatos.repository.PersonalDetailsRepository;

@Service
public class PersonalDetailsService implements IPersonalDetailsService {

    @Autowired
    private PersonalDetailsRepository personalDetailsRepository;

    @Override
    public List<PersonalDetails> getPersonalDetails() {
        return personalDetailsRepository.findAll();
    }

    @Override
    public void savePersonalDetails(PersonalDetails data) {
        personalDetailsRepository.save(data);
    }

    @Override
    public void deletePersonalDetails(int id) {
        personalDetailsRepository.deleteById(id);
    }

    @Override
    public PersonalDetails findPersonalDetails(int id) {
        return personalDetailsRepository.findById(id).orElse(null);
    }
}
