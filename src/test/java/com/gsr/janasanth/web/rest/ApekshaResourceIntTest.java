package com.gsr.janasanth.web.rest;

import com.gsr.janasanth.JanasanthwanamApp;

import com.gsr.janasanth.domain.Apeksha;
import com.gsr.janasanth.repository.ApekshaRepository;
import com.gsr.janasanth.service.ApekshaService;
import com.gsr.janasanth.repository.search.ApekshaSearchRepository;
import com.gsr.janasanth.service.dto.ApekshaDTO;
import com.gsr.janasanth.service.mapper.ApekshaMapper;
import com.gsr.janasanth.web.rest.errors.ExceptionTranslator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Base64Utils;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the ApekshaResource REST controller.
 *
 * @see ApekshaResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JanasanthwanamApp.class)
public class ApekshaResourceIntTest {

    private static final String DEFAULT_APPLICATION_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_APPLICATION_NUMBER = "BBBBBBBBBB";

    private static final String DEFAULT_BENEFICIARY_NAME = "AAAAAAAAAA";
    private static final String UPDATED_BENEFICIARY_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_DISTRICT = "AAAAAAAAAA";
    private static final String UPDATED_DISTRICT = "BBBBBBBBBB";

    private static final String DEFAULT_GENDER = "AAAAAAAAAA";
    private static final String UPDATED_GENDER = "BBBBBBBBBB";

    private static final String DEFAULT_FATHERS_NAME = "AAAAAAAAAA";
    private static final String UPDATED_FATHERS_NAME = "BBBBBBBBBB";

    private static final Integer DEFAULT_AGE = 1;
    private static final Integer UPDATED_AGE = 2;

    private static final LocalDate DEFAULT_DATE_OF_BIRTH = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_OF_BIRTH = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_AADHAR_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_AADHAR_NUMBER = "BBBBBBBBBB";

    private static final String DEFAULT_RATION_CARD_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_RATION_CARD_NUMBER = "BBBBBBBBBB";

    private static final String DEFAULT_RATION_CARD_CATEGORY = "AAAAAAAAAA";
    private static final String UPDATED_RATION_CARD_CATEGORY = "BBBBBBBBBB";

    private static final String DEFAULT_CASTE = "AAAAAAAAAA";
    private static final String UPDATED_CASTE = "BBBBBBBBBB";

    private static final String DEFAULT_RELIGION = "AAAAAAAAAA";
    private static final String UPDATED_RELIGION = "BBBBBBBBBB";

    private static final String DEFAULT_HOUSE_NAME = "AAAAAAAAAA";
    private static final String UPDATED_HOUSE_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_HOUSE_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_HOUSE_NUMBER = "BBBBBBBBBB";

    private static final String DEFAULT_TC_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_TC_NUMBER = "BBBBBBBBBB";

    private static final String DEFAULT_VILLAGE = "AAAAAAAAAA";
    private static final String UPDATED_VILLAGE = "BBBBBBBBBB";

    private static final String DEFAULT_PANCHAYAT = "AAAAAAAAAA";
    private static final String UPDATED_PANCHAYAT = "BBBBBBBBBB";

    private static final String DEFAULT_POST_OFFICE = "AAAAAAAAAA";
    private static final String UPDATED_POST_OFFICE = "BBBBBBBBBB";

    private static final String DEFAULT_MOBILE_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_MOBILE_NUMBER = "BBBBBBBBBB";

    private static final String DEFAULT_LAND_LINE_WITH_STD = "AAAAAAAAAA";
    private static final String UPDATED_LAND_LINE_WITH_STD = "BBBBBBBBBB";

    private static final String DEFAULT_PIN_CODE = "AAAAAAAAAA";
    private static final String UPDATED_PIN_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_OCCUPATION = "AAAAAAAAAA";
    private static final String UPDATED_OCCUPATION = "BBBBBBBBBB";

    private static final Double DEFAULT_ANNUAL_INCOME = 1D;
    private static final Double UPDATED_ANNUAL_INCOME = 2D;

    private static final String DEFAULT_FAMILY_DETAILS = "AAAAAAAAAA";
    private static final String UPDATED_FAMILY_DETAILS = "BBBBBBBBBB";

    private static final String DEFAULT_LAND_TOTAL_CENT = "AAAAAAAAAA";
    private static final String UPDATED_LAND_TOTAL_CENT = "BBBBBBBBBB";

    private static final String DEFAULT_LAND_THALUK = "AAAAAAAAAA";
    private static final String UPDATED_LAND_THALUK = "BBBBBBBBBB";

    private static final String DEFAULT_LAND_VILLAGE = "AAAAAAAAAA";
    private static final String UPDATED_LAND_VILLAGE = "BBBBBBBBBB";

    private static final String DEFAULT_LAND_DISTRICT = "AAAAAAAAAA";
    private static final String UPDATED_LAND_DISTRICT = "BBBBBBBBBB";

    private static final String DEFAULT_THALUK = "AAAAAAAAAA";
    private static final String UPDATED_THALUK = "BBBBBBBBBB";

    private static final String DEFAULT_REQUIREMENT_PURPOSE = "AAAAAAAAAA";
    private static final String UPDATED_REQUIREMENT_PURPOSE = "BBBBBBBBBB";

    private static final String DEFAULT_RECOMMENDATION = "AAAAAAAAAA";
    private static final String UPDATED_RECOMMENDATION = "BBBBBBBBBB";

    private static final String DEFAULT_HOSPITAL_NAME = "AAAAAAAAAA";
    private static final String UPDATED_HOSPITAL_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_TREATMENT_HISTORY = "AAAAAAAAAA";
    private static final String UPDATED_TREATMENT_HISTORY = "BBBBBBBBBB";

    private static final Double DEFAULT_EXPECTED_AMOUNT = 1D;
    private static final Double UPDATED_EXPECTED_AMOUNT = 2D;

    private static final String DEFAULT_BANK_NAME = "AAAAAAAAAA";
    private static final String UPDATED_BANK_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_BANK_BRANCH_NAME = "AAAAAAAAAA";
    private static final String UPDATED_BANK_BRANCH_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_BANK_ACCOUNT_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_BANK_ACCOUNT_NUMBER = "BBBBBBBBBB";

    private static final String DEFAULT_BANK_IFSC_CODE = "AAAAAAAAAA";
    private static final String UPDATED_BANK_IFSC_CODE = "BBBBBBBBBB";

    private static final byte[] DEFAULT_ADDITIONAL_DOCUMENTS = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_ADDITIONAL_DOCUMENTS = TestUtil.createByteArray(2, "1");
    private static final String DEFAULT_ADDITIONAL_DOCUMENTS_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_ADDITIONAL_DOCUMENTS_CONTENT_TYPE = "image/png";

    private static final String DEFAULT_REMARKS = "AAAAAAAAAA";
    private static final String UPDATED_REMARKS = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_DATE_OF_APPLCATION = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_OF_APPLCATION = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_NOMINEE_AVAILABLE = "AAAAAAAAAA";
    private static final String UPDATED_NOMINEE_AVAILABLE = "BBBBBBBBBB";

    private static final String DEFAULT_NOMINEE_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NOMINEE_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_NOMINEE_GENDER = "AAAAAAAAAA";
    private static final String UPDATED_NOMINEE_GENDER = "BBBBBBBBBB";

    private static final Integer DEFAULT_NOMINEE_AGE = 1;
    private static final Integer UPDATED_NOMINEE_AGE = 2;

    private static final String DEFAULT_NOMINEE_RELATIONSHIP = "AAAAAAAAAA";
    private static final String UPDATED_NOMINEE_RELATIONSHIP = "BBBBBBBBBB";

    private static final String DEFAULT_NOMINEE_HOUSE_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NOMINEE_HOUSE_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_NOMINEE_HOUSE_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_NOMINEE_HOUSE_NUMBER = "BBBBBBBBBB";

    private static final String DEFAULT_NOMINEE_TC_NO = "AAAAAAAAAA";
    private static final String UPDATED_NOMINEE_TC_NO = "BBBBBBBBBB";

    private static final String DEFAULT_NOMINEE_VILLAGE = "AAAAAAAAAA";
    private static final String UPDATED_NOMINEE_VILLAGE = "BBBBBBBBBB";

    private static final String DEFAULT_NOMINEE_THALUK = "AAAAAAAAAA";
    private static final String UPDATED_NOMINEE_THALUK = "BBBBBBBBBB";

    private static final String DEFAULT_NOMINEE_PANCHAYAT = "AAAAAAAAAA";
    private static final String UPDATED_NOMINEE_PANCHAYAT = "BBBBBBBBBB";

    private static final String DEFAULT_NOMINEE_POST_OFFICE = "AAAAAAAAAA";
    private static final String UPDATED_NOMINEE_POST_OFFICE = "BBBBBBBBBB";

    private static final String DEFAULT_NOMINEE_PIN_CODE = "AAAAAAAAAA";
    private static final String UPDATED_NOMINEE_PIN_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_NOMINEE_MOBILE_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_NOMINEE_MOBILE_NUMBER = "BBBBBBBBBB";

    private static final String DEFAULT_NOMINEE_LAND_LINE_WITH_STD = "AAAAAAAAAA";
    private static final String UPDATED_NOMINEE_LAND_LINE_WITH_STD = "BBBBBBBBBB";

    private static final String DEFAULT_NOMINEE_BANK_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NOMINEE_BANK_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_NOMINEE_BANK_BRANCH = "AAAAAAAAAA";
    private static final String UPDATED_NOMINEE_BANK_BRANCH = "BBBBBBBBBB";

    private static final String DEFAULT_NOMINEE_BANK_ACCOUNT_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_NOMINEE_BANK_ACCOUNT_NUMBER = "BBBBBBBBBB";

    private static final String DEFAULT_NOMINEE_BANK_IFSC_CODE = "AAAAAAAAAA";
    private static final String UPDATED_NOMINEE_BANK_IFSC_CODE = "BBBBBBBBBB";

    @Autowired
    private ApekshaRepository apekshaRepository;

    @Autowired
    private ApekshaMapper apekshaMapper;

    @Autowired
    private ApekshaService apekshaService;

    @Autowired
    private ApekshaSearchRepository apekshaSearchRepository;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restApekshaMockMvc;

    private Apeksha apeksha;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        ApekshaResource apekshaResource = new ApekshaResource(apekshaService);
        this.restApekshaMockMvc = MockMvcBuilders.standaloneSetup(apekshaResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setMessageConverters(jacksonMessageConverter).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Apeksha createEntity(EntityManager em) {
        Apeksha apeksha = new Apeksha()
            .applicationNumber(DEFAULT_APPLICATION_NUMBER)
            .beneficiaryName(DEFAULT_BENEFICIARY_NAME)
            .district(DEFAULT_DISTRICT)
            .gender(DEFAULT_GENDER)
            .fathersName(DEFAULT_FATHERS_NAME)
            .age(DEFAULT_AGE)
            .dateOfBirth(DEFAULT_DATE_OF_BIRTH)
            .aadharNumber(DEFAULT_AADHAR_NUMBER)
            .rationCardNumber(DEFAULT_RATION_CARD_NUMBER)
            .rationCardCategory(DEFAULT_RATION_CARD_CATEGORY)
            .caste(DEFAULT_CASTE)
            .religion(DEFAULT_RELIGION)
            .houseName(DEFAULT_HOUSE_NAME)
            .houseNumber(DEFAULT_HOUSE_NUMBER)
            .tcNumber(DEFAULT_TC_NUMBER)
            .village(DEFAULT_VILLAGE)
            .panchayat(DEFAULT_PANCHAYAT)
            .postOffice(DEFAULT_POST_OFFICE)
            .mobileNumber(DEFAULT_MOBILE_NUMBER)
            .landLineWithSTD(DEFAULT_LAND_LINE_WITH_STD)
            .pinCode(DEFAULT_PIN_CODE)
            .occupation(DEFAULT_OCCUPATION)
            .annualIncome(DEFAULT_ANNUAL_INCOME)
            .familyDetails(DEFAULT_FAMILY_DETAILS)
            .landTotalCent(DEFAULT_LAND_TOTAL_CENT)
            .landThaluk(DEFAULT_LAND_THALUK)
            .landVillage(DEFAULT_LAND_VILLAGE)
            .landDistrict(DEFAULT_LAND_DISTRICT)
            .thaluk(DEFAULT_THALUK)
            .requirementPurpose(DEFAULT_REQUIREMENT_PURPOSE)
            .recommendation(DEFAULT_RECOMMENDATION)
            .hospitalName(DEFAULT_HOSPITAL_NAME)
            .treatmentHistory(DEFAULT_TREATMENT_HISTORY)
            .expectedAmount(DEFAULT_EXPECTED_AMOUNT)
            .bankName(DEFAULT_BANK_NAME)
            .bankBranchName(DEFAULT_BANK_BRANCH_NAME)
            .bankAccountNumber(DEFAULT_BANK_ACCOUNT_NUMBER)
            .bankIfscCode(DEFAULT_BANK_IFSC_CODE)
            .additionalDocuments(DEFAULT_ADDITIONAL_DOCUMENTS)
            .additionalDocumentsContentType(DEFAULT_ADDITIONAL_DOCUMENTS_CONTENT_TYPE)
            .remarks(DEFAULT_REMARKS)
            .dateOfApplcation(DEFAULT_DATE_OF_APPLCATION)
            .nomineeAvailable(DEFAULT_NOMINEE_AVAILABLE)
            .nomineeName(DEFAULT_NOMINEE_NAME)
            .nomineeGender(DEFAULT_NOMINEE_GENDER)
            .nomineeAge(DEFAULT_NOMINEE_AGE)
            .nomineeRelationship(DEFAULT_NOMINEE_RELATIONSHIP)
            .nomineeHouseName(DEFAULT_NOMINEE_HOUSE_NAME)
            .nomineeHouseNumber(DEFAULT_NOMINEE_HOUSE_NUMBER)
            .nomineeTcNo(DEFAULT_NOMINEE_TC_NO)
            .nomineeVillage(DEFAULT_NOMINEE_VILLAGE)
            .nomineeThaluk(DEFAULT_NOMINEE_THALUK)
            .nomineePanchayat(DEFAULT_NOMINEE_PANCHAYAT)
            .nomineePostOffice(DEFAULT_NOMINEE_POST_OFFICE)
            .nomineePinCode(DEFAULT_NOMINEE_PIN_CODE)
            .nomineeMobileNumber(DEFAULT_NOMINEE_MOBILE_NUMBER)
            .nomineeLandLineWithSTD(DEFAULT_NOMINEE_LAND_LINE_WITH_STD)
            .nomineeBankName(DEFAULT_NOMINEE_BANK_NAME)
            .nomineeBankBranch(DEFAULT_NOMINEE_BANK_BRANCH)
            .nomineeBankAccountNumber(DEFAULT_NOMINEE_BANK_ACCOUNT_NUMBER)
            .nomineeBankIfscCode(DEFAULT_NOMINEE_BANK_IFSC_CODE);
        return apeksha;
    }

    @Before
    public void initTest() {
        apekshaSearchRepository.deleteAll();
        apeksha = createEntity(em);
    }

    @Test
    @Transactional
    public void createApeksha() throws Exception {
        int databaseSizeBeforeCreate = apekshaRepository.findAll().size();

        // Create the Apeksha
        ApekshaDTO apekshaDTO = apekshaMapper.toDto(apeksha);
        restApekshaMockMvc.perform(post("/api/apekshas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(apekshaDTO)))
            .andExpect(status().isCreated());

        // Validate the Apeksha in the database
        List<Apeksha> apekshaList = apekshaRepository.findAll();
        assertThat(apekshaList).hasSize(databaseSizeBeforeCreate + 1);
        Apeksha testApeksha = apekshaList.get(apekshaList.size() - 1);
        assertThat(testApeksha.getApplicationNumber()).isEqualTo(DEFAULT_APPLICATION_NUMBER);
        assertThat(testApeksha.getBeneficiaryName()).isEqualTo(DEFAULT_BENEFICIARY_NAME);
        assertThat(testApeksha.getDistrict()).isEqualTo(DEFAULT_DISTRICT);
        assertThat(testApeksha.getGender()).isEqualTo(DEFAULT_GENDER);
        assertThat(testApeksha.getFathersName()).isEqualTo(DEFAULT_FATHERS_NAME);
        assertThat(testApeksha.getAge()).isEqualTo(DEFAULT_AGE);
        assertThat(testApeksha.getDateOfBirth()).isEqualTo(DEFAULT_DATE_OF_BIRTH);
        assertThat(testApeksha.getAadharNumber()).isEqualTo(DEFAULT_AADHAR_NUMBER);
        assertThat(testApeksha.getRationCardNumber()).isEqualTo(DEFAULT_RATION_CARD_NUMBER);
        assertThat(testApeksha.getRationCardCategory()).isEqualTo(DEFAULT_RATION_CARD_CATEGORY);
        assertThat(testApeksha.getCaste()).isEqualTo(DEFAULT_CASTE);
        assertThat(testApeksha.getReligion()).isEqualTo(DEFAULT_RELIGION);
        assertThat(testApeksha.getHouseName()).isEqualTo(DEFAULT_HOUSE_NAME);
        assertThat(testApeksha.getHouseNumber()).isEqualTo(DEFAULT_HOUSE_NUMBER);
        assertThat(testApeksha.getTcNumber()).isEqualTo(DEFAULT_TC_NUMBER);
        assertThat(testApeksha.getVillage()).isEqualTo(DEFAULT_VILLAGE);
        assertThat(testApeksha.getPanchayat()).isEqualTo(DEFAULT_PANCHAYAT);
        assertThat(testApeksha.getPostOffice()).isEqualTo(DEFAULT_POST_OFFICE);
        assertThat(testApeksha.getMobileNumber()).isEqualTo(DEFAULT_MOBILE_NUMBER);
        assertThat(testApeksha.getLandLineWithSTD()).isEqualTo(DEFAULT_LAND_LINE_WITH_STD);
        assertThat(testApeksha.getPinCode()).isEqualTo(DEFAULT_PIN_CODE);
        assertThat(testApeksha.getOccupation()).isEqualTo(DEFAULT_OCCUPATION);
        assertThat(testApeksha.getAnnualIncome()).isEqualTo(DEFAULT_ANNUAL_INCOME);
        assertThat(testApeksha.getFamilyDetails()).isEqualTo(DEFAULT_FAMILY_DETAILS);
        assertThat(testApeksha.getLandTotalCent()).isEqualTo(DEFAULT_LAND_TOTAL_CENT);
        assertThat(testApeksha.getLandThaluk()).isEqualTo(DEFAULT_LAND_THALUK);
        assertThat(testApeksha.getLandVillage()).isEqualTo(DEFAULT_LAND_VILLAGE);
        assertThat(testApeksha.getLandDistrict()).isEqualTo(DEFAULT_LAND_DISTRICT);
        assertThat(testApeksha.getThaluk()).isEqualTo(DEFAULT_THALUK);
        assertThat(testApeksha.getRequirementPurpose()).isEqualTo(DEFAULT_REQUIREMENT_PURPOSE);
        assertThat(testApeksha.getRecommendation()).isEqualTo(DEFAULT_RECOMMENDATION);
        assertThat(testApeksha.getHospitalName()).isEqualTo(DEFAULT_HOSPITAL_NAME);
        assertThat(testApeksha.getTreatmentHistory()).isEqualTo(DEFAULT_TREATMENT_HISTORY);
        assertThat(testApeksha.getExpectedAmount()).isEqualTo(DEFAULT_EXPECTED_AMOUNT);
        assertThat(testApeksha.getBankName()).isEqualTo(DEFAULT_BANK_NAME);
        assertThat(testApeksha.getBankBranchName()).isEqualTo(DEFAULT_BANK_BRANCH_NAME);
        assertThat(testApeksha.getBankAccountNumber()).isEqualTo(DEFAULT_BANK_ACCOUNT_NUMBER);
        assertThat(testApeksha.getBankIfscCode()).isEqualTo(DEFAULT_BANK_IFSC_CODE);
        assertThat(testApeksha.getAdditionalDocuments()).isEqualTo(DEFAULT_ADDITIONAL_DOCUMENTS);
        assertThat(testApeksha.getAdditionalDocumentsContentType()).isEqualTo(DEFAULT_ADDITIONAL_DOCUMENTS_CONTENT_TYPE);
        assertThat(testApeksha.getRemarks()).isEqualTo(DEFAULT_REMARKS);
        assertThat(testApeksha.getDateOfApplcation()).isEqualTo(DEFAULT_DATE_OF_APPLCATION);
        assertThat(testApeksha.getNomineeAvailable()).isEqualTo(DEFAULT_NOMINEE_AVAILABLE);
        assertThat(testApeksha.getNomineeName()).isEqualTo(DEFAULT_NOMINEE_NAME);
        assertThat(testApeksha.getNomineeGender()).isEqualTo(DEFAULT_NOMINEE_GENDER);
        assertThat(testApeksha.getNomineeAge()).isEqualTo(DEFAULT_NOMINEE_AGE);
        assertThat(testApeksha.getNomineeRelationship()).isEqualTo(DEFAULT_NOMINEE_RELATIONSHIP);
        assertThat(testApeksha.getNomineeHouseName()).isEqualTo(DEFAULT_NOMINEE_HOUSE_NAME);
        assertThat(testApeksha.getNomineeHouseNumber()).isEqualTo(DEFAULT_NOMINEE_HOUSE_NUMBER);
        assertThat(testApeksha.getNomineeTcNo()).isEqualTo(DEFAULT_NOMINEE_TC_NO);
        assertThat(testApeksha.getNomineeVillage()).isEqualTo(DEFAULT_NOMINEE_VILLAGE);
        assertThat(testApeksha.getNomineeThaluk()).isEqualTo(DEFAULT_NOMINEE_THALUK);
        assertThat(testApeksha.getNomineePanchayat()).isEqualTo(DEFAULT_NOMINEE_PANCHAYAT);
        assertThat(testApeksha.getNomineePostOffice()).isEqualTo(DEFAULT_NOMINEE_POST_OFFICE);
        assertThat(testApeksha.getNomineePinCode()).isEqualTo(DEFAULT_NOMINEE_PIN_CODE);
        assertThat(testApeksha.getNomineeMobileNumber()).isEqualTo(DEFAULT_NOMINEE_MOBILE_NUMBER);
        assertThat(testApeksha.getNomineeLandLineWithSTD()).isEqualTo(DEFAULT_NOMINEE_LAND_LINE_WITH_STD);
        assertThat(testApeksha.getNomineeBankName()).isEqualTo(DEFAULT_NOMINEE_BANK_NAME);
        assertThat(testApeksha.getNomineeBankBranch()).isEqualTo(DEFAULT_NOMINEE_BANK_BRANCH);
        assertThat(testApeksha.getNomineeBankAccountNumber()).isEqualTo(DEFAULT_NOMINEE_BANK_ACCOUNT_NUMBER);
        assertThat(testApeksha.getNomineeBankIfscCode()).isEqualTo(DEFAULT_NOMINEE_BANK_IFSC_CODE);

        // Validate the Apeksha in Elasticsearch
        Apeksha apekshaEs = apekshaSearchRepository.findOne(testApeksha.getId());
        assertThat(apekshaEs).isEqualToComparingFieldByField(testApeksha);
    }

    @Test
    @Transactional
    public void createApekshaWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = apekshaRepository.findAll().size();

        // Create the Apeksha with an existing ID
        apeksha.setId(1L);
        ApekshaDTO apekshaDTO = apekshaMapper.toDto(apeksha);

        // An entity with an existing ID cannot be created, so this API call must fail
        restApekshaMockMvc.perform(post("/api/apekshas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(apekshaDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Alice in the database
        List<Apeksha> apekshaList = apekshaRepository.findAll();
        assertThat(apekshaList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void checkBeneficiaryNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = apekshaRepository.findAll().size();
        // set the field null
        apeksha.setBeneficiaryName(null);

        // Create the Apeksha, which fails.
        ApekshaDTO apekshaDTO = apekshaMapper.toDto(apeksha);

        restApekshaMockMvc.perform(post("/api/apekshas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(apekshaDTO)))
            .andExpect(status().isBadRequest());

        List<Apeksha> apekshaList = apekshaRepository.findAll();
        assertThat(apekshaList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkDistrictIsRequired() throws Exception {
        int databaseSizeBeforeTest = apekshaRepository.findAll().size();
        // set the field null
        apeksha.setDistrict(null);

        // Create the Apeksha, which fails.
        ApekshaDTO apekshaDTO = apekshaMapper.toDto(apeksha);

        restApekshaMockMvc.perform(post("/api/apekshas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(apekshaDTO)))
            .andExpect(status().isBadRequest());

        List<Apeksha> apekshaList = apekshaRepository.findAll();
        assertThat(apekshaList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkGenderIsRequired() throws Exception {
        int databaseSizeBeforeTest = apekshaRepository.findAll().size();
        // set the field null
        apeksha.setGender(null);

        // Create the Apeksha, which fails.
        ApekshaDTO apekshaDTO = apekshaMapper.toDto(apeksha);

        restApekshaMockMvc.perform(post("/api/apekshas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(apekshaDTO)))
            .andExpect(status().isBadRequest());

        List<Apeksha> apekshaList = apekshaRepository.findAll();
        assertThat(apekshaList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkAgeIsRequired() throws Exception {
        int databaseSizeBeforeTest = apekshaRepository.findAll().size();
        // set the field null
        apeksha.setAge(null);

        // Create the Apeksha, which fails.
        ApekshaDTO apekshaDTO = apekshaMapper.toDto(apeksha);

        restApekshaMockMvc.perform(post("/api/apekshas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(apekshaDTO)))
            .andExpect(status().isBadRequest());

        List<Apeksha> apekshaList = apekshaRepository.findAll();
        assertThat(apekshaList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkAadharNumberIsRequired() throws Exception {
        int databaseSizeBeforeTest = apekshaRepository.findAll().size();
        // set the field null
        apeksha.setAadharNumber(null);

        // Create the Apeksha, which fails.
        ApekshaDTO apekshaDTO = apekshaMapper.toDto(apeksha);

        restApekshaMockMvc.perform(post("/api/apekshas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(apekshaDTO)))
            .andExpect(status().isBadRequest());

        List<Apeksha> apekshaList = apekshaRepository.findAll();
        assertThat(apekshaList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkRationCardNumberIsRequired() throws Exception {
        int databaseSizeBeforeTest = apekshaRepository.findAll().size();
        // set the field null
        apeksha.setRationCardNumber(null);

        // Create the Apeksha, which fails.
        ApekshaDTO apekshaDTO = apekshaMapper.toDto(apeksha);

        restApekshaMockMvc.perform(post("/api/apekshas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(apekshaDTO)))
            .andExpect(status().isBadRequest());

        List<Apeksha> apekshaList = apekshaRepository.findAll();
        assertThat(apekshaList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkCasteIsRequired() throws Exception {
        int databaseSizeBeforeTest = apekshaRepository.findAll().size();
        // set the field null
        apeksha.setCaste(null);

        // Create the Apeksha, which fails.
        ApekshaDTO apekshaDTO = apekshaMapper.toDto(apeksha);

        restApekshaMockMvc.perform(post("/api/apekshas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(apekshaDTO)))
            .andExpect(status().isBadRequest());

        List<Apeksha> apekshaList = apekshaRepository.findAll();
        assertThat(apekshaList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkReligionIsRequired() throws Exception {
        int databaseSizeBeforeTest = apekshaRepository.findAll().size();
        // set the field null
        apeksha.setReligion(null);

        // Create the Apeksha, which fails.
        ApekshaDTO apekshaDTO = apekshaMapper.toDto(apeksha);

        restApekshaMockMvc.perform(post("/api/apekshas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(apekshaDTO)))
            .andExpect(status().isBadRequest());

        List<Apeksha> apekshaList = apekshaRepository.findAll();
        assertThat(apekshaList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkVillageIsRequired() throws Exception {
        int databaseSizeBeforeTest = apekshaRepository.findAll().size();
        // set the field null
        apeksha.setVillage(null);

        // Create the Apeksha, which fails.
        ApekshaDTO apekshaDTO = apekshaMapper.toDto(apeksha);

        restApekshaMockMvc.perform(post("/api/apekshas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(apekshaDTO)))
            .andExpect(status().isBadRequest());

        List<Apeksha> apekshaList = apekshaRepository.findAll();
        assertThat(apekshaList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkMobileNumberIsRequired() throws Exception {
        int databaseSizeBeforeTest = apekshaRepository.findAll().size();
        // set the field null
        apeksha.setMobileNumber(null);

        // Create the Apeksha, which fails.
        ApekshaDTO apekshaDTO = apekshaMapper.toDto(apeksha);

        restApekshaMockMvc.perform(post("/api/apekshas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(apekshaDTO)))
            .andExpect(status().isBadRequest());

        List<Apeksha> apekshaList = apekshaRepository.findAll();
        assertThat(apekshaList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkAnnualIncomeIsRequired() throws Exception {
        int databaseSizeBeforeTest = apekshaRepository.findAll().size();
        // set the field null
        apeksha.setAnnualIncome(null);

        // Create the Apeksha, which fails.
        ApekshaDTO apekshaDTO = apekshaMapper.toDto(apeksha);

        restApekshaMockMvc.perform(post("/api/apekshas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(apekshaDTO)))
            .andExpect(status().isBadRequest());

        List<Apeksha> apekshaList = apekshaRepository.findAll();
        assertThat(apekshaList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkRequirementPurposeIsRequired() throws Exception {
        int databaseSizeBeforeTest = apekshaRepository.findAll().size();
        // set the field null
        apeksha.setRequirementPurpose(null);

        // Create the Apeksha, which fails.
        ApekshaDTO apekshaDTO = apekshaMapper.toDto(apeksha);

        restApekshaMockMvc.perform(post("/api/apekshas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(apekshaDTO)))
            .andExpect(status().isBadRequest());

        List<Apeksha> apekshaList = apekshaRepository.findAll();
        assertThat(apekshaList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkHospitalNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = apekshaRepository.findAll().size();
        // set the field null
        apeksha.setHospitalName(null);

        // Create the Apeksha, which fails.
        ApekshaDTO apekshaDTO = apekshaMapper.toDto(apeksha);

        restApekshaMockMvc.perform(post("/api/apekshas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(apekshaDTO)))
            .andExpect(status().isBadRequest());

        List<Apeksha> apekshaList = apekshaRepository.findAll();
        assertThat(apekshaList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkExpectedAmountIsRequired() throws Exception {
        int databaseSizeBeforeTest = apekshaRepository.findAll().size();
        // set the field null
        apeksha.setExpectedAmount(null);

        // Create the Apeksha, which fails.
        ApekshaDTO apekshaDTO = apekshaMapper.toDto(apeksha);

        restApekshaMockMvc.perform(post("/api/apekshas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(apekshaDTO)))
            .andExpect(status().isBadRequest());

        List<Apeksha> apekshaList = apekshaRepository.findAll();
        assertThat(apekshaList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllApekshas() throws Exception {
        // Initialize the database
        apekshaRepository.saveAndFlush(apeksha);

        // Get all the apekshaList
        restApekshaMockMvc.perform(get("/api/apekshas?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(apeksha.getId().intValue())))
            .andExpect(jsonPath("$.[*].applicationNumber").value(hasItem(DEFAULT_APPLICATION_NUMBER.toString())))
            .andExpect(jsonPath("$.[*].beneficiaryName").value(hasItem(DEFAULT_BENEFICIARY_NAME.toString())))
            .andExpect(jsonPath("$.[*].district").value(hasItem(DEFAULT_DISTRICT.toString())))
            .andExpect(jsonPath("$.[*].gender").value(hasItem(DEFAULT_GENDER.toString())))
            .andExpect(jsonPath("$.[*].fathersName").value(hasItem(DEFAULT_FATHERS_NAME.toString())))
            .andExpect(jsonPath("$.[*].age").value(hasItem(DEFAULT_AGE)))
            .andExpect(jsonPath("$.[*].dateOfBirth").value(hasItem(DEFAULT_DATE_OF_BIRTH.toString())))
            .andExpect(jsonPath("$.[*].aadharNumber").value(hasItem(DEFAULT_AADHAR_NUMBER.toString())))
            .andExpect(jsonPath("$.[*].rationCardNumber").value(hasItem(DEFAULT_RATION_CARD_NUMBER.toString())))
            .andExpect(jsonPath("$.[*].rationCardCategory").value(hasItem(DEFAULT_RATION_CARD_CATEGORY.toString())))
            .andExpect(jsonPath("$.[*].caste").value(hasItem(DEFAULT_CASTE.toString())))
            .andExpect(jsonPath("$.[*].religion").value(hasItem(DEFAULT_RELIGION.toString())))
            .andExpect(jsonPath("$.[*].houseName").value(hasItem(DEFAULT_HOUSE_NAME.toString())))
            .andExpect(jsonPath("$.[*].houseNumber").value(hasItem(DEFAULT_HOUSE_NUMBER.toString())))
            .andExpect(jsonPath("$.[*].tcNumber").value(hasItem(DEFAULT_TC_NUMBER.toString())))
            .andExpect(jsonPath("$.[*].village").value(hasItem(DEFAULT_VILLAGE.toString())))
            .andExpect(jsonPath("$.[*].panchayat").value(hasItem(DEFAULT_PANCHAYAT.toString())))
            .andExpect(jsonPath("$.[*].postOffice").value(hasItem(DEFAULT_POST_OFFICE.toString())))
            .andExpect(jsonPath("$.[*].mobileNumber").value(hasItem(DEFAULT_MOBILE_NUMBER.toString())))
            .andExpect(jsonPath("$.[*].landLineWithSTD").value(hasItem(DEFAULT_LAND_LINE_WITH_STD.toString())))
            .andExpect(jsonPath("$.[*].pinCode").value(hasItem(DEFAULT_PIN_CODE.toString())))
            .andExpect(jsonPath("$.[*].occupation").value(hasItem(DEFAULT_OCCUPATION.toString())))
            .andExpect(jsonPath("$.[*].annualIncome").value(hasItem(DEFAULT_ANNUAL_INCOME.doubleValue())))
            .andExpect(jsonPath("$.[*].familyDetails").value(hasItem(DEFAULT_FAMILY_DETAILS.toString())))
            .andExpect(jsonPath("$.[*].landTotalCent").value(hasItem(DEFAULT_LAND_TOTAL_CENT.toString())))
            .andExpect(jsonPath("$.[*].landThaluk").value(hasItem(DEFAULT_LAND_THALUK.toString())))
            .andExpect(jsonPath("$.[*].landVillage").value(hasItem(DEFAULT_LAND_VILLAGE.toString())))
            .andExpect(jsonPath("$.[*].landDistrict").value(hasItem(DEFAULT_LAND_DISTRICT.toString())))
            .andExpect(jsonPath("$.[*].thaluk").value(hasItem(DEFAULT_THALUK.toString())))
            .andExpect(jsonPath("$.[*].requirementPurpose").value(hasItem(DEFAULT_REQUIREMENT_PURPOSE.toString())))
            .andExpect(jsonPath("$.[*].recommendation").value(hasItem(DEFAULT_RECOMMENDATION.toString())))
            .andExpect(jsonPath("$.[*].hospitalName").value(hasItem(DEFAULT_HOSPITAL_NAME.toString())))
            .andExpect(jsonPath("$.[*].treatmentHistory").value(hasItem(DEFAULT_TREATMENT_HISTORY.toString())))
            .andExpect(jsonPath("$.[*].expectedAmount").value(hasItem(DEFAULT_EXPECTED_AMOUNT.doubleValue())))
            .andExpect(jsonPath("$.[*].bankName").value(hasItem(DEFAULT_BANK_NAME.toString())))
            .andExpect(jsonPath("$.[*].bankBranchName").value(hasItem(DEFAULT_BANK_BRANCH_NAME.toString())))
            .andExpect(jsonPath("$.[*].bankAccountNumber").value(hasItem(DEFAULT_BANK_ACCOUNT_NUMBER.toString())))
            .andExpect(jsonPath("$.[*].bankIfscCode").value(hasItem(DEFAULT_BANK_IFSC_CODE.toString())))
            .andExpect(jsonPath("$.[*].additionalDocumentsContentType").value(hasItem(DEFAULT_ADDITIONAL_DOCUMENTS_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].additionalDocuments").value(hasItem(Base64Utils.encodeToString(DEFAULT_ADDITIONAL_DOCUMENTS))))
            .andExpect(jsonPath("$.[*].remarks").value(hasItem(DEFAULT_REMARKS.toString())))
            .andExpect(jsonPath("$.[*].dateOfApplcation").value(hasItem(DEFAULT_DATE_OF_APPLCATION.toString())))
            .andExpect(jsonPath("$.[*].nomineeAvailable").value(hasItem(DEFAULT_NOMINEE_AVAILABLE.toString())))
            .andExpect(jsonPath("$.[*].nomineeName").value(hasItem(DEFAULT_NOMINEE_NAME.toString())))
            .andExpect(jsonPath("$.[*].nomineeGender").value(hasItem(DEFAULT_NOMINEE_GENDER.toString())))
            .andExpect(jsonPath("$.[*].nomineeAge").value(hasItem(DEFAULT_NOMINEE_AGE)))
            .andExpect(jsonPath("$.[*].nomineeRelationship").value(hasItem(DEFAULT_NOMINEE_RELATIONSHIP.toString())))
            .andExpect(jsonPath("$.[*].nomineeHouseName").value(hasItem(DEFAULT_NOMINEE_HOUSE_NAME.toString())))
            .andExpect(jsonPath("$.[*].nomineeHouseNumber").value(hasItem(DEFAULT_NOMINEE_HOUSE_NUMBER.toString())))
            .andExpect(jsonPath("$.[*].nomineeTcNo").value(hasItem(DEFAULT_NOMINEE_TC_NO.toString())))
            .andExpect(jsonPath("$.[*].nomineeVillage").value(hasItem(DEFAULT_NOMINEE_VILLAGE.toString())))
            .andExpect(jsonPath("$.[*].nomineeThaluk").value(hasItem(DEFAULT_NOMINEE_THALUK.toString())))
            .andExpect(jsonPath("$.[*].nomineePanchayat").value(hasItem(DEFAULT_NOMINEE_PANCHAYAT.toString())))
            .andExpect(jsonPath("$.[*].nomineePostOffice").value(hasItem(DEFAULT_NOMINEE_POST_OFFICE.toString())))
            .andExpect(jsonPath("$.[*].nomineePinCode").value(hasItem(DEFAULT_NOMINEE_PIN_CODE.toString())))
            .andExpect(jsonPath("$.[*].nomineeMobileNumber").value(hasItem(DEFAULT_NOMINEE_MOBILE_NUMBER.toString())))
            .andExpect(jsonPath("$.[*].nomineeLandLineWithSTD").value(hasItem(DEFAULT_NOMINEE_LAND_LINE_WITH_STD.toString())))
            .andExpect(jsonPath("$.[*].nomineeBankName").value(hasItem(DEFAULT_NOMINEE_BANK_NAME.toString())))
            .andExpect(jsonPath("$.[*].nomineeBankBranch").value(hasItem(DEFAULT_NOMINEE_BANK_BRANCH.toString())))
            .andExpect(jsonPath("$.[*].nomineeBankAccountNumber").value(hasItem(DEFAULT_NOMINEE_BANK_ACCOUNT_NUMBER.toString())))
            .andExpect(jsonPath("$.[*].nomineeBankIfscCode").value(hasItem(DEFAULT_NOMINEE_BANK_IFSC_CODE.toString())));
    }

    @Test
    @Transactional
    public void getApeksha() throws Exception {
        // Initialize the database
        apekshaRepository.saveAndFlush(apeksha);

        // Get the apeksha
        restApekshaMockMvc.perform(get("/api/apekshas/{id}", apeksha.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(apeksha.getId().intValue()))
            .andExpect(jsonPath("$.applicationNumber").value(DEFAULT_APPLICATION_NUMBER.toString()))
            .andExpect(jsonPath("$.beneficiaryName").value(DEFAULT_BENEFICIARY_NAME.toString()))
            .andExpect(jsonPath("$.district").value(DEFAULT_DISTRICT.toString()))
            .andExpect(jsonPath("$.gender").value(DEFAULT_GENDER.toString()))
            .andExpect(jsonPath("$.fathersName").value(DEFAULT_FATHERS_NAME.toString()))
            .andExpect(jsonPath("$.age").value(DEFAULT_AGE))
            .andExpect(jsonPath("$.dateOfBirth").value(DEFAULT_DATE_OF_BIRTH.toString()))
            .andExpect(jsonPath("$.aadharNumber").value(DEFAULT_AADHAR_NUMBER.toString()))
            .andExpect(jsonPath("$.rationCardNumber").value(DEFAULT_RATION_CARD_NUMBER.toString()))
            .andExpect(jsonPath("$.rationCardCategory").value(DEFAULT_RATION_CARD_CATEGORY.toString()))
            .andExpect(jsonPath("$.caste").value(DEFAULT_CASTE.toString()))
            .andExpect(jsonPath("$.religion").value(DEFAULT_RELIGION.toString()))
            .andExpect(jsonPath("$.houseName").value(DEFAULT_HOUSE_NAME.toString()))
            .andExpect(jsonPath("$.houseNumber").value(DEFAULT_HOUSE_NUMBER.toString()))
            .andExpect(jsonPath("$.tcNumber").value(DEFAULT_TC_NUMBER.toString()))
            .andExpect(jsonPath("$.village").value(DEFAULT_VILLAGE.toString()))
            .andExpect(jsonPath("$.panchayat").value(DEFAULT_PANCHAYAT.toString()))
            .andExpect(jsonPath("$.postOffice").value(DEFAULT_POST_OFFICE.toString()))
            .andExpect(jsonPath("$.mobileNumber").value(DEFAULT_MOBILE_NUMBER.toString()))
            .andExpect(jsonPath("$.landLineWithSTD").value(DEFAULT_LAND_LINE_WITH_STD.toString()))
            .andExpect(jsonPath("$.pinCode").value(DEFAULT_PIN_CODE.toString()))
            .andExpect(jsonPath("$.occupation").value(DEFAULT_OCCUPATION.toString()))
            .andExpect(jsonPath("$.annualIncome").value(DEFAULT_ANNUAL_INCOME.doubleValue()))
            .andExpect(jsonPath("$.familyDetails").value(DEFAULT_FAMILY_DETAILS.toString()))
            .andExpect(jsonPath("$.landTotalCent").value(DEFAULT_LAND_TOTAL_CENT.toString()))
            .andExpect(jsonPath("$.landThaluk").value(DEFAULT_LAND_THALUK.toString()))
            .andExpect(jsonPath("$.landVillage").value(DEFAULT_LAND_VILLAGE.toString()))
            .andExpect(jsonPath("$.landDistrict").value(DEFAULT_LAND_DISTRICT.toString()))
            .andExpect(jsonPath("$.thaluk").value(DEFAULT_THALUK.toString()))
            .andExpect(jsonPath("$.requirementPurpose").value(DEFAULT_REQUIREMENT_PURPOSE.toString()))
            .andExpect(jsonPath("$.recommendation").value(DEFAULT_RECOMMENDATION.toString()))
            .andExpect(jsonPath("$.hospitalName").value(DEFAULT_HOSPITAL_NAME.toString()))
            .andExpect(jsonPath("$.treatmentHistory").value(DEFAULT_TREATMENT_HISTORY.toString()))
            .andExpect(jsonPath("$.expectedAmount").value(DEFAULT_EXPECTED_AMOUNT.doubleValue()))
            .andExpect(jsonPath("$.bankName").value(DEFAULT_BANK_NAME.toString()))
            .andExpect(jsonPath("$.bankBranchName").value(DEFAULT_BANK_BRANCH_NAME.toString()))
            .andExpect(jsonPath("$.bankAccountNumber").value(DEFAULT_BANK_ACCOUNT_NUMBER.toString()))
            .andExpect(jsonPath("$.bankIfscCode").value(DEFAULT_BANK_IFSC_CODE.toString()))
            .andExpect(jsonPath("$.additionalDocumentsContentType").value(DEFAULT_ADDITIONAL_DOCUMENTS_CONTENT_TYPE))
            .andExpect(jsonPath("$.additionalDocuments").value(Base64Utils.encodeToString(DEFAULT_ADDITIONAL_DOCUMENTS)))
            .andExpect(jsonPath("$.remarks").value(DEFAULT_REMARKS.toString()))
            .andExpect(jsonPath("$.dateOfApplcation").value(DEFAULT_DATE_OF_APPLCATION.toString()))
            .andExpect(jsonPath("$.nomineeAvailable").value(DEFAULT_NOMINEE_AVAILABLE.toString()))
            .andExpect(jsonPath("$.nomineeName").value(DEFAULT_NOMINEE_NAME.toString()))
            .andExpect(jsonPath("$.nomineeGender").value(DEFAULT_NOMINEE_GENDER.toString()))
            .andExpect(jsonPath("$.nomineeAge").value(DEFAULT_NOMINEE_AGE))
            .andExpect(jsonPath("$.nomineeRelationship").value(DEFAULT_NOMINEE_RELATIONSHIP.toString()))
            .andExpect(jsonPath("$.nomineeHouseName").value(DEFAULT_NOMINEE_HOUSE_NAME.toString()))
            .andExpect(jsonPath("$.nomineeHouseNumber").value(DEFAULT_NOMINEE_HOUSE_NUMBER.toString()))
            .andExpect(jsonPath("$.nomineeTcNo").value(DEFAULT_NOMINEE_TC_NO.toString()))
            .andExpect(jsonPath("$.nomineeVillage").value(DEFAULT_NOMINEE_VILLAGE.toString()))
            .andExpect(jsonPath("$.nomineeThaluk").value(DEFAULT_NOMINEE_THALUK.toString()))
            .andExpect(jsonPath("$.nomineePanchayat").value(DEFAULT_NOMINEE_PANCHAYAT.toString()))
            .andExpect(jsonPath("$.nomineePostOffice").value(DEFAULT_NOMINEE_POST_OFFICE.toString()))
            .andExpect(jsonPath("$.nomineePinCode").value(DEFAULT_NOMINEE_PIN_CODE.toString()))
            .andExpect(jsonPath("$.nomineeMobileNumber").value(DEFAULT_NOMINEE_MOBILE_NUMBER.toString()))
            .andExpect(jsonPath("$.nomineeLandLineWithSTD").value(DEFAULT_NOMINEE_LAND_LINE_WITH_STD.toString()))
            .andExpect(jsonPath("$.nomineeBankName").value(DEFAULT_NOMINEE_BANK_NAME.toString()))
            .andExpect(jsonPath("$.nomineeBankBranch").value(DEFAULT_NOMINEE_BANK_BRANCH.toString()))
            .andExpect(jsonPath("$.nomineeBankAccountNumber").value(DEFAULT_NOMINEE_BANK_ACCOUNT_NUMBER.toString()))
            .andExpect(jsonPath("$.nomineeBankIfscCode").value(DEFAULT_NOMINEE_BANK_IFSC_CODE.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingApeksha() throws Exception {
        // Get the apeksha
        restApekshaMockMvc.perform(get("/api/apekshas/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateApeksha() throws Exception {
        // Initialize the database
        apekshaRepository.saveAndFlush(apeksha);
        apekshaSearchRepository.save(apeksha);
        int databaseSizeBeforeUpdate = apekshaRepository.findAll().size();

        // Update the apeksha
        Apeksha updatedApeksha = apekshaRepository.findOne(apeksha.getId());
        updatedApeksha
            .applicationNumber(UPDATED_APPLICATION_NUMBER)
            .beneficiaryName(UPDATED_BENEFICIARY_NAME)
            .district(UPDATED_DISTRICT)
            .gender(UPDATED_GENDER)
            .fathersName(UPDATED_FATHERS_NAME)
            .age(UPDATED_AGE)
            .dateOfBirth(UPDATED_DATE_OF_BIRTH)
            .aadharNumber(UPDATED_AADHAR_NUMBER)
            .rationCardNumber(UPDATED_RATION_CARD_NUMBER)
            .rationCardCategory(UPDATED_RATION_CARD_CATEGORY)
            .caste(UPDATED_CASTE)
            .religion(UPDATED_RELIGION)
            .houseName(UPDATED_HOUSE_NAME)
            .houseNumber(UPDATED_HOUSE_NUMBER)
            .tcNumber(UPDATED_TC_NUMBER)
            .village(UPDATED_VILLAGE)
            .panchayat(UPDATED_PANCHAYAT)
            .postOffice(UPDATED_POST_OFFICE)
            .mobileNumber(UPDATED_MOBILE_NUMBER)
            .landLineWithSTD(UPDATED_LAND_LINE_WITH_STD)
            .pinCode(UPDATED_PIN_CODE)
            .occupation(UPDATED_OCCUPATION)
            .annualIncome(UPDATED_ANNUAL_INCOME)
            .familyDetails(UPDATED_FAMILY_DETAILS)
            .landTotalCent(UPDATED_LAND_TOTAL_CENT)
            .landThaluk(UPDATED_LAND_THALUK)
            .landVillage(UPDATED_LAND_VILLAGE)
            .landDistrict(UPDATED_LAND_DISTRICT)
            .thaluk(UPDATED_THALUK)
            .requirementPurpose(UPDATED_REQUIREMENT_PURPOSE)
            .recommendation(UPDATED_RECOMMENDATION)
            .hospitalName(UPDATED_HOSPITAL_NAME)
            .treatmentHistory(UPDATED_TREATMENT_HISTORY)
            .expectedAmount(UPDATED_EXPECTED_AMOUNT)
            .bankName(UPDATED_BANK_NAME)
            .bankBranchName(UPDATED_BANK_BRANCH_NAME)
            .bankAccountNumber(UPDATED_BANK_ACCOUNT_NUMBER)
            .bankIfscCode(UPDATED_BANK_IFSC_CODE)
            .additionalDocuments(UPDATED_ADDITIONAL_DOCUMENTS)
            .additionalDocumentsContentType(UPDATED_ADDITIONAL_DOCUMENTS_CONTENT_TYPE)
            .remarks(UPDATED_REMARKS)
            .dateOfApplcation(UPDATED_DATE_OF_APPLCATION)
            .nomineeAvailable(UPDATED_NOMINEE_AVAILABLE)
            .nomineeName(UPDATED_NOMINEE_NAME)
            .nomineeGender(UPDATED_NOMINEE_GENDER)
            .nomineeAge(UPDATED_NOMINEE_AGE)
            .nomineeRelationship(UPDATED_NOMINEE_RELATIONSHIP)
            .nomineeHouseName(UPDATED_NOMINEE_HOUSE_NAME)
            .nomineeHouseNumber(UPDATED_NOMINEE_HOUSE_NUMBER)
            .nomineeTcNo(UPDATED_NOMINEE_TC_NO)
            .nomineeVillage(UPDATED_NOMINEE_VILLAGE)
            .nomineeThaluk(UPDATED_NOMINEE_THALUK)
            .nomineePanchayat(UPDATED_NOMINEE_PANCHAYAT)
            .nomineePostOffice(UPDATED_NOMINEE_POST_OFFICE)
            .nomineePinCode(UPDATED_NOMINEE_PIN_CODE)
            .nomineeMobileNumber(UPDATED_NOMINEE_MOBILE_NUMBER)
            .nomineeLandLineWithSTD(UPDATED_NOMINEE_LAND_LINE_WITH_STD)
            .nomineeBankName(UPDATED_NOMINEE_BANK_NAME)
            .nomineeBankBranch(UPDATED_NOMINEE_BANK_BRANCH)
            .nomineeBankAccountNumber(UPDATED_NOMINEE_BANK_ACCOUNT_NUMBER)
            .nomineeBankIfscCode(UPDATED_NOMINEE_BANK_IFSC_CODE);
        ApekshaDTO apekshaDTO = apekshaMapper.toDto(updatedApeksha);

        restApekshaMockMvc.perform(put("/api/apekshas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(apekshaDTO)))
            .andExpect(status().isOk());

        // Validate the Apeksha in the database
        List<Apeksha> apekshaList = apekshaRepository.findAll();
        assertThat(apekshaList).hasSize(databaseSizeBeforeUpdate);
        Apeksha testApeksha = apekshaList.get(apekshaList.size() - 1);
        assertThat(testApeksha.getApplicationNumber()).isEqualTo(UPDATED_APPLICATION_NUMBER);
        assertThat(testApeksha.getBeneficiaryName()).isEqualTo(UPDATED_BENEFICIARY_NAME);
        assertThat(testApeksha.getDistrict()).isEqualTo(UPDATED_DISTRICT);
        assertThat(testApeksha.getGender()).isEqualTo(UPDATED_GENDER);
        assertThat(testApeksha.getFathersName()).isEqualTo(UPDATED_FATHERS_NAME);
        assertThat(testApeksha.getAge()).isEqualTo(UPDATED_AGE);
        assertThat(testApeksha.getDateOfBirth()).isEqualTo(UPDATED_DATE_OF_BIRTH);
        assertThat(testApeksha.getAadharNumber()).isEqualTo(UPDATED_AADHAR_NUMBER);
        assertThat(testApeksha.getRationCardNumber()).isEqualTo(UPDATED_RATION_CARD_NUMBER);
        assertThat(testApeksha.getRationCardCategory()).isEqualTo(UPDATED_RATION_CARD_CATEGORY);
        assertThat(testApeksha.getCaste()).isEqualTo(UPDATED_CASTE);
        assertThat(testApeksha.getReligion()).isEqualTo(UPDATED_RELIGION);
        assertThat(testApeksha.getHouseName()).isEqualTo(UPDATED_HOUSE_NAME);
        assertThat(testApeksha.getHouseNumber()).isEqualTo(UPDATED_HOUSE_NUMBER);
        assertThat(testApeksha.getTcNumber()).isEqualTo(UPDATED_TC_NUMBER);
        assertThat(testApeksha.getVillage()).isEqualTo(UPDATED_VILLAGE);
        assertThat(testApeksha.getPanchayat()).isEqualTo(UPDATED_PANCHAYAT);
        assertThat(testApeksha.getPostOffice()).isEqualTo(UPDATED_POST_OFFICE);
        assertThat(testApeksha.getMobileNumber()).isEqualTo(UPDATED_MOBILE_NUMBER);
        assertThat(testApeksha.getLandLineWithSTD()).isEqualTo(UPDATED_LAND_LINE_WITH_STD);
        assertThat(testApeksha.getPinCode()).isEqualTo(UPDATED_PIN_CODE);
        assertThat(testApeksha.getOccupation()).isEqualTo(UPDATED_OCCUPATION);
        assertThat(testApeksha.getAnnualIncome()).isEqualTo(UPDATED_ANNUAL_INCOME);
        assertThat(testApeksha.getFamilyDetails()).isEqualTo(UPDATED_FAMILY_DETAILS);
        assertThat(testApeksha.getLandTotalCent()).isEqualTo(UPDATED_LAND_TOTAL_CENT);
        assertThat(testApeksha.getLandThaluk()).isEqualTo(UPDATED_LAND_THALUK);
        assertThat(testApeksha.getLandVillage()).isEqualTo(UPDATED_LAND_VILLAGE);
        assertThat(testApeksha.getLandDistrict()).isEqualTo(UPDATED_LAND_DISTRICT);
        assertThat(testApeksha.getThaluk()).isEqualTo(UPDATED_THALUK);
        assertThat(testApeksha.getRequirementPurpose()).isEqualTo(UPDATED_REQUIREMENT_PURPOSE);
        assertThat(testApeksha.getRecommendation()).isEqualTo(UPDATED_RECOMMENDATION);
        assertThat(testApeksha.getHospitalName()).isEqualTo(UPDATED_HOSPITAL_NAME);
        assertThat(testApeksha.getTreatmentHistory()).isEqualTo(UPDATED_TREATMENT_HISTORY);
        assertThat(testApeksha.getExpectedAmount()).isEqualTo(UPDATED_EXPECTED_AMOUNT);
        assertThat(testApeksha.getBankName()).isEqualTo(UPDATED_BANK_NAME);
        assertThat(testApeksha.getBankBranchName()).isEqualTo(UPDATED_BANK_BRANCH_NAME);
        assertThat(testApeksha.getBankAccountNumber()).isEqualTo(UPDATED_BANK_ACCOUNT_NUMBER);
        assertThat(testApeksha.getBankIfscCode()).isEqualTo(UPDATED_BANK_IFSC_CODE);
        assertThat(testApeksha.getAdditionalDocuments()).isEqualTo(UPDATED_ADDITIONAL_DOCUMENTS);
        assertThat(testApeksha.getAdditionalDocumentsContentType()).isEqualTo(UPDATED_ADDITIONAL_DOCUMENTS_CONTENT_TYPE);
        assertThat(testApeksha.getRemarks()).isEqualTo(UPDATED_REMARKS);
        assertThat(testApeksha.getDateOfApplcation()).isEqualTo(UPDATED_DATE_OF_APPLCATION);
        assertThat(testApeksha.getNomineeAvailable()).isEqualTo(UPDATED_NOMINEE_AVAILABLE);
        assertThat(testApeksha.getNomineeName()).isEqualTo(UPDATED_NOMINEE_NAME);
        assertThat(testApeksha.getNomineeGender()).isEqualTo(UPDATED_NOMINEE_GENDER);
        assertThat(testApeksha.getNomineeAge()).isEqualTo(UPDATED_NOMINEE_AGE);
        assertThat(testApeksha.getNomineeRelationship()).isEqualTo(UPDATED_NOMINEE_RELATIONSHIP);
        assertThat(testApeksha.getNomineeHouseName()).isEqualTo(UPDATED_NOMINEE_HOUSE_NAME);
        assertThat(testApeksha.getNomineeHouseNumber()).isEqualTo(UPDATED_NOMINEE_HOUSE_NUMBER);
        assertThat(testApeksha.getNomineeTcNo()).isEqualTo(UPDATED_NOMINEE_TC_NO);
        assertThat(testApeksha.getNomineeVillage()).isEqualTo(UPDATED_NOMINEE_VILLAGE);
        assertThat(testApeksha.getNomineeThaluk()).isEqualTo(UPDATED_NOMINEE_THALUK);
        assertThat(testApeksha.getNomineePanchayat()).isEqualTo(UPDATED_NOMINEE_PANCHAYAT);
        assertThat(testApeksha.getNomineePostOffice()).isEqualTo(UPDATED_NOMINEE_POST_OFFICE);
        assertThat(testApeksha.getNomineePinCode()).isEqualTo(UPDATED_NOMINEE_PIN_CODE);
        assertThat(testApeksha.getNomineeMobileNumber()).isEqualTo(UPDATED_NOMINEE_MOBILE_NUMBER);
        assertThat(testApeksha.getNomineeLandLineWithSTD()).isEqualTo(UPDATED_NOMINEE_LAND_LINE_WITH_STD);
        assertThat(testApeksha.getNomineeBankName()).isEqualTo(UPDATED_NOMINEE_BANK_NAME);
        assertThat(testApeksha.getNomineeBankBranch()).isEqualTo(UPDATED_NOMINEE_BANK_BRANCH);
        assertThat(testApeksha.getNomineeBankAccountNumber()).isEqualTo(UPDATED_NOMINEE_BANK_ACCOUNT_NUMBER);
        assertThat(testApeksha.getNomineeBankIfscCode()).isEqualTo(UPDATED_NOMINEE_BANK_IFSC_CODE);

        // Validate the Apeksha in Elasticsearch
        Apeksha apekshaEs = apekshaSearchRepository.findOne(testApeksha.getId());
        assertThat(apekshaEs).isEqualToComparingFieldByField(testApeksha);
    }

    @Test
    @Transactional
    public void updateNonExistingApeksha() throws Exception {
        int databaseSizeBeforeUpdate = apekshaRepository.findAll().size();

        // Create the Apeksha
        ApekshaDTO apekshaDTO = apekshaMapper.toDto(apeksha);

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restApekshaMockMvc.perform(put("/api/apekshas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(apekshaDTO)))
            .andExpect(status().isCreated());

        // Validate the Apeksha in the database
        List<Apeksha> apekshaList = apekshaRepository.findAll();
        assertThat(apekshaList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteApeksha() throws Exception {
        // Initialize the database
        apekshaRepository.saveAndFlush(apeksha);
        apekshaSearchRepository.save(apeksha);
        int databaseSizeBeforeDelete = apekshaRepository.findAll().size();

        // Get the apeksha
        restApekshaMockMvc.perform(delete("/api/apekshas/{id}", apeksha.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate Elasticsearch is empty
        boolean apekshaExistsInEs = apekshaSearchRepository.exists(apeksha.getId());
        assertThat(apekshaExistsInEs).isFalse();

        // Validate the database is empty
        List<Apeksha> apekshaList = apekshaRepository.findAll();
        assertThat(apekshaList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void searchApeksha() throws Exception {
        // Initialize the database
        apekshaRepository.saveAndFlush(apeksha);
        apekshaSearchRepository.save(apeksha);

        // Search the apeksha
        restApekshaMockMvc.perform(get("/api/_search/apekshas?query=id:" + apeksha.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(apeksha.getId().intValue())))
            .andExpect(jsonPath("$.[*].applicationNumber").value(hasItem(DEFAULT_APPLICATION_NUMBER.toString())))
            .andExpect(jsonPath("$.[*].beneficiaryName").value(hasItem(DEFAULT_BENEFICIARY_NAME.toString())))
            .andExpect(jsonPath("$.[*].district").value(hasItem(DEFAULT_DISTRICT.toString())))
            .andExpect(jsonPath("$.[*].gender").value(hasItem(DEFAULT_GENDER.toString())))
            .andExpect(jsonPath("$.[*].fathersName").value(hasItem(DEFAULT_FATHERS_NAME.toString())))
            .andExpect(jsonPath("$.[*].age").value(hasItem(DEFAULT_AGE)))
            .andExpect(jsonPath("$.[*].dateOfBirth").value(hasItem(DEFAULT_DATE_OF_BIRTH.toString())))
            .andExpect(jsonPath("$.[*].aadharNumber").value(hasItem(DEFAULT_AADHAR_NUMBER.toString())))
            .andExpect(jsonPath("$.[*].rationCardNumber").value(hasItem(DEFAULT_RATION_CARD_NUMBER.toString())))
            .andExpect(jsonPath("$.[*].rationCardCategory").value(hasItem(DEFAULT_RATION_CARD_CATEGORY.toString())))
            .andExpect(jsonPath("$.[*].caste").value(hasItem(DEFAULT_CASTE.toString())))
            .andExpect(jsonPath("$.[*].religion").value(hasItem(DEFAULT_RELIGION.toString())))
            .andExpect(jsonPath("$.[*].houseName").value(hasItem(DEFAULT_HOUSE_NAME.toString())))
            .andExpect(jsonPath("$.[*].houseNumber").value(hasItem(DEFAULT_HOUSE_NUMBER.toString())))
            .andExpect(jsonPath("$.[*].tcNumber").value(hasItem(DEFAULT_TC_NUMBER.toString())))
            .andExpect(jsonPath("$.[*].village").value(hasItem(DEFAULT_VILLAGE.toString())))
            .andExpect(jsonPath("$.[*].panchayat").value(hasItem(DEFAULT_PANCHAYAT.toString())))
            .andExpect(jsonPath("$.[*].postOffice").value(hasItem(DEFAULT_POST_OFFICE.toString())))
            .andExpect(jsonPath("$.[*].mobileNumber").value(hasItem(DEFAULT_MOBILE_NUMBER.toString())))
            .andExpect(jsonPath("$.[*].landLineWithSTD").value(hasItem(DEFAULT_LAND_LINE_WITH_STD.toString())))
            .andExpect(jsonPath("$.[*].pinCode").value(hasItem(DEFAULT_PIN_CODE.toString())))
            .andExpect(jsonPath("$.[*].occupation").value(hasItem(DEFAULT_OCCUPATION.toString())))
            .andExpect(jsonPath("$.[*].annualIncome").value(hasItem(DEFAULT_ANNUAL_INCOME.doubleValue())))
            .andExpect(jsonPath("$.[*].familyDetails").value(hasItem(DEFAULT_FAMILY_DETAILS.toString())))
            .andExpect(jsonPath("$.[*].landTotalCent").value(hasItem(DEFAULT_LAND_TOTAL_CENT.toString())))
            .andExpect(jsonPath("$.[*].landThaluk").value(hasItem(DEFAULT_LAND_THALUK.toString())))
            .andExpect(jsonPath("$.[*].landVillage").value(hasItem(DEFAULT_LAND_VILLAGE.toString())))
            .andExpect(jsonPath("$.[*].landDistrict").value(hasItem(DEFAULT_LAND_DISTRICT.toString())))
            .andExpect(jsonPath("$.[*].thaluk").value(hasItem(DEFAULT_THALUK.toString())))
            .andExpect(jsonPath("$.[*].requirementPurpose").value(hasItem(DEFAULT_REQUIREMENT_PURPOSE.toString())))
            .andExpect(jsonPath("$.[*].recommendation").value(hasItem(DEFAULT_RECOMMENDATION.toString())))
            .andExpect(jsonPath("$.[*].hospitalName").value(hasItem(DEFAULT_HOSPITAL_NAME.toString())))
            .andExpect(jsonPath("$.[*].treatmentHistory").value(hasItem(DEFAULT_TREATMENT_HISTORY.toString())))
            .andExpect(jsonPath("$.[*].expectedAmount").value(hasItem(DEFAULT_EXPECTED_AMOUNT.doubleValue())))
            .andExpect(jsonPath("$.[*].bankName").value(hasItem(DEFAULT_BANK_NAME.toString())))
            .andExpect(jsonPath("$.[*].bankBranchName").value(hasItem(DEFAULT_BANK_BRANCH_NAME.toString())))
            .andExpect(jsonPath("$.[*].bankAccountNumber").value(hasItem(DEFAULT_BANK_ACCOUNT_NUMBER.toString())))
            .andExpect(jsonPath("$.[*].bankIfscCode").value(hasItem(DEFAULT_BANK_IFSC_CODE.toString())))
            .andExpect(jsonPath("$.[*].additionalDocumentsContentType").value(hasItem(DEFAULT_ADDITIONAL_DOCUMENTS_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].additionalDocuments").value(hasItem(Base64Utils.encodeToString(DEFAULT_ADDITIONAL_DOCUMENTS))))
            .andExpect(jsonPath("$.[*].remarks").value(hasItem(DEFAULT_REMARKS.toString())))
            .andExpect(jsonPath("$.[*].dateOfApplcation").value(hasItem(DEFAULT_DATE_OF_APPLCATION.toString())))
            .andExpect(jsonPath("$.[*].nomineeAvailable").value(hasItem(DEFAULT_NOMINEE_AVAILABLE.toString())))
            .andExpect(jsonPath("$.[*].nomineeName").value(hasItem(DEFAULT_NOMINEE_NAME.toString())))
            .andExpect(jsonPath("$.[*].nomineeGender").value(hasItem(DEFAULT_NOMINEE_GENDER.toString())))
            .andExpect(jsonPath("$.[*].nomineeAge").value(hasItem(DEFAULT_NOMINEE_AGE)))
            .andExpect(jsonPath("$.[*].nomineeRelationship").value(hasItem(DEFAULT_NOMINEE_RELATIONSHIP.toString())))
            .andExpect(jsonPath("$.[*].nomineeHouseName").value(hasItem(DEFAULT_NOMINEE_HOUSE_NAME.toString())))
            .andExpect(jsonPath("$.[*].nomineeHouseNumber").value(hasItem(DEFAULT_NOMINEE_HOUSE_NUMBER.toString())))
            .andExpect(jsonPath("$.[*].nomineeTcNo").value(hasItem(DEFAULT_NOMINEE_TC_NO.toString())))
            .andExpect(jsonPath("$.[*].nomineeVillage").value(hasItem(DEFAULT_NOMINEE_VILLAGE.toString())))
            .andExpect(jsonPath("$.[*].nomineeThaluk").value(hasItem(DEFAULT_NOMINEE_THALUK.toString())))
            .andExpect(jsonPath("$.[*].nomineePanchayat").value(hasItem(DEFAULT_NOMINEE_PANCHAYAT.toString())))
            .andExpect(jsonPath("$.[*].nomineePostOffice").value(hasItem(DEFAULT_NOMINEE_POST_OFFICE.toString())))
            .andExpect(jsonPath("$.[*].nomineePinCode").value(hasItem(DEFAULT_NOMINEE_PIN_CODE.toString())))
            .andExpect(jsonPath("$.[*].nomineeMobileNumber").value(hasItem(DEFAULT_NOMINEE_MOBILE_NUMBER.toString())))
            .andExpect(jsonPath("$.[*].nomineeLandLineWithSTD").value(hasItem(DEFAULT_NOMINEE_LAND_LINE_WITH_STD.toString())))
            .andExpect(jsonPath("$.[*].nomineeBankName").value(hasItem(DEFAULT_NOMINEE_BANK_NAME.toString())))
            .andExpect(jsonPath("$.[*].nomineeBankBranch").value(hasItem(DEFAULT_NOMINEE_BANK_BRANCH.toString())))
            .andExpect(jsonPath("$.[*].nomineeBankAccountNumber").value(hasItem(DEFAULT_NOMINEE_BANK_ACCOUNT_NUMBER.toString())))
            .andExpect(jsonPath("$.[*].nomineeBankIfscCode").value(hasItem(DEFAULT_NOMINEE_BANK_IFSC_CODE.toString())));
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Apeksha.class);
        Apeksha apeksha1 = new Apeksha();
        apeksha1.setId(1L);
        Apeksha apeksha2 = new Apeksha();
        apeksha2.setId(apeksha1.getId());
        assertThat(apeksha1).isEqualTo(apeksha2);
        apeksha2.setId(2L);
        assertThat(apeksha1).isNotEqualTo(apeksha2);
        apeksha1.setId(null);
        assertThat(apeksha1).isNotEqualTo(apeksha2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ApekshaDTO.class);
        ApekshaDTO apekshaDTO1 = new ApekshaDTO();
        apekshaDTO1.setId(1L);
        ApekshaDTO apekshaDTO2 = new ApekshaDTO();
        assertThat(apekshaDTO1).isNotEqualTo(apekshaDTO2);
        apekshaDTO2.setId(apekshaDTO1.getId());
        assertThat(apekshaDTO1).isEqualTo(apekshaDTO2);
        apekshaDTO2.setId(2L);
        assertThat(apekshaDTO1).isNotEqualTo(apekshaDTO2);
        apekshaDTO1.setId(null);
        assertThat(apekshaDTO1).isNotEqualTo(apekshaDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(apekshaMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(apekshaMapper.fromId(null)).isNull();
    }
}
