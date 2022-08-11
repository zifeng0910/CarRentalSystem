package com.yjq.programmer.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CarExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CarExample() {
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

    protected abstract static class GeneratedCriteria {
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

        public Criteria andNameIsNull() {
            addCriterion("`name` is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("`name` is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("`name` =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("`name` <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("`name` >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("`name` >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("`name` <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("`name` <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("`name` like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("`name` not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("`name` in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("`name` not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("`name` between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("`name` not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("`time` is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("`time` is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(String value) {
            addCriterion("`time` =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(String value) {
            addCriterion("`time` <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(String value) {
            addCriterion("`time` >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(String value) {
            addCriterion("`time` >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(String value) {
            addCriterion("`time` <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(String value) {
            addCriterion("`time` <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLike(String value) {
            addCriterion("`time` like", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotLike(String value) {
            addCriterion("`time` not like", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<String> values) {
            addCriterion("`time` in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<String> values) {
            addCriterion("`time` not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(String value1, String value2) {
            addCriterion("`time` between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(String value1, String value2) {
            addCriterion("`time` not between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andBrandIsNull() {
            addCriterion("brand is null");
            return (Criteria) this;
        }

        public Criteria andBrandIsNotNull() {
            addCriterion("brand is not null");
            return (Criteria) this;
        }

        public Criteria andBrandEqualTo(String value) {
            addCriterion("brand =", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotEqualTo(String value) {
            addCriterion("brand <>", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandGreaterThan(String value) {
            addCriterion("brand >", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandGreaterThanOrEqualTo(String value) {
            addCriterion("brand >=", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLessThan(String value) {
            addCriterion("brand <", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLessThanOrEqualTo(String value) {
            addCriterion("brand <=", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLike(String value) {
            addCriterion("brand like", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotLike(String value) {
            addCriterion("brand not like", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandIn(List<String> values) {
            addCriterion("brand in", values, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotIn(List<String> values) {
            addCriterion("brand not in", values, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandBetween(String value1, String value2) {
            addCriterion("brand between", value1, value2, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotBetween(String value1, String value2) {
            addCriterion("brand not between", value1, value2, "brand");
            return (Criteria) this;
        }

        public Criteria andGearIsNull() {
            addCriterion("gear is null");
            return (Criteria) this;
        }

        public Criteria andGearIsNotNull() {
            addCriterion("gear is not null");
            return (Criteria) this;
        }

        public Criteria andGearEqualTo(String value) {
            addCriterion("gear =", value, "gear");
            return (Criteria) this;
        }

        public Criteria andGearNotEqualTo(String value) {
            addCriterion("gear <>", value, "gear");
            return (Criteria) this;
        }

        public Criteria andGearGreaterThan(String value) {
            addCriterion("gear >", value, "gear");
            return (Criteria) this;
        }

        public Criteria andGearGreaterThanOrEqualTo(String value) {
            addCriterion("gear >=", value, "gear");
            return (Criteria) this;
        }

        public Criteria andGearLessThan(String value) {
            addCriterion("gear <", value, "gear");
            return (Criteria) this;
        }

        public Criteria andGearLessThanOrEqualTo(String value) {
            addCriterion("gear <=", value, "gear");
            return (Criteria) this;
        }

        public Criteria andGearLike(String value) {
            addCriterion("gear like", value, "gear");
            return (Criteria) this;
        }

        public Criteria andGearNotLike(String value) {
            addCriterion("gear not like", value, "gear");
            return (Criteria) this;
        }

        public Criteria andGearIn(List<String> values) {
            addCriterion("gear in", values, "gear");
            return (Criteria) this;
        }

        public Criteria andGearNotIn(List<String> values) {
            addCriterion("gear not in", values, "gear");
            return (Criteria) this;
        }

        public Criteria andGearBetween(String value1, String value2) {
            addCriterion("gear between", value1, value2, "gear");
            return (Criteria) this;
        }

        public Criteria andGearNotBetween(String value1, String value2) {
            addCriterion("gear not between", value1, value2, "gear");
            return (Criteria) this;
        }

        public Criteria andSeatIsNull() {
            addCriterion("seat is null");
            return (Criteria) this;
        }

        public Criteria andSeatIsNotNull() {
            addCriterion("seat is not null");
            return (Criteria) this;
        }

        public Criteria andSeatEqualTo(String value) {
            addCriterion("seat =", value, "seat");
            return (Criteria) this;
        }

        public Criteria andSeatNotEqualTo(String value) {
            addCriterion("seat <>", value, "seat");
            return (Criteria) this;
        }

        public Criteria andSeatGreaterThan(String value) {
            addCriterion("seat >", value, "seat");
            return (Criteria) this;
        }

        public Criteria andSeatGreaterThanOrEqualTo(String value) {
            addCriterion("seat >=", value, "seat");
            return (Criteria) this;
        }

        public Criteria andSeatLessThan(String value) {
            addCriterion("seat <", value, "seat");
            return (Criteria) this;
        }

        public Criteria andSeatLessThanOrEqualTo(String value) {
            addCriterion("seat <=", value, "seat");
            return (Criteria) this;
        }

        public Criteria andSeatLike(String value) {
            addCriterion("seat like", value, "seat");
            return (Criteria) this;
        }

        public Criteria andSeatNotLike(String value) {
            addCriterion("seat not like", value, "seat");
            return (Criteria) this;
        }

        public Criteria andSeatIn(List<String> values) {
            addCriterion("seat in", values, "seat");
            return (Criteria) this;
        }

        public Criteria andSeatNotIn(List<String> values) {
            addCriterion("seat not in", values, "seat");
            return (Criteria) this;
        }

        public Criteria andSeatBetween(String value1, String value2) {
            addCriterion("seat between", value1, value2, "seat");
            return (Criteria) this;
        }

        public Criteria andSeatNotBetween(String value1, String value2) {
            addCriterion("seat not between", value1, value2, "seat");
            return (Criteria) this;
        }

        public Criteria andDayPriceIsNull() {
            addCriterion("day_price is null");
            return (Criteria) this;
        }

        public Criteria andDayPriceIsNotNull() {
            addCriterion("day_price is not null");
            return (Criteria) this;
        }

        public Criteria andDayPriceEqualTo(BigDecimal value) {
            addCriterion("day_price =", value, "dayPrice");
            return (Criteria) this;
        }

        public Criteria andDayPriceNotEqualTo(BigDecimal value) {
            addCriterion("day_price <>", value, "dayPrice");
            return (Criteria) this;
        }

        public Criteria andDayPriceGreaterThan(BigDecimal value) {
            addCriterion("day_price >", value, "dayPrice");
            return (Criteria) this;
        }

        public Criteria andDayPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("day_price >=", value, "dayPrice");
            return (Criteria) this;
        }

        public Criteria andDayPriceLessThan(BigDecimal value) {
            addCriterion("day_price <", value, "dayPrice");
            return (Criteria) this;
        }

        public Criteria andDayPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("day_price <=", value, "dayPrice");
            return (Criteria) this;
        }

        public Criteria andDayPriceIn(List<BigDecimal> values) {
            addCriterion("day_price in", values, "dayPrice");
            return (Criteria) this;
        }

        public Criteria andDayPriceNotIn(List<BigDecimal> values) {
            addCriterion("day_price not in", values, "dayPrice");
            return (Criteria) this;
        }

        public Criteria andDayPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("day_price between", value1, value2, "dayPrice");
            return (Criteria) this;
        }

        public Criteria andDayPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("day_price not between", value1, value2, "dayPrice");
            return (Criteria) this;
        }

        public Criteria andCartonNumIsNull() {
            addCriterion("carton_num is null");
            return (Criteria) this;
        }

        public Criteria andCartonNumIsNotNull() {
            addCriterion("carton_num is not null");
            return (Criteria) this;
        }

        public Criteria andCartonNumEqualTo(String value) {
            addCriterion("carton_num =", value, "cartonNum");
            return (Criteria) this;
        }

        public Criteria andCartonNumNotEqualTo(String value) {
            addCriterion("carton_num <>", value, "cartonNum");
            return (Criteria) this;
        }

        public Criteria andCartonNumGreaterThan(String value) {
            addCriterion("carton_num >", value, "cartonNum");
            return (Criteria) this;
        }

        public Criteria andCartonNumGreaterThanOrEqualTo(String value) {
            addCriterion("carton_num >=", value, "cartonNum");
            return (Criteria) this;
        }

        public Criteria andCartonNumLessThan(String value) {
            addCriterion("carton_num <", value, "cartonNum");
            return (Criteria) this;
        }

        public Criteria andCartonNumLessThanOrEqualTo(String value) {
            addCriterion("carton_num <=", value, "cartonNum");
            return (Criteria) this;
        }

        public Criteria andCartonNumLike(String value) {
            addCriterion("carton_num like", value, "cartonNum");
            return (Criteria) this;
        }

        public Criteria andCartonNumNotLike(String value) {
            addCriterion("carton_num not like", value, "cartonNum");
            return (Criteria) this;
        }

        public Criteria andCartonNumIn(List<String> values) {
            addCriterion("carton_num in", values, "cartonNum");
            return (Criteria) this;
        }

        public Criteria andCartonNumNotIn(List<String> values) {
            addCriterion("carton_num not in", values, "cartonNum");
            return (Criteria) this;
        }

        public Criteria andCartonNumBetween(String value1, String value2) {
            addCriterion("carton_num between", value1, value2, "cartonNum");
            return (Criteria) this;
        }

        public Criteria andCartonNumNotBetween(String value1, String value2) {
            addCriterion("carton_num not between", value1, value2, "cartonNum");
            return (Criteria) this;
        }

        public Criteria andPickPlaceIsNull() {
            addCriterion("pick_place is null");
            return (Criteria) this;
        }

        public Criteria andPickPlaceIsNotNull() {
            addCriterion("pick_place is not null");
            return (Criteria) this;
        }

        public Criteria andPickPlaceEqualTo(String value) {
            addCriterion("pick_place =", value, "pickPlace");
            return (Criteria) this;
        }

        public Criteria andPickPlaceNotEqualTo(String value) {
            addCriterion("pick_place <>", value, "pickPlace");
            return (Criteria) this;
        }

        public Criteria andPickPlaceGreaterThan(String value) {
            addCriterion("pick_place >", value, "pickPlace");
            return (Criteria) this;
        }

        public Criteria andPickPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("pick_place >=", value, "pickPlace");
            return (Criteria) this;
        }

        public Criteria andPickPlaceLessThan(String value) {
            addCriterion("pick_place <", value, "pickPlace");
            return (Criteria) this;
        }

        public Criteria andPickPlaceLessThanOrEqualTo(String value) {
            addCriterion("pick_place <=", value, "pickPlace");
            return (Criteria) this;
        }

        public Criteria andPickPlaceLike(String value) {
            addCriterion("pick_place like", value, "pickPlace");
            return (Criteria) this;
        }

        public Criteria andPickPlaceNotLike(String value) {
            addCriterion("pick_place not like", value, "pickPlace");
            return (Criteria) this;
        }

        public Criteria andPickPlaceIn(List<String> values) {
            addCriterion("pick_place in", values, "pickPlace");
            return (Criteria) this;
        }

        public Criteria andPickPlaceNotIn(List<String> values) {
            addCriterion("pick_place not in", values, "pickPlace");
            return (Criteria) this;
        }

        public Criteria andPickPlaceBetween(String value1, String value2) {
            addCriterion("pick_place between", value1, value2, "pickPlace");
            return (Criteria) this;
        }

        public Criteria andPickPlaceNotBetween(String value1, String value2) {
            addCriterion("pick_place not between", value1, value2, "pickPlace");
            return (Criteria) this;
        }

        public Criteria andReturnPlaceIsNull() {
            addCriterion("return_place is null");
            return (Criteria) this;
        }

        public Criteria andReturnPlaceIsNotNull() {
            addCriterion("return_place is not null");
            return (Criteria) this;
        }

        public Criteria andReturnPlaceEqualTo(String value) {
            addCriterion("return_place =", value, "returnPlace");
            return (Criteria) this;
        }

        public Criteria andReturnPlaceNotEqualTo(String value) {
            addCriterion("return_place <>", value, "returnPlace");
            return (Criteria) this;
        }

        public Criteria andReturnPlaceGreaterThan(String value) {
            addCriterion("return_place >", value, "returnPlace");
            return (Criteria) this;
        }

        public Criteria andReturnPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("return_place >=", value, "returnPlace");
            return (Criteria) this;
        }

        public Criteria andReturnPlaceLessThan(String value) {
            addCriterion("return_place <", value, "returnPlace");
            return (Criteria) this;
        }

        public Criteria andReturnPlaceLessThanOrEqualTo(String value) {
            addCriterion("return_place <=", value, "returnPlace");
            return (Criteria) this;
        }

        public Criteria andReturnPlaceLike(String value) {
            addCriterion("return_place like", value, "returnPlace");
            return (Criteria) this;
        }

        public Criteria andReturnPlaceNotLike(String value) {
            addCriterion("return_place not like", value, "returnPlace");
            return (Criteria) this;
        }

        public Criteria andReturnPlaceIn(List<String> values) {
            addCriterion("return_place in", values, "returnPlace");
            return (Criteria) this;
        }

        public Criteria andReturnPlaceNotIn(List<String> values) {
            addCriterion("return_place not in", values, "returnPlace");
            return (Criteria) this;
        }

        public Criteria andReturnPlaceBetween(String value1, String value2) {
            addCriterion("return_place between", value1, value2, "returnPlace");
            return (Criteria) this;
        }

        public Criteria andReturnPlaceNotBetween(String value1, String value2) {
            addCriterion("return_place not between", value1, value2, "returnPlace");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("`state` is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("`state` is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("`state` =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("`state` <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("`state` >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("`state` >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("`state` <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("`state` <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("`state` in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("`state` not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("`state` between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("`state` not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andPhotoIsNull() {
            addCriterion("photo is null");
            return (Criteria) this;
        }

        public Criteria andPhotoIsNotNull() {
            addCriterion("photo is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoEqualTo(String value) {
            addCriterion("photo =", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotEqualTo(String value) {
            addCriterion("photo <>", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoGreaterThan(String value) {
            addCriterion("photo >", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("photo >=", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoLessThan(String value) {
            addCriterion("photo <", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoLessThanOrEqualTo(String value) {
            addCriterion("photo <=", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoLike(String value) {
            addCriterion("photo like", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotLike(String value) {
            addCriterion("photo not like", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoIn(List<String> values) {
            addCriterion("photo in", values, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotIn(List<String> values) {
            addCriterion("photo not in", values, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoBetween(String value1, String value2) {
            addCriterion("photo between", value1, value2, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotBetween(String value1, String value2) {
            addCriterion("photo not between", value1, value2, "photo");
            return (Criteria) this;
        }

        public Criteria andPledgePriceIsNull() {
            addCriterion("pledge_price is null");
            return (Criteria) this;
        }

        public Criteria andPledgePriceIsNotNull() {
            addCriterion("pledge_price is not null");
            return (Criteria) this;
        }

        public Criteria andPledgePriceEqualTo(BigDecimal value) {
            addCriterion("pledge_price =", value, "pledgePrice");
            return (Criteria) this;
        }

        public Criteria andPledgePriceNotEqualTo(BigDecimal value) {
            addCriterion("pledge_price <>", value, "pledgePrice");
            return (Criteria) this;
        }

        public Criteria andPledgePriceGreaterThan(BigDecimal value) {
            addCriterion("pledge_price >", value, "pledgePrice");
            return (Criteria) this;
        }

        public Criteria andPledgePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("pledge_price >=", value, "pledgePrice");
            return (Criteria) this;
        }

        public Criteria andPledgePriceLessThan(BigDecimal value) {
            addCriterion("pledge_price <", value, "pledgePrice");
            return (Criteria) this;
        }

        public Criteria andPledgePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("pledge_price <=", value, "pledgePrice");
            return (Criteria) this;
        }

        public Criteria andPledgePriceIn(List<BigDecimal> values) {
            addCriterion("pledge_price in", values, "pledgePrice");
            return (Criteria) this;
        }

        public Criteria andPledgePriceNotIn(List<BigDecimal> values) {
            addCriterion("pledge_price not in", values, "pledgePrice");
            return (Criteria) this;
        }

        public Criteria andPledgePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pledge_price between", value1, value2, "pledgePrice");
            return (Criteria) this;
        }

        public Criteria andPledgePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pledge_price not between", value1, value2, "pledgePrice");
            return (Criteria) this;
        }
    }

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