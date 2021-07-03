package challenge.services;

import challenge.model.Coordinate;

/**
 * 
 * @author Nicolas Rodriguez
 * @since 1.0.0
 *
 */
public interface CoordinateService {
	
	/**
	 * Returns the coordinates of an Argentine province.
	 * 
	 * @param the province name.
	 * @return {@link challenge.model.Coordinate}
	 */
	Coordinate getCoordinateByProvince(String province);

}
