package com.oasis.poc1.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
public class WellAttributes {

	private Integer OBJECTID;
	private Integer OGF_ID;
	
	//Well Attributes
	private Integer WELL_ID;
	
	private String LICENCE_NUMBER;
	
	private String WELL_NAME;
	
	private String OPERATOR;
	
	private String WELL_TYPE;
	
	private String WELL_MODE;
	
	private Double SURFACE_LATITUDE_83;
	
	private Double SURFACE_LONGITUDE_83;
	
	private Double BOTTOM_LATITUDE_83;
	
	private Double BOTTOM_LONGITUDE_83;
	
	private String LOCATION_SOURCE;
	
	private Double GROUND_ELEVATION;
	
	private Double TOTAL_DEPTH;
	
	private Double TRUE_VERTICAL_DEPTH;
	
	private String COUNTY;
	
	private String TOWNSHIP;
	
	private String LOT;
	
	private String CONCESSION;
	
	private String NORTH_SOUTH_BOUNDARY;
	
	private String NORTH_SOUTH_FLG;
	
	private String EAST_WEST_BOUNDARY;
	
	private String EAST_WEST_FLG;
	
	private String OFFSHORE_BLOCK;
	
	private String OFFSHORE_TRACT;
	
	private String VERTICAL_FLG;
	
	private String HORIZONTAL_FLG;
	
	private String DIRECTIONAL_FLG;
	
	private String DEEPENING_FLG;
	
	private String REENTRY_FLG;
	
	private String LATERAL_FLG;	

	private Long SPUD_DATE;
	
	private Long TOTAL_DEPTH_REACHED_DATE;

	private Long PLUGGING_END_DATE;
	
	
	private String MAP_SYMBOL_CODE;
	private String LOCATION_ACCURACY;
	private Long GEOMETRY_UPDATE_DATETIME;
	private Long EFFECTIVE_DATETIME;
	private Long SYSTEM_DATETIME;
	private String SE_ANNO_CAD_DATA;
	public Integer getOBJECTID() {
		return OBJECTID;
	}
	public void setOBJECTID(Integer oBJECTID) {
		OBJECTID = oBJECTID;
	}
	public Integer getOGF_ID() {
		return OGF_ID;
	}
	public void setOGF_ID(Integer oGF_ID) {
		OGF_ID = oGF_ID;
	}
	public Integer getWELL_ID() {
		return WELL_ID;
	}
	public void setWELL_ID(Integer wELL_ID) {
		WELL_ID = wELL_ID;
	}
	public String getLICENCE_NUMBER() {
		return LICENCE_NUMBER;
	}
	public void setLICENCE_NUMBER(String lICENCE_NUMBER) {
		LICENCE_NUMBER = lICENCE_NUMBER;
	}
	public String getWELL_NAME() {
		return WELL_NAME;
	}
	public void setWELL_NAME(String wELL_NAME) {
		WELL_NAME = wELL_NAME;
	}
	public String getOPERATOR() {
		return OPERATOR;
	}
	public void setOPERATOR(String oPERATOR) {
		OPERATOR = oPERATOR;
	}
	public String getWELL_TYPE() {
		return WELL_TYPE;
	}
	public void setWELL_TYPE(String wELL_TYPE) {
		WELL_TYPE = wELL_TYPE;
	}
	public String getWELL_MODE() {
		return WELL_MODE;
	}
	public void setWELL_MODE(String wELL_MODE) {
		WELL_MODE = wELL_MODE;
	}
	public Double getSURFACE_LATITUDE_83() {
		return SURFACE_LATITUDE_83;
	}
	public void setSURFACE_LATITUDE_83(Double sURFACE_LATITUDE_83) {
		SURFACE_LATITUDE_83 = sURFACE_LATITUDE_83;
	}
	public Double getSURFACE_LONGITUDE_83() {
		return SURFACE_LONGITUDE_83;
	}
	public void setSURFACE_LONGITUDE_83(Double sURFACE_LONGITUDE_83) {
		SURFACE_LONGITUDE_83 = sURFACE_LONGITUDE_83;
	}
	public Double getBOTTOM_LATITUDE_83() {
		return BOTTOM_LATITUDE_83;
	}
	public void setBOTTOM_LATITUDE_83(Double bOTTOM_LATITUDE_83) {
		BOTTOM_LATITUDE_83 = bOTTOM_LATITUDE_83;
	}
	public Double getBOTTOM_LONGITUDE_83() {
		return BOTTOM_LONGITUDE_83;
	}
	public void setBOTTOM_LONGITUDE_83(Double bOTTOM_LONGITUDE_83) {
		BOTTOM_LONGITUDE_83 = bOTTOM_LONGITUDE_83;
	}
	public String getLOCATION_SOURCE() {
		return LOCATION_SOURCE;
	}
	public void setLOCATION_SOURCE(String lOCATION_SOURCE) {
		LOCATION_SOURCE = lOCATION_SOURCE;
	}
	public Double getGROUND_ELEVATION() {
		return GROUND_ELEVATION;
	}
	public void setGROUND_ELEVATION(Double gROUND_ELEVATION) {
		GROUND_ELEVATION = gROUND_ELEVATION;
	}
	public Double getTOTAL_DEPTH() {
		return TOTAL_DEPTH;
	}
	public void setTOTAL_DEPTH(Double tOTAL_DEPTH) {
		TOTAL_DEPTH = tOTAL_DEPTH;
	}
	public Double getTRUE_VERTICAL_DEPTH() {
		return TRUE_VERTICAL_DEPTH;
	}
	public void setTRUE_VERTICAL_DEPTH(Double tRUE_VERTICAL_DEPTH) {
		TRUE_VERTICAL_DEPTH = tRUE_VERTICAL_DEPTH;
	}
	public String getCOUNTY() {
		return COUNTY;
	}
	public void setCOUNTY(String cOUNTY) {
		COUNTY = cOUNTY;
	}
	public String getTOWNSHIP() {
		return TOWNSHIP;
	}
	public void setTOWNSHIP(String tOWNSHIP) {
		TOWNSHIP = tOWNSHIP;
	}
	public String getLOT() {
		return LOT;
	}
	public void setLOT(String lOT) {
		LOT = lOT;
	}
	public String getCONCESSION() {
		return CONCESSION;
	}
	public void setCONCESSION(String cONCESSION) {
		CONCESSION = cONCESSION;
	}
	public String getNORTH_SOUTH_BOUNDARY() {
		return NORTH_SOUTH_BOUNDARY;
	}
	public void setNORTH_SOUTH_BOUNDARY(String nORTH_SOUTH_BOUNDARY) {
		NORTH_SOUTH_BOUNDARY = nORTH_SOUTH_BOUNDARY;
	}
	public String getNORTH_SOUTH_FLG() {
		return NORTH_SOUTH_FLG;
	}
	public void setNORTH_SOUTH_FLG(String nORTH_SOUTH_FLG) {
		NORTH_SOUTH_FLG = nORTH_SOUTH_FLG;
	}
	public String getEAST_WEST_BOUNDARY() {
		return EAST_WEST_BOUNDARY;
	}
	public void setEAST_WEST_BOUNDARY(String eAST_WEST_BOUNDARY) {
		EAST_WEST_BOUNDARY = eAST_WEST_BOUNDARY;
	}
	public String getEAST_WEST_FLG() {
		return EAST_WEST_FLG;
	}
	public void setEAST_WEST_FLG(String eAST_WEST_FLG) {
		EAST_WEST_FLG = eAST_WEST_FLG;
	}
	public String getOFFSHORE_BLOCK() {
		return OFFSHORE_BLOCK;
	}
	public void setOFFSHORE_BLOCK(String oFFSHORE_BLOCK) {
		OFFSHORE_BLOCK = oFFSHORE_BLOCK;
	}
	public String getOFFSHORE_TRACT() {
		return OFFSHORE_TRACT;
	}
	public void setOFFSHORE_TRACT(String oFFSHORE_TRACT) {
		OFFSHORE_TRACT = oFFSHORE_TRACT;
	}
	public String getVERTICAL_FLG() {
		return VERTICAL_FLG;
	}
	public void setVERTICAL_FLG(String vERTICAL_FLG) {
		VERTICAL_FLG = vERTICAL_FLG;
	}
	public String getHORIZONTAL_FLG() {
		return HORIZONTAL_FLG;
	}
	public void setHORIZONTAL_FLG(String hORIZONTAL_FLG) {
		HORIZONTAL_FLG = hORIZONTAL_FLG;
	}
	public String getDIRECTIONAL_FLG() {
		return DIRECTIONAL_FLG;
	}
	public void setDIRECTIONAL_FLG(String dIRECTIONAL_FLG) {
		DIRECTIONAL_FLG = dIRECTIONAL_FLG;
	}
	public String getDEEPENING_FLG() {
		return DEEPENING_FLG;
	}
	public void setDEEPENING_FLG(String dEEPENING_FLG) {
		DEEPENING_FLG = dEEPENING_FLG;
	}
	public String getREENTRY_FLG() {
		return REENTRY_FLG;
	}
	public void setREENTRY_FLG(String rEENTRY_FLG) {
		REENTRY_FLG = rEENTRY_FLG;
	}
	public String getLATERAL_FLG() {
		return LATERAL_FLG;
	}
	public void setLATERAL_FLG(String lATERAL_FLG) {
		LATERAL_FLG = lATERAL_FLG;
	}
	public Long getSPUD_DATE() {
		return SPUD_DATE;
	}
	public void setSPUD_DATE(Long sPUD_DATE) {
		SPUD_DATE = sPUD_DATE;
	}
	public Long getTOTAL_DEPTH_REACHED_DATE() {
		return TOTAL_DEPTH_REACHED_DATE;
	}
	public void setTOTAL_DEPTH_REACHED_DATE(Long tOTAL_DEPTH_REACHED_DATE) {
		TOTAL_DEPTH_REACHED_DATE = tOTAL_DEPTH_REACHED_DATE;
	}
	public Long getPLUGGING_END_DATE() {
		return PLUGGING_END_DATE;
	}
	public void setPLUGGING_END_DATE(Long pLUGGING_END_DATE) {
		PLUGGING_END_DATE = pLUGGING_END_DATE;
	}
	public String getMAP_SYMBOL_CODE() {
		return MAP_SYMBOL_CODE;
	}
	public void setMAP_SYMBOL_CODE(String mAP_SYMBOL_CODE) {
		MAP_SYMBOL_CODE = mAP_SYMBOL_CODE;
	}
	public String getLOCATION_ACCURACY() {
		return LOCATION_ACCURACY;
	}
	public void setLOCATION_ACCURACY(String lOCATION_ACCURACY) {
		LOCATION_ACCURACY = lOCATION_ACCURACY;
	}
	public Long getGEOMETRY_UPDATE_DATETIME() {
		return GEOMETRY_UPDATE_DATETIME;
	}
	public void setGEOMETRY_UPDATE_DATETIME(Long gEOMETRY_UPDATE_DATETIME) {
		GEOMETRY_UPDATE_DATETIME = gEOMETRY_UPDATE_DATETIME;
	}
	public Long getEFFECTIVE_DATETIME() {
		return EFFECTIVE_DATETIME;
	}
	public void setEFFECTIVE_DATETIME(Long eFFECTIVE_DATETIME) {
		EFFECTIVE_DATETIME = eFFECTIVE_DATETIME;
	}
	public Long getSYSTEM_DATETIME() {
		return SYSTEM_DATETIME;
	}
	public void setSYSTEM_DATETIME(Long sYSTEM_DATETIME) {
		SYSTEM_DATETIME = sYSTEM_DATETIME;
	}
	public String getSE_ANNO_CAD_DATA() {
		return SE_ANNO_CAD_DATA;
	}
	public void setSE_ANNO_CAD_DATA(String sE_ANNO_CAD_DATA) {
		SE_ANNO_CAD_DATA = sE_ANNO_CAD_DATA;
	}
	
	@Override
	public String toString() {
		return "WellAttributes [OBJECTID=" + OBJECTID + ", OGF_ID=" + OGF_ID + ", WELL_ID=" + WELL_ID
				+ ", LICENCE_NUMBER=" + LICENCE_NUMBER + ", WELL_NAME=" + WELL_NAME + ", OPERATOR=" + OPERATOR
				+ ", WELL_TYPE=" + WELL_TYPE + ", WELL_MODE=" + WELL_MODE + ", SURFACE_LATITUDE_83="
				+ SURFACE_LATITUDE_83 + ", SURFACE_LONGITUDE_83=" + SURFACE_LONGITUDE_83 + ", BOTTOM_LATITUDE_83="
				+ BOTTOM_LATITUDE_83 + ", BOTTOM_LONGITUDE_83=" + BOTTOM_LONGITUDE_83 + ", LOCATION_SOURCE="
				+ LOCATION_SOURCE + ", GROUND_ELEVATION=" + GROUND_ELEVATION + ", TOTAL_DEPTH=" + TOTAL_DEPTH
				+ ", TRUE_VERTICAL_DEPTH=" + TRUE_VERTICAL_DEPTH + ", COUNTY=" + COUNTY + ", TOWNSHIP=" + TOWNSHIP
				+ ", LOT=" + LOT + ", CONCESSION=" + CONCESSION + ", NORTH_SOUTH_BOUNDARY=" + NORTH_SOUTH_BOUNDARY
				+ ", NORTH_SOUTH_FLG=" + NORTH_SOUTH_FLG + ", EAST_WEST_BOUNDARY=" + EAST_WEST_BOUNDARY
				+ ", EAST_WEST_FLG=" + EAST_WEST_FLG + ", OFFSHORE_BLOCK=" + OFFSHORE_BLOCK + ", OFFSHORE_TRACT="
				+ OFFSHORE_TRACT + ", VERTICAL_FLG=" + VERTICAL_FLG + ", HORIZONTAL_FLG=" + HORIZONTAL_FLG
				+ ", DIRECTIONAL_FLG=" + DIRECTIONAL_FLG + ", DEEPENING_FLG=" + DEEPENING_FLG + ", REENTRY_FLG="
				+ REENTRY_FLG + ", LATERAL_FLG=" + LATERAL_FLG + ", SPUD_DATE=" + SPUD_DATE
				+ ", TOTAL_DEPTH_REACHED_DATE=" + TOTAL_DEPTH_REACHED_DATE + ", PLUGGING_END_DATE=" + PLUGGING_END_DATE
				+ ", MAP_SYMBOL_CODE=" + MAP_SYMBOL_CODE + ", LOCATION_ACCURACY=" + LOCATION_ACCURACY
				+ ", GEOMETRY_UPDATE_DATETIME=" + GEOMETRY_UPDATE_DATETIME + ", EFFECTIVE_DATETIME="
				+ EFFECTIVE_DATETIME + ", SYSTEM_DATETIME=" + SYSTEM_DATETIME + ", SE_ANNO_CAD_DATA=" + SE_ANNO_CAD_DATA
				+ "]";
	}
	
	
	
	
}
