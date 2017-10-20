package jsons.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Iryna_Bartnytska on 10/14/2017.
 */
public class Cameras {

    @SerializedName("name")
    private String name;
    @SerializedName("full_name")
    private String fullName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
