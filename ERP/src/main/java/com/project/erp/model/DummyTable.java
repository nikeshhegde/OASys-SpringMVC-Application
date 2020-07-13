package com.project.erp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Table(name="dummytable")
@Entity
public class DummyTable {
	
	@Id
	@Column(name = "MERITNO")
	@GeneratedValue
	private Integer meritNo;
	
	@Column(name = "ACKNO")
	private String dummyTableAckNo;
	
	@Column(name = "NAMEOFTHECANDIDATE")
	private String dummyTableNameOfTheCandidate;
	
	@Column(name = "GENDER")
	private String dummyTableGender;
	
	
	@Column(name = "DATEOFBIRTH")
	private String dummyTableDateOfBirth;
	
	@Column(name = "EMAILID")
	private String dummyTableEmailId;
	
	@Column(name = "MOBNO")
	private String dummyTableMobileNumber;
	
	
	@Column(name = "MOTHERTONGUE")
	private String dummyTableMotherTongue;
	
	@Column(name = "RELIGION")
	private String dummyTableReligion;
	
	@Column(name = "HSCBOARD")
	private String dummyTableHscBoard;
	
	@Column(name = "HSCTOTAL")
	private Integer dummyTableHscTotal;
	
	@Column(name = "HSCMATHS")
	private Integer dummyTableHscMaths;
	
	
	@Column(name = "HSCPHY")
	private Integer dummyTableHscPhysics;
	
	@Column(name = "HSCCHEM")
	private Integer dummyTableHscChem;
	
	@Column(name = "HSCBIO")
	private Integer dummyTableHscBio;
	
	@Column(name = "HSCVOC")
	private Integer dummyTableHscVoc;
	
	
	@Column(name = "PCMTOTAL")
	private Integer dummyTableHscPcmTotal;
	
	@Column(name = "PCMPERCENTAGE")
	private Double dummyTablePcmPercentage;
	
	@Column(name = "PMVTOTAL")
	private Integer dummyTableHscPmvTotal;
	
	@Column(name = "PMVPERCENTAGE")
	private Double dummyTablePmvPercentage;
	
	@Column(name = "SSCMATHS")
	private Integer dummyTableSscMaths;
	
	@Column(name = "SSCTOTAL")
	private Integer dummyTableSscTotal;
	
	@Column(name = "JEEMATHS")
	private Integer dummyTableJeeMaths;
	
	@Column(name = "JEEPHY")
	private Integer dummyTableJeePhysics;
	
	@Column(name = "JEECHEM")
	private Integer dummyTableJeeChem;
	
	@Column(name = "JEESCORE")
	private Integer dummyTableJeeScore;
	
	@Column(name = "JEEPERCENTILE")
	private Double dummyTableJeePercentile;
	
	
	@Column(name = "BOARDPERCENTILE")
	private Double dummyTableBoardPercentile;
	
	@Column(name = "Compositescore")
	private Double dummyTableCompositeScore;
	
	
	@Column(name = "CE")
	private String dummyTableCEPriority;
	
	@Column(name = "EXTC")
	private String dummyTableEXTCPriority;
	
	@Column(name = "IT")
	private String dummyTableITPriority;
	
	@Column(name = "PPT")
	private String dummyTablePPTPriority;
	
	@Column(name = "BT")
	private String dummyTableBTPriority;
	
	@Column(name = "MECH")
	private String dummyTableMECHPriority;
	
	public Integer getMeritNo() {
		return meritNo;
	}

	public void setMeritNo(Integer meritNo) {
		this.meritNo = meritNo;
	}

	public String getDummyTableAckNo() {
		return dummyTableAckNo;
	}

	public void setDummyTableAckNo(String dummyTableAckNo) {
		this.dummyTableAckNo = dummyTableAckNo;
	}

	public String getDummyTableNameOfTheCandidate() {
		return dummyTableNameOfTheCandidate;
	}

	public void setDummyTableNameOfTheCandidate(String dummyTableNameOfTheCandidate) {
		this.dummyTableNameOfTheCandidate = dummyTableNameOfTheCandidate;
	}

	public String getDummyTableGender() {
		return dummyTableGender;
	}

	public void setDummyTableGender(String dummyTableGender) {
		this.dummyTableGender = dummyTableGender;
	}

	public String getDummyTableDateOfBirth() {
		return dummyTableDateOfBirth;
	}

	public void setDummyTableDateOfBirth(String dummyTableDateOfBirth) {
		this.dummyTableDateOfBirth = dummyTableDateOfBirth;
	}

	public String getDummyTableEmailId() {
		return dummyTableEmailId;
	}

	public void setDummyTableEmailId(String dummyTableEmailId) {
		this.dummyTableEmailId = dummyTableEmailId;
	}

	public String getDummyTableMobileNumber() {
		return dummyTableMobileNumber;
	}

	public void setDummyTableMobileNumber(String dummyTableMobileNumber) {
		this.dummyTableMobileNumber = dummyTableMobileNumber;
	}

	public String getDummyTableMotherTongue() {
		return dummyTableMotherTongue;
	}

	public void setDummyTableMotherTongue(String dummyTableMotherTongue) {
		this.dummyTableMotherTongue = dummyTableMotherTongue;
	}

	public String getDummyTableReligion() {
		return dummyTableReligion;
	}

	public void setDummyTableReligion(String dummyTableReligion) {
		this.dummyTableReligion = dummyTableReligion;
	}

	public String getDummyTableHscBoard() {
		return dummyTableHscBoard;
	}

	public void setDummyTableHscBoard(String dummyTableHscBoard) {
		this.dummyTableHscBoard = dummyTableHscBoard;
	}

	public Integer getDummyTableHscTotal() {
		return dummyTableHscTotal;
	}

	public void setDummyTableHscTotal(Integer dummyTableHscTotal) {
		this.dummyTableHscTotal = dummyTableHscTotal;
	}

	public Integer getDummyTableHscMaths() {
		return dummyTableHscMaths;
	}

	public void setDummyTableHscMaths(Integer dummyTableHscMaths) {
		this.dummyTableHscMaths = dummyTableHscMaths;
	}

	public Integer getDummyTableHscPhysics() {
		return dummyTableHscPhysics;
	}

	public void setDummyTableHscPhysics(Integer dummyTableHscPhysics) {
		this.dummyTableHscPhysics = dummyTableHscPhysics;
	}

	public Integer getDummyTableHscChem() {
		return dummyTableHscChem;
	}

	public void setDummyTableHscChem(Integer dummyTableHscChem) {
		this.dummyTableHscChem = dummyTableHscChem;
	}

	public Integer getDummyTableHscBio() {
		return dummyTableHscBio;
	}

	public void setDummyTableHscBio(Integer dummyTableHscBio) {
		this.dummyTableHscBio = dummyTableHscBio;
	}

	public Integer getDummyTableHscVoc() {
		return dummyTableHscVoc;
	}

	public void setDummyTableHscVoc(Integer dummyTableHscVoc) {
		this.dummyTableHscVoc = dummyTableHscVoc;
	}

	public Integer getDummyTableHscPcmTotal() {
		return dummyTableHscPcmTotal;
	}

	public void setDummyTableHscPcmTotal(Integer dummyTableHscPcmTotal) {
		this.dummyTableHscPcmTotal = dummyTableHscPcmTotal;
	}

	public Double getDummyTablePcmPercentage() {
		return dummyTablePcmPercentage;
	}

	public void setDummyTablePcmPercentage(Double dummyTablePcmPercentage) {
		this.dummyTablePcmPercentage = dummyTablePcmPercentage;
	}

	public Integer getDummyTableHscPmvTotal() {
		return dummyTableHscPmvTotal;
	}

	public void setDummyTableHscPmvTotal(Integer dummyTableHscPmvTotal) {
		this.dummyTableHscPmvTotal = dummyTableHscPmvTotal;
	}

	public Double getDummyTablePmvPercentage() {
		return dummyTablePmvPercentage;
	}

	public void setDummyTablePmvPercentage(Double dummyTablePmvPercentage) {
		this.dummyTablePmvPercentage = dummyTablePmvPercentage;
	}

	public Integer getDummyTableSscMaths() {
		return dummyTableSscMaths;
	}

	public void setDummyTableSscMaths(Integer dummyTableSscMaths) {
		this.dummyTableSscMaths = dummyTableSscMaths;
	}

	public Integer getDummyTableSscTotal() {
		return dummyTableSscTotal;
	}

	public void setDummyTableSscTotal(Integer dummyTableSscTotal) {
		this.dummyTableSscTotal = dummyTableSscTotal;
	}

	public Integer getDummyTableJeeMaths() {
		return dummyTableJeeMaths;
	}

	public void setDummyTableJeeMaths(Integer dummyTableJeeMaths) {
		this.dummyTableJeeMaths = dummyTableJeeMaths;
	}

	public Integer getDummyTableJeePhysics() {
		return dummyTableJeePhysics;
	}

	public void setDummyTableJeePhysics(Integer dummyTableJeePhysics) {
		this.dummyTableJeePhysics = dummyTableJeePhysics;
	}

	public Integer getDummyTableJeeChem() {
		return dummyTableJeeChem;
	}

	public void setDummyTableJeeChem(Integer dummyTableJeeChem) {
		this.dummyTableJeeChem = dummyTableJeeChem;
	}

	public Integer getDummyTableJeeScore() {
		return dummyTableJeeScore;
	}

	public void setDummyTableJeeScore(Integer dummyTableJeeScore) {
		this.dummyTableJeeScore = dummyTableJeeScore;
	}

	public Double getDummyTableJeePercentile() {
		return dummyTableJeePercentile;
	}

	public void setDummyTableJeePercentile(Double dummyTableJeePercentile) {
		this.dummyTableJeePercentile = dummyTableJeePercentile;
	}

	public Double getDummyTableBoardPercentile() {
		return dummyTableBoardPercentile;
	}

	public void setDummyTableBoardPercentile(Double dummyTableBoardPercentile) {
		this.dummyTableBoardPercentile = dummyTableBoardPercentile;
	}

	public Double getDummyTableCompositeScore() {
		return dummyTableCompositeScore;
	}

	public void setDummyTableCompositeScore(Double dummyTableCompositeScore) {
		this.dummyTableCompositeScore = dummyTableCompositeScore;
	}

	public String getDummyTableCEPriority() {
		return dummyTableCEPriority;
	}

	public void setDummyTableCEPriority(String dummyTableCEPriority) {
		this.dummyTableCEPriority = dummyTableCEPriority;
	}

	public String getDummyTableEXTCPriority() {
		return dummyTableEXTCPriority;
	}

	public void setDummyTableEXTCPriority(String dummyTableEXTCPriority) {
		this.dummyTableEXTCPriority = dummyTableEXTCPriority;
	}

	public String getDummyTableITPriority() {
		return dummyTableITPriority;
	}

	public void setDummyTableITPriority(String dummyTableITPriority) {
		this.dummyTableITPriority = dummyTableITPriority;
	}

	public String getDummyTablePPTPriority() {
		return dummyTablePPTPriority;
	}

	public void setDummyTablePPTPriority(String dummyTablePPTPriority) {
		this.dummyTablePPTPriority = dummyTablePPTPriority;
	}

	public String getDummyTableBTPriority() {
		return dummyTableBTPriority;
	}

	public void setDummyTableBTPriority(String dummyTableBTPriority) {
		this.dummyTableBTPriority = dummyTableBTPriority;
	}

	public String getDummyTableMECHPriority() {
		return dummyTableMECHPriority;
	}

	public void setDummyTableMECHPriority(String dummyTableMECHPriority) {
		this.dummyTableMECHPriority = dummyTableMECHPriority;
	}

	
	
	
	
	
	
}	