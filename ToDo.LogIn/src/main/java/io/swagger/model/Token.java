package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.threeten.bp.LocalDate;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Token
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-07-31T18:12:46.646471100-04:00[America/New_York]")
public class Token   {
  @JsonProperty("token")
  private String token = null;

  @JsonProperty("refreshToken")
  private String refreshToken = null;

  @JsonProperty("issueDate")
  private LocalDate issueDate = null;

  @JsonProperty("expirationDate")
  private LocalDate expirationDate = null;

  public Token token(String token) {
    this.token = token;
    return this;
  }

  /**
   * Get token
   * @return token
  **/
  @ApiModelProperty(example = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE0ODc5NzU0NTgsImlhdCI", value = "")

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public Token refreshToken(String refreshToken) {
    this.refreshToken = refreshToken;
    return this;
  }

  /**
   * Get refreshToken
   * @return refreshToken
  **/
  @ApiModelProperty(example = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE0ODc5NzU0NTgsImlhdCI", value = "")

  public String getRefreshToken() {
    return refreshToken;
  }

  public void setRefreshToken(String refreshToken) {
    this.refreshToken = refreshToken;
  }

  public Token issueDate(LocalDate issueDate) {
    this.issueDate = issueDate;
    return this;
  }

  /**
   * Get issueDate
   * @return issueDate
  **/
  @ApiModelProperty(value = "")

  @Valid
  public LocalDate getIssueDate() {
    return issueDate;
  }

  public void setIssueDate(LocalDate issueDate) {
    this.issueDate = issueDate;
  }

  public Token expirationDate(LocalDate expirationDate) {
    this.expirationDate = expirationDate;
    return this;
  }

  /**
   * Get expirationDate
   * @return expirationDate
  **/
  @ApiModelProperty(value = "")

  @Valid
  public LocalDate getExpirationDate() {
    return expirationDate;
  }

  public void setExpirationDate(LocalDate expirationDate) {
    this.expirationDate = expirationDate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Token token = (Token) o;
    return Objects.equals(this.token, token.token) &&
        Objects.equals(this.refreshToken, token.refreshToken) &&
        Objects.equals(this.issueDate, token.issueDate) &&
        Objects.equals(this.expirationDate, token.expirationDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(token, refreshToken, issueDate, expirationDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Token {\n");
    
    sb.append("    token: ").append(toIndentedString(token)).append("\n");
    sb.append("    refreshToken: ").append(toIndentedString(refreshToken)).append("\n");
    sb.append("    issueDate: ").append(toIndentedString(issueDate)).append("\n");
    sb.append("    expirationDate: ").append(toIndentedString(expirationDate)).append("\n");
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
