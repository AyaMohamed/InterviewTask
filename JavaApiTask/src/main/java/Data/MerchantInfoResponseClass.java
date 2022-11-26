package Data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MerchantInfoResponseClass {
    int merchantId, cityId, bankId, status, merchantType, totalTerminals, activeTerminals;
    String name, nameArabic, cityName, bankName, address, addressArabic, contactPerson, contactNumber, email, commercialRegistrationNumber;
    double vatPercent, madaFee, creditCardFee;
    String merchantBankName, merchantBankAccountNumber, merchantIBAN, merchantAccountName, terminals;
    String salesAgentName, salesAgentPhone, salesAgentEmail;
    boolean isVerified;
    int userId;
    int statusCode;
    String [] errors;
    String [] errorCodes;


    @JsonProperty("merchantId")
    public int getMerchantId() {
        return merchantId;
    }

    @JsonProperty("cityId")
    public int getCityId() {
        return cityId;
    }

    @JsonProperty("bankId")
    public int getBankId() {
        return bankId;
    }

    @JsonProperty("status")
    public int getStatus() {
        return status;
    }

    @JsonProperty("merchantType")
    public int getMerchantType() {
        return merchantType;
    }

    @JsonProperty("totalTerminals")
    public int getTotalTerminals() {
        return totalTerminals;
    }

    @JsonProperty("activeTerminals")
    public int getActiveTerminals() {
        return activeTerminals;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("nameArabic")
    public String getNameArabic() {
        return nameArabic;
    }

    @JsonProperty("cityName")
    public String getCityName() {
        return cityName;
    }

    @JsonProperty("bankName")
    public String getBankName() {
        return bankName;
    }

    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    @JsonProperty("addressArabic")
    public String getAddressArabic() {
        return addressArabic;
    }

    @JsonProperty("contactPerson")
    public String getContactPerson() {
        return contactPerson;
    }

    @JsonProperty("contactNumber")
    public String getContactNumber() {
        return contactNumber;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("commercialRegistrationNumber")
    public String getCommercialRegistrationNumber() {
        return commercialRegistrationNumber;
    }

    @JsonProperty("varPercent")
    public double getVarPercent() {
        return vatPercent;
    }

    @JsonProperty("madaFee")
    public double getMadaFee() {
        return madaFee;
    }

    @JsonProperty("creditCardFee")
    public double getCreditCardFee() {
        return creditCardFee;
    }

    @JsonProperty("merchantBankName")
    public String getMerchantBankName() {
        return merchantBankName;
    }

    @JsonProperty("merchantBankAccountNumber")
    public String getMerchantBankAccountNumber() {
        return merchantBankAccountNumber;
    }

    @JsonProperty("merchantIBAN")
    public String getMerchantIBAN() {
        return merchantIBAN;
    }

    @JsonProperty("merchantAccountName")
    public String getMerchantAccountName() {
        return merchantAccountName;
    }

    @JsonProperty("terminals")
    public String getTerminals() {
        return terminals;
    }

    @JsonProperty("salesAgentName")
    public String getSalesAgentName() {
        return salesAgentName;
    }

    @JsonProperty("salesAgentPhone")
    public String getSalesAgentPhone() {
        return salesAgentPhone;
    }

    @JsonProperty("salesAgentEmail")
    public String getSalesAgentEmail() {
        return salesAgentEmail;
    }

    @JsonProperty("isVerified")
    public boolean isVerified() {
        return isVerified;
    }


    //=======================error response parameters
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
