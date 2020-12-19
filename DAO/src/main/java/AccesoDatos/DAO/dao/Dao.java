package AccesoDatos.DAO.dao;

import java.sql.Connection;
import java.util.List;

public interface Dao<T> {
	void get(int id, Connection connect);
    
    List<T> getAll(Connection connect);
    
    void save(T t, Connection connect);
    
    void update(T t, Connection connect);
    
    void delete(int t, Connection connect);
}
