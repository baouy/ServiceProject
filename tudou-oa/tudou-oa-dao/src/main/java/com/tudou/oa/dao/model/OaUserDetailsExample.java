package com.tudou.oa.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class OaUserDetailsExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public OaUserDetailsExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria implements Serializable {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andWorkNumIsNull() {
            addCriterion("work_num is null");
            return (Criteria) this;
        }

        public Criteria andWorkNumIsNotNull() {
            addCriterion("work_num is not null");
            return (Criteria) this;
        }

        public Criteria andWorkNumEqualTo(String value) {
            addCriterion("work_num =", value, "workNum");
            return (Criteria) this;
        }

        public Criteria andWorkNumNotEqualTo(String value) {
            addCriterion("work_num <>", value, "workNum");
            return (Criteria) this;
        }

        public Criteria andWorkNumGreaterThan(String value) {
            addCriterion("work_num >", value, "workNum");
            return (Criteria) this;
        }

        public Criteria andWorkNumGreaterThanOrEqualTo(String value) {
            addCriterion("work_num >=", value, "workNum");
            return (Criteria) this;
        }

        public Criteria andWorkNumLessThan(String value) {
            addCriterion("work_num <", value, "workNum");
            return (Criteria) this;
        }

        public Criteria andWorkNumLessThanOrEqualTo(String value) {
            addCriterion("work_num <=", value, "workNum");
            return (Criteria) this;
        }

        public Criteria andWorkNumLike(String value) {
            addCriterion("work_num like", value, "workNum");
            return (Criteria) this;
        }

        public Criteria andWorkNumNotLike(String value) {
            addCriterion("work_num not like", value, "workNum");
            return (Criteria) this;
        }

        public Criteria andWorkNumIn(List<String> values) {
            addCriterion("work_num in", values, "workNum");
            return (Criteria) this;
        }

        public Criteria andWorkNumNotIn(List<String> values) {
            addCriterion("work_num not in", values, "workNum");
            return (Criteria) this;
        }

        public Criteria andWorkNumBetween(String value1, String value2) {
            addCriterion("work_num between", value1, value2, "workNum");
            return (Criteria) this;
        }

        public Criteria andWorkNumNotBetween(String value1, String value2) {
            addCriterion("work_num not between", value1, value2, "workNum");
            return (Criteria) this;
        }

        public Criteria andFlowerNameIsNull() {
            addCriterion("flower_name is null");
            return (Criteria) this;
        }

        public Criteria andFlowerNameIsNotNull() {
            addCriterion("flower_name is not null");
            return (Criteria) this;
        }

        public Criteria andFlowerNameEqualTo(String value) {
            addCriterion("flower_name =", value, "flowerName");
            return (Criteria) this;
        }

        public Criteria andFlowerNameNotEqualTo(String value) {
            addCriterion("flower_name <>", value, "flowerName");
            return (Criteria) this;
        }

        public Criteria andFlowerNameGreaterThan(String value) {
            addCriterion("flower_name >", value, "flowerName");
            return (Criteria) this;
        }

        public Criteria andFlowerNameGreaterThanOrEqualTo(String value) {
            addCriterion("flower_name >=", value, "flowerName");
            return (Criteria) this;
        }

        public Criteria andFlowerNameLessThan(String value) {
            addCriterion("flower_name <", value, "flowerName");
            return (Criteria) this;
        }

        public Criteria andFlowerNameLessThanOrEqualTo(String value) {
            addCriterion("flower_name <=", value, "flowerName");
            return (Criteria) this;
        }

        public Criteria andFlowerNameLike(String value) {
            addCriterion("flower_name like", value, "flowerName");
            return (Criteria) this;
        }

        public Criteria andFlowerNameNotLike(String value) {
            addCriterion("flower_name not like", value, "flowerName");
            return (Criteria) this;
        }

        public Criteria andFlowerNameIn(List<String> values) {
            addCriterion("flower_name in", values, "flowerName");
            return (Criteria) this;
        }

        public Criteria andFlowerNameNotIn(List<String> values) {
            addCriterion("flower_name not in", values, "flowerName");
            return (Criteria) this;
        }

        public Criteria andFlowerNameBetween(String value1, String value2) {
            addCriterion("flower_name between", value1, value2, "flowerName");
            return (Criteria) this;
        }

        public Criteria andFlowerNameNotBetween(String value1, String value2) {
            addCriterion("flower_name not between", value1, value2, "flowerName");
            return (Criteria) this;
        }

        public Criteria andCompanyMobileIsNull() {
            addCriterion("company_mobile is null");
            return (Criteria) this;
        }

        public Criteria andCompanyMobileIsNotNull() {
            addCriterion("company_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyMobileEqualTo(String value) {
            addCriterion("company_mobile =", value, "companyMobile");
            return (Criteria) this;
        }

        public Criteria andCompanyMobileNotEqualTo(String value) {
            addCriterion("company_mobile <>", value, "companyMobile");
            return (Criteria) this;
        }

        public Criteria andCompanyMobileGreaterThan(String value) {
            addCriterion("company_mobile >", value, "companyMobile");
            return (Criteria) this;
        }

        public Criteria andCompanyMobileGreaterThanOrEqualTo(String value) {
            addCriterion("company_mobile >=", value, "companyMobile");
            return (Criteria) this;
        }

        public Criteria andCompanyMobileLessThan(String value) {
            addCriterion("company_mobile <", value, "companyMobile");
            return (Criteria) this;
        }

        public Criteria andCompanyMobileLessThanOrEqualTo(String value) {
            addCriterion("company_mobile <=", value, "companyMobile");
            return (Criteria) this;
        }

        public Criteria andCompanyMobileLike(String value) {
            addCriterion("company_mobile like", value, "companyMobile");
            return (Criteria) this;
        }

        public Criteria andCompanyMobileNotLike(String value) {
            addCriterion("company_mobile not like", value, "companyMobile");
            return (Criteria) this;
        }

        public Criteria andCompanyMobileIn(List<String> values) {
            addCriterion("company_mobile in", values, "companyMobile");
            return (Criteria) this;
        }

        public Criteria andCompanyMobileNotIn(List<String> values) {
            addCriterion("company_mobile not in", values, "companyMobile");
            return (Criteria) this;
        }

        public Criteria andCompanyMobileBetween(String value1, String value2) {
            addCriterion("company_mobile between", value1, value2, "companyMobile");
            return (Criteria) this;
        }

        public Criteria andCompanyMobileNotBetween(String value1, String value2) {
            addCriterion("company_mobile not between", value1, value2, "companyMobile");
            return (Criteria) this;
        }

        public Criteria andCompanyEmailIsNull() {
            addCriterion("company_email is null");
            return (Criteria) this;
        }

        public Criteria andCompanyEmailIsNotNull() {
            addCriterion("company_email is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyEmailEqualTo(String value) {
            addCriterion("company_email =", value, "companyEmail");
            return (Criteria) this;
        }

        public Criteria andCompanyEmailNotEqualTo(String value) {
            addCriterion("company_email <>", value, "companyEmail");
            return (Criteria) this;
        }

        public Criteria andCompanyEmailGreaterThan(String value) {
            addCriterion("company_email >", value, "companyEmail");
            return (Criteria) this;
        }

        public Criteria andCompanyEmailGreaterThanOrEqualTo(String value) {
            addCriterion("company_email >=", value, "companyEmail");
            return (Criteria) this;
        }

        public Criteria andCompanyEmailLessThan(String value) {
            addCriterion("company_email <", value, "companyEmail");
            return (Criteria) this;
        }

        public Criteria andCompanyEmailLessThanOrEqualTo(String value) {
            addCriterion("company_email <=", value, "companyEmail");
            return (Criteria) this;
        }

        public Criteria andCompanyEmailLike(String value) {
            addCriterion("company_email like", value, "companyEmail");
            return (Criteria) this;
        }

        public Criteria andCompanyEmailNotLike(String value) {
            addCriterion("company_email not like", value, "companyEmail");
            return (Criteria) this;
        }

        public Criteria andCompanyEmailIn(List<String> values) {
            addCriterion("company_email in", values, "companyEmail");
            return (Criteria) this;
        }

        public Criteria andCompanyEmailNotIn(List<String> values) {
            addCriterion("company_email not in", values, "companyEmail");
            return (Criteria) this;
        }

        public Criteria andCompanyEmailBetween(String value1, String value2) {
            addCriterion("company_email between", value1, value2, "companyEmail");
            return (Criteria) this;
        }

        public Criteria andCompanyEmailNotBetween(String value1, String value2) {
            addCriterion("company_email not between", value1, value2, "companyEmail");
            return (Criteria) this;
        }

        public Criteria andRecruitmentEnumIdIsNull() {
            addCriterion("recruitment_enum_id is null");
            return (Criteria) this;
        }

        public Criteria andRecruitmentEnumIdIsNotNull() {
            addCriterion("recruitment_enum_id is not null");
            return (Criteria) this;
        }

        public Criteria andRecruitmentEnumIdEqualTo(Integer value) {
            addCriterion("recruitment_enum_id =", value, "recruitmentEnumId");
            return (Criteria) this;
        }

        public Criteria andRecruitmentEnumIdNotEqualTo(Integer value) {
            addCriterion("recruitment_enum_id <>", value, "recruitmentEnumId");
            return (Criteria) this;
        }

        public Criteria andRecruitmentEnumIdGreaterThan(Integer value) {
            addCriterion("recruitment_enum_id >", value, "recruitmentEnumId");
            return (Criteria) this;
        }

        public Criteria andRecruitmentEnumIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("recruitment_enum_id >=", value, "recruitmentEnumId");
            return (Criteria) this;
        }

        public Criteria andRecruitmentEnumIdLessThan(Integer value) {
            addCriterion("recruitment_enum_id <", value, "recruitmentEnumId");
            return (Criteria) this;
        }

        public Criteria andRecruitmentEnumIdLessThanOrEqualTo(Integer value) {
            addCriterion("recruitment_enum_id <=", value, "recruitmentEnumId");
            return (Criteria) this;
        }

        public Criteria andRecruitmentEnumIdIn(List<Integer> values) {
            addCriterion("recruitment_enum_id in", values, "recruitmentEnumId");
            return (Criteria) this;
        }

        public Criteria andRecruitmentEnumIdNotIn(List<Integer> values) {
            addCriterion("recruitment_enum_id not in", values, "recruitmentEnumId");
            return (Criteria) this;
        }

        public Criteria andRecruitmentEnumIdBetween(Integer value1, Integer value2) {
            addCriterion("recruitment_enum_id between", value1, value2, "recruitmentEnumId");
            return (Criteria) this;
        }

        public Criteria andRecruitmentEnumIdNotBetween(Integer value1, Integer value2) {
            addCriterion("recruitment_enum_id not between", value1, value2, "recruitmentEnumId");
            return (Criteria) this;
        }

        public Criteria andRecruitmentEnumOtherIsNull() {
            addCriterion("recruitment_enum_other is null");
            return (Criteria) this;
        }

        public Criteria andRecruitmentEnumOtherIsNotNull() {
            addCriterion("recruitment_enum_other is not null");
            return (Criteria) this;
        }

        public Criteria andRecruitmentEnumOtherEqualTo(String value) {
            addCriterion("recruitment_enum_other =", value, "recruitmentEnumOther");
            return (Criteria) this;
        }

        public Criteria andRecruitmentEnumOtherNotEqualTo(String value) {
            addCriterion("recruitment_enum_other <>", value, "recruitmentEnumOther");
            return (Criteria) this;
        }

        public Criteria andRecruitmentEnumOtherGreaterThan(String value) {
            addCriterion("recruitment_enum_other >", value, "recruitmentEnumOther");
            return (Criteria) this;
        }

        public Criteria andRecruitmentEnumOtherGreaterThanOrEqualTo(String value) {
            addCriterion("recruitment_enum_other >=", value, "recruitmentEnumOther");
            return (Criteria) this;
        }

        public Criteria andRecruitmentEnumOtherLessThan(String value) {
            addCriterion("recruitment_enum_other <", value, "recruitmentEnumOther");
            return (Criteria) this;
        }

        public Criteria andRecruitmentEnumOtherLessThanOrEqualTo(String value) {
            addCriterion("recruitment_enum_other <=", value, "recruitmentEnumOther");
            return (Criteria) this;
        }

        public Criteria andRecruitmentEnumOtherLike(String value) {
            addCriterion("recruitment_enum_other like", value, "recruitmentEnumOther");
            return (Criteria) this;
        }

        public Criteria andRecruitmentEnumOtherNotLike(String value) {
            addCriterion("recruitment_enum_other not like", value, "recruitmentEnumOther");
            return (Criteria) this;
        }

        public Criteria andRecruitmentEnumOtherIn(List<String> values) {
            addCriterion("recruitment_enum_other in", values, "recruitmentEnumOther");
            return (Criteria) this;
        }

        public Criteria andRecruitmentEnumOtherNotIn(List<String> values) {
            addCriterion("recruitment_enum_other not in", values, "recruitmentEnumOther");
            return (Criteria) this;
        }

        public Criteria andRecruitmentEnumOtherBetween(String value1, String value2) {
            addCriterion("recruitment_enum_other between", value1, value2, "recruitmentEnumOther");
            return (Criteria) this;
        }

        public Criteria andRecruitmentEnumOtherNotBetween(String value1, String value2) {
            addCriterion("recruitment_enum_other not between", value1, value2, "recruitmentEnumOther");
            return (Criteria) this;
        }

        public Criteria andRUserIdIsNull() {
            addCriterion("r_user_id is null");
            return (Criteria) this;
        }

        public Criteria andRUserIdIsNotNull() {
            addCriterion("r_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andRUserIdEqualTo(Integer value) {
            addCriterion("r_user_id =", value, "rUserId");
            return (Criteria) this;
        }

        public Criteria andRUserIdNotEqualTo(Integer value) {
            addCriterion("r_user_id <>", value, "rUserId");
            return (Criteria) this;
        }

        public Criteria andRUserIdGreaterThan(Integer value) {
            addCriterion("r_user_id >", value, "rUserId");
            return (Criteria) this;
        }

        public Criteria andRUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("r_user_id >=", value, "rUserId");
            return (Criteria) this;
        }

        public Criteria andRUserIdLessThan(Integer value) {
            addCriterion("r_user_id <", value, "rUserId");
            return (Criteria) this;
        }

        public Criteria andRUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("r_user_id <=", value, "rUserId");
            return (Criteria) this;
        }

        public Criteria andRUserIdIn(List<Integer> values) {
            addCriterion("r_user_id in", values, "rUserId");
            return (Criteria) this;
        }

        public Criteria andRUserIdNotIn(List<Integer> values) {
            addCriterion("r_user_id not in", values, "rUserId");
            return (Criteria) this;
        }

        public Criteria andRUserIdBetween(Integer value1, Integer value2) {
            addCriterion("r_user_id between", value1, value2, "rUserId");
            return (Criteria) this;
        }

        public Criteria andRUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("r_user_id not between", value1, value2, "rUserId");
            return (Criteria) this;
        }

        public Criteria andItimeIsNull() {
            addCriterion("itime is null");
            return (Criteria) this;
        }

        public Criteria andItimeIsNotNull() {
            addCriterion("itime is not null");
            return (Criteria) this;
        }

        public Criteria andItimeEqualTo(Long value) {
            addCriterion("itime =", value, "itime");
            return (Criteria) this;
        }

        public Criteria andItimeNotEqualTo(Long value) {
            addCriterion("itime <>", value, "itime");
            return (Criteria) this;
        }

        public Criteria andItimeGreaterThan(Long value) {
            addCriterion("itime >", value, "itime");
            return (Criteria) this;
        }

        public Criteria andItimeGreaterThanOrEqualTo(Long value) {
            addCriterion("itime >=", value, "itime");
            return (Criteria) this;
        }

        public Criteria andItimeLessThan(Long value) {
            addCriterion("itime <", value, "itime");
            return (Criteria) this;
        }

        public Criteria andItimeLessThanOrEqualTo(Long value) {
            addCriterion("itime <=", value, "itime");
            return (Criteria) this;
        }

        public Criteria andItimeIn(List<Long> values) {
            addCriterion("itime in", values, "itime");
            return (Criteria) this;
        }

        public Criteria andItimeNotIn(List<Long> values) {
            addCriterion("itime not in", values, "itime");
            return (Criteria) this;
        }

        public Criteria andItimeBetween(Long value1, Long value2) {
            addCriterion("itime between", value1, value2, "itime");
            return (Criteria) this;
        }

        public Criteria andItimeNotBetween(Long value1, Long value2) {
            addCriterion("itime not between", value1, value2, "itime");
            return (Criteria) this;
        }

        public Criteria andProbationIsNull() {
            addCriterion("probation is null");
            return (Criteria) this;
        }

        public Criteria andProbationIsNotNull() {
            addCriterion("probation is not null");
            return (Criteria) this;
        }

        public Criteria andProbationEqualTo(Integer value) {
            addCriterion("probation =", value, "probation");
            return (Criteria) this;
        }

        public Criteria andProbationNotEqualTo(Integer value) {
            addCriterion("probation <>", value, "probation");
            return (Criteria) this;
        }

        public Criteria andProbationGreaterThan(Integer value) {
            addCriterion("probation >", value, "probation");
            return (Criteria) this;
        }

        public Criteria andProbationGreaterThanOrEqualTo(Integer value) {
            addCriterion("probation >=", value, "probation");
            return (Criteria) this;
        }

        public Criteria andProbationLessThan(Integer value) {
            addCriterion("probation <", value, "probation");
            return (Criteria) this;
        }

        public Criteria andProbationLessThanOrEqualTo(Integer value) {
            addCriterion("probation <=", value, "probation");
            return (Criteria) this;
        }

        public Criteria andProbationIn(List<Integer> values) {
            addCriterion("probation in", values, "probation");
            return (Criteria) this;
        }

        public Criteria andProbationNotIn(List<Integer> values) {
            addCriterion("probation not in", values, "probation");
            return (Criteria) this;
        }

        public Criteria andProbationBetween(Integer value1, Integer value2) {
            addCriterion("probation between", value1, value2, "probation");
            return (Criteria) this;
        }

        public Criteria andProbationNotBetween(Integer value1, Integer value2) {
            addCriterion("probation not between", value1, value2, "probation");
            return (Criteria) this;
        }

        public Criteria andPtimeIsNull() {
            addCriterion("ptime is null");
            return (Criteria) this;
        }

        public Criteria andPtimeIsNotNull() {
            addCriterion("ptime is not null");
            return (Criteria) this;
        }

        public Criteria andPtimeEqualTo(Long value) {
            addCriterion("ptime =", value, "ptime");
            return (Criteria) this;
        }

        public Criteria andPtimeNotEqualTo(Long value) {
            addCriterion("ptime <>", value, "ptime");
            return (Criteria) this;
        }

        public Criteria andPtimeGreaterThan(Long value) {
            addCriterion("ptime >", value, "ptime");
            return (Criteria) this;
        }

        public Criteria andPtimeGreaterThanOrEqualTo(Long value) {
            addCriterion("ptime >=", value, "ptime");
            return (Criteria) this;
        }

        public Criteria andPtimeLessThan(Long value) {
            addCriterion("ptime <", value, "ptime");
            return (Criteria) this;
        }

        public Criteria andPtimeLessThanOrEqualTo(Long value) {
            addCriterion("ptime <=", value, "ptime");
            return (Criteria) this;
        }

        public Criteria andPtimeIn(List<Long> values) {
            addCriterion("ptime in", values, "ptime");
            return (Criteria) this;
        }

        public Criteria andPtimeNotIn(List<Long> values) {
            addCriterion("ptime not in", values, "ptime");
            return (Criteria) this;
        }

        public Criteria andPtimeBetween(Long value1, Long value2) {
            addCriterion("ptime between", value1, value2, "ptime");
            return (Criteria) this;
        }

        public Criteria andPtimeNotBetween(Long value1, Long value2) {
            addCriterion("ptime not between", value1, value2, "ptime");
            return (Criteria) this;
        }

        public Criteria andContractageIsNull() {
            addCriterion("contractage is null");
            return (Criteria) this;
        }

        public Criteria andContractageIsNotNull() {
            addCriterion("contractage is not null");
            return (Criteria) this;
        }

        public Criteria andContractageEqualTo(Integer value) {
            addCriterion("contractage =", value, "contractage");
            return (Criteria) this;
        }

        public Criteria andContractageNotEqualTo(Integer value) {
            addCriterion("contractage <>", value, "contractage");
            return (Criteria) this;
        }

        public Criteria andContractageGreaterThan(Integer value) {
            addCriterion("contractage >", value, "contractage");
            return (Criteria) this;
        }

        public Criteria andContractageGreaterThanOrEqualTo(Integer value) {
            addCriterion("contractage >=", value, "contractage");
            return (Criteria) this;
        }

        public Criteria andContractageLessThan(Integer value) {
            addCriterion("contractage <", value, "contractage");
            return (Criteria) this;
        }

        public Criteria andContractageLessThanOrEqualTo(Integer value) {
            addCriterion("contractage <=", value, "contractage");
            return (Criteria) this;
        }

        public Criteria andContractageIn(List<Integer> values) {
            addCriterion("contractage in", values, "contractage");
            return (Criteria) this;
        }

        public Criteria andContractageNotIn(List<Integer> values) {
            addCriterion("contractage not in", values, "contractage");
            return (Criteria) this;
        }

        public Criteria andContractageBetween(Integer value1, Integer value2) {
            addCriterion("contractage between", value1, value2, "contractage");
            return (Criteria) this;
        }

        public Criteria andContractageNotBetween(Integer value1, Integer value2) {
            addCriterion("contractage not between", value1, value2, "contractage");
            return (Criteria) this;
        }

        public Criteria andContracttypeEnumIdIsNull() {
            addCriterion("contracttype_enum_id is null");
            return (Criteria) this;
        }

        public Criteria andContracttypeEnumIdIsNotNull() {
            addCriterion("contracttype_enum_id is not null");
            return (Criteria) this;
        }

        public Criteria andContracttypeEnumIdEqualTo(Integer value) {
            addCriterion("contracttype_enum_id =", value, "contracttypeEnumId");
            return (Criteria) this;
        }

        public Criteria andContracttypeEnumIdNotEqualTo(Integer value) {
            addCriterion("contracttype_enum_id <>", value, "contracttypeEnumId");
            return (Criteria) this;
        }

        public Criteria andContracttypeEnumIdGreaterThan(Integer value) {
            addCriterion("contracttype_enum_id >", value, "contracttypeEnumId");
            return (Criteria) this;
        }

        public Criteria andContracttypeEnumIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("contracttype_enum_id >=", value, "contracttypeEnumId");
            return (Criteria) this;
        }

        public Criteria andContracttypeEnumIdLessThan(Integer value) {
            addCriterion("contracttype_enum_id <", value, "contracttypeEnumId");
            return (Criteria) this;
        }

        public Criteria andContracttypeEnumIdLessThanOrEqualTo(Integer value) {
            addCriterion("contracttype_enum_id <=", value, "contracttypeEnumId");
            return (Criteria) this;
        }

        public Criteria andContracttypeEnumIdIn(List<Integer> values) {
            addCriterion("contracttype_enum_id in", values, "contracttypeEnumId");
            return (Criteria) this;
        }

        public Criteria andContracttypeEnumIdNotIn(List<Integer> values) {
            addCriterion("contracttype_enum_id not in", values, "contracttypeEnumId");
            return (Criteria) this;
        }

        public Criteria andContracttypeEnumIdBetween(Integer value1, Integer value2) {
            addCriterion("contracttype_enum_id between", value1, value2, "contracttypeEnumId");
            return (Criteria) this;
        }

        public Criteria andContracttypeEnumIdNotBetween(Integer value1, Integer value2) {
            addCriterion("contracttype_enum_id not between", value1, value2, "contracttypeEnumId");
            return (Criteria) this;
        }

        public Criteria andContracttimesIsNull() {
            addCriterion("contracttimes is null");
            return (Criteria) this;
        }

        public Criteria andContracttimesIsNotNull() {
            addCriterion("contracttimes is not null");
            return (Criteria) this;
        }

        public Criteria andContracttimesEqualTo(Integer value) {
            addCriterion("contracttimes =", value, "contracttimes");
            return (Criteria) this;
        }

        public Criteria andContracttimesNotEqualTo(Integer value) {
            addCriterion("contracttimes <>", value, "contracttimes");
            return (Criteria) this;
        }

        public Criteria andContracttimesGreaterThan(Integer value) {
            addCriterion("contracttimes >", value, "contracttimes");
            return (Criteria) this;
        }

        public Criteria andContracttimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("contracttimes >=", value, "contracttimes");
            return (Criteria) this;
        }

        public Criteria andContracttimesLessThan(Integer value) {
            addCriterion("contracttimes <", value, "contracttimes");
            return (Criteria) this;
        }

        public Criteria andContracttimesLessThanOrEqualTo(Integer value) {
            addCriterion("contracttimes <=", value, "contracttimes");
            return (Criteria) this;
        }

        public Criteria andContracttimesIn(List<Integer> values) {
            addCriterion("contracttimes in", values, "contracttimes");
            return (Criteria) this;
        }

        public Criteria andContracttimesNotIn(List<Integer> values) {
            addCriterion("contracttimes not in", values, "contracttimes");
            return (Criteria) this;
        }

        public Criteria andContracttimesBetween(Integer value1, Integer value2) {
            addCriterion("contracttimes between", value1, value2, "contracttimes");
            return (Criteria) this;
        }

        public Criteria andContracttimesNotBetween(Integer value1, Integer value2) {
            addCriterion("contracttimes not between", value1, value2, "contracttimes");
            return (Criteria) this;
        }

        public Criteria andIdNumberIsNull() {
            addCriterion("id_number is null");
            return (Criteria) this;
        }

        public Criteria andIdNumberIsNotNull() {
            addCriterion("id_number is not null");
            return (Criteria) this;
        }

        public Criteria andIdNumberEqualTo(String value) {
            addCriterion("id_number =", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberNotEqualTo(String value) {
            addCriterion("id_number <>", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberGreaterThan(String value) {
            addCriterion("id_number >", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberGreaterThanOrEqualTo(String value) {
            addCriterion("id_number >=", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberLessThan(String value) {
            addCriterion("id_number <", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberLessThanOrEqualTo(String value) {
            addCriterion("id_number <=", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberLike(String value) {
            addCriterion("id_number like", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberNotLike(String value) {
            addCriterion("id_number not like", value, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberIn(List<String> values) {
            addCriterion("id_number in", values, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberNotIn(List<String> values) {
            addCriterion("id_number not in", values, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberBetween(String value1, String value2) {
            addCriterion("id_number between", value1, value2, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdNumberNotBetween(String value1, String value2) {
            addCriterion("id_number not between", value1, value2, "idNumber");
            return (Criteria) this;
        }

        public Criteria andIdAddressIsNull() {
            addCriterion("id_address is null");
            return (Criteria) this;
        }

        public Criteria andIdAddressIsNotNull() {
            addCriterion("id_address is not null");
            return (Criteria) this;
        }

        public Criteria andIdAddressEqualTo(String value) {
            addCriterion("id_address =", value, "idAddress");
            return (Criteria) this;
        }

        public Criteria andIdAddressNotEqualTo(String value) {
            addCriterion("id_address <>", value, "idAddress");
            return (Criteria) this;
        }

        public Criteria andIdAddressGreaterThan(String value) {
            addCriterion("id_address >", value, "idAddress");
            return (Criteria) this;
        }

        public Criteria andIdAddressGreaterThanOrEqualTo(String value) {
            addCriterion("id_address >=", value, "idAddress");
            return (Criteria) this;
        }

        public Criteria andIdAddressLessThan(String value) {
            addCriterion("id_address <", value, "idAddress");
            return (Criteria) this;
        }

        public Criteria andIdAddressLessThanOrEqualTo(String value) {
            addCriterion("id_address <=", value, "idAddress");
            return (Criteria) this;
        }

        public Criteria andIdAddressLike(String value) {
            addCriterion("id_address like", value, "idAddress");
            return (Criteria) this;
        }

        public Criteria andIdAddressNotLike(String value) {
            addCriterion("id_address not like", value, "idAddress");
            return (Criteria) this;
        }

        public Criteria andIdAddressIn(List<String> values) {
            addCriterion("id_address in", values, "idAddress");
            return (Criteria) this;
        }

        public Criteria andIdAddressNotIn(List<String> values) {
            addCriterion("id_address not in", values, "idAddress");
            return (Criteria) this;
        }

        public Criteria andIdAddressBetween(String value1, String value2) {
            addCriterion("id_address between", value1, value2, "idAddress");
            return (Criteria) this;
        }

        public Criteria andIdAddressNotBetween(String value1, String value2) {
            addCriterion("id_address not between", value1, value2, "idAddress");
            return (Criteria) this;
        }

        public Criteria andHrEnumIdIsNull() {
            addCriterion("hr_enum_id is null");
            return (Criteria) this;
        }

        public Criteria andHrEnumIdIsNotNull() {
            addCriterion("hr_enum_id is not null");
            return (Criteria) this;
        }

        public Criteria andHrEnumIdEqualTo(Integer value) {
            addCriterion("hr_enum_id =", value, "hrEnumId");
            return (Criteria) this;
        }

        public Criteria andHrEnumIdNotEqualTo(Integer value) {
            addCriterion("hr_enum_id <>", value, "hrEnumId");
            return (Criteria) this;
        }

        public Criteria andHrEnumIdGreaterThan(Integer value) {
            addCriterion("hr_enum_id >", value, "hrEnumId");
            return (Criteria) this;
        }

        public Criteria andHrEnumIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("hr_enum_id >=", value, "hrEnumId");
            return (Criteria) this;
        }

        public Criteria andHrEnumIdLessThan(Integer value) {
            addCriterion("hr_enum_id <", value, "hrEnumId");
            return (Criteria) this;
        }

        public Criteria andHrEnumIdLessThanOrEqualTo(Integer value) {
            addCriterion("hr_enum_id <=", value, "hrEnumId");
            return (Criteria) this;
        }

        public Criteria andHrEnumIdIn(List<Integer> values) {
            addCriterion("hr_enum_id in", values, "hrEnumId");
            return (Criteria) this;
        }

        public Criteria andHrEnumIdNotIn(List<Integer> values) {
            addCriterion("hr_enum_id not in", values, "hrEnumId");
            return (Criteria) this;
        }

        public Criteria andHrEnumIdBetween(Integer value1, Integer value2) {
            addCriterion("hr_enum_id between", value1, value2, "hrEnumId");
            return (Criteria) this;
        }

        public Criteria andHrEnumIdNotBetween(Integer value1, Integer value2) {
            addCriterion("hr_enum_id not between", value1, value2, "hrEnumId");
            return (Criteria) this;
        }

        public Criteria andCardnumberIsNull() {
            addCriterion("cardnumber is null");
            return (Criteria) this;
        }

        public Criteria andCardnumberIsNotNull() {
            addCriterion("cardnumber is not null");
            return (Criteria) this;
        }

        public Criteria andCardnumberEqualTo(String value) {
            addCriterion("cardnumber =", value, "cardnumber");
            return (Criteria) this;
        }

        public Criteria andCardnumberNotEqualTo(String value) {
            addCriterion("cardnumber <>", value, "cardnumber");
            return (Criteria) this;
        }

        public Criteria andCardnumberGreaterThan(String value) {
            addCriterion("cardnumber >", value, "cardnumber");
            return (Criteria) this;
        }

        public Criteria andCardnumberGreaterThanOrEqualTo(String value) {
            addCriterion("cardnumber >=", value, "cardnumber");
            return (Criteria) this;
        }

        public Criteria andCardnumberLessThan(String value) {
            addCriterion("cardnumber <", value, "cardnumber");
            return (Criteria) this;
        }

        public Criteria andCardnumberLessThanOrEqualTo(String value) {
            addCriterion("cardnumber <=", value, "cardnumber");
            return (Criteria) this;
        }

        public Criteria andCardnumberLike(String value) {
            addCriterion("cardnumber like", value, "cardnumber");
            return (Criteria) this;
        }

        public Criteria andCardnumberNotLike(String value) {
            addCriterion("cardnumber not like", value, "cardnumber");
            return (Criteria) this;
        }

        public Criteria andCardnumberIn(List<String> values) {
            addCriterion("cardnumber in", values, "cardnumber");
            return (Criteria) this;
        }

        public Criteria andCardnumberNotIn(List<String> values) {
            addCriterion("cardnumber not in", values, "cardnumber");
            return (Criteria) this;
        }

        public Criteria andCardnumberBetween(String value1, String value2) {
            addCriterion("cardnumber between", value1, value2, "cardnumber");
            return (Criteria) this;
        }

        public Criteria andCardnumberNotBetween(String value1, String value2) {
            addCriterion("cardnumber not between", value1, value2, "cardnumber");
            return (Criteria) this;
        }

        public Criteria andBankEnumIdIsNull() {
            addCriterion("bank_enum_id is null");
            return (Criteria) this;
        }

        public Criteria andBankEnumIdIsNotNull() {
            addCriterion("bank_enum_id is not null");
            return (Criteria) this;
        }

        public Criteria andBankEnumIdEqualTo(Integer value) {
            addCriterion("bank_enum_id =", value, "bankEnumId");
            return (Criteria) this;
        }

        public Criteria andBankEnumIdNotEqualTo(Integer value) {
            addCriterion("bank_enum_id <>", value, "bankEnumId");
            return (Criteria) this;
        }

        public Criteria andBankEnumIdGreaterThan(Integer value) {
            addCriterion("bank_enum_id >", value, "bankEnumId");
            return (Criteria) this;
        }

        public Criteria andBankEnumIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("bank_enum_id >=", value, "bankEnumId");
            return (Criteria) this;
        }

        public Criteria andBankEnumIdLessThan(Integer value) {
            addCriterion("bank_enum_id <", value, "bankEnumId");
            return (Criteria) this;
        }

        public Criteria andBankEnumIdLessThanOrEqualTo(Integer value) {
            addCriterion("bank_enum_id <=", value, "bankEnumId");
            return (Criteria) this;
        }

        public Criteria andBankEnumIdIn(List<Integer> values) {
            addCriterion("bank_enum_id in", values, "bankEnumId");
            return (Criteria) this;
        }

        public Criteria andBankEnumIdNotIn(List<Integer> values) {
            addCriterion("bank_enum_id not in", values, "bankEnumId");
            return (Criteria) this;
        }

        public Criteria andBankEnumIdBetween(Integer value1, Integer value2) {
            addCriterion("bank_enum_id between", value1, value2, "bankEnumId");
            return (Criteria) this;
        }

        public Criteria andBankEnumIdNotBetween(Integer value1, Integer value2) {
            addCriterion("bank_enum_id not between", value1, value2, "bankEnumId");
            return (Criteria) this;
        }

        public Criteria andIsmarryIsNull() {
            addCriterion("ismarry is null");
            return (Criteria) this;
        }

        public Criteria andIsmarryIsNotNull() {
            addCriterion("ismarry is not null");
            return (Criteria) this;
        }

        public Criteria andIsmarryEqualTo(Boolean value) {
            addCriterion("ismarry =", value, "ismarry");
            return (Criteria) this;
        }

        public Criteria andIsmarryNotEqualTo(Boolean value) {
            addCriterion("ismarry <>", value, "ismarry");
            return (Criteria) this;
        }

        public Criteria andIsmarryGreaterThan(Boolean value) {
            addCriterion("ismarry >", value, "ismarry");
            return (Criteria) this;
        }

        public Criteria andIsmarryGreaterThanOrEqualTo(Boolean value) {
            addCriterion("ismarry >=", value, "ismarry");
            return (Criteria) this;
        }

        public Criteria andIsmarryLessThan(Boolean value) {
            addCriterion("ismarry <", value, "ismarry");
            return (Criteria) this;
        }

        public Criteria andIsmarryLessThanOrEqualTo(Boolean value) {
            addCriterion("ismarry <=", value, "ismarry");
            return (Criteria) this;
        }

        public Criteria andIsmarryIn(List<Boolean> values) {
            addCriterion("ismarry in", values, "ismarry");
            return (Criteria) this;
        }

        public Criteria andIsmarryNotIn(List<Boolean> values) {
            addCriterion("ismarry not in", values, "ismarry");
            return (Criteria) this;
        }

        public Criteria andIsmarryBetween(Boolean value1, Boolean value2) {
            addCriterion("ismarry between", value1, value2, "ismarry");
            return (Criteria) this;
        }

        public Criteria andIsmarryNotBetween(Boolean value1, Boolean value2) {
            addCriterion("ismarry not between", value1, value2, "ismarry");
            return (Criteria) this;
        }

        public Criteria andFertilityIsNull() {
            addCriterion("fertility is null");
            return (Criteria) this;
        }

        public Criteria andFertilityIsNotNull() {
            addCriterion("fertility is not null");
            return (Criteria) this;
        }

        public Criteria andFertilityEqualTo(Boolean value) {
            addCriterion("fertility =", value, "fertility");
            return (Criteria) this;
        }

        public Criteria andFertilityNotEqualTo(Boolean value) {
            addCriterion("fertility <>", value, "fertility");
            return (Criteria) this;
        }

        public Criteria andFertilityGreaterThan(Boolean value) {
            addCriterion("fertility >", value, "fertility");
            return (Criteria) this;
        }

        public Criteria andFertilityGreaterThanOrEqualTo(Boolean value) {
            addCriterion("fertility >=", value, "fertility");
            return (Criteria) this;
        }

        public Criteria andFertilityLessThan(Boolean value) {
            addCriterion("fertility <", value, "fertility");
            return (Criteria) this;
        }

        public Criteria andFertilityLessThanOrEqualTo(Boolean value) {
            addCriterion("fertility <=", value, "fertility");
            return (Criteria) this;
        }

        public Criteria andFertilityIn(List<Boolean> values) {
            addCriterion("fertility in", values, "fertility");
            return (Criteria) this;
        }

        public Criteria andFertilityNotIn(List<Boolean> values) {
            addCriterion("fertility not in", values, "fertility");
            return (Criteria) this;
        }

        public Criteria andFertilityBetween(Boolean value1, Boolean value2) {
            addCriterion("fertility between", value1, value2, "fertility");
            return (Criteria) this;
        }

        public Criteria andFertilityNotBetween(Boolean value1, Boolean value2) {
            addCriterion("fertility not between", value1, value2, "fertility");
            return (Criteria) this;
        }

        public Criteria andNationIsNull() {
            addCriterion("nation is null");
            return (Criteria) this;
        }

        public Criteria andNationIsNotNull() {
            addCriterion("nation is not null");
            return (Criteria) this;
        }

        public Criteria andNationEqualTo(String value) {
            addCriterion("nation =", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotEqualTo(String value) {
            addCriterion("nation <>", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationGreaterThan(String value) {
            addCriterion("nation >", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationGreaterThanOrEqualTo(String value) {
            addCriterion("nation >=", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLessThan(String value) {
            addCriterion("nation <", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLessThanOrEqualTo(String value) {
            addCriterion("nation <=", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLike(String value) {
            addCriterion("nation like", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotLike(String value) {
            addCriterion("nation not like", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationIn(List<String> values) {
            addCriterion("nation in", values, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotIn(List<String> values) {
            addCriterion("nation not in", values, "nation");
            return (Criteria) this;
        }

        public Criteria andNationBetween(String value1, String value2) {
            addCriterion("nation between", value1, value2, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotBetween(String value1, String value2) {
            addCriterion("nation not between", value1, value2, "nation");
            return (Criteria) this;
        }

        public Criteria andNativeplaceIsNull() {
            addCriterion("nativeplace is null");
            return (Criteria) this;
        }

        public Criteria andNativeplaceIsNotNull() {
            addCriterion("nativeplace is not null");
            return (Criteria) this;
        }

        public Criteria andNativeplaceEqualTo(String value) {
            addCriterion("nativeplace =", value, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andNativeplaceNotEqualTo(String value) {
            addCriterion("nativeplace <>", value, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andNativeplaceGreaterThan(String value) {
            addCriterion("nativeplace >", value, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andNativeplaceGreaterThanOrEqualTo(String value) {
            addCriterion("nativeplace >=", value, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andNativeplaceLessThan(String value) {
            addCriterion("nativeplace <", value, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andNativeplaceLessThanOrEqualTo(String value) {
            addCriterion("nativeplace <=", value, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andNativeplaceLike(String value) {
            addCriterion("nativeplace like", value, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andNativeplaceNotLike(String value) {
            addCriterion("nativeplace not like", value, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andNativeplaceIn(List<String> values) {
            addCriterion("nativeplace in", values, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andNativeplaceNotIn(List<String> values) {
            addCriterion("nativeplace not in", values, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andNativeplaceBetween(String value1, String value2) {
            addCriterion("nativeplace between", value1, value2, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andNativeplaceNotBetween(String value1, String value2) {
            addCriterion("nativeplace not between", value1, value2, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andQqIsNull() {
            addCriterion("qq is null");
            return (Criteria) this;
        }

        public Criteria andQqIsNotNull() {
            addCriterion("qq is not null");
            return (Criteria) this;
        }

        public Criteria andQqEqualTo(String value) {
            addCriterion("qq =", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotEqualTo(String value) {
            addCriterion("qq <>", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqGreaterThan(String value) {
            addCriterion("qq >", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqGreaterThanOrEqualTo(String value) {
            addCriterion("qq >=", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLessThan(String value) {
            addCriterion("qq <", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLessThanOrEqualTo(String value) {
            addCriterion("qq <=", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLike(String value) {
            addCriterion("qq like", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotLike(String value) {
            addCriterion("qq not like", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqIn(List<String> values) {
            addCriterion("qq in", values, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotIn(List<String> values) {
            addCriterion("qq not in", values, "qq");
            return (Criteria) this;
        }

        public Criteria andQqBetween(String value1, String value2) {
            addCriterion("qq between", value1, value2, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotBetween(String value1, String value2) {
            addCriterion("qq not between", value1, value2, "qq");
            return (Criteria) this;
        }

        public Criteria andWxIsNull() {
            addCriterion("wx is null");
            return (Criteria) this;
        }

        public Criteria andWxIsNotNull() {
            addCriterion("wx is not null");
            return (Criteria) this;
        }

        public Criteria andWxEqualTo(String value) {
            addCriterion("wx =", value, "wx");
            return (Criteria) this;
        }

        public Criteria andWxNotEqualTo(String value) {
            addCriterion("wx <>", value, "wx");
            return (Criteria) this;
        }

        public Criteria andWxGreaterThan(String value) {
            addCriterion("wx >", value, "wx");
            return (Criteria) this;
        }

        public Criteria andWxGreaterThanOrEqualTo(String value) {
            addCriterion("wx >=", value, "wx");
            return (Criteria) this;
        }

        public Criteria andWxLessThan(String value) {
            addCriterion("wx <", value, "wx");
            return (Criteria) this;
        }

        public Criteria andWxLessThanOrEqualTo(String value) {
            addCriterion("wx <=", value, "wx");
            return (Criteria) this;
        }

        public Criteria andWxLike(String value) {
            addCriterion("wx like", value, "wx");
            return (Criteria) this;
        }

        public Criteria andWxNotLike(String value) {
            addCriterion("wx not like", value, "wx");
            return (Criteria) this;
        }

        public Criteria andWxIn(List<String> values) {
            addCriterion("wx in", values, "wx");
            return (Criteria) this;
        }

        public Criteria andWxNotIn(List<String> values) {
            addCriterion("wx not in", values, "wx");
            return (Criteria) this;
        }

        public Criteria andWxBetween(String value1, String value2) {
            addCriterion("wx between", value1, value2, "wx");
            return (Criteria) this;
        }

        public Criteria andWxNotBetween(String value1, String value2) {
            addCriterion("wx not between", value1, value2, "wx");
            return (Criteria) this;
        }

        public Criteria andEEnumIdIsNull() {
            addCriterion("e_enum_id is null");
            return (Criteria) this;
        }

        public Criteria andEEnumIdIsNotNull() {
            addCriterion("e_enum_id is not null");
            return (Criteria) this;
        }

        public Criteria andEEnumIdEqualTo(Integer value) {
            addCriterion("e_enum_id =", value, "eEnumId");
            return (Criteria) this;
        }

        public Criteria andEEnumIdNotEqualTo(Integer value) {
            addCriterion("e_enum_id <>", value, "eEnumId");
            return (Criteria) this;
        }

        public Criteria andEEnumIdGreaterThan(Integer value) {
            addCriterion("e_enum_id >", value, "eEnumId");
            return (Criteria) this;
        }

        public Criteria andEEnumIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("e_enum_id >=", value, "eEnumId");
            return (Criteria) this;
        }

        public Criteria andEEnumIdLessThan(Integer value) {
            addCriterion("e_enum_id <", value, "eEnumId");
            return (Criteria) this;
        }

        public Criteria andEEnumIdLessThanOrEqualTo(Integer value) {
            addCriterion("e_enum_id <=", value, "eEnumId");
            return (Criteria) this;
        }

        public Criteria andEEnumIdIn(List<Integer> values) {
            addCriterion("e_enum_id in", values, "eEnumId");
            return (Criteria) this;
        }

        public Criteria andEEnumIdNotIn(List<Integer> values) {
            addCriterion("e_enum_id not in", values, "eEnumId");
            return (Criteria) this;
        }

        public Criteria andEEnumIdBetween(Integer value1, Integer value2) {
            addCriterion("e_enum_id between", value1, value2, "eEnumId");
            return (Criteria) this;
        }

        public Criteria andEEnumIdNotBetween(Integer value1, Integer value2) {
            addCriterion("e_enum_id not between", value1, value2, "eEnumId");
            return (Criteria) this;
        }

        public Criteria andSchoolIsNull() {
            addCriterion("school is null");
            return (Criteria) this;
        }

        public Criteria andSchoolIsNotNull() {
            addCriterion("school is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolEqualTo(String value) {
            addCriterion("school =", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotEqualTo(String value) {
            addCriterion("school <>", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolGreaterThan(String value) {
            addCriterion("school >", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolGreaterThanOrEqualTo(String value) {
            addCriterion("school >=", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolLessThan(String value) {
            addCriterion("school <", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolLessThanOrEqualTo(String value) {
            addCriterion("school <=", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolLike(String value) {
            addCriterion("school like", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotLike(String value) {
            addCriterion("school not like", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolIn(List<String> values) {
            addCriterion("school in", values, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotIn(List<String> values) {
            addCriterion("school not in", values, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolBetween(String value1, String value2) {
            addCriterion("school between", value1, value2, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotBetween(String value1, String value2) {
            addCriterion("school not between", value1, value2, "school");
            return (Criteria) this;
        }

        public Criteria andProfessionalIsNull() {
            addCriterion("professional is null");
            return (Criteria) this;
        }

        public Criteria andProfessionalIsNotNull() {
            addCriterion("professional is not null");
            return (Criteria) this;
        }

        public Criteria andProfessionalEqualTo(String value) {
            addCriterion("professional =", value, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalNotEqualTo(String value) {
            addCriterion("professional <>", value, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalGreaterThan(String value) {
            addCriterion("professional >", value, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalGreaterThanOrEqualTo(String value) {
            addCriterion("professional >=", value, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalLessThan(String value) {
            addCriterion("professional <", value, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalLessThanOrEqualTo(String value) {
            addCriterion("professional <=", value, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalLike(String value) {
            addCriterion("professional like", value, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalNotLike(String value) {
            addCriterion("professional not like", value, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalIn(List<String> values) {
            addCriterion("professional in", values, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalNotIn(List<String> values) {
            addCriterion("professional not in", values, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalBetween(String value1, String value2) {
            addCriterion("professional between", value1, value2, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalNotBetween(String value1, String value2) {
            addCriterion("professional not between", value1, value2, "professional");
            return (Criteria) this;
        }

        public Criteria andEmerContactIsNull() {
            addCriterion("emer_contact is null");
            return (Criteria) this;
        }

        public Criteria andEmerContactIsNotNull() {
            addCriterion("emer_contact is not null");
            return (Criteria) this;
        }

        public Criteria andEmerContactEqualTo(String value) {
            addCriterion("emer_contact =", value, "emerContact");
            return (Criteria) this;
        }

        public Criteria andEmerContactNotEqualTo(String value) {
            addCriterion("emer_contact <>", value, "emerContact");
            return (Criteria) this;
        }

        public Criteria andEmerContactGreaterThan(String value) {
            addCriterion("emer_contact >", value, "emerContact");
            return (Criteria) this;
        }

        public Criteria andEmerContactGreaterThanOrEqualTo(String value) {
            addCriterion("emer_contact >=", value, "emerContact");
            return (Criteria) this;
        }

        public Criteria andEmerContactLessThan(String value) {
            addCriterion("emer_contact <", value, "emerContact");
            return (Criteria) this;
        }

        public Criteria andEmerContactLessThanOrEqualTo(String value) {
            addCriterion("emer_contact <=", value, "emerContact");
            return (Criteria) this;
        }

        public Criteria andEmerContactLike(String value) {
            addCriterion("emer_contact like", value, "emerContact");
            return (Criteria) this;
        }

        public Criteria andEmerContactNotLike(String value) {
            addCriterion("emer_contact not like", value, "emerContact");
            return (Criteria) this;
        }

        public Criteria andEmerContactIn(List<String> values) {
            addCriterion("emer_contact in", values, "emerContact");
            return (Criteria) this;
        }

        public Criteria andEmerContactNotIn(List<String> values) {
            addCriterion("emer_contact not in", values, "emerContact");
            return (Criteria) this;
        }

        public Criteria andEmerContactBetween(String value1, String value2) {
            addCriterion("emer_contact between", value1, value2, "emerContact");
            return (Criteria) this;
        }

        public Criteria andEmerContactNotBetween(String value1, String value2) {
            addCriterion("emer_contact not between", value1, value2, "emerContact");
            return (Criteria) this;
        }

        public Criteria andEmerMobileIsNull() {
            addCriterion("emer_mobile is null");
            return (Criteria) this;
        }

        public Criteria andEmerMobileIsNotNull() {
            addCriterion("emer_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andEmerMobileEqualTo(String value) {
            addCriterion("emer_mobile =", value, "emerMobile");
            return (Criteria) this;
        }

        public Criteria andEmerMobileNotEqualTo(String value) {
            addCriterion("emer_mobile <>", value, "emerMobile");
            return (Criteria) this;
        }

        public Criteria andEmerMobileGreaterThan(String value) {
            addCriterion("emer_mobile >", value, "emerMobile");
            return (Criteria) this;
        }

        public Criteria andEmerMobileGreaterThanOrEqualTo(String value) {
            addCriterion("emer_mobile >=", value, "emerMobile");
            return (Criteria) this;
        }

        public Criteria andEmerMobileLessThan(String value) {
            addCriterion("emer_mobile <", value, "emerMobile");
            return (Criteria) this;
        }

        public Criteria andEmerMobileLessThanOrEqualTo(String value) {
            addCriterion("emer_mobile <=", value, "emerMobile");
            return (Criteria) this;
        }

        public Criteria andEmerMobileLike(String value) {
            addCriterion("emer_mobile like", value, "emerMobile");
            return (Criteria) this;
        }

        public Criteria andEmerMobileNotLike(String value) {
            addCriterion("emer_mobile not like", value, "emerMobile");
            return (Criteria) this;
        }

        public Criteria andEmerMobileIn(List<String> values) {
            addCriterion("emer_mobile in", values, "emerMobile");
            return (Criteria) this;
        }

        public Criteria andEmerMobileNotIn(List<String> values) {
            addCriterion("emer_mobile not in", values, "emerMobile");
            return (Criteria) this;
        }

        public Criteria andEmerMobileBetween(String value1, String value2) {
            addCriterion("emer_mobile between", value1, value2, "emerMobile");
            return (Criteria) this;
        }

        public Criteria andEmerMobileNotBetween(String value1, String value2) {
            addCriterion("emer_mobile not between", value1, value2, "emerMobile");
            return (Criteria) this;
        }

        public Criteria andLeavetimeIsNull() {
            addCriterion("leavetime is null");
            return (Criteria) this;
        }

        public Criteria andLeavetimeIsNotNull() {
            addCriterion("leavetime is not null");
            return (Criteria) this;
        }

        public Criteria andLeavetimeEqualTo(Long value) {
            addCriterion("leavetime =", value, "leavetime");
            return (Criteria) this;
        }

        public Criteria andLeavetimeNotEqualTo(Long value) {
            addCriterion("leavetime <>", value, "leavetime");
            return (Criteria) this;
        }

        public Criteria andLeavetimeGreaterThan(Long value) {
            addCriterion("leavetime >", value, "leavetime");
            return (Criteria) this;
        }

        public Criteria andLeavetimeGreaterThanOrEqualTo(Long value) {
            addCriterion("leavetime >=", value, "leavetime");
            return (Criteria) this;
        }

        public Criteria andLeavetimeLessThan(Long value) {
            addCriterion("leavetime <", value, "leavetime");
            return (Criteria) this;
        }

        public Criteria andLeavetimeLessThanOrEqualTo(Long value) {
            addCriterion("leavetime <=", value, "leavetime");
            return (Criteria) this;
        }

        public Criteria andLeavetimeIn(List<Long> values) {
            addCriterion("leavetime in", values, "leavetime");
            return (Criteria) this;
        }

        public Criteria andLeavetimeNotIn(List<Long> values) {
            addCriterion("leavetime not in", values, "leavetime");
            return (Criteria) this;
        }

        public Criteria andLeavetimeBetween(Long value1, Long value2) {
            addCriterion("leavetime between", value1, value2, "leavetime");
            return (Criteria) this;
        }

        public Criteria andLeavetimeNotBetween(Long value1, Long value2) {
            addCriterion("leavetime not between", value1, value2, "leavetime");
            return (Criteria) this;
        }

        public Criteria andLeavingreasonIsNull() {
            addCriterion("leavingreason is null");
            return (Criteria) this;
        }

        public Criteria andLeavingreasonIsNotNull() {
            addCriterion("leavingreason is not null");
            return (Criteria) this;
        }

        public Criteria andLeavingreasonEqualTo(String value) {
            addCriterion("leavingreason =", value, "leavingreason");
            return (Criteria) this;
        }

        public Criteria andLeavingreasonNotEqualTo(String value) {
            addCriterion("leavingreason <>", value, "leavingreason");
            return (Criteria) this;
        }

        public Criteria andLeavingreasonGreaterThan(String value) {
            addCriterion("leavingreason >", value, "leavingreason");
            return (Criteria) this;
        }

        public Criteria andLeavingreasonGreaterThanOrEqualTo(String value) {
            addCriterion("leavingreason >=", value, "leavingreason");
            return (Criteria) this;
        }

        public Criteria andLeavingreasonLessThan(String value) {
            addCriterion("leavingreason <", value, "leavingreason");
            return (Criteria) this;
        }

        public Criteria andLeavingreasonLessThanOrEqualTo(String value) {
            addCriterion("leavingreason <=", value, "leavingreason");
            return (Criteria) this;
        }

        public Criteria andLeavingreasonLike(String value) {
            addCriterion("leavingreason like", value, "leavingreason");
            return (Criteria) this;
        }

        public Criteria andLeavingreasonNotLike(String value) {
            addCriterion("leavingreason not like", value, "leavingreason");
            return (Criteria) this;
        }

        public Criteria andLeavingreasonIn(List<String> values) {
            addCriterion("leavingreason in", values, "leavingreason");
            return (Criteria) this;
        }

        public Criteria andLeavingreasonNotIn(List<String> values) {
            addCriterion("leavingreason not in", values, "leavingreason");
            return (Criteria) this;
        }

        public Criteria andLeavingreasonBetween(String value1, String value2) {
            addCriterion("leavingreason between", value1, value2, "leavingreason");
            return (Criteria) this;
        }

        public Criteria andLeavingreasonNotBetween(String value1, String value2) {
            addCriterion("leavingreason not between", value1, value2, "leavingreason");
            return (Criteria) this;
        }

        public Criteria andSecuritystartIsNull() {
            addCriterion("securitystart is null");
            return (Criteria) this;
        }

        public Criteria andSecuritystartIsNotNull() {
            addCriterion("securitystart is not null");
            return (Criteria) this;
        }

        public Criteria andSecuritystartEqualTo(Long value) {
            addCriterion("securitystart =", value, "securitystart");
            return (Criteria) this;
        }

        public Criteria andSecuritystartNotEqualTo(Long value) {
            addCriterion("securitystart <>", value, "securitystart");
            return (Criteria) this;
        }

        public Criteria andSecuritystartGreaterThan(Long value) {
            addCriterion("securitystart >", value, "securitystart");
            return (Criteria) this;
        }

        public Criteria andSecuritystartGreaterThanOrEqualTo(Long value) {
            addCriterion("securitystart >=", value, "securitystart");
            return (Criteria) this;
        }

        public Criteria andSecuritystartLessThan(Long value) {
            addCriterion("securitystart <", value, "securitystart");
            return (Criteria) this;
        }

        public Criteria andSecuritystartLessThanOrEqualTo(Long value) {
            addCriterion("securitystart <=", value, "securitystart");
            return (Criteria) this;
        }

        public Criteria andSecuritystartIn(List<Long> values) {
            addCriterion("securitystart in", values, "securitystart");
            return (Criteria) this;
        }

        public Criteria andSecuritystartNotIn(List<Long> values) {
            addCriterion("securitystart not in", values, "securitystart");
            return (Criteria) this;
        }

        public Criteria andSecuritystartBetween(Long value1, Long value2) {
            addCriterion("securitystart between", value1, value2, "securitystart");
            return (Criteria) this;
        }

        public Criteria andSecuritystartNotBetween(Long value1, Long value2) {
            addCriterion("securitystart not between", value1, value2, "securitystart");
            return (Criteria) this;
        }

        public Criteria andSecurityendtimeIsNull() {
            addCriterion("securityendtime is null");
            return (Criteria) this;
        }

        public Criteria andSecurityendtimeIsNotNull() {
            addCriterion("securityendtime is not null");
            return (Criteria) this;
        }

        public Criteria andSecurityendtimeEqualTo(Long value) {
            addCriterion("securityendtime =", value, "securityendtime");
            return (Criteria) this;
        }

        public Criteria andSecurityendtimeNotEqualTo(Long value) {
            addCriterion("securityendtime <>", value, "securityendtime");
            return (Criteria) this;
        }

        public Criteria andSecurityendtimeGreaterThan(Long value) {
            addCriterion("securityendtime >", value, "securityendtime");
            return (Criteria) this;
        }

        public Criteria andSecurityendtimeGreaterThanOrEqualTo(Long value) {
            addCriterion("securityendtime >=", value, "securityendtime");
            return (Criteria) this;
        }

        public Criteria andSecurityendtimeLessThan(Long value) {
            addCriterion("securityendtime <", value, "securityendtime");
            return (Criteria) this;
        }

        public Criteria andSecurityendtimeLessThanOrEqualTo(Long value) {
            addCriterion("securityendtime <=", value, "securityendtime");
            return (Criteria) this;
        }

        public Criteria andSecurityendtimeIn(List<Long> values) {
            addCriterion("securityendtime in", values, "securityendtime");
            return (Criteria) this;
        }

        public Criteria andSecurityendtimeNotIn(List<Long> values) {
            addCriterion("securityendtime not in", values, "securityendtime");
            return (Criteria) this;
        }

        public Criteria andSecurityendtimeBetween(Long value1, Long value2) {
            addCriterion("securityendtime between", value1, value2, "securityendtime");
            return (Criteria) this;
        }

        public Criteria andSecurityendtimeNotBetween(Long value1, Long value2) {
            addCriterion("securityendtime not between", value1, value2, "securityendtime");
            return (Criteria) this;
        }

        public Criteria andFundtimeIsNull() {
            addCriterion("fundtime is null");
            return (Criteria) this;
        }

        public Criteria andFundtimeIsNotNull() {
            addCriterion("fundtime is not null");
            return (Criteria) this;
        }

        public Criteria andFundtimeEqualTo(Long value) {
            addCriterion("fundtime =", value, "fundtime");
            return (Criteria) this;
        }

        public Criteria andFundtimeNotEqualTo(Long value) {
            addCriterion("fundtime <>", value, "fundtime");
            return (Criteria) this;
        }

        public Criteria andFundtimeGreaterThan(Long value) {
            addCriterion("fundtime >", value, "fundtime");
            return (Criteria) this;
        }

        public Criteria andFundtimeGreaterThanOrEqualTo(Long value) {
            addCriterion("fundtime >=", value, "fundtime");
            return (Criteria) this;
        }

        public Criteria andFundtimeLessThan(Long value) {
            addCriterion("fundtime <", value, "fundtime");
            return (Criteria) this;
        }

        public Criteria andFundtimeLessThanOrEqualTo(Long value) {
            addCriterion("fundtime <=", value, "fundtime");
            return (Criteria) this;
        }

        public Criteria andFundtimeIn(List<Long> values) {
            addCriterion("fundtime in", values, "fundtime");
            return (Criteria) this;
        }

        public Criteria andFundtimeNotIn(List<Long> values) {
            addCriterion("fundtime not in", values, "fundtime");
            return (Criteria) this;
        }

        public Criteria andFundtimeBetween(Long value1, Long value2) {
            addCriterion("fundtime between", value1, value2, "fundtime");
            return (Criteria) this;
        }

        public Criteria andFundtimeNotBetween(Long value1, Long value2) {
            addCriterion("fundtime not between", value1, value2, "fundtime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion implements Serializable {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}