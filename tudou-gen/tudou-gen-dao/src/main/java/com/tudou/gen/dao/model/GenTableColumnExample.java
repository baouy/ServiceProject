package com.tudou.gen.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GenTableColumnExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public GenTableColumnExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andGenTableIdIsNull() {
            addCriterion("gen_table_id is null");
            return (Criteria) this;
        }

        public Criteria andGenTableIdIsNotNull() {
            addCriterion("gen_table_id is not null");
            return (Criteria) this;
        }

        public Criteria andGenTableIdEqualTo(String value) {
            addCriterion("gen_table_id =", value, "genTableId");
            return (Criteria) this;
        }

        public Criteria andGenTableIdNotEqualTo(String value) {
            addCriterion("gen_table_id <>", value, "genTableId");
            return (Criteria) this;
        }

        public Criteria andGenTableIdGreaterThan(String value) {
            addCriterion("gen_table_id >", value, "genTableId");
            return (Criteria) this;
        }

        public Criteria andGenTableIdGreaterThanOrEqualTo(String value) {
            addCriterion("gen_table_id >=", value, "genTableId");
            return (Criteria) this;
        }

        public Criteria andGenTableIdLessThan(String value) {
            addCriterion("gen_table_id <", value, "genTableId");
            return (Criteria) this;
        }

        public Criteria andGenTableIdLessThanOrEqualTo(String value) {
            addCriterion("gen_table_id <=", value, "genTableId");
            return (Criteria) this;
        }

        public Criteria andGenTableIdLike(String value) {
            addCriterion("gen_table_id like", value, "genTableId");
            return (Criteria) this;
        }

        public Criteria andGenTableIdNotLike(String value) {
            addCriterion("gen_table_id not like", value, "genTableId");
            return (Criteria) this;
        }

        public Criteria andGenTableIdIn(List<String> values) {
            addCriterion("gen_table_id in", values, "genTableId");
            return (Criteria) this;
        }

        public Criteria andGenTableIdNotIn(List<String> values) {
            addCriterion("gen_table_id not in", values, "genTableId");
            return (Criteria) this;
        }

        public Criteria andGenTableIdBetween(String value1, String value2) {
            addCriterion("gen_table_id between", value1, value2, "genTableId");
            return (Criteria) this;
        }

        public Criteria andGenTableIdNotBetween(String value1, String value2) {
            addCriterion("gen_table_id not between", value1, value2, "genTableId");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andCommentsIsNull() {
            addCriterion("comments is null");
            return (Criteria) this;
        }

        public Criteria andCommentsIsNotNull() {
            addCriterion("comments is not null");
            return (Criteria) this;
        }

        public Criteria andCommentsEqualTo(String value) {
            addCriterion("comments =", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsNotEqualTo(String value) {
            addCriterion("comments <>", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsGreaterThan(String value) {
            addCriterion("comments >", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsGreaterThanOrEqualTo(String value) {
            addCriterion("comments >=", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsLessThan(String value) {
            addCriterion("comments <", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsLessThanOrEqualTo(String value) {
            addCriterion("comments <=", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsLike(String value) {
            addCriterion("comments like", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsNotLike(String value) {
            addCriterion("comments not like", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsIn(List<String> values) {
            addCriterion("comments in", values, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsNotIn(List<String> values) {
            addCriterion("comments not in", values, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsBetween(String value1, String value2) {
            addCriterion("comments between", value1, value2, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsNotBetween(String value1, String value2) {
            addCriterion("comments not between", value1, value2, "comments");
            return (Criteria) this;
        }

        public Criteria andJdbcTypeIsNull() {
            addCriterion("jdbc_type is null");
            return (Criteria) this;
        }

        public Criteria andJdbcTypeIsNotNull() {
            addCriterion("jdbc_type is not null");
            return (Criteria) this;
        }

        public Criteria andJdbcTypeEqualTo(String value) {
            addCriterion("jdbc_type =", value, "jdbcType");
            return (Criteria) this;
        }

        public Criteria andJdbcTypeNotEqualTo(String value) {
            addCriterion("jdbc_type <>", value, "jdbcType");
            return (Criteria) this;
        }

        public Criteria andJdbcTypeGreaterThan(String value) {
            addCriterion("jdbc_type >", value, "jdbcType");
            return (Criteria) this;
        }

        public Criteria andJdbcTypeGreaterThanOrEqualTo(String value) {
            addCriterion("jdbc_type >=", value, "jdbcType");
            return (Criteria) this;
        }

        public Criteria andJdbcTypeLessThan(String value) {
            addCriterion("jdbc_type <", value, "jdbcType");
            return (Criteria) this;
        }

        public Criteria andJdbcTypeLessThanOrEqualTo(String value) {
            addCriterion("jdbc_type <=", value, "jdbcType");
            return (Criteria) this;
        }

        public Criteria andJdbcTypeLike(String value) {
            addCriterion("jdbc_type like", value, "jdbcType");
            return (Criteria) this;
        }

        public Criteria andJdbcTypeNotLike(String value) {
            addCriterion("jdbc_type not like", value, "jdbcType");
            return (Criteria) this;
        }

        public Criteria andJdbcTypeIn(List<String> values) {
            addCriterion("jdbc_type in", values, "jdbcType");
            return (Criteria) this;
        }

        public Criteria andJdbcTypeNotIn(List<String> values) {
            addCriterion("jdbc_type not in", values, "jdbcType");
            return (Criteria) this;
        }

        public Criteria andJdbcTypeBetween(String value1, String value2) {
            addCriterion("jdbc_type between", value1, value2, "jdbcType");
            return (Criteria) this;
        }

        public Criteria andJdbcTypeNotBetween(String value1, String value2) {
            addCriterion("jdbc_type not between", value1, value2, "jdbcType");
            return (Criteria) this;
        }

        public Criteria andJavaTypeIsNull() {
            addCriterion("java_type is null");
            return (Criteria) this;
        }

        public Criteria andJavaTypeIsNotNull() {
            addCriterion("java_type is not null");
            return (Criteria) this;
        }

        public Criteria andJavaTypeEqualTo(String value) {
            addCriterion("java_type =", value, "javaType");
            return (Criteria) this;
        }

        public Criteria andJavaTypeNotEqualTo(String value) {
            addCriterion("java_type <>", value, "javaType");
            return (Criteria) this;
        }

        public Criteria andJavaTypeGreaterThan(String value) {
            addCriterion("java_type >", value, "javaType");
            return (Criteria) this;
        }

        public Criteria andJavaTypeGreaterThanOrEqualTo(String value) {
            addCriterion("java_type >=", value, "javaType");
            return (Criteria) this;
        }

        public Criteria andJavaTypeLessThan(String value) {
            addCriterion("java_type <", value, "javaType");
            return (Criteria) this;
        }

        public Criteria andJavaTypeLessThanOrEqualTo(String value) {
            addCriterion("java_type <=", value, "javaType");
            return (Criteria) this;
        }

        public Criteria andJavaTypeLike(String value) {
            addCriterion("java_type like", value, "javaType");
            return (Criteria) this;
        }

        public Criteria andJavaTypeNotLike(String value) {
            addCriterion("java_type not like", value, "javaType");
            return (Criteria) this;
        }

        public Criteria andJavaTypeIn(List<String> values) {
            addCriterion("java_type in", values, "javaType");
            return (Criteria) this;
        }

        public Criteria andJavaTypeNotIn(List<String> values) {
            addCriterion("java_type not in", values, "javaType");
            return (Criteria) this;
        }

        public Criteria andJavaTypeBetween(String value1, String value2) {
            addCriterion("java_type between", value1, value2, "javaType");
            return (Criteria) this;
        }

        public Criteria andJavaTypeNotBetween(String value1, String value2) {
            addCriterion("java_type not between", value1, value2, "javaType");
            return (Criteria) this;
        }

        public Criteria andJavaFieldIsNull() {
            addCriterion("java_field is null");
            return (Criteria) this;
        }

        public Criteria andJavaFieldIsNotNull() {
            addCriterion("java_field is not null");
            return (Criteria) this;
        }

        public Criteria andJavaFieldEqualTo(String value) {
            addCriterion("java_field =", value, "javaField");
            return (Criteria) this;
        }

        public Criteria andJavaFieldNotEqualTo(String value) {
            addCriterion("java_field <>", value, "javaField");
            return (Criteria) this;
        }

        public Criteria andJavaFieldGreaterThan(String value) {
            addCriterion("java_field >", value, "javaField");
            return (Criteria) this;
        }

        public Criteria andJavaFieldGreaterThanOrEqualTo(String value) {
            addCriterion("java_field >=", value, "javaField");
            return (Criteria) this;
        }

        public Criteria andJavaFieldLessThan(String value) {
            addCriterion("java_field <", value, "javaField");
            return (Criteria) this;
        }

        public Criteria andJavaFieldLessThanOrEqualTo(String value) {
            addCriterion("java_field <=", value, "javaField");
            return (Criteria) this;
        }

        public Criteria andJavaFieldLike(String value) {
            addCriterion("java_field like", value, "javaField");
            return (Criteria) this;
        }

        public Criteria andJavaFieldNotLike(String value) {
            addCriterion("java_field not like", value, "javaField");
            return (Criteria) this;
        }

        public Criteria andJavaFieldIn(List<String> values) {
            addCriterion("java_field in", values, "javaField");
            return (Criteria) this;
        }

        public Criteria andJavaFieldNotIn(List<String> values) {
            addCriterion("java_field not in", values, "javaField");
            return (Criteria) this;
        }

        public Criteria andJavaFieldBetween(String value1, String value2) {
            addCriterion("java_field between", value1, value2, "javaField");
            return (Criteria) this;
        }

        public Criteria andJavaFieldNotBetween(String value1, String value2) {
            addCriterion("java_field not between", value1, value2, "javaField");
            return (Criteria) this;
        }

        public Criteria andIsPkIsNull() {
            addCriterion("is_pk is null");
            return (Criteria) this;
        }

        public Criteria andIsPkIsNotNull() {
            addCriterion("is_pk is not null");
            return (Criteria) this;
        }

        public Criteria andIsPkEqualTo(String value) {
            addCriterion("is_pk =", value, "isPk");
            return (Criteria) this;
        }

        public Criteria andIsPkNotEqualTo(String value) {
            addCriterion("is_pk <>", value, "isPk");
            return (Criteria) this;
        }

        public Criteria andIsPkGreaterThan(String value) {
            addCriterion("is_pk >", value, "isPk");
            return (Criteria) this;
        }

        public Criteria andIsPkGreaterThanOrEqualTo(String value) {
            addCriterion("is_pk >=", value, "isPk");
            return (Criteria) this;
        }

        public Criteria andIsPkLessThan(String value) {
            addCriterion("is_pk <", value, "isPk");
            return (Criteria) this;
        }

        public Criteria andIsPkLessThanOrEqualTo(String value) {
            addCriterion("is_pk <=", value, "isPk");
            return (Criteria) this;
        }

        public Criteria andIsPkLike(String value) {
            addCriterion("is_pk like", value, "isPk");
            return (Criteria) this;
        }

        public Criteria andIsPkNotLike(String value) {
            addCriterion("is_pk not like", value, "isPk");
            return (Criteria) this;
        }

        public Criteria andIsPkIn(List<String> values) {
            addCriterion("is_pk in", values, "isPk");
            return (Criteria) this;
        }

        public Criteria andIsPkNotIn(List<String> values) {
            addCriterion("is_pk not in", values, "isPk");
            return (Criteria) this;
        }

        public Criteria andIsPkBetween(String value1, String value2) {
            addCriterion("is_pk between", value1, value2, "isPk");
            return (Criteria) this;
        }

        public Criteria andIsPkNotBetween(String value1, String value2) {
            addCriterion("is_pk not between", value1, value2, "isPk");
            return (Criteria) this;
        }

        public Criteria andIsNullIsNull() {
            addCriterion("is_null is null");
            return (Criteria) this;
        }

        public Criteria andIsNullIsNotNull() {
            addCriterion("is_null is not null");
            return (Criteria) this;
        }

        public Criteria andIsNullEqualTo(String value) {
            addCriterion("is_null =", value, "isNull");
            return (Criteria) this;
        }

        public Criteria andIsNullNotEqualTo(String value) {
            addCriterion("is_null <>", value, "isNull");
            return (Criteria) this;
        }

        public Criteria andIsNullGreaterThan(String value) {
            addCriterion("is_null >", value, "isNull");
            return (Criteria) this;
        }

        public Criteria andIsNullGreaterThanOrEqualTo(String value) {
            addCriterion("is_null >=", value, "isNull");
            return (Criteria) this;
        }

        public Criteria andIsNullLessThan(String value) {
            addCriterion("is_null <", value, "isNull");
            return (Criteria) this;
        }

        public Criteria andIsNullLessThanOrEqualTo(String value) {
            addCriterion("is_null <=", value, "isNull");
            return (Criteria) this;
        }

        public Criteria andIsNullLike(String value) {
            addCriterion("is_null like", value, "isNull");
            return (Criteria) this;
        }

        public Criteria andIsNullNotLike(String value) {
            addCriterion("is_null not like", value, "isNull");
            return (Criteria) this;
        }

        public Criteria andIsNullIn(List<String> values) {
            addCriterion("is_null in", values, "isNull");
            return (Criteria) this;
        }

        public Criteria andIsNullNotIn(List<String> values) {
            addCriterion("is_null not in", values, "isNull");
            return (Criteria) this;
        }

        public Criteria andIsNullBetween(String value1, String value2) {
            addCriterion("is_null between", value1, value2, "isNull");
            return (Criteria) this;
        }

        public Criteria andIsNullNotBetween(String value1, String value2) {
            addCriterion("is_null not between", value1, value2, "isNull");
            return (Criteria) this;
        }

        public Criteria andIsInsertIsNull() {
            addCriterion("is_insert is null");
            return (Criteria) this;
        }

        public Criteria andIsInsertIsNotNull() {
            addCriterion("is_insert is not null");
            return (Criteria) this;
        }

        public Criteria andIsInsertEqualTo(String value) {
            addCriterion("is_insert =", value, "isInsert");
            return (Criteria) this;
        }

        public Criteria andIsInsertNotEqualTo(String value) {
            addCriterion("is_insert <>", value, "isInsert");
            return (Criteria) this;
        }

        public Criteria andIsInsertGreaterThan(String value) {
            addCriterion("is_insert >", value, "isInsert");
            return (Criteria) this;
        }

        public Criteria andIsInsertGreaterThanOrEqualTo(String value) {
            addCriterion("is_insert >=", value, "isInsert");
            return (Criteria) this;
        }

        public Criteria andIsInsertLessThan(String value) {
            addCriterion("is_insert <", value, "isInsert");
            return (Criteria) this;
        }

        public Criteria andIsInsertLessThanOrEqualTo(String value) {
            addCriterion("is_insert <=", value, "isInsert");
            return (Criteria) this;
        }

        public Criteria andIsInsertLike(String value) {
            addCriterion("is_insert like", value, "isInsert");
            return (Criteria) this;
        }

        public Criteria andIsInsertNotLike(String value) {
            addCriterion("is_insert not like", value, "isInsert");
            return (Criteria) this;
        }

        public Criteria andIsInsertIn(List<String> values) {
            addCriterion("is_insert in", values, "isInsert");
            return (Criteria) this;
        }

        public Criteria andIsInsertNotIn(List<String> values) {
            addCriterion("is_insert not in", values, "isInsert");
            return (Criteria) this;
        }

        public Criteria andIsInsertBetween(String value1, String value2) {
            addCriterion("is_insert between", value1, value2, "isInsert");
            return (Criteria) this;
        }

        public Criteria andIsInsertNotBetween(String value1, String value2) {
            addCriterion("is_insert not between", value1, value2, "isInsert");
            return (Criteria) this;
        }

        public Criteria andIsEditIsNull() {
            addCriterion("is_edit is null");
            return (Criteria) this;
        }

        public Criteria andIsEditIsNotNull() {
            addCriterion("is_edit is not null");
            return (Criteria) this;
        }

        public Criteria andIsEditEqualTo(String value) {
            addCriterion("is_edit =", value, "isEdit");
            return (Criteria) this;
        }

        public Criteria andIsEditNotEqualTo(String value) {
            addCriterion("is_edit <>", value, "isEdit");
            return (Criteria) this;
        }

        public Criteria andIsEditGreaterThan(String value) {
            addCriterion("is_edit >", value, "isEdit");
            return (Criteria) this;
        }

        public Criteria andIsEditGreaterThanOrEqualTo(String value) {
            addCriterion("is_edit >=", value, "isEdit");
            return (Criteria) this;
        }

        public Criteria andIsEditLessThan(String value) {
            addCriterion("is_edit <", value, "isEdit");
            return (Criteria) this;
        }

        public Criteria andIsEditLessThanOrEqualTo(String value) {
            addCriterion("is_edit <=", value, "isEdit");
            return (Criteria) this;
        }

        public Criteria andIsEditLike(String value) {
            addCriterion("is_edit like", value, "isEdit");
            return (Criteria) this;
        }

        public Criteria andIsEditNotLike(String value) {
            addCriterion("is_edit not like", value, "isEdit");
            return (Criteria) this;
        }

        public Criteria andIsEditIn(List<String> values) {
            addCriterion("is_edit in", values, "isEdit");
            return (Criteria) this;
        }

        public Criteria andIsEditNotIn(List<String> values) {
            addCriterion("is_edit not in", values, "isEdit");
            return (Criteria) this;
        }

        public Criteria andIsEditBetween(String value1, String value2) {
            addCriterion("is_edit between", value1, value2, "isEdit");
            return (Criteria) this;
        }

        public Criteria andIsEditNotBetween(String value1, String value2) {
            addCriterion("is_edit not between", value1, value2, "isEdit");
            return (Criteria) this;
        }

        public Criteria andIsListIsNull() {
            addCriterion("is_list is null");
            return (Criteria) this;
        }

        public Criteria andIsListIsNotNull() {
            addCriterion("is_list is not null");
            return (Criteria) this;
        }

        public Criteria andIsListEqualTo(String value) {
            addCriterion("is_list =", value, "isList");
            return (Criteria) this;
        }

        public Criteria andIsListNotEqualTo(String value) {
            addCriterion("is_list <>", value, "isList");
            return (Criteria) this;
        }

        public Criteria andIsListGreaterThan(String value) {
            addCriterion("is_list >", value, "isList");
            return (Criteria) this;
        }

        public Criteria andIsListGreaterThanOrEqualTo(String value) {
            addCriterion("is_list >=", value, "isList");
            return (Criteria) this;
        }

        public Criteria andIsListLessThan(String value) {
            addCriterion("is_list <", value, "isList");
            return (Criteria) this;
        }

        public Criteria andIsListLessThanOrEqualTo(String value) {
            addCriterion("is_list <=", value, "isList");
            return (Criteria) this;
        }

        public Criteria andIsListLike(String value) {
            addCriterion("is_list like", value, "isList");
            return (Criteria) this;
        }

        public Criteria andIsListNotLike(String value) {
            addCriterion("is_list not like", value, "isList");
            return (Criteria) this;
        }

        public Criteria andIsListIn(List<String> values) {
            addCriterion("is_list in", values, "isList");
            return (Criteria) this;
        }

        public Criteria andIsListNotIn(List<String> values) {
            addCriterion("is_list not in", values, "isList");
            return (Criteria) this;
        }

        public Criteria andIsListBetween(String value1, String value2) {
            addCriterion("is_list between", value1, value2, "isList");
            return (Criteria) this;
        }

        public Criteria andIsListNotBetween(String value1, String value2) {
            addCriterion("is_list not between", value1, value2, "isList");
            return (Criteria) this;
        }

        public Criteria andIsQueryIsNull() {
            addCriterion("is_query is null");
            return (Criteria) this;
        }

        public Criteria andIsQueryIsNotNull() {
            addCriterion("is_query is not null");
            return (Criteria) this;
        }

        public Criteria andIsQueryEqualTo(String value) {
            addCriterion("is_query =", value, "isQuery");
            return (Criteria) this;
        }

        public Criteria andIsQueryNotEqualTo(String value) {
            addCriterion("is_query <>", value, "isQuery");
            return (Criteria) this;
        }

        public Criteria andIsQueryGreaterThan(String value) {
            addCriterion("is_query >", value, "isQuery");
            return (Criteria) this;
        }

        public Criteria andIsQueryGreaterThanOrEqualTo(String value) {
            addCriterion("is_query >=", value, "isQuery");
            return (Criteria) this;
        }

        public Criteria andIsQueryLessThan(String value) {
            addCriterion("is_query <", value, "isQuery");
            return (Criteria) this;
        }

        public Criteria andIsQueryLessThanOrEqualTo(String value) {
            addCriterion("is_query <=", value, "isQuery");
            return (Criteria) this;
        }

        public Criteria andIsQueryLike(String value) {
            addCriterion("is_query like", value, "isQuery");
            return (Criteria) this;
        }

        public Criteria andIsQueryNotLike(String value) {
            addCriterion("is_query not like", value, "isQuery");
            return (Criteria) this;
        }

        public Criteria andIsQueryIn(List<String> values) {
            addCriterion("is_query in", values, "isQuery");
            return (Criteria) this;
        }

        public Criteria andIsQueryNotIn(List<String> values) {
            addCriterion("is_query not in", values, "isQuery");
            return (Criteria) this;
        }

        public Criteria andIsQueryBetween(String value1, String value2) {
            addCriterion("is_query between", value1, value2, "isQuery");
            return (Criteria) this;
        }

        public Criteria andIsQueryNotBetween(String value1, String value2) {
            addCriterion("is_query not between", value1, value2, "isQuery");
            return (Criteria) this;
        }

        public Criteria andQueryTypeIsNull() {
            addCriterion("query_type is null");
            return (Criteria) this;
        }

        public Criteria andQueryTypeIsNotNull() {
            addCriterion("query_type is not null");
            return (Criteria) this;
        }

        public Criteria andQueryTypeEqualTo(String value) {
            addCriterion("query_type =", value, "queryType");
            return (Criteria) this;
        }

        public Criteria andQueryTypeNotEqualTo(String value) {
            addCriterion("query_type <>", value, "queryType");
            return (Criteria) this;
        }

        public Criteria andQueryTypeGreaterThan(String value) {
            addCriterion("query_type >", value, "queryType");
            return (Criteria) this;
        }

        public Criteria andQueryTypeGreaterThanOrEqualTo(String value) {
            addCriterion("query_type >=", value, "queryType");
            return (Criteria) this;
        }

        public Criteria andQueryTypeLessThan(String value) {
            addCriterion("query_type <", value, "queryType");
            return (Criteria) this;
        }

        public Criteria andQueryTypeLessThanOrEqualTo(String value) {
            addCriterion("query_type <=", value, "queryType");
            return (Criteria) this;
        }

        public Criteria andQueryTypeLike(String value) {
            addCriterion("query_type like", value, "queryType");
            return (Criteria) this;
        }

        public Criteria andQueryTypeNotLike(String value) {
            addCriterion("query_type not like", value, "queryType");
            return (Criteria) this;
        }

        public Criteria andQueryTypeIn(List<String> values) {
            addCriterion("query_type in", values, "queryType");
            return (Criteria) this;
        }

        public Criteria andQueryTypeNotIn(List<String> values) {
            addCriterion("query_type not in", values, "queryType");
            return (Criteria) this;
        }

        public Criteria andQueryTypeBetween(String value1, String value2) {
            addCriterion("query_type between", value1, value2, "queryType");
            return (Criteria) this;
        }

        public Criteria andQueryTypeNotBetween(String value1, String value2) {
            addCriterion("query_type not between", value1, value2, "queryType");
            return (Criteria) this;
        }

        public Criteria andShowTypeIsNull() {
            addCriterion("show_type is null");
            return (Criteria) this;
        }

        public Criteria andShowTypeIsNotNull() {
            addCriterion("show_type is not null");
            return (Criteria) this;
        }

        public Criteria andShowTypeEqualTo(String value) {
            addCriterion("show_type =", value, "showType");
            return (Criteria) this;
        }

        public Criteria andShowTypeNotEqualTo(String value) {
            addCriterion("show_type <>", value, "showType");
            return (Criteria) this;
        }

        public Criteria andShowTypeGreaterThan(String value) {
            addCriterion("show_type >", value, "showType");
            return (Criteria) this;
        }

        public Criteria andShowTypeGreaterThanOrEqualTo(String value) {
            addCriterion("show_type >=", value, "showType");
            return (Criteria) this;
        }

        public Criteria andShowTypeLessThan(String value) {
            addCriterion("show_type <", value, "showType");
            return (Criteria) this;
        }

        public Criteria andShowTypeLessThanOrEqualTo(String value) {
            addCriterion("show_type <=", value, "showType");
            return (Criteria) this;
        }

        public Criteria andShowTypeLike(String value) {
            addCriterion("show_type like", value, "showType");
            return (Criteria) this;
        }

        public Criteria andShowTypeNotLike(String value) {
            addCriterion("show_type not like", value, "showType");
            return (Criteria) this;
        }

        public Criteria andShowTypeIn(List<String> values) {
            addCriterion("show_type in", values, "showType");
            return (Criteria) this;
        }

        public Criteria andShowTypeNotIn(List<String> values) {
            addCriterion("show_type not in", values, "showType");
            return (Criteria) this;
        }

        public Criteria andShowTypeBetween(String value1, String value2) {
            addCriterion("show_type between", value1, value2, "showType");
            return (Criteria) this;
        }

        public Criteria andShowTypeNotBetween(String value1, String value2) {
            addCriterion("show_type not between", value1, value2, "showType");
            return (Criteria) this;
        }

        public Criteria andDictTypeIsNull() {
            addCriterion("dict_type is null");
            return (Criteria) this;
        }

        public Criteria andDictTypeIsNotNull() {
            addCriterion("dict_type is not null");
            return (Criteria) this;
        }

        public Criteria andDictTypeEqualTo(String value) {
            addCriterion("dict_type =", value, "dictType");
            return (Criteria) this;
        }

        public Criteria andDictTypeNotEqualTo(String value) {
            addCriterion("dict_type <>", value, "dictType");
            return (Criteria) this;
        }

        public Criteria andDictTypeGreaterThan(String value) {
            addCriterion("dict_type >", value, "dictType");
            return (Criteria) this;
        }

        public Criteria andDictTypeGreaterThanOrEqualTo(String value) {
            addCriterion("dict_type >=", value, "dictType");
            return (Criteria) this;
        }

        public Criteria andDictTypeLessThan(String value) {
            addCriterion("dict_type <", value, "dictType");
            return (Criteria) this;
        }

        public Criteria andDictTypeLessThanOrEqualTo(String value) {
            addCriterion("dict_type <=", value, "dictType");
            return (Criteria) this;
        }

        public Criteria andDictTypeLike(String value) {
            addCriterion("dict_type like", value, "dictType");
            return (Criteria) this;
        }

        public Criteria andDictTypeNotLike(String value) {
            addCriterion("dict_type not like", value, "dictType");
            return (Criteria) this;
        }

        public Criteria andDictTypeIn(List<String> values) {
            addCriterion("dict_type in", values, "dictType");
            return (Criteria) this;
        }

        public Criteria andDictTypeNotIn(List<String> values) {
            addCriterion("dict_type not in", values, "dictType");
            return (Criteria) this;
        }

        public Criteria andDictTypeBetween(String value1, String value2) {
            addCriterion("dict_type between", value1, value2, "dictType");
            return (Criteria) this;
        }

        public Criteria andDictTypeNotBetween(String value1, String value2) {
            addCriterion("dict_type not between", value1, value2, "dictType");
            return (Criteria) this;
        }

        public Criteria andSettingsIsNull() {
            addCriterion("settings is null");
            return (Criteria) this;
        }

        public Criteria andSettingsIsNotNull() {
            addCriterion("settings is not null");
            return (Criteria) this;
        }

        public Criteria andSettingsEqualTo(String value) {
            addCriterion("settings =", value, "settings");
            return (Criteria) this;
        }

        public Criteria andSettingsNotEqualTo(String value) {
            addCriterion("settings <>", value, "settings");
            return (Criteria) this;
        }

        public Criteria andSettingsGreaterThan(String value) {
            addCriterion("settings >", value, "settings");
            return (Criteria) this;
        }

        public Criteria andSettingsGreaterThanOrEqualTo(String value) {
            addCriterion("settings >=", value, "settings");
            return (Criteria) this;
        }

        public Criteria andSettingsLessThan(String value) {
            addCriterion("settings <", value, "settings");
            return (Criteria) this;
        }

        public Criteria andSettingsLessThanOrEqualTo(String value) {
            addCriterion("settings <=", value, "settings");
            return (Criteria) this;
        }

        public Criteria andSettingsLike(String value) {
            addCriterion("settings like", value, "settings");
            return (Criteria) this;
        }

        public Criteria andSettingsNotLike(String value) {
            addCriterion("settings not like", value, "settings");
            return (Criteria) this;
        }

        public Criteria andSettingsIn(List<String> values) {
            addCriterion("settings in", values, "settings");
            return (Criteria) this;
        }

        public Criteria andSettingsNotIn(List<String> values) {
            addCriterion("settings not in", values, "settings");
            return (Criteria) this;
        }

        public Criteria andSettingsBetween(String value1, String value2) {
            addCriterion("settings between", value1, value2, "settings");
            return (Criteria) this;
        }

        public Criteria andSettingsNotBetween(String value1, String value2) {
            addCriterion("settings not between", value1, value2, "settings");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("sort is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("sort is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Long value) {
            addCriterion("sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Long value) {
            addCriterion("sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Long value) {
            addCriterion("sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Long value) {
            addCriterion("sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Long value) {
            addCriterion("sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Long value) {
            addCriterion("sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Long> values) {
            addCriterion("sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Long> values) {
            addCriterion("sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Long value1, Long value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Long value1, Long value2) {
            addCriterion("sort not between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNull() {
            addCriterion("create_by is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("create_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(String value) {
            addCriterion("create_by =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(String value) {
            addCriterion("create_by <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(String value) {
            addCriterion("create_by >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(String value) {
            addCriterion("create_by >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(String value) {
            addCriterion("create_by <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(String value) {
            addCriterion("create_by <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLike(String value) {
            addCriterion("create_by like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotLike(String value) {
            addCriterion("create_by not like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<String> values) {
            addCriterion("create_by in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<String> values) {
            addCriterion("create_by not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(String value1, String value2) {
            addCriterion("create_by between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(String value1, String value2) {
            addCriterion("create_by not between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNull() {
            addCriterion("update_by is null");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNotNull() {
            addCriterion("update_by is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateByEqualTo(String value) {
            addCriterion("update_by =", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotEqualTo(String value) {
            addCriterion("update_by <>", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThan(String value) {
            addCriterion("update_by >", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThanOrEqualTo(String value) {
            addCriterion("update_by >=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThan(String value) {
            addCriterion("update_by <", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThanOrEqualTo(String value) {
            addCriterion("update_by <=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLike(String value) {
            addCriterion("update_by like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotLike(String value) {
            addCriterion("update_by not like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByIn(List<String> values) {
            addCriterion("update_by in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotIn(List<String> values) {
            addCriterion("update_by not in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByBetween(String value1, String value2) {
            addCriterion("update_by between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotBetween(String value1, String value2) {
            addCriterion("update_by not between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("update_date is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("update_date is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(Date value) {
            addCriterion("update_date =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterion("update_date <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterion("update_date >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("update_date >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterion("update_date <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("update_date <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Date> values) {
            addCriterion("update_date in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Date> values) {
            addCriterion("update_date not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterion("update_date between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("update_date not between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNull() {
            addCriterion("del_flag is null");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNotNull() {
            addCriterion("del_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDelFlagEqualTo(String value) {
            addCriterion("del_flag =", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotEqualTo(String value) {
            addCriterion("del_flag <>", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThan(String value) {
            addCriterion("del_flag >", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThanOrEqualTo(String value) {
            addCriterion("del_flag >=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThan(String value) {
            addCriterion("del_flag <", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThanOrEqualTo(String value) {
            addCriterion("del_flag <=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLike(String value) {
            addCriterion("del_flag like", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotLike(String value) {
            addCriterion("del_flag not like", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagIn(List<String> values) {
            addCriterion("del_flag in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotIn(List<String> values) {
            addCriterion("del_flag not in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagBetween(String value1, String value2) {
            addCriterion("del_flag between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotBetween(String value1, String value2) {
            addCriterion("del_flag not between", value1, value2, "delFlag");
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