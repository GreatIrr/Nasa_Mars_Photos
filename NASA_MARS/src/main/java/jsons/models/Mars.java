package jsons.models;

import java.util.List;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Iryna_Bartnytska on 10/13/2017.
 */
public class Mars {

    @SerializedName("photos")
    private List<Photos> photos;

    public List<Photos> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photos> photos) {
        this.photos = photos;
    }
}
