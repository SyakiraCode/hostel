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
package com.example.hostel.models;

/*
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;*/

//import javax.persistence.CascadeType;
//import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
//import javax.validation.constraints.NotEmpty;

//import org.springframework.beans.support.MutableSortDefinition;
//import org.springframework.beans.support.PropertyComparator;
//import org.springframework.core.style.ToStringCreator;





//import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;



/**
 * Simple JavaBean domain object representing an owner.
 *
 * 
 */
@Data
@Entity
@Table(name = "room")
public class Room {

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

	
	@Column(name = "name")
	private String name;


	@Column(name = "matrik")
	//@NotEmpty
	private String matrik;

	@Column(name = "email")
	//@NotEmpty
	private String email;

	@Column(name = "block")
	//@NotEmpty
	@Digits(fraction = 0, integer = 10)
	private String block;

	@Column(name = "roomno")
	//@NotEmpty
	@Digits(fraction = 0, integer = 10)
	private String roomno;

	public Room() {

	}

	public Room(String name, String matrik, String email, String block, String roomno) {
		
		this.name = name;
		this.matrik=matrik;
        this.email = email;
        this.block = block;
        this.roomno = roomno;
 



	}
	//@OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
	//private Set<Pet> pets;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isNew() {
		return this.id == null;
	}



	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getMatrik() {
		return this.matrik;
	}

	public void setMatrik(String matrik) {
		this.matrik = matrik;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBlock() {
		return this.block;
	}

	public void setBlock(String block) {
		this. block =  block;
	}


	/*
	protected Set<Pet> getPetsInternal() {
		if (this.pets == null) {
			this.pets = new HashSet<>();
		}
		return this.pets;
	}

	protected void setPetsInternal(Set<Pet> pets) {
		this.pets = pets;
	}

	public List<Pet> getPets() {
		List<Pet> sortedPets = new ArrayList<>(getPetsInternal());
		PropertyComparator.sort(sortedPets, new MutableSortDefinition("name", true, true));
		return Collections.unmodifiableList(sortedPets);
	}

	public void addPet(Pet pet) {
		if (pet.isNew()) {
			getPetsInternal().add(pet);
		}
		pet.setOwner(this);
	}

	*/

	/**
	 * Return the Pet with the given name, or null if none found for this Owner.
	 * @param name to test
	 * @return true if pet name is already in use
	 */

	 /*
	public Pet getPet(String name) {
		return getPet(name, false);
	}*/

	/**
	 * Return the Pet with the given name, or null if none found for this Owner.
	 * @param name to test
	 * @return true if pet name is already in use
	 */


	 /*
	public Pet getPet(String name, boolean ignoreNew) {
		name = name.toLowerCase();
		for (Pet pet : getPetsInternal()) {
			if (!ignoreNew || !pet.isNew()) {
				String compName = pet.getName();
				compName = compName.toLowerCase();
				if (compName.equals(name)) {
					return pet;
				}
			}
		}
		return null;
	}
	*/

	/*
	@Override
	public String toString() {
		return new ToStringCreator(this)

				.append("id", this.getId()).append("new", this.isNew()).append("matrik", this.getMatrik())
				.append("name", this.getName()).append("email", this.email).append("block", this.block)
				.append("roomno", this.roomno).toString();
	}
	*/

}
