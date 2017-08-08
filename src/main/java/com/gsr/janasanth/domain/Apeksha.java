package com.gsr.janasanth.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A Apeksha.
 */
@Entity
@Table(name = "apeksha")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "apeksha")
public class Apeksha implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "application_number")
    private String applicationNumber;

    @NotNull
    @Column(name = "beneficiary_name", nullable = false)
    private String beneficiaryName;

    @NotNull
    @Column(name = "district", nullable = false)
    private String district;

    @NotNull
    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "fathers_name")
    private String fathersName;

    @NotNull
    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @NotNull
    @Column(name = "aadhar_number", nullable = false)
    private String aadharNumber;

    @NotNull
    @Column(name = "ration_card_number", nullable = false)
    private String rationCardNumber;

    @Column(name = "ration_card_category")
    private String rationCardCategory;

    @NotNull
    @Column(name = "caste", nullable = false)
    private String caste;

    @NotNull
    @Column(name = "religion", nullable = false)
    private String religion;

    @Column(name = "house_name")
    private String houseName;

    @Column(name = "house_number")
    private String houseNumber;

    @Column(name = "tc_number")
    private String tcNumber;

    @NotNull
    @Column(name = "village", nullable = false)
    private String village;

    @Column(name = "panchayat")
    private String panchayat;

    @Column(name = "post_office")
    private String postOffice;

    @NotNull
    @Column(name = "mobile_number", nullable = false)
    private String mobileNumber;

    @Column(name = "land_line_with_std")
    private String landLineWithSTD;

    @Column(name = "pin_code")
    private String pinCode;

    @Column(name = "occupation")
    private String occupation;

    @NotNull
    @Column(name = "annual_income", nullable = false)
    private Double annualIncome;

    @Column(name = "family_details")
    private String familyDetails;

    @Column(name = "land_total_cent")
    private String landTotalCent;

    @Column(name = "land_thaluk")
    private String landThaluk;

    @Column(name = "land_village")
    private String landVillage;

    @Column(name = "land_district")
    private String landDistrict;

    @Column(name = "thaluk")
    private String thaluk;

    @NotNull
    @Column(name = "requirement_purpose", nullable = false)
    private String requirementPurpose;

    @Column(name = "recommendation")
    private String recommendation;

    @NotNull
    @Column(name = "hospital_name", nullable = false)
    private String hospitalName;

    @Column(name = "treatment_history")
    private String treatmentHistory;

    @NotNull
    @Column(name = "expected_amount", nullable = false)
    private Double expectedAmount;

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "bank_branch_name")
    private String bankBranchName;

    @Column(name = "bank_account_number")
    private String bankAccountNumber;

    @Column(name = "bank_ifsc_code")
    private String bankIfscCode;

    @Lob
    @Column(name = "additional_documents")
    private byte[] additionalDocuments;

    @Column(name = "additional_documents_content_type")
    private String additionalDocumentsContentType;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "date_of_applcation")
    private LocalDate dateOfApplcation;

    @Column(name = "nominee_available")
    private String nomineeAvailable;

    @Column(name = "nominee_name")
    private String nomineeName;

    @Column(name = "nominee_gender")
    private String nomineeGender;

    @Column(name = "nominee_age")
    private Integer nomineeAge;

    @Column(name = "nominee_relationship")
    private String nomineeRelationship;

    @Column(name = "nominee_house_name")
    private String nomineeHouseName;

    @Column(name = "nominee_house_number")
    private String nomineeHouseNumber;

    @Column(name = "nominee_tc_no")
    private String nomineeTcNo;

    @Column(name = "nominee_village")
    private String nomineeVillage;

    @Column(name = "nominee_thaluk")
    private String nomineeThaluk;

    @Column(name = "nominee_panchayat")
    private String nomineePanchayat;

    @Column(name = "nominee_post_office")
    private String nomineePostOffice;

    @Column(name = "nominee_pin_code")
    private String nomineePinCode;

    @Column(name = "nominee_mobile_number")
    private String nomineeMobileNumber;

    @Column(name = "nominee_land_line_with_std")
    private String nomineeLandLineWithSTD;

    @Column(name = "nominee_bank_name")
    private String nomineeBankName;

    @Column(name = "nominee_bank_branch")
    private String nomineeBankBranch;

    @Column(name = "nominee_bank_account_number")
    private String nomineeBankAccountNumber;

    @Column(name = "nominee_bank_ifsc_code")
    private String nomineeBankIfscCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApplicationNumber() {
        return applicationNumber;
    }

    public Apeksha applicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
        return this;
    }

    public void setApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    public String getBeneficiaryName() {
        return beneficiaryName;
    }

    public Apeksha beneficiaryName(String beneficiaryName) {
        this.beneficiaryName = beneficiaryName;
        return this;
    }

    public void setBeneficiaryName(String beneficiaryName) {
        this.beneficiaryName = beneficiaryName;
    }

    public String getDistrict() {
        return district;
    }

    public Apeksha district(String district) {
        this.district = district;
        return this;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getGender() {
        return gender;
    }

    public Apeksha gender(String gender) {
        this.gender = gender;
        return this;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFathersName() {
        return fathersName;
    }

    public Apeksha fathersName(String fathersName) {
        this.fathersName = fathersName;
        return this;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public Integer getAge() {
        return age;
    }

    public Apeksha age(Integer age) {
        this.age = age;
        return this;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Apeksha dateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public Apeksha aadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
        return this;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public String getRationCardNumber() {
        return rationCardNumber;
    }

    public Apeksha rationCardNumber(String rationCardNumber) {
        this.rationCardNumber = rationCardNumber;
        return this;
    }

    public void setRationCardNumber(String rationCardNumber) {
        this.rationCardNumber = rationCardNumber;
    }

    public String getRationCardCategory() {
        return rationCardCategory;
    }

    public Apeksha rationCardCategory(String rationCardCategory) {
        this.rationCardCategory = rationCardCategory;
        return this;
    }

    public void setRationCardCategory(String rationCardCategory) {
        this.rationCardCategory = rationCardCategory;
    }

    public String getCaste() {
        return caste;
    }

    public Apeksha caste(String caste) {
        this.caste = caste;
        return this;
    }

    public void setCaste(String caste) {
        this.caste = caste;
    }

    public String getReligion() {
        return religion;
    }

    public Apeksha religion(String religion) {
        this.religion = religion;
        return this;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getHouseName() {
        return houseName;
    }

    public Apeksha houseName(String houseName) {
        this.houseName = houseName;
        return this;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public Apeksha houseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
        return this;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getTcNumber() {
        return tcNumber;
    }

    public Apeksha tcNumber(String tcNumber) {
        this.tcNumber = tcNumber;
        return this;
    }

    public void setTcNumber(String tcNumber) {
        this.tcNumber = tcNumber;
    }

    public String getVillage() {
        return village;
    }

    public Apeksha village(String village) {
        this.village = village;
        return this;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getPanchayat() {
        return panchayat;
    }

    public Apeksha panchayat(String panchayat) {
        this.panchayat = panchayat;
        return this;
    }

    public void setPanchayat(String panchayat) {
        this.panchayat = panchayat;
    }

    public String getPostOffice() {
        return postOffice;
    }

    public Apeksha postOffice(String postOffice) {
        this.postOffice = postOffice;
        return this;
    }

    public void setPostOffice(String postOffice) {
        this.postOffice = postOffice;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public Apeksha mobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
        return this;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getLandLineWithSTD() {
        return landLineWithSTD;
    }

    public Apeksha landLineWithSTD(String landLineWithSTD) {
        this.landLineWithSTD = landLineWithSTD;
        return this;
    }

    public void setLandLineWithSTD(String landLineWithSTD) {
        this.landLineWithSTD = landLineWithSTD;
    }

    public String getPinCode() {
        return pinCode;
    }

    public Apeksha pinCode(String pinCode) {
        this.pinCode = pinCode;
        return this;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getOccupation() {
        return occupation;
    }

    public Apeksha occupation(String occupation) {
        this.occupation = occupation;
        return this;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Double getAnnualIncome() {
        return annualIncome;
    }

    public Apeksha annualIncome(Double annualIncome) {
        this.annualIncome = annualIncome;
        return this;
    }

    public void setAnnualIncome(Double annualIncome) {
        this.annualIncome = annualIncome;
    }

    public String getFamilyDetails() {
        return familyDetails;
    }

    public Apeksha familyDetails(String familyDetails) {
        this.familyDetails = familyDetails;
        return this;
    }

    public void setFamilyDetails(String familyDetails) {
        this.familyDetails = familyDetails;
    }

    public String getLandTotalCent() {
        return landTotalCent;
    }

    public Apeksha landTotalCent(String landTotalCent) {
        this.landTotalCent = landTotalCent;
        return this;
    }

    public void setLandTotalCent(String landTotalCent) {
        this.landTotalCent = landTotalCent;
    }

    public String getLandThaluk() {
        return landThaluk;
    }

    public Apeksha landThaluk(String landThaluk) {
        this.landThaluk = landThaluk;
        return this;
    }

    public void setLandThaluk(String landThaluk) {
        this.landThaluk = landThaluk;
    }

    public String getLandVillage() {
        return landVillage;
    }

    public Apeksha landVillage(String landVillage) {
        this.landVillage = landVillage;
        return this;
    }

    public void setLandVillage(String landVillage) {
        this.landVillage = landVillage;
    }

    public String getLandDistrict() {
        return landDistrict;
    }

    public Apeksha landDistrict(String landDistrict) {
        this.landDistrict = landDistrict;
        return this;
    }

    public void setLandDistrict(String landDistrict) {
        this.landDistrict = landDistrict;
    }

    public String getThaluk() {
        return thaluk;
    }

    public Apeksha thaluk(String thaluk) {
        this.thaluk = thaluk;
        return this;
    }

    public void setThaluk(String thaluk) {
        this.thaluk = thaluk;
    }

    public String getRequirementPurpose() {
        return requirementPurpose;
    }

    public Apeksha requirementPurpose(String requirementPurpose) {
        this.requirementPurpose = requirementPurpose;
        return this;
    }

    public void setRequirementPurpose(String requirementPurpose) {
        this.requirementPurpose = requirementPurpose;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public Apeksha recommendation(String recommendation) {
        this.recommendation = recommendation;
        return this;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public Apeksha hospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
        return this;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getTreatmentHistory() {
        return treatmentHistory;
    }

    public Apeksha treatmentHistory(String treatmentHistory) {
        this.treatmentHistory = treatmentHistory;
        return this;
    }

    public void setTreatmentHistory(String treatmentHistory) {
        this.treatmentHistory = treatmentHistory;
    }

    public Double getExpectedAmount() {
        return expectedAmount;
    }

    public Apeksha expectedAmount(Double expectedAmount) {
        this.expectedAmount = expectedAmount;
        return this;
    }

    public void setExpectedAmount(Double expectedAmount) {
        this.expectedAmount = expectedAmount;
    }

    public String getBankName() {
        return bankName;
    }

    public Apeksha bankName(String bankName) {
        this.bankName = bankName;
        return this;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankBranchName() {
        return bankBranchName;
    }

    public Apeksha bankBranchName(String bankBranchName) {
        this.bankBranchName = bankBranchName;
        return this;
    }

    public void setBankBranchName(String bankBranchName) {
        this.bankBranchName = bankBranchName;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public Apeksha bankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
        return this;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getBankIfscCode() {
        return bankIfscCode;
    }

    public Apeksha bankIfscCode(String bankIfscCode) {
        this.bankIfscCode = bankIfscCode;
        return this;
    }

    public void setBankIfscCode(String bankIfscCode) {
        this.bankIfscCode = bankIfscCode;
    }

    public byte[] getAdditionalDocuments() {
        return additionalDocuments;
    }

    public Apeksha additionalDocuments(byte[] additionalDocuments) {
        this.additionalDocuments = additionalDocuments;
        return this;
    }

    public void setAdditionalDocuments(byte[] additionalDocuments) {
        this.additionalDocuments = additionalDocuments;
    }

    public String getAdditionalDocumentsContentType() {
        return additionalDocumentsContentType;
    }

    public Apeksha additionalDocumentsContentType(String additionalDocumentsContentType) {
        this.additionalDocumentsContentType = additionalDocumentsContentType;
        return this;
    }

    public void setAdditionalDocumentsContentType(String additionalDocumentsContentType) {
        this.additionalDocumentsContentType = additionalDocumentsContentType;
    }

    public String getRemarks() {
        return remarks;
    }

    public Apeksha remarks(String remarks) {
        this.remarks = remarks;
        return this;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public LocalDate getDateOfApplcation() {
        return dateOfApplcation;
    }

    public Apeksha dateOfApplcation(LocalDate dateOfApplcation) {
        this.dateOfApplcation = dateOfApplcation;
        return this;
    }

    public void setDateOfApplcation(LocalDate dateOfApplcation) {
        this.dateOfApplcation = dateOfApplcation;
    }

    public String getNomineeAvailable() {
        return nomineeAvailable;
    }

    public Apeksha nomineeAvailable(String nomineeAvailable) {
        this.nomineeAvailable = nomineeAvailable;
        return this;
    }

    public void setNomineeAvailable(String nomineeAvailable) {
        this.nomineeAvailable = nomineeAvailable;
    }

    public String getNomineeName() {
        return nomineeName;
    }

    public Apeksha nomineeName(String nomineeName) {
        this.nomineeName = nomineeName;
        return this;
    }

    public void setNomineeName(String nomineeName) {
        this.nomineeName = nomineeName;
    }

    public String getNomineeGender() {
        return nomineeGender;
    }

    public Apeksha nomineeGender(String nomineeGender) {
        this.nomineeGender = nomineeGender;
        return this;
    }

    public void setNomineeGender(String nomineeGender) {
        this.nomineeGender = nomineeGender;
    }

    public Integer getNomineeAge() {
        return nomineeAge;
    }

    public Apeksha nomineeAge(Integer nomineeAge) {
        this.nomineeAge = nomineeAge;
        return this;
    }

    public void setNomineeAge(Integer nomineeAge) {
        this.nomineeAge = nomineeAge;
    }

    public String getNomineeRelationship() {
        return nomineeRelationship;
    }

    public Apeksha nomineeRelationship(String nomineeRelationship) {
        this.nomineeRelationship = nomineeRelationship;
        return this;
    }

    public void setNomineeRelationship(String nomineeRelationship) {
        this.nomineeRelationship = nomineeRelationship;
    }

    public String getNomineeHouseName() {
        return nomineeHouseName;
    }

    public Apeksha nomineeHouseName(String nomineeHouseName) {
        this.nomineeHouseName = nomineeHouseName;
        return this;
    }

    public void setNomineeHouseName(String nomineeHouseName) {
        this.nomineeHouseName = nomineeHouseName;
    }

    public String getNomineeHouseNumber() {
        return nomineeHouseNumber;
    }

    public Apeksha nomineeHouseNumber(String nomineeHouseNumber) {
        this.nomineeHouseNumber = nomineeHouseNumber;
        return this;
    }

    public void setNomineeHouseNumber(String nomineeHouseNumber) {
        this.nomineeHouseNumber = nomineeHouseNumber;
    }

    public String getNomineeTcNo() {
        return nomineeTcNo;
    }

    public Apeksha nomineeTcNo(String nomineeTcNo) {
        this.nomineeTcNo = nomineeTcNo;
        return this;
    }

    public void setNomineeTcNo(String nomineeTcNo) {
        this.nomineeTcNo = nomineeTcNo;
    }

    public String getNomineeVillage() {
        return nomineeVillage;
    }

    public Apeksha nomineeVillage(String nomineeVillage) {
        this.nomineeVillage = nomineeVillage;
        return this;
    }

    public void setNomineeVillage(String nomineeVillage) {
        this.nomineeVillage = nomineeVillage;
    }

    public String getNomineeThaluk() {
        return nomineeThaluk;
    }

    public Apeksha nomineeThaluk(String nomineeThaluk) {
        this.nomineeThaluk = nomineeThaluk;
        return this;
    }

    public void setNomineeThaluk(String nomineeThaluk) {
        this.nomineeThaluk = nomineeThaluk;
    }

    public String getNomineePanchayat() {
        return nomineePanchayat;
    }

    public Apeksha nomineePanchayat(String nomineePanchayat) {
        this.nomineePanchayat = nomineePanchayat;
        return this;
    }

    public void setNomineePanchayat(String nomineePanchayat) {
        this.nomineePanchayat = nomineePanchayat;
    }

    public String getNomineePostOffice() {
        return nomineePostOffice;
    }

    public Apeksha nomineePostOffice(String nomineePostOffice) {
        this.nomineePostOffice = nomineePostOffice;
        return this;
    }

    public void setNomineePostOffice(String nomineePostOffice) {
        this.nomineePostOffice = nomineePostOffice;
    }

    public String getNomineePinCode() {
        return nomineePinCode;
    }

    public Apeksha nomineePinCode(String nomineePinCode) {
        this.nomineePinCode = nomineePinCode;
        return this;
    }

    public void setNomineePinCode(String nomineePinCode) {
        this.nomineePinCode = nomineePinCode;
    }

    public String getNomineeMobileNumber() {
        return nomineeMobileNumber;
    }

    public Apeksha nomineeMobileNumber(String nomineeMobileNumber) {
        this.nomineeMobileNumber = nomineeMobileNumber;
        return this;
    }

    public void setNomineeMobileNumber(String nomineeMobileNumber) {
        this.nomineeMobileNumber = nomineeMobileNumber;
    }

    public String getNomineeLandLineWithSTD() {
        return nomineeLandLineWithSTD;
    }

    public Apeksha nomineeLandLineWithSTD(String nomineeLandLineWithSTD) {
        this.nomineeLandLineWithSTD = nomineeLandLineWithSTD;
        return this;
    }

    public void setNomineeLandLineWithSTD(String nomineeLandLineWithSTD) {
        this.nomineeLandLineWithSTD = nomineeLandLineWithSTD;
    }

    public String getNomineeBankName() {
        return nomineeBankName;
    }

    public Apeksha nomineeBankName(String nomineeBankName) {
        this.nomineeBankName = nomineeBankName;
        return this;
    }

    public void setNomineeBankName(String nomineeBankName) {
        this.nomineeBankName = nomineeBankName;
    }

    public String getNomineeBankBranch() {
        return nomineeBankBranch;
    }

    public Apeksha nomineeBankBranch(String nomineeBankBranch) {
        this.nomineeBankBranch = nomineeBankBranch;
        return this;
    }

    public void setNomineeBankBranch(String nomineeBankBranch) {
        this.nomineeBankBranch = nomineeBankBranch;
    }

    public String getNomineeBankAccountNumber() {
        return nomineeBankAccountNumber;
    }

    public Apeksha nomineeBankAccountNumber(String nomineeBankAccountNumber) {
        this.nomineeBankAccountNumber = nomineeBankAccountNumber;
        return this;
    }

    public void setNomineeBankAccountNumber(String nomineeBankAccountNumber) {
        this.nomineeBankAccountNumber = nomineeBankAccountNumber;
    }

    public String getNomineeBankIfscCode() {
        return nomineeBankIfscCode;
    }

    public Apeksha nomineeBankIfscCode(String nomineeBankIfscCode) {
        this.nomineeBankIfscCode = nomineeBankIfscCode;
        return this;
    }

    public void setNomineeBankIfscCode(String nomineeBankIfscCode) {
        this.nomineeBankIfscCode = nomineeBankIfscCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Apeksha apeksha = (Apeksha) o;
        if (apeksha.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), apeksha.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Apeksha{" +
            "id=" + getId() +
            ", applicationNumber='" + getApplicationNumber() + "'" +
            ", beneficiaryName='" + getBeneficiaryName() + "'" +
            ", district='" + getDistrict() + "'" +
            ", gender='" + getGender() + "'" +
            ", fathersName='" + getFathersName() + "'" +
            ", age='" + getAge() + "'" +
            ", dateOfBirth='" + getDateOfBirth() + "'" +
            ", aadharNumber='" + getAadharNumber() + "'" +
            ", rationCardNumber='" + getRationCardNumber() + "'" +
            ", rationCardCategory='" + getRationCardCategory() + "'" +
            ", caste='" + getCaste() + "'" +
            ", religion='" + getReligion() + "'" +
            ", houseName='" + getHouseName() + "'" +
            ", houseNumber='" + getHouseNumber() + "'" +
            ", tcNumber='" + getTcNumber() + "'" +
            ", village='" + getVillage() + "'" +
            ", panchayat='" + getPanchayat() + "'" +
            ", postOffice='" + getPostOffice() + "'" +
            ", mobileNumber='" + getMobileNumber() + "'" +
            ", landLineWithSTD='" + getLandLineWithSTD() + "'" +
            ", pinCode='" + getPinCode() + "'" +
            ", occupation='" + getOccupation() + "'" +
            ", annualIncome='" + getAnnualIncome() + "'" +
            ", familyDetails='" + getFamilyDetails() + "'" +
            ", landTotalCent='" + getLandTotalCent() + "'" +
            ", landThaluk='" + getLandThaluk() + "'" +
            ", landVillage='" + getLandVillage() + "'" +
            ", landDistrict='" + getLandDistrict() + "'" +
            ", thaluk='" + getThaluk() + "'" +
            ", requirementPurpose='" + getRequirementPurpose() + "'" +
            ", recommendation='" + getRecommendation() + "'" +
            ", hospitalName='" + getHospitalName() + "'" +
            ", treatmentHistory='" + getTreatmentHistory() + "'" +
            ", expectedAmount='" + getExpectedAmount() + "'" +
            ", bankName='" + getBankName() + "'" +
            ", bankBranchName='" + getBankBranchName() + "'" +
            ", bankAccountNumber='" + getBankAccountNumber() + "'" +
            ", bankIfscCode='" + getBankIfscCode() + "'" +
            ", additionalDocuments='" + getAdditionalDocuments() + "'" +
            ", additionalDocumentsContentType='" + additionalDocumentsContentType + "'" +
            ", remarks='" + getRemarks() + "'" +
            ", dateOfApplcation='" + getDateOfApplcation() + "'" +
            ", nomineeAvailable='" + getNomineeAvailable() + "'" +
            ", nomineeName='" + getNomineeName() + "'" +
            ", nomineeGender='" + getNomineeGender() + "'" +
            ", nomineeAge='" + getNomineeAge() + "'" +
            ", nomineeRelationship='" + getNomineeRelationship() + "'" +
            ", nomineeHouseName='" + getNomineeHouseName() + "'" +
            ", nomineeHouseNumber='" + getNomineeHouseNumber() + "'" +
            ", nomineeTcNo='" + getNomineeTcNo() + "'" +
            ", nomineeVillage='" + getNomineeVillage() + "'" +
            ", nomineeThaluk='" + getNomineeThaluk() + "'" +
            ", nomineePanchayat='" + getNomineePanchayat() + "'" +
            ", nomineePostOffice='" + getNomineePostOffice() + "'" +
            ", nomineePinCode='" + getNomineePinCode() + "'" +
            ", nomineeMobileNumber='" + getNomineeMobileNumber() + "'" +
            ", nomineeLandLineWithSTD='" + getNomineeLandLineWithSTD() + "'" +
            ", nomineeBankName='" + getNomineeBankName() + "'" +
            ", nomineeBankBranch='" + getNomineeBankBranch() + "'" +
            ", nomineeBankAccountNumber='" + getNomineeBankAccountNumber() + "'" +
            ", nomineeBankIfscCode='" + getNomineeBankIfscCode() + "'" +
            "}";
    }
}
