package com.portfolio.backend.basededatos.service;

import com.portfolio.backend.basededatos.model.Education;
import java.util.List;

public interface IEducationService {

    public List<Education> getEducation();

    public void saveEducation(Education edu);

    public void deleteEducation(int id);

    public Education findEducation(int id);
}
