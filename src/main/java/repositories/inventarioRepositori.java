package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import models.inventarioModel;

@Repository
public interface inventarioRepositori extends JpaRepository<inventarioModel, Long>{


    
}
