package com.offcn.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ItemsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ItemsExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andItemNameIsNull() {
            addCriterion("item_name is null");
            return (Criteria) this;
        }

        public Criteria andItemNameIsNotNull() {
            addCriterion("item_name is not null");
            return (Criteria) this;
        }

        public Criteria andItemNameEqualTo(String value) {
            addCriterion("item_name =", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotEqualTo(String value) {
            addCriterion("item_name <>", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameGreaterThan(String value) {
            addCriterion("item_name >", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameGreaterThanOrEqualTo(String value) {
            addCriterion("item_name >=", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLessThan(String value) {
            addCriterion("item_name <", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLessThanOrEqualTo(String value) {
            addCriterion("item_name <=", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLike(String value) {
            addCriterion("item_name like", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotLike(String value) {
            addCriterion("item_name not like", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameIn(List<String> values) {
            addCriterion("item_name in", values, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotIn(List<String> values) {
            addCriterion("item_name not in", values, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameBetween(String value1, String value2) {
            addCriterion("item_name between", value1, value2, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotBetween(String value1, String value2) {
            addCriterion("item_name not between", value1, value2, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemPriceIsNull() {
            addCriterion("item_price is null");
            return (Criteria) this;
        }

        public Criteria andItemPriceIsNotNull() {
            addCriterion("item_price is not null");
            return (Criteria) this;
        }

        public Criteria andItemPriceEqualTo(BigDecimal value) {
            addCriterion("item_price =", value, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceNotEqualTo(BigDecimal value) {
            addCriterion("item_price <>", value, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceGreaterThan(BigDecimal value) {
            addCriterion("item_price >", value, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("item_price >=", value, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceLessThan(BigDecimal value) {
            addCriterion("item_price <", value, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("item_price <=", value, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceIn(List<BigDecimal> values) {
            addCriterion("item_price in", values, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceNotIn(List<BigDecimal> values) {
            addCriterion("item_price not in", values, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("item_price between", value1, value2, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("item_price not between", value1, value2, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemSkuIsNull() {
            addCriterion("item_sku is null");
            return (Criteria) this;
        }

        public Criteria andItemSkuIsNotNull() {
            addCriterion("item_sku is not null");
            return (Criteria) this;
        }

        public Criteria andItemSkuEqualTo(Integer value) {
            addCriterion("item_sku =", value, "itemSku");
            return (Criteria) this;
        }

        public Criteria andItemSkuNotEqualTo(Integer value) {
            addCriterion("item_sku <>", value, "itemSku");
            return (Criteria) this;
        }

        public Criteria andItemSkuGreaterThan(Integer value) {
            addCriterion("item_sku >", value, "itemSku");
            return (Criteria) this;
        }

        public Criteria andItemSkuGreaterThanOrEqualTo(Integer value) {
            addCriterion("item_sku >=", value, "itemSku");
            return (Criteria) this;
        }

        public Criteria andItemSkuLessThan(Integer value) {
            addCriterion("item_sku <", value, "itemSku");
            return (Criteria) this;
        }

        public Criteria andItemSkuLessThanOrEqualTo(Integer value) {
            addCriterion("item_sku <=", value, "itemSku");
            return (Criteria) this;
        }

        public Criteria andItemSkuIn(List<Integer> values) {
            addCriterion("item_sku in", values, "itemSku");
            return (Criteria) this;
        }

        public Criteria andItemSkuNotIn(List<Integer> values) {
            addCriterion("item_sku not in", values, "itemSku");
            return (Criteria) this;
        }

        public Criteria andItemSkuBetween(Integer value1, Integer value2) {
            addCriterion("item_sku between", value1, value2, "itemSku");
            return (Criteria) this;
        }

        public Criteria andItemSkuNotBetween(Integer value1, Integer value2) {
            addCriterion("item_sku not between", value1, value2, "itemSku");
            return (Criteria) this;
        }

        public Criteria andItemSoldIsNull() {
            addCriterion("item_sold is null");
            return (Criteria) this;
        }

        public Criteria andItemSoldIsNotNull() {
            addCriterion("item_sold is not null");
            return (Criteria) this;
        }

        public Criteria andItemSoldEqualTo(Integer value) {
            addCriterion("item_sold =", value, "itemSold");
            return (Criteria) this;
        }

        public Criteria andItemSoldNotEqualTo(Integer value) {
            addCriterion("item_sold <>", value, "itemSold");
            return (Criteria) this;
        }

        public Criteria andItemSoldGreaterThan(Integer value) {
            addCriterion("item_sold >", value, "itemSold");
            return (Criteria) this;
        }

        public Criteria andItemSoldGreaterThanOrEqualTo(Integer value) {
            addCriterion("item_sold >=", value, "itemSold");
            return (Criteria) this;
        }

        public Criteria andItemSoldLessThan(Integer value) {
            addCriterion("item_sold <", value, "itemSold");
            return (Criteria) this;
        }

        public Criteria andItemSoldLessThanOrEqualTo(Integer value) {
            addCriterion("item_sold <=", value, "itemSold");
            return (Criteria) this;
        }

        public Criteria andItemSoldIn(List<Integer> values) {
            addCriterion("item_sold in", values, "itemSold");
            return (Criteria) this;
        }

        public Criteria andItemSoldNotIn(List<Integer> values) {
            addCriterion("item_sold not in", values, "itemSold");
            return (Criteria) this;
        }

        public Criteria andItemSoldBetween(Integer value1, Integer value2) {
            addCriterion("item_sold between", value1, value2, "itemSold");
            return (Criteria) this;
        }

        public Criteria andItemSoldNotBetween(Integer value1, Integer value2) {
            addCriterion("item_sold not between", value1, value2, "itemSold");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andItemCategoryIdIsNull() {
            addCriterion("item_category_id is null");
            return (Criteria) this;
        }

        public Criteria andItemCategoryIdIsNotNull() {
            addCriterion("item_category_id is not null");
            return (Criteria) this;
        }

        public Criteria andItemCategoryIdEqualTo(Integer value) {
            addCriterion("item_category_id =", value, "itemCategoryId");
            return (Criteria) this;
        }

        public Criteria andItemCategoryIdNotEqualTo(Integer value) {
            addCriterion("item_category_id <>", value, "itemCategoryId");
            return (Criteria) this;
        }

        public Criteria andItemCategoryIdGreaterThan(Integer value) {
            addCriterion("item_category_id >", value, "itemCategoryId");
            return (Criteria) this;
        }

        public Criteria andItemCategoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("item_category_id >=", value, "itemCategoryId");
            return (Criteria) this;
        }

        public Criteria andItemCategoryIdLessThan(Integer value) {
            addCriterion("item_category_id <", value, "itemCategoryId");
            return (Criteria) this;
        }

        public Criteria andItemCategoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("item_category_id <=", value, "itemCategoryId");
            return (Criteria) this;
        }

        public Criteria andItemCategoryIdIn(List<Integer> values) {
            addCriterion("item_category_id in", values, "itemCategoryId");
            return (Criteria) this;
        }

        public Criteria andItemCategoryIdNotIn(List<Integer> values) {
            addCriterion("item_category_id not in", values, "itemCategoryId");
            return (Criteria) this;
        }

        public Criteria andItemCategoryIdBetween(Integer value1, Integer value2) {
            addCriterion("item_category_id between", value1, value2, "itemCategoryId");
            return (Criteria) this;
        }

        public Criteria andItemCategoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("item_category_id not between", value1, value2, "itemCategoryId");
            return (Criteria) this;
        }

        public Criteria andIsHotIsNull() {
            addCriterion("is_hot is null");
            return (Criteria) this;
        }

        public Criteria andIsHotIsNotNull() {
            addCriterion("is_hot is not null");
            return (Criteria) this;
        }

        public Criteria andIsHotEqualTo(Byte value) {
            addCriterion("is_hot =", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotNotEqualTo(Byte value) {
            addCriterion("is_hot <>", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotGreaterThan(Byte value) {
            addCriterion("is_hot >", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_hot >=", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotLessThan(Byte value) {
            addCriterion("is_hot <", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotLessThanOrEqualTo(Byte value) {
            addCriterion("is_hot <=", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotIn(List<Byte> values) {
            addCriterion("is_hot in", values, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotNotIn(List<Byte> values) {
            addCriterion("is_hot not in", values, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotBetween(Byte value1, Byte value2) {
            addCriterion("is_hot between", value1, value2, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotNotBetween(Byte value1, Byte value2) {
            addCriterion("is_hot not between", value1, value2, "isHot");
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