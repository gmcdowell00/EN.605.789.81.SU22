package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.threeten.bp.LocalDate;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Model class for user
 * 
 * @authors Glenwood McDowell
 *
 */
@Document(collection = "user")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-07-28T21:22:43.336883600-04:00[America/New_York]")
public class UserAccount {

	@Id
	private ObjectId _id;

	@Field
	@NotBlank(message = "Can't be empty")
	@NotEmpty(message = "Can't be empty")
	@NotNull(message = "Can't be null")
	@JsonProperty("userId")
	private String userId = null;

	@Field
	@NotBlank(message = "Can't be empty")
	@NotEmpty(message = "Can't be empty")
	@NotNull(message = "Can't be null")
	@JsonProperty("password")
	private String password = null;

	@Field
	@NotBlank(message = "Can't be empty")
	@NotEmpty(message = "Can't be empty")
	@NotNull(message = "Can't be null")
	@JsonProperty("firstName")
	private String firstName = null;

	@Field
	@NotEmpty(message = "Can't be empty")
	@NotNull(message = "Can't be null")
	@JsonProperty("lastName")
	private String lastName = null;

	@Field
	@NotBlank(message = "Can't be empty")
	@NotEmpty(message = "Can't be empty")
	@NotNull(message = "Can't be null")
	@JsonProperty("email")
	private String email = null;

	@Field
	@NotBlank(message = "Can't be empty")
	@NotEmpty(message = "Can't be empty")
	@NotNull(message = "Can't be null")
	@JsonProperty("dateOfBirth")
	private LocalDate dateOfBirth = null;

	@Field
	@JsonProperty("token")
	private Token token = null;

	@Field
	@JsonProperty("tasks")
	@Valid
	private List<Task> tasks = null;

	@Field
	@NotBlank(message = "Can't be empty")
	@NotEmpty(message = "Can't be empty")
	@NotNull(message = "Can't be null")
	@JsonProperty("street")
	@Valid
	public String street = null;

	@Field
	@NotBlank(message = "Can't be empty")
	@NotEmpty(message = "Can't be empty")
	@NotNull(message = "Can't be null")
	@JsonProperty("city")
	@Valid
	public String city = null;

	@Field
	@NotBlank(message = "Can't be empty")
	@NotEmpty(message = "Can't be empty")
	@NotNull(message = "Can't be null")
	@JsonProperty("state")
	@Valid
	public String state = null;

	@Field
	@NotBlank(message = "Can't be empty")
	@NotEmpty(message = "Can't be empty")
	@NotNull(message = "Can't be null")
	@JsonProperty("zipCode")
	@Valid
	public String zipCode = null;

	public UserAccount userId(String userId) {
		this.userId = userId;
		return this;
	}

	/**
	 * Get userId
	 * 
	 * @return userId
	 **/
	@ApiModelProperty(example = "TestUser20", required = true, value = "")
	@NotNull

	@Size(min = 8, max = 16)
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public UserAccount password(String password) {
		this.password = password;
		return this;
	}

	/**
	 * Get password
	 * 
	 * @return password
	 **/
	@ApiModelProperty(example = "password1", required = true, value = "")
	@NotNull

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserAccount firstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	/**
	 * Get firstName
	 * 
	 * @return firstName
	 **/
	@ApiModelProperty(example = "John", required = true, value = "")
	@NotNull

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public UserAccount lastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	/**
	 * Get lastName
	 * 
	 * @return lastName
	 **/
	@ApiModelProperty(example = "John", required = true, value = "")
	@NotNull

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public UserAccount email(String email) {
		this.email = email;
		return this;
	}

	/**
	 * Get email
	 * 
	 * @return email
	 **/
	@ApiModelProperty(example = "jsmith@gmail.com", required = true, value = "")
	@NotNull

	@Pattern(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\\\.[a-z]{2,3}")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserAccount dateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
		return this;
	}

	/**
	 * Get dateOfBirth
	 * 
	 * @return dateOfBirth
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull

	@Valid
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public UserAccount token(Token token) {
		this.token = token;
		return this;
	}

	/**
	 * Get token
	 * 
	 * @return token
	 **/
	@ApiModelProperty(value = "")

	@Valid
	public Token getToken() {
		return token;
	}

	public void setToken(Token token) {
		this.token = token;
	}

	public UserAccount tasks(List<Task> tasks) {
		this.tasks = tasks;
		return this;
	}

	public UserAccount addTasksItem(Task tasksItem) {
		if (this.tasks == null) {
			this.tasks = new ArrayList<Task>();
		}
		this.tasks.add(tasksItem);
		return this;
	}

	public ObjectId getObjectId() {
		return this._id;
	}

	/**
	 * Get tasks
	 * 
	 * @return tasks
	 **/
	@ApiModelProperty(value = "")
	@Valid
	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		UserAccount user = (UserAccount) o;
		return Objects.equals(this.userId, user.userId) && Objects.equals(this.password, user.password)
				&& Objects.equals(this.firstName, user.firstName) && Objects.equals(this.lastName, user.lastName)
				&& Objects.equals(this.email, user.email) && Objects.equals(this.dateOfBirth, user.dateOfBirth)
				&& Objects.equals(this.token, user.token) && Objects.equals(this.tasks, user.tasks);
	}

	@Override
	public int hashCode() {
		return Objects.hash(userId, password, firstName, lastName, email, dateOfBirth, token, tasks);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class User {\n");

		sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
		sb.append("    password: ").append(toIndentedString(password)).append("\n");
		sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
		sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
		sb.append("    email: ").append(toIndentedString(email)).append("\n");
		sb.append("    dateOfBirth: ").append(toIndentedString(dateOfBirth)).append("\n");
		sb.append("    token: ").append(toIndentedString(token)).append("\n");
		sb.append("    tasks: ").append(toIndentedString(tasks)).append("\n");
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
