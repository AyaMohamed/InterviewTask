package Data;

import Utilities.HelperClass;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginRequestClass {

    private String userName;
    private String password;
    private HelperClass helperClass;


    public LoginRequestClass() {
        helperClass = new HelperClass();
        this.userName = helperClass.getRequestParametersUsingProperties("username");
        this.password=helperClass.getRequestParametersUsingProperties("password");

    }

    @JsonProperty("username")
    public String getUserName() {
        return userName;
    }

    @JsonProperty("username")
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    @JsonProperty("password")
    public void setPassword(String password) {
        this.password = password;
    }
}
