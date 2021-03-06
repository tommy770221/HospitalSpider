package model;

import java.util.List;

public class TestGeoDataResponse{
	private List<Double> coordinates;
	private String type;

	public void setCoordinates(List<Double> coordinates){
		this.coordinates = coordinates;
	}

	public List<Double> getCoordinates(){
		return coordinates;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	@Override
 	public String toString(){
		return 
			"TestGeoDataResponse{" + 
			"coordinates = '" + coordinates + '\'' + 
			",type = '" + type + '\'' + 
			"}";
		}
}