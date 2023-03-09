package ZealousService.BikeService;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
public class ServiceDetails 
{
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int bikeJobcardno;
	private String[] bikeIssuse;
	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date bikeDateofservice;
	private int bikeKilometer;
	private String bikeStatus;
	private String bikeTypeofservice;
	private int bikeEstimatecharge;
	private int bikeNewproductcost;
	private int bikeLabourcharge;
	private int bikeFinalamount;
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JsonIgnoreProperties(value = {"service_details","hibernateLazyInitializer"})
	@JoinColumn(name = "bikeCustomerid")
	private BikeDetails bikeDetails1;
	public ServiceDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ServiceDetails(int bikeJobcardno, String[] bikeIssuse, Date bikeDateofservice, int bikeKilometer,
			String bikeStatus, String bikeTypeofservice, int bikeEstimatecharge, int bikeNewproductcost,
			int bikeLabourcharge, int bikeFinalamount, BikeDetails bikeDetails1) {
		super();
		this.bikeJobcardno = bikeJobcardno;
		this.bikeIssuse = bikeIssuse;
		this.bikeDateofservice = bikeDateofservice;
		this.bikeKilometer = bikeKilometer;
		this.bikeStatus = bikeStatus;
		this.bikeTypeofservice = bikeTypeofservice;
		this.bikeEstimatecharge = bikeEstimatecharge;
		this.bikeNewproductcost = bikeNewproductcost;
		this.bikeLabourcharge = bikeLabourcharge;
		this.bikeFinalamount = bikeFinalamount;
		this.bikeDetails1 = bikeDetails1;
	}
	@Override
	public String toString() {
		return "ServiceDetails [bikeJobcardno=" + bikeJobcardno + ", bikeIssuse=" + Arrays.toString(bikeIssuse)
				+ ", bikeDateofservice=" + bikeDateofservice + ", bikeKilometer=" + bikeKilometer + ", bikeStatus="
				+ bikeStatus + ", bikeTypeofservice=" + bikeTypeofservice + ", bikeEstimatecharge=" + bikeEstimatecharge
				+ ", bikeNewproductcost=" + bikeNewproductcost + ", bikeLabourcharge=" + bikeLabourcharge
				+ ", bikeFinalamount=" + bikeFinalamount + ", bikeDetails1=" + bikeDetails1 + "]";
	}
	public int getBikeJobcardno() {
		return bikeJobcardno;
	}
	public void setBikeJobcardno(int bikeJobcardno) {
		this.bikeJobcardno = bikeJobcardno;
	}
	public String[] getBikeIssuse() {
		return bikeIssuse;
	}
	public void setBikeIssuse(String[] bikeIssuse) {
		this.bikeIssuse = bikeIssuse;
	}
	public Date getBikeDateofservice() {
		return bikeDateofservice;
	}
	public void setBikeDateofservice(Date bikeDateofservice) {
		this.bikeDateofservice = bikeDateofservice;
	}
	public int getBikeKilometer() {
		return bikeKilometer;
	}
	public void setBikeKilometer(int bikeKilometer) {
		this.bikeKilometer = bikeKilometer;
	}
	public String getBikeStatus() {
		return bikeStatus;
	}
	public void setBikeStatus(String bikeStatus) {
		this.bikeStatus = bikeStatus;
	}
	public String getBikeTypeofservice() {
		return bikeTypeofservice;
	}
	public void setBikeTypeofservice(String bikeTypeofservice) {
		this.bikeTypeofservice = bikeTypeofservice;
	}
	public int getBikeEstimatecharge() {
		return bikeEstimatecharge;
	}
	public void setBikeEstimatecharge(int bikeEstimatecharge) {
		this.bikeEstimatecharge = bikeEstimatecharge;
	}
	public int getBikeNewproductcost() {
		return bikeNewproductcost;
	}
	public void setBikeNewproductcost(int bikeNewproductcost) {
		this.bikeNewproductcost = bikeNewproductcost;
	}
	public int getBikeLabourcharge() {
		return bikeLabourcharge;
	}
	public void setBikeLabourcharge(int bikeLabourcharge) {
		this.bikeLabourcharge = bikeLabourcharge;
	}
	public int getBikeFinalamount() {
		return bikeFinalamount;
	}
	public void setBikeFinalamount(int bikeFinalamount) {
		this.bikeFinalamount = bikeFinalamount;
	}
	public BikeDetails getBikeDetails1() {
		return bikeDetails1;
	}
	public void setBikeDetails1(BikeDetails bikeDetails1) {
		this.bikeDetails1 = bikeDetails1;
	}
	
}
