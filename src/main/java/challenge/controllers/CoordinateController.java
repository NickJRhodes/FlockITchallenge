package challenge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import challenge.model.Coordinate;
import challenge.services.CoordinateService;

/**
 * 
 * @author Nicolas Rodriguez
 * @since 1.0.0
 *
 */
@RestController
@RequestMapping("/coordinates")
class CoordinateController {
	
	@Autowired
	private CoordinateService coordinateService;
	
	@GetMapping("/{province}")
	public ResponseEntity<Coordinate> getCoordinates(@PathVariable("province") String province) {
		return ResponseEntity.ok(coordinateService.getCoordinateByProvince(province));
	}

}
