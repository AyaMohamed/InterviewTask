package Data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginResponseClass {

    private UserDetails userDetails;
    String token;
    String expiration;
    private Branches[] branches;
    int userId;
    int statusCode;
    String [] errors;
    String [] errorCodes;

    @JsonProperty("userDetails")
    public UserDetails getUserDetails() {
        return userDetails;
    }
    @JsonProperty("token")
    public String getToken() {
        return token;
    }
    @JsonProperty("userDetails")
    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    @JsonProperty("token")
    public void setToken(String token) {
        this.token = token;
    }
    @JsonProperty("expiration")
    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }
    @JsonProperty("branches")
    public void setBranches(Branches[] branches) {
        this.branches = branches;
    }

    @JsonProperty("expiration")
    public String getExpiration() {
        return expiration;
    }

    @JsonProperty("branches")
    public Branches[] getBranches() {
        return branches;
    }


    //==================================== response error parameters
    @JsonProperty("userId")
    public int getUserId() {
        return userId;
    }

    @JsonProperty("statusCode")
    public int getStatusCode() {
        return statusCode;
    }

    @JsonProperty("errors")
    public String[] getErrors() {
        return errors;
    }

    @JsonProperty("errorCodes")
    public String[] getErrorCodes() {
        return errorCodes;
    }
}
