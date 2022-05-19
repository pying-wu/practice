package verify;

public class VerifyResult {

    protected boolean isVerifySuccess;
    protected String id;
    protected String message;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setVerifySuccess(boolean isVerifySuccess) {
        this.isVerifySuccess = isVerifySuccess;
    }

    public boolean isVerifySuccess() {
        return isVerifySuccess;
    }
}
