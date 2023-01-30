package com.soprasteria.model;

public class LoginResponse {

  private boolean isAdmin;
  private boolean isUser;
  private String validation;

  public LoginResponse() {
    super();
  }

  public boolean isAdmin() {
    return isAdmin;
  }

  public void setAdmin(boolean isAdmin) {
    this.isAdmin = isAdmin;
  }

  public boolean isUser() {
    return isUser;
  }

  public void setUser(boolean isUser) {
    this.isUser = isUser;
  }

  public String getValidation() {
    return validation;
  }

  public void setValidation(String validation) {
    this.validation = validation;
  }

  @Override
  public String toString() {
    return "LoginResponse [isAdmin=" + isAdmin + ", isUser=" + isUser + ", validation=" + validation
        + "]";
  }
  

}
