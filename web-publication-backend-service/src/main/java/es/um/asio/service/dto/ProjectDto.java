package es.um.asio.service.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class ProjectDto.
 */
@Getter
@Setter
public class ProjectDto {

	/**
	 * The abbreviation
	 */
	private String abbreviation;
	
	/**
	 * The description
	 */
	private String description;
	
	/**
	 * The endDate
	 */
	private String endDate;
	
	/**
	 * The foreseenJustificationDate
	 */
	private String foreseenJustificationDate;
	
	/** 
	 * The id
	 */
	private String id;
	
	/**
	 * The keyword
	 */
	private String keyword;

	/**
	 * The modality
	 */
	private String modality;
	
	/**
	 * The needsEthicalValidation
	 */
	private String needsEthicalValidation;
	
	/** 
	 * The startDate 
	 */
	private String startDate;
	
	/** 
	 * The status 
	 */
	private String status;
	
	/** 
	 * The title 
	 */
	private String title;
}
