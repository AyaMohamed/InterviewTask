package Data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Branches {

    private int id;
    private String name, city, address;

    @JsonProperty("id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
