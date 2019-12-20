package br.com.salao.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data   
@AllArgsConstructor  
@NoArgsConstructor  
@Entity  
@NamedQueries(value = {
	@NamedQuery(name = "select_all_courses", query = "SELECT c FROM Course c"),
	@NamedQuery(name = "select_all_courses_condition", query = "SELECT c FROM Course c WHERE name like '%Ciê%'")
})

public class Course{
 
	@Id 
	@GeneratedValue  
	private Long id; 
	
	@Column(name = "name", nullable = false, unique = true) 
	private String name; 
	
	@CreationTimestamp
	private LocalDateTime createdDate; 
	
	@UpdateTimestamp
	private LocalDateTime lastUpdatedDate;
	
	@OneToMany(mappedBy = "course")
	private List<Review> reviews = new ArrayList<Review>();
		
	public Course(String name) {
		this.name = name;
	}
	
	public void addReview(Review review) {
		reviews.add(review);
	}
	
	public void removeReview(Review review) {
		reviews.remove(review);
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", createdDate=" + createdDate + ", lastUpdatedDate="
				+ lastUpdatedDate + "]";
	}
	
	
}
