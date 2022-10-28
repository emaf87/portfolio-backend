
package com.portfolio.backend.basededatos.service;


import com.portfolio.backend.basededatos.model.Project;
import java.util.List;


public interface IProyectService {
    
    public List<Project> getProjects();
    
    public void saveProject(Project proy);
    
    public void deleteProject(int id);
    
    public Project findProject(int id);
    
   public void saveProjectsList(List<Project> projList);
    
    
}
