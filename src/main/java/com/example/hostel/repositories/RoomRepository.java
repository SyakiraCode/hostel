/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.hostel.repositories;

import java.util.Collection;
import java.util.List;
//import java.util.List;
//import java.util.List;
//import java.util.Optional;
import java.util.Optional;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jdbc.repository.query.Modifying;

/**
 * Repository class for <code>Owner</code> domain objects All method names are compliant
 * with Spring Data naming conventions so this interface can easily be extended for Spring
 * Data. See:
 * https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.query-creation
 *
 * @author Ken Krebs
 * @author Juergen Hoeller
 * @author Sam Brannen
 * @author Michael Isvy
 * 
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import com.example.hostel.models.Room;
import org.springframework.transaction.annotation.Transactional;

@ComponentScan
public interface RoomRepository extends JpaRepository<Room, Integer> {

	/**
	 * Retrieve {@link Owner}s from the data store by last name, returning all
	 * owners whose last name <i>starts</i> with the given name.
	 * 
	 * @param lastName Value to search for
	 * @return a Collection of matching {@link Owner}s (or an empty Collection if
	 *         none found)
	 */

	// @Query("SELECT DISTINCT owner FROM Owner owner left join fetch owner.pets
	// WHERE owner.matrik LIKE :matrik%")

	@Query("SELECT DISTINCT room FROM Room room")
	@Transactional(readOnly = true)
	Collection<Room> findByMatrik(@Param("matrik") String matrik);

	/**
	 * Retrieve an {@link Owner} from the data store by id.
	 * 
	 * @param id the id to search for
	 * @return the {@link Owner} if found
	 */

	// @Query("SELECT owner FROM Owner owner left join fetch owner.pets WHERE
	// owner.id =:id")

	
	
	@Query("SELECT room FROM Room room WHERE room.id =:id")
	@Transactional(readOnly = true)
	Optional<Room> findById(@Param("id") Integer id);


	@Transactional
    @Modifying
    @Query(value = "UPDATE room r set name =:name, matrik =:matrik, email =:email, block =:block, roomno=:roomno",
                    nativeQuery = true)
	 // DEFINED THE NATIVE QUERY FOR UPDATE INSTEAD OF USING SAVE() OPERATION            
	void updateRoom(@Param("name") String name,@Param("matrik") String matrik,@Param("email") String email,@Param("block") String block, @Param("roomno") String roomno);

	//List<Room> search(String matrik);


	@Query(value = "SELECT room FROM Room room WHERE room.name LIKE '%' || :keyword || '%'"
	+ " OR room.matrik LIKE '%' || :keyword || '%'"
	+ " OR room.email LIKE '%' || :keyword || '%'"
	+ " OR room.block LIKE '%' || :keyword || '%'"
	+ " OR room.roomno LIKE '%' || :keyword || '%'")
	public List<Room> search(@Param("keyword") String keyword);




	/*
	@Override
	@Query("SELECT room FROM Room room WHERE room.id=:id")
	public Room findById(Integer id);*/
	
	//void save(Room room);

	//<S> S save(Room room);

}
