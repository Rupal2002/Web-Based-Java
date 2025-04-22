package JDBCPractice;

	import java.util.Collection;

	public interface jdbcDao<T, K>
	{
	   //READ
	   Collection<T> getAll();// Get all objects of specific type.
	   T getOne(K Key);//get one object of the specific type based upon its identity.
	   
	   //CREATE
	   void add(T t);//Add a new record into the existing table
	   
	   //UPDATE
	   void update(T t);//update the existing record
	   
	   //DELETE
	   void delete(K keys);//Delete the specific record against its identity.
	}
	//This is generic interface which provides a basic templates for performing
	//CRUD Operations.


