package com.gyb.demo.bean;

import java.util.ArrayList;
import java.util.List;

public class StudentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public StudentExample() {
        oredCriteria = new ArrayList<>();
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

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
        return offset;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
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

        public Criteria andSIdIsNull() {
            addCriterion("student.s_id is null");
            return (Criteria) this;
        }

        public Criteria andSIdIsNotNull() {
            addCriterion("student.s_id is not null");
            return (Criteria) this;
        }

        public Criteria andSIdEqualTo(Integer value) {
            addCriterion("student.s_id =", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdNotEqualTo(Integer value) {
            addCriterion("student.s_id <>", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdGreaterThan(Integer value) {
            addCriterion("student.s_id >", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("student.s_id >=", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdLessThan(Integer value) {
            addCriterion("student.s_id <", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdLessThanOrEqualTo(Integer value) {
            addCriterion("student.s_id <=", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdIn(List<Integer> values) {
            addCriterion("student.s_id in", values, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdNotIn(List<Integer> values) {
            addCriterion("student.s_id not in", values, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdBetween(Integer value1, Integer value2) {
            addCriterion("student.s_id between", value1, value2, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdNotBetween(Integer value1, Integer value2) {
            addCriterion("student.s_id not between", value1, value2, "sId");
            return (Criteria) this;
        }

        public Criteria andSNameIsNull() {
            addCriterion("student.s_name is null");
            return (Criteria) this;
        }

        public Criteria andSNameIsNotNull() {
            addCriterion("student.s_name is not null");
            return (Criteria) this;
        }

        public Criteria andSNameEqualTo(String value) {
            addCriterion("student.s_name =", value, "sName");
            return (Criteria) this;
        }

        public Criteria andSNameNotEqualTo(String value) {
            addCriterion("student.s_name <>", value, "sName");
            return (Criteria) this;
        }

        public Criteria andSNameGreaterThan(String value) {
            addCriterion("student.s_name >", value, "sName");
            return (Criteria) this;
        }

        public Criteria andSNameGreaterThanOrEqualTo(String value) {
            addCriterion("student.s_name >=", value, "sName");
            return (Criteria) this;
        }

        public Criteria andSNameLessThan(String value) {
            addCriterion("student.s_name <", value, "sName");
            return (Criteria) this;
        }

        public Criteria andSNameLessThanOrEqualTo(String value) {
            addCriterion("student.s_name <=", value, "sName");
            return (Criteria) this;
        }

        public Criteria andSNameLike(String value) {
            addCriterion("student.s_name like", value, "sName");
            return (Criteria) this;
        }

        public Criteria andSNameNotLike(String value) {
            addCriterion("student.s_name not like", value, "sName");
            return (Criteria) this;
        }

        public Criteria andSNameIn(List<String> values) {
            addCriterion("student.s_name in", values, "sName");
            return (Criteria) this;
        }

        public Criteria andSNameNotIn(List<String> values) {
            addCriterion("student.s_name not in", values, "sName");
            return (Criteria) this;
        }

        public Criteria andSNameBetween(String value1, String value2) {
            addCriterion("student.s_name between", value1, value2, "sName");
            return (Criteria) this;
        }

        public Criteria andSNameNotBetween(String value1, String value2) {
            addCriterion("student.s_name not between", value1, value2, "sName");
            return (Criteria) this;
        }

        public Criteria andSBirthIsNull() {
            addCriterion("student.s_birth is null");
            return (Criteria) this;
        }

        public Criteria andSBirthIsNotNull() {
            addCriterion("student.s_birth is not null");
            return (Criteria) this;
        }

        public Criteria andSBirthEqualTo(String value) {
            addCriterion("student.s_birth =", value, "sBirth");
            return (Criteria) this;
        }

        public Criteria andSBirthNotEqualTo(String value) {
            addCriterion("student.s_birth <>", value, "sBirth");
            return (Criteria) this;
        }

        public Criteria andSBirthGreaterThan(String value) {
            addCriterion("student.s_birth >", value, "sBirth");
            return (Criteria) this;
        }

        public Criteria andSBirthGreaterThanOrEqualTo(String value) {
            addCriterion("student.s_birth >=", value, "sBirth");
            return (Criteria) this;
        }

        public Criteria andSBirthLessThan(String value) {
            addCriterion("student.s_birth <", value, "sBirth");
            return (Criteria) this;
        }

        public Criteria andSBirthLessThanOrEqualTo(String value) {
            addCriterion("student.s_birth <=", value, "sBirth");
            return (Criteria) this;
        }

        public Criteria andSBirthLike(String value) {
            addCriterion("student.s_birth like", value, "sBirth");
            return (Criteria) this;
        }

        public Criteria andSBirthNotLike(String value) {
            addCriterion("student.s_birth not like", value, "sBirth");
            return (Criteria) this;
        }

        public Criteria andSBirthIn(List<String> values) {
            addCriterion("student.s_birth in", values, "sBirth");
            return (Criteria) this;
        }

        public Criteria andSBirthNotIn(List<String> values) {
            addCriterion("student.s_birth not in", values, "sBirth");
            return (Criteria) this;
        }

        public Criteria andSBirthBetween(String value1, String value2) {
            addCriterion("student.s_birth between", value1, value2, "sBirth");
            return (Criteria) this;
        }

        public Criteria andSBirthNotBetween(String value1, String value2) {
            addCriterion("student.s_birth not between", value1, value2, "sBirth");
            return (Criteria) this;
        }

        public Criteria andSSexIsNull() {
            addCriterion("student.s_sex is null");
            return (Criteria) this;
        }

        public Criteria andSSexIsNotNull() {
            addCriterion("student.s_sex is not null");
            return (Criteria) this;
        }

        public Criteria andSSexEqualTo(String value) {
            addCriterion("student.s_sex =", value, "sSex");
            return (Criteria) this;
        }

        public Criteria andSSexNotEqualTo(String value) {
            addCriterion("student.s_sex <>", value, "sSex");
            return (Criteria) this;
        }

        public Criteria andSSexGreaterThan(String value) {
            addCriterion("student.s_sex >", value, "sSex");
            return (Criteria) this;
        }

        public Criteria andSSexGreaterThanOrEqualTo(String value) {
            addCriterion("student.s_sex >=", value, "sSex");
            return (Criteria) this;
        }

        public Criteria andSSexLessThan(String value) {
            addCriterion("student.s_sex <", value, "sSex");
            return (Criteria) this;
        }

        public Criteria andSSexLessThanOrEqualTo(String value) {
            addCriterion("student.s_sex <=", value, "sSex");
            return (Criteria) this;
        }

        public Criteria andSSexLike(String value) {
            addCriterion("student.s_sex like", value, "sSex");
            return (Criteria) this;
        }

        public Criteria andSSexNotLike(String value) {
            addCriterion("student.s_sex not like", value, "sSex");
            return (Criteria) this;
        }

        public Criteria andSSexIn(List<String> values) {
            addCriterion("student.s_sex in", values, "sSex");
            return (Criteria) this;
        }

        public Criteria andSSexNotIn(List<String> values) {
            addCriterion("student.s_sex not in", values, "sSex");
            return (Criteria) this;
        }

        public Criteria andSSexBetween(String value1, String value2) {
            addCriterion("student.s_sex between", value1, value2, "sSex");
            return (Criteria) this;
        }

        public Criteria andSSexNotBetween(String value1, String value2) {
            addCriterion("student.s_sex not between", value1, value2, "sSex");
            return (Criteria) this;
        }

        public Criteria andSAddressIsNull() {
            addCriterion("student.s_address is null");
            return (Criteria) this;
        }

        public Criteria andSAddressIsNotNull() {
            addCriterion("student.s_address is not null");
            return (Criteria) this;
        }

        public Criteria andSAddressEqualTo(String value) {
            addCriterion("student.s_address =", value, "sAddress");
            return (Criteria) this;
        }

        public Criteria andSAddressNotEqualTo(String value) {
            addCriterion("student.s_address <>", value, "sAddress");
            return (Criteria) this;
        }

        public Criteria andSAddressGreaterThan(String value) {
            addCriterion("student.s_address >", value, "sAddress");
            return (Criteria) this;
        }

        public Criteria andSAddressGreaterThanOrEqualTo(String value) {
            addCriterion("student.s_address >=", value, "sAddress");
            return (Criteria) this;
        }

        public Criteria andSAddressLessThan(String value) {
            addCriterion("student.s_address <", value, "sAddress");
            return (Criteria) this;
        }

        public Criteria andSAddressLessThanOrEqualTo(String value) {
            addCriterion("student.s_address <=", value, "sAddress");
            return (Criteria) this;
        }

        public Criteria andSAddressLike(String value) {
            addCriterion("student.s_address like", value, "sAddress");
            return (Criteria) this;
        }

        public Criteria andSAddressNotLike(String value) {
            addCriterion("student.s_address not like", value, "sAddress");
            return (Criteria) this;
        }

        public Criteria andSAddressIn(List<String> values) {
            addCriterion("student.s_address in", values, "sAddress");
            return (Criteria) this;
        }

        public Criteria andSAddressNotIn(List<String> values) {
            addCriterion("student.s_address not in", values, "sAddress");
            return (Criteria) this;
        }

        public Criteria andSAddressBetween(String value1, String value2) {
            addCriterion("student.s_address between", value1, value2, "sAddress");
            return (Criteria) this;
        }

        public Criteria andSAddressNotBetween(String value1, String value2) {
            addCriterion("student.s_address not between", value1, value2, "sAddress");
            return (Criteria) this;
        }

        public Criteria andSMessageIsNull() {
            addCriterion("student.s_message is null");
            return (Criteria) this;
        }

        public Criteria andSMessageIsNotNull() {
            addCriterion("student.s_message is not null");
            return (Criteria) this;
        }

        public Criteria andSMessageEqualTo(String value) {
            addCriterion("student.s_message =", value, "sMessage");
            return (Criteria) this;
        }

        public Criteria andSMessageNotEqualTo(String value) {
            addCriterion("student.s_message <>", value, "sMessage");
            return (Criteria) this;
        }

        public Criteria andSMessageGreaterThan(String value) {
            addCriterion("student.s_message >", value, "sMessage");
            return (Criteria) this;
        }

        public Criteria andSMessageGreaterThanOrEqualTo(String value) {
            addCriterion("student.s_message >=", value, "sMessage");
            return (Criteria) this;
        }

        public Criteria andSMessageLessThan(String value) {
            addCriterion("student.s_message <", value, "sMessage");
            return (Criteria) this;
        }

        public Criteria andSMessageLessThanOrEqualTo(String value) {
            addCriterion("student.s_message <=", value, "sMessage");
            return (Criteria) this;
        }

        public Criteria andSMessageLike(String value) {
            addCriterion("student.s_message like", value, "sMessage");
            return (Criteria) this;
        }

        public Criteria andSMessageNotLike(String value) {
            addCriterion("student.s_message not like", value, "sMessage");
            return (Criteria) this;
        }

        public Criteria andSMessageIn(List<String> values) {
            addCriterion("student.s_message in", values, "sMessage");
            return (Criteria) this;
        }

        public Criteria andSMessageNotIn(List<String> values) {
            addCriterion("student.s_message not in", values, "sMessage");
            return (Criteria) this;
        }

        public Criteria andSMessageBetween(String value1, String value2) {
            addCriterion("student.s_message between", value1, value2, "sMessage");
            return (Criteria) this;
        }

        public Criteria andSMessageNotBetween(String value1, String value2) {
            addCriterion("student.s_message not between", value1, value2, "sMessage");
            return (Criteria) this;
        }

        public Criteria andSTest1IsNull() {
            addCriterion("student.s_test_1 is null");
            return (Criteria) this;
        }

        public Criteria andSTest1IsNotNull() {
            addCriterion("student.s_test_1 is not null");
            return (Criteria) this;
        }

        public Criteria andSTest1EqualTo(String value) {
            addCriterion("student.s_test_1 =", value, "sTest1");
            return (Criteria) this;
        }

        public Criteria andSTest1NotEqualTo(String value) {
            addCriterion("student.s_test_1 <>", value, "sTest1");
            return (Criteria) this;
        }

        public Criteria andSTest1GreaterThan(String value) {
            addCriterion("student.s_test_1 >", value, "sTest1");
            return (Criteria) this;
        }

        public Criteria andSTest1GreaterThanOrEqualTo(String value) {
            addCriterion("student.s_test_1 >=", value, "sTest1");
            return (Criteria) this;
        }

        public Criteria andSTest1LessThan(String value) {
            addCriterion("student.s_test_1 <", value, "sTest1");
            return (Criteria) this;
        }

        public Criteria andSTest1LessThanOrEqualTo(String value) {
            addCriterion("student.s_test_1 <=", value, "sTest1");
            return (Criteria) this;
        }

        public Criteria andSTest1Like(String value) {
            addCriterion("student.s_test_1 like", value, "sTest1");
            return (Criteria) this;
        }

        public Criteria andSTest1NotLike(String value) {
            addCriterion("student.s_test_1 not like", value, "sTest1");
            return (Criteria) this;
        }

        public Criteria andSTest1In(List<String> values) {
            addCriterion("student.s_test_1 in", values, "sTest1");
            return (Criteria) this;
        }

        public Criteria andSTest1NotIn(List<String> values) {
            addCriterion("student.s_test_1 not in", values, "sTest1");
            return (Criteria) this;
        }

        public Criteria andSTest1Between(String value1, String value2) {
            addCriterion("student.s_test_1 between", value1, value2, "sTest1");
            return (Criteria) this;
        }

        public Criteria andSTest1NotBetween(String value1, String value2) {
            addCriterion("student.s_test_1 not between", value1, value2, "sTest1");
            return (Criteria) this;
        }

        public Criteria andSTest2IsNull() {
            addCriterion("student.s_test_2 is null");
            return (Criteria) this;
        }

        public Criteria andSTest2IsNotNull() {
            addCriterion("student.s_test_2 is not null");
            return (Criteria) this;
        }

        public Criteria andSTest2EqualTo(String value) {
            addCriterion("student.s_test_2 =", value, "sTest2");
            return (Criteria) this;
        }

        public Criteria andSTest2NotEqualTo(String value) {
            addCriterion("student.s_test_2 <>", value, "sTest2");
            return (Criteria) this;
        }

        public Criteria andSTest2GreaterThan(String value) {
            addCriterion("student.s_test_2 >", value, "sTest2");
            return (Criteria) this;
        }

        public Criteria andSTest2GreaterThanOrEqualTo(String value) {
            addCriterion("student.s_test_2 >=", value, "sTest2");
            return (Criteria) this;
        }

        public Criteria andSTest2LessThan(String value) {
            addCriterion("student.s_test_2 <", value, "sTest2");
            return (Criteria) this;
        }

        public Criteria andSTest2LessThanOrEqualTo(String value) {
            addCriterion("student.s_test_2 <=", value, "sTest2");
            return (Criteria) this;
        }

        public Criteria andSTest2Like(String value) {
            addCriterion("student.s_test_2 like", value, "sTest2");
            return (Criteria) this;
        }

        public Criteria andSTest2NotLike(String value) {
            addCriterion("student.s_test_2 not like", value, "sTest2");
            return (Criteria) this;
        }

        public Criteria andSTest2In(List<String> values) {
            addCriterion("student.s_test_2 in", values, "sTest2");
            return (Criteria) this;
        }

        public Criteria andSTest2NotIn(List<String> values) {
            addCriterion("student.s_test_2 not in", values, "sTest2");
            return (Criteria) this;
        }

        public Criteria andSTest2Between(String value1, String value2) {
            addCriterion("student.s_test_2 between", value1, value2, "sTest2");
            return (Criteria) this;
        }

        public Criteria andSTest2NotBetween(String value1, String value2) {
            addCriterion("student.s_test_2 not between", value1, value2, "sTest2");
            return (Criteria) this;
        }

        public Criteria andSTest3IsNull() {
            addCriterion("student.s_test_3 is null");
            return (Criteria) this;
        }

        public Criteria andSTest3IsNotNull() {
            addCriterion("student.s_test_3 is not null");
            return (Criteria) this;
        }

        public Criteria andSTest3EqualTo(String value) {
            addCriterion("student.s_test_3 =", value, "sTest3");
            return (Criteria) this;
        }

        public Criteria andSTest3NotEqualTo(String value) {
            addCriterion("student.s_test_3 <>", value, "sTest3");
            return (Criteria) this;
        }

        public Criteria andSTest3GreaterThan(String value) {
            addCriterion("student.s_test_3 >", value, "sTest3");
            return (Criteria) this;
        }

        public Criteria andSTest3GreaterThanOrEqualTo(String value) {
            addCriterion("student.s_test_3 >=", value, "sTest3");
            return (Criteria) this;
        }

        public Criteria andSTest3LessThan(String value) {
            addCriterion("student.s_test_3 <", value, "sTest3");
            return (Criteria) this;
        }

        public Criteria andSTest3LessThanOrEqualTo(String value) {
            addCriterion("student.s_test_3 <=", value, "sTest3");
            return (Criteria) this;
        }

        public Criteria andSTest3Like(String value) {
            addCriterion("student.s_test_3 like", value, "sTest3");
            return (Criteria) this;
        }

        public Criteria andSTest3NotLike(String value) {
            addCriterion("student.s_test_3 not like", value, "sTest3");
            return (Criteria) this;
        }

        public Criteria andSTest3In(List<String> values) {
            addCriterion("student.s_test_3 in", values, "sTest3");
            return (Criteria) this;
        }

        public Criteria andSTest3NotIn(List<String> values) {
            addCriterion("student.s_test_3 not in", values, "sTest3");
            return (Criteria) this;
        }

        public Criteria andSTest3Between(String value1, String value2) {
            addCriterion("student.s_test_3 between", value1, value2, "sTest3");
            return (Criteria) this;
        }

        public Criteria andSTest3NotBetween(String value1, String value2) {
            addCriterion("student.s_test_3 not between", value1, value2, "sTest3");
            return (Criteria) this;
        }
    }

    /**
     */
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
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