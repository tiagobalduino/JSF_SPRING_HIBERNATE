package com.tiagobalduino.springhibernate.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
 
/**
 * Entity Department respolsible populate Table Person 
 * @author Tiago Balduino
 *
 */
@Entity
@Table(name="User")
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4677585752422832410L;

	@Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
	@Column(name="name")
    private String name;
	
	@Column(name="description")
    private String description;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
	  name="userpermission",
	  joinColumns={@JoinColumn(name="user_id", referencedColumnName="id")},
	  inverseJoinColumns={@JoinColumn(name="permission_id", referencedColumnName="id")})
	private List<Permission> permissions;
	
	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "department_id")
	private Department department;
	
	

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<Permission> permissionsList() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + "]";
	}
	

   
}