package com.fresheats.fresh.entities;

import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Category")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoryEntity extends BaseEntity {

	 	@Column(name = "Category_Name", nullable = false)
	    private String categoryName;

	    @Column(name = "Description")
	    private String description;

		@OneToMany(mappedBy = "categoryId")
		private List<ProductEntity> products;

//	    @ManyToOne(fetch = FetchType.LAZY)
//	    @JoinColumn(name = "Parent_CategoryID")
//	    private CategoryEntity parentCategory;

//	    @OneToMany(mappedBy = "parentCategory", cascade = CascadeType.ALL, orphanRemoval = true)
//	    private List<CategoryEntity> subcategories = new ArrayList<>();
}
