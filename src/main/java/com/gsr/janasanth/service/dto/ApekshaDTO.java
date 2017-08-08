package com.gsr.janasanth.service.dto;


import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Lob;

/**
 * A DTO for the Apeksha entity.
 */
public class ApekshaDTO implements Serializable {

    private Long id;

    private String applicationNumber;

    @NotNull
    private String beneficiaryName;

    @NotNull
    private String district;

    @NotNull
    private String gender;

    private String fathersName;

    @NotNull
    private Integer age;

    private LocalDate dateOfBirth;

    @NotNull
    private String aadharNumber;

    @NotNull
    private String rationCardNumber;

    private String rationCardCategory;

    @NotNull
    private String caste;

    @NotNull
    private String religion;

    private String houseName;

    private String houseNumber;

    private String tcNumber;

    @NotNull
    private String village;

    private String panchayat;

    private String postOffice;

    @NotNull
    private String mobileNumber;

    private String landLineWithSTD;

    private String pinCode;

    private String occupation;

    @NotNull
    private Double annualIncome;

    private String familyDetails;

    private String landTotalCent;

    private String landThaluk;

    private String landVillage;

    private String landDistrict;

    private String thaluk;

    @NotNull
    private String requirementPurpose;

    private String recommendation;

    @NotNull
    private String hospitalName;

    private String treatmentHistory;

    @NotNull
    private Double expectedAmount;

    private String bankName;

    private String bankBranchName;

    private String bankAccountNumber;

    private String bankIfscCode;

    @Lob
    private byte[] additionalDocuments;
    private String additionalDocumentsContentType;

    private String remarks;

    private LocalDate dateOfApplcation;

    private String nomineeAvailable;

    private String nomineeName;

    private String nomineeGender;

    private Integer nomineeAge;

    private String nomineeRelationship;

    private String nomineeHouseName;

    private String nomineeHouseNumber;

    private String nomineeTcNo;

    private String nomineeVillage;

    private String nomineeThaluk;

    private String nomineePanchayat;

    private String nomineePostOffice;

    private String nomineePinCode;

    private String nomineeMobileNumber;

    private String nomineeLandLineWithSTD;

    private String nomineeBankName;

    private String nomineeBankBranch;

    private String nomineeBankAccountNumber;

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

    public void setApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    public String getBeneficiaryName() {
        return beneficiaryName;
    }

    public void setBeneficiaryName(String beneficiaryName) {
        this.beneficiaryName = beneficiaryName;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFathersName() {
        return fathersName;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public String getRationCardNumber() {
        return rationCardNumber;
    }

    public void setRationCardNumber(String rationCardNumber) {
        this.rationCardNumber = rationCardNumber;
    }

    public String getRationCardCategory() {
        return rationCardCategory;
    }

    public void setRationCardCategory(String rationCardCategory) {
        this.rationCardCategory = rationCardCategory;
    }

    public String getCaste() {
        return caste;
    }

    public void setCaste(String caste) {
        this.caste = caste;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getTcNumber() {
        return tcNumber;
    }

    public void setTcNumber(String tcNumber) {
        this.tcNumber = tcNumber;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getPanchayat() {
        return panchayat;
    }

    public void setPanchayat(String panchayat) {
        this.panchayat = panchayat;
    }

    public String getPostOffice() {
        return postOffice;
    }

    public void setPostOffice(String postOffice) {
        this.postOffice = postOffice;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getLandLineWithSTD() {
        return landLineWithSTD;
    }

    public void setLandLineWithSTD(String landLineWithSTD) {
        this.landLineWithSTD = landLineWithSTD;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Double getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(Double annualIncome) {
        this.annualIncome = annualIncome;
    }

    public String getFamilyDetails() {
        return familyDetails;
    }

    public void setFamilyDetails(String familyDetails) {
        this.familyDetails = familyDetails;
    }

    public String getLandTotalCent() {
        return landTotalCent;
    }

    public void setLandTotalCent(String landTotalCent) {
        this.landTotalCent = landTotalCent;
    }

    public String getLandThaluk() {
        return landThaluk;
    }

    public void setLandThaluk(String landThaluk) {
        this.landThaluk = landThaluk;
    }

    public String getLandVillage() {
        return landVillage;
    }

    public void setLandVillage(String landVillage) {
        this.landVillage = landVillage;
    }

    public String getLandDistrict() {
        return landDistrict;
    }

    public void setLandDistrict(String landDistrict) {
        this.landDistrict = landDistrict;
    }

    public String getThaluk() {
        return thaluk;
    }

    public void setThaluk(String thaluk) {
        this.thaluk = thaluk;
    }

    public String getRequirementPurpose() {
        return requirementPurpose;
    }

    public void setRequirementPurpose(String requirementPurpose) {
        this.requirementPurpose = requirementPurpose;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getTreatmentHistory() {
        return treatmentHistory;
    }

    public void setTreatmentHistory(String treatmentHistory) {
        this.treatmentHistory = treatmentHistory;
    }

    public Double getExpectedAmount() {
        return expectedAmount;
    }

    public void setExpectedAmount(Double expectedAmount) {
        this.expectedAmount = expectedAmount;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankBranchName() {
        return bankBranchName;
    }

    public void setBankBranchName(String bankBranchName) {
        this.bankBranchName = bankBranchName;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getBankIfscCode() {
        return bankIfscCode;
    }

    public void setBankIfscCode(String bankIfscCode) {
        this.bankIfscCode = bankIfscCode;
    }

    public byte[] getAdditionalDocuments() {
        return additionalDocuments;
    }

    public void setAdditionalDocuments(byte[] additionalDocuments) {
        this.additionalDocuments = additionalDocuments;
    }

    public String getAdditionalDocumentsContentType() {
        return additionalDocumentsContentType;
    }

    public void setAdditionalDocumentsContentType(String additionalDocumentsContentType) {
        this.additionalDocumentsContentType = additionalDocumentsContentType;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public LocalDate getDateOfApplcation() {
        return dateOfApplcation;
    }

    public void setDateOfApplcation(LocalDate dateOfApplcation) {
        this.dateOfApplcation = dateOfApplcation;
    }

    public String getNomineeAvailable() {
        return nomineeAvailable;
    }

    public void setNomineeAvailable(String nomineeAvailable) {
        this.nomineeAvailable = nomineeAvailable;
    }

    public String getNomineeName() {
        return nomineeName;
    }

    public void setNomineeName(String nomineeName) {
        this.nomineeName = nomineeName;
    }

    public String getNomineeGender() {
        return nomineeGender;
    }

    public void setNomineeGender(String nomineeGender) {
        this.nomineeGender = nomineeGender;
    }

    public Integer getNomineeAge() {
        return nomineeAge;
    }

    public void setNomineeAge(Integer nomineeAge) {
        this.nomineeAge = nomineeAge;
    }

    public String getNomineeRelationship() {
        return nomineeRelationship;
    }

    public void setNomineeRelationship(String nomineeRelationship) {
        this.nomineeRelationship = nomineeRelationship;
    }

    public String getNomineeHouseName() {
        return nomineeHouseName;
    }

    public void setNomineeHouseName(String nomineeHouseName) {
        this.nomineeHouseName = nomineeHouseName;
    }

    public String getNomineeHouseNumber() {
        return nomineeHouseNumber;
    }

    public void setNomineeHouseNumber(String nomineeHouseNumber) {
        this.nomineeHouseNumber = nomineeHouseNumber;
    }

    public String getNomineeTcNo() {
        return nomineeTcNo;
    }

    public void setNomineeTcNo(String nomineeTcNo) {
        this.nomineeTcNo = nomineeTcNo;
    }

    public String getNomineeVillage() {
        return nomineeVillage;
    }

    public void setNomineeVillage(String nomineeVillage) {
        this.nomineeVillage = nomineeVillage;
    }

    public String getNomineeThaluk() {
        return nomineeThaluk;
    }

    public void setNomineeThaluk(String nomineeThaluk) {
        this.nomineeThaluk = nomineeThaluk;
    }

    public String getNomineePanchayat() {
        return nomineePanchayat;
    }

    public void setNomineePanchayat(String nomineePanchayat) {
        this.nomineePanchayat = nomineePanchayat;
    }

    public String getNomineePostOffice() {
        return nomineePostOffice;
    }

    public void setNomineePostOffice(String nomineePostOffice) {
        this.nomineePostOffice = nomineePostOffice;
    }

    public String getNomineePinCode() {
        return nomineePinCode;
    }

    public void setNomineePinCode(String nomineePinCode) {
        this.nomineePinCode = nomineePinCode;
    }

    public String getNomineeMobileNumber() {
        return nomineeMobileNumber;
    }

    public void setNomineeMobileNumber(String nomineeMobileNumber) {
        this.nomineeMobileNumber = nomineeMobileNumber;
    }

    public String getNomineeLandLineWithSTD() {
        return nomineeLandLineWithSTD;
    }

    public void setNomineeLandLineWithSTD(String nomineeLandLineWithSTD) {
        this.nomineeLandLineWithSTD = nomineeLandLineWithSTD;
    }

    public String getNomineeBankName() {
        return nomineeBankName;
    }

    public void setNomineeBankName(String nomineeBankName) {
        this.nomineeBankName = nomineeBankName;
    }

    public String getNomineeBankBranch() {
        return nomineeBankBranch;
    }

    public void setNomineeBankBranch(String nomineeBankBranch) {
        this.nomineeBankBranch = nomineeBankBranch;
    }

    public String getNomineeBankAccountNumber() {
        return nomineeBankAccountNumber;
    }

    public void setNomineeBankAccountNumber(String nomineeBankAccountNumber) {
        this.nomineeBankAccountNumber = nomineeBankAccountNumber;
    }

    public String getNomineeBankIfscCode() {
        return nomineeBankIfscCode;
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

        ApekshaDTO apekshaDTO = (ApekshaDTO) o;
        if(apekshaDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), apekshaDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ApekshaDTO{" +
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
