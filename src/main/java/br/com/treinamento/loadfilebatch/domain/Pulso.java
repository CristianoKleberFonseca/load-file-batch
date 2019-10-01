package br.com.treinamento.loadfilebatch.domain;

import java.math.BigInteger;

public class Pulso {
	private int id;
	private String telematicsID;
	private BigInteger driverReferenceId;
	private String journeyUUID;
	private String localDtmIso;
	private double latitude;
	private double longitude;
	private double speed;
	private double dSpeed;
	private int heading;
	private int dHeading;
	private int altitude;
	private int dAltitude;
	private int hacCuracy;
	private int vacCuracy;
	private double v2Distance;
	private float v2AvgDuration;
	private int roadSegmentId;
	private int rslValidationId;
	private double rsl;
	private double rslDistanceFromRoad;
	private int distanceFromNonRoadWay;
	
	public Pulso() {
		super();
	}
	
	public Pulso(int id, String telematicsID, BigInteger driverReferenceId, String journeyUUID, String localDtmIso,
			double latitude, double longitude, double speed, double dSpeed, int heading, int dHeading, int altitude,
			int dAltitude, int hacCuracy, int vacCuracy, double v2Distance, float v2AvgDuration, int roadSegmentId,
			int rslValidationId, double rsl, double rslDistanceFromRoad, int distanceFromNonRoadWay) {
		super();
		this.id = id;
		this.telematicsID = telematicsID;
		this.driverReferenceId = driverReferenceId;
		this.journeyUUID = journeyUUID;
		this.localDtmIso = localDtmIso;
		this.latitude = latitude;
		this.longitude = longitude;
		this.speed = speed;
		this.dSpeed = dSpeed;
		this.heading = heading;
		this.dHeading = dHeading;
		this.altitude = altitude;
		this.dAltitude = dAltitude;
		this.hacCuracy = hacCuracy;
		this.vacCuracy = vacCuracy;
		this.v2Distance = v2Distance;
		this.v2AvgDuration = v2AvgDuration;
		this.roadSegmentId = roadSegmentId;
		this.rslValidationId = rslValidationId;
		this.rsl = rsl;
		this.rslDistanceFromRoad = rslDistanceFromRoad;
		this.distanceFromNonRoadWay = distanceFromNonRoadWay;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTelematicsID() {
		return telematicsID;
	}
	public void setTelematicsID(String telematicsID) {
		this.telematicsID = telematicsID;
	}
	public BigInteger getDriverReferenceId() {
		return driverReferenceId;
	}
	public void setDriverReferenceId(BigInteger driverReferenceId) {
		this.driverReferenceId = driverReferenceId;
	}
	public String getJourneyUUID() {
		return journeyUUID;
	}
	public void setJourneyUUID(String journeyUUID) {
		this.journeyUUID = journeyUUID;
	}
	public String getLocalDtmIso() {
		return localDtmIso;
	}
	public void setLocalDtmIso(String localDtmIso) {
		this.localDtmIso = localDtmIso;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public double getdSpeed() {
		return dSpeed;
	}
	public void setdSpeed(double dSpeed) {
		this.dSpeed = dSpeed;
	}
	public int getHeading() {
		return heading;
	}
	public void setHeading(int heading) {
		this.heading = heading;
	}
	public int getdHeading() {
		return dHeading;
	}
	public void setdHeading(int dHeading) {
		this.dHeading = dHeading;
	}
	public int getAltitude() {
		return altitude;
	}
	public void setAltitude(int altitude) {
		this.altitude = altitude;
	}
	public int getdAltitude() {
		return dAltitude;
	}
	public void setdAltitude(int dAltitude) {
		this.dAltitude = dAltitude;
	}
	public int getHacCuracy() {
		return hacCuracy;
	}
	public void setHacCuracy(int hacCuracy) {
		this.hacCuracy = hacCuracy;
	}
	public int getVacCuracy() {
		return vacCuracy;
	}
	public void setVacCuracy(int vacCuracy) {
		this.vacCuracy = vacCuracy;
	}
	public double getV2Distance() {
		return v2Distance;
	}
	public void setV2Distance(double v2Distance) {
		this.v2Distance = v2Distance;
	}
	public float getV2AvgDuration() {
		return v2AvgDuration;
	}
	public void setV2AvgDuration(float v2AvgDuration) {
		this.v2AvgDuration = v2AvgDuration;
	}
	public int getRoadSegmentId() {
		return roadSegmentId;
	}
	public void setRoadSegmentId(int roadSegmentId) {
		this.roadSegmentId = roadSegmentId;
	}
	public int getRslValidationId() {
		return rslValidationId;
	}
	public void setRslValidationId(int rslValidationId) {
		this.rslValidationId = rslValidationId;
	}
	public double getRsl() {
		return rsl;
	}
	public void setRsl(double rsl) {
		this.rsl = rsl;
	}
	public double getRslDistanceFromRoad() {
		return rslDistanceFromRoad;
	}
	public void setRslDistanceFromRoad(double rslDistanceFromRoad) {
		this.rslDistanceFromRoad = rslDistanceFromRoad;
	}
	public int getDistanceFromNonRoadWay() {
		return distanceFromNonRoadWay;
	}
	public void setDistanceFromNonRoadWay(int distanceFromNonRoadWay) {
		this.distanceFromNonRoadWay = distanceFromNonRoadWay;
	}
	
	@Override
	public String toString() {
		
		return super.toString();
	}
}
