package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.threeten.bp.LocalDate;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Model class for Task
 * 
 * @authors Glenwood McDowell & Yaser Albonni
 *
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-07-31T18:12:46.646471100-04:00[America/New_York]")
public class Task {
	
	@Size(min = 3, max = 100)
	@JsonProperty("name")
	private String name = null;

	@JsonProperty("dueDate")
	private LocalDate dueDate = null;

	@Size(min = 3, max = 100)
	@JsonProperty("category")
	private String category = null;

	@Size(max = 2000)
	@JsonProperty("description")
	private String description = null;

	@JsonProperty("isCompleted")
	private Boolean isCompleted = null;

	public Task name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Get name
	 * 
	 * @return name
	 **/
	@ApiModelProperty(example = "Task", value = "")

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Task dueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
		return this;
	}

	/**
	 * Get dueDate
	 * 
	 * @return dueDate
	 **/
	@ApiModelProperty(value = "")

	@Valid
	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	@Size(min = 3, max = 100)
	public Task category(String category) {
		this.category = category;
		return this;
	}

	/**
	 * Get category
	 * 
	 * @return category
	 **/
	@ApiModelProperty(example = "Category", value = "")

	@Size(min = 3, max = 100)
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Task description(String description) {
		this.description = description;
		return this;
	}

	public void setIsCompleted(Boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	public Boolean getIsCompleted() {
		return this.isCompleted;
	}

	public void toggleIsCompleted() {
		this.isCompleted = !this.isCompleted;
	}

	/**
	 * Get description
	 * 
	 * @return description
	 **/
	@ApiModelProperty(example = "Category", value = "")

	@Size(max = 2000)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Task task = (Task) o;
		return Objects.equals(this.name, task.name);
		// && Objects.equals(this.dueDate, task.dueDate)
		// && Objects.equals(this.category, task.category) &&
		// Objects.equals(this.description, task.description);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, dueDate, category, description);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Task {\n");

		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    dueDate: ").append(toIndentedString(dueDate)).append("\n");
		sb.append("    category: ").append(toIndentedString(category)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
