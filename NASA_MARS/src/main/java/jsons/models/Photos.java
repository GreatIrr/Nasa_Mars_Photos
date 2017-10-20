package jsons.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Iryna_Bartnytska on 10/14/2017.
 */
public class Photos {

    @SerializedName("sol")
    private Integer sol;
    @SerializedName("id")
    private Integer id;
    @SerializedName("img_src")
    private String imgSrc;
    @SerializedName("earth_date")
    private String earthDate;
    @SerializedName("camera")
    private Camera camera;
    @SerializedName("rover")
    private Rover rover;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSol() {
        return sol;
    }

    public void setSol(Integer sol) {
        this.sol = sol;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getEarthDate() {
        return earthDate;
    }

    public void setEarthDate(String earthDate) {
        this.earthDate = earthDate;
    }

    public jsons.models.Camera getCamera() {
        return camera;
    }

    public void setCamera(jsons.models.Camera camera) {
        this.camera = camera;
    }

    public Rover getRover() {
        return rover;
    }

    public void setRover(Rover rover) {
        this.rover = rover;
    }
}
