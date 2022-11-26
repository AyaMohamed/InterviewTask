package Data;

public class UserDetails {

    String id,name,email,username,phoneNumber,role,isLockedOut, activeSessionId,rejectReason,rejectURL,isPay2;
    int statusId;
    Branches branches [];


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getRole() {
        return role;
    }

    public String getIsLockedOut() {
        return isLockedOut;
    }

    public String getActiveSessionId() {
        return activeSessionId;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public String getRejectURL() {
        return rejectURL;
    }

    public String getIsPay2() {
        return isPay2;
    }

    public int getStatusId() {
        return statusId;
    }

    public Branches[] getBranches() {
        return branches;
    }
}
