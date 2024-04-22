package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.ToDoList.entity.checkList;

@Repository
public interface checkListRepository extends JpaRepository<checkList,Long> {
    
}
