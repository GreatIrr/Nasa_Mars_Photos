package jsons.models;

import java.util.List;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Iryna_Bartnytska on 10/14/2017.
 */
public class Rover {

    @SerializedName("id")
    private Integer id;
    @SerializedName("name")
    private String name;
    @SerializedName("landing_date")
    private String landingDate;
    @SerializedName("launch_date")
    private String launchDate;
    @SerializedName("status")
    private String status;
    @SerializedName("max_sol")
    private Integer maxSol;
    @SerializedName("max_date")
    private String maxDate;
    @SerializedName("total_photos")
    private Integer totalPhotos;
    @SerializedName("camerases")
    private List<Cameras> cameras;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLandingDate() {
        return landingDate;
    }

    public void setLandingDate(String landingDate) {
        this.landingDate = landingDate;
    }

    public String getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(String launchDate) {
        this.launchDate = launchDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getMaxSol() {
        return maxSol;
    }

    public void setMaxSol(Integer maxSol) {
        this.maxSol = maxSol;
    }

    public String getMaxDate() {
        return maxDate;
    }

    public void setMaxDate(String maxDate) {
        this.maxDate = maxDate;
    }

    public Integer getTotalPhotos() {
        return totalPhotos;
    }

    public void setTotalPhotos(Integer totalPhotos) {
        this.totalPhotos = totalPhotos;
    }

    public List<Cameras> getCameras() {
        return cameras;
    }

    public void setCameras(List<Cameras> cameras) {
        this.cameras = cameras;
    }
}
